package com.springbootbasic.service;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.entity.MemberPO;
import com.springbootbasic.partialupdate.util.MemberMapper;
import com.springbootbasic.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// 可一個 service 來包 service call service，因為要去設計 transaction bounded
// BeanConfig自己配置 vs Spring 自己掃描@Service
@AllArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberDTO createMember(MemberDTO memberDTO){
        return memberRepository
                .save(memberDTO.toPO())
                .toDTO();
    }

    public List<MemberDTO> readMembers(){
        return memberRepository
                .findAll()
                .stream()
                .map(MemberPO::toDTO)
                .collect(Collectors.toList());

//        return memberRepository
//                .findAll()
//                .stream()
//                .map(v -> {
//                    return v.toDTO();
//                })
//                .collect(Collectors.toList());
    }

    public MemberDTO readMemberById(Integer id){
        return memberRepository
                .findById(id)
                .map(MemberPO::toDTO)
                .orElseThrow(RuntimeException::new);
    }

    public MemberDTO updateMember(MemberDTO memberDTO){

        // 查 -> 改 -> 刪
        return memberRepository.findById(memberDTO.getId())
                .flatMap(v -> {
                    v.setHeight(memberDTO.getHeight());
                    v.setAge(memberDTO.getAge());
                    return Optional.of(memberRepository.save(v).toDTO());
                })
                .orElseThrow(RuntimeException::new);

//        // 查
//        final Optional<MemberPO> memberPoOpt = memberRepository.findById(memberDTO.getId());
//        if (memberPoOpt.isEmpty())throw new RuntimeException();
//        final MemberPO memberPO = memberPoOpt.get();
//
//        // 改
//        memberPO.setHeight(memberDTO.getHeight());
//        memberPO.setAge(memberDTO.getAge());
//
//        // 存
//        return memberRepository.save(memberPO).toDTO();
    }

    public void deleteMember(Integer id){
        memberRepository.deleteById(id);
    }

    public void updateMemberWithMapper(MemberDTO memberDTO){
        MemberPO memberPO = memberRepository.findById(memberDTO.getId()).orElse(null);
        memberMapper.updateMemberFromDto(memberDTO, memberPO);
        memberRepository.save(memberPO);
    }
}
