package com.springbootbasic.controller;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0")
public class MemberController {

    // 不使用@Autowired的原因是可以脫離spring的掌控，比如寫unit test，constructor injection可意識到component的責任
    // constructor injection
    private final MemberService memberService;
    @PostMapping("/members")
    public ResponseEntity<MemberDTO> postMember(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(memberDTO));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> getMembers(){
        return ResponseEntity.ok(memberService.readMembers());
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
