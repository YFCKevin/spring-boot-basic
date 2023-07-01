package com.springbootbasic.controller;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.entity.MemberListDTO;
import com.springbootbasic.entity.MemberPO;
import com.springbootbasic.repository.MemberRepository;
import com.springbootbasic.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
@AllArgsConstructor
public class MemberController {

    // 不使用@Autowired的原因是可以脫離spring的掌控，比如寫unit test，constructor injection可意識到component的責任
    // constructor injection
    private final MemberService memberService;
    private final MemberRepository memberRepository;


    @PostMapping("/members")
    public ResponseEntity<MemberDTO> postMember(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(memberDTO));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> getMembers(){
        return ResponseEntity.ok(memberService.readMembers());
    }

    @GetMapping("/allMembers")
    public ResponseEntity<MemberListDTO> getAllMembers(){
        List<MemberDTO> memberDTOs = memberService.readMembers();
        MemberListDTO memberListDTO = new MemberListDTO();
        memberListDTO.setMemberDTOList(memberDTOs);
        System.out.println(memberListDTO);
        return ResponseEntity.ok(memberListDTO);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDTO> getMembers(@PathVariable Integer id){

        final MemberDTO memberDTO = memberService.readMemberById(id);

        return ResponseEntity.ok(memberDTO);

//        final Optional<MemberDTO> memberPoOpt = memberService.readMemberById(id);
//
//        if(memberPoOpt.isEmpty()){
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(memberPoOpt.get());
//        }
    }

    @GetMapping("/members/sex/{sex}")
    public ResponseEntity<List<MemberPO>> findAllMaleMembers(String sex){
        return ResponseEntity.ok().body(memberRepository.findAllMembersWhenSexIsMale(sex));
    }

    @PatchMapping("/updateAgeByName")
    public ResponseEntity<Integer> updateAgeByName(
            @RequestParam Integer age,
            @RequestParam String name
    ){
        return ResponseEntity.ok().body(memberRepository.updateMemberSetAgeForName(age, name));
    }

    @GetMapping("/searchMembers")
    public ResponseEntity<List<MemberPO>> searchMembersByNameAgeSex(
            @RequestParam String name,
            @RequestParam Integer age,
            @RequestParam String sex
    ){
        return ResponseEntity.ok().body(memberRepository.searchMembers(name, age, sex));
    }

    @PatchMapping("/members/{id}")
    public ResponseEntity<MemberDTO> patchMembers(
            @RequestBody MemberDTO memberReq,
            @PathVariable Integer id)
    {
        final MemberDTO memberDTO = memberService.updateMember(memberReq);

        return ResponseEntity.ok(memberDTO);

//        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMembers(@PathVariable Integer id){
        memberService.deleteMember(id);

        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/{path}/members")
//    public ResponseEntity<Map<String, String>> getMembers(
//            @RequestHeader String header,
//            @RequestParam String param,
//            @PathVariable String path,
//            HttpServletRequest request
//            ) {
//
//        System.out.println(header);
//        System.out.println(param);
//        System.out.println(path);
//        System.out.println(Arrays.toString(request.getCookies()));
//        System.out.println(Arrays.toString(request.getCookies()));
//
//        return ResponseEntity.ok(Map.of("hoho", "hehe"));
//    }
//
//    @PostMapping("/{path}/members")
//    ResponseEntity<Map<String, String>> postMembers(@RequestBody Map<String, String> body){
//        System.out.println(body);
//        return ResponseEntity.ok(Map.of("hoho", "hehe"));
//    }
}
