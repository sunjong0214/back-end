package com.WalkiePaw.presentation.domain.member;

import com.WalkiePaw.domain.member.service.MemberService;
import com.WalkiePaw.presentation.domain.member.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "members", description = "멤버 API")
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private static final String MEMBER_URL = "/members/";

    @ApiResponse(responseCode = "200")
    @Operation(summary = "멤버 리스트")
    @GetMapping
    public ResponseEntity<List<MemberListResponse>> memberList() {
        return ResponseEntity.ok()
                .body(memberService.findAll());
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "멤버 조회")
    @GetMapping("/{id}")
    public ResponseEntity<MemberGetResponse> getMember(@Parameter(description = "멤버의 ID") final @PathVariable("id") Integer memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @ApiResponse(responseCode = "201")
    @Operation(summary = "멤버 추가")
    @PostMapping
    public ResponseEntity<Void> addMember(final @Validated @RequestBody MemberAddRequest request) {
        System.out.println("request = " + request);
        Integer memberId = memberService.save(request);
        return ResponseEntity.created(URI.create(MEMBER_URL + memberId)).build();
    }

    @ApiResponse(responseCode = "204", description = "수정됨")
    @Operation(summary = "멤버 수정")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMember(final @PathVariable("id") Integer memberId, final @RequestBody MemberUpdateRequest request) {
        memberService.update(memberId, request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "멤버 리뷰 평점 조회")
    @GetMapping("/{id}/score")
    public ResponseEntity<MemberScoreResponse> getMemberScore(@PathVariable("id") final Integer memberId) {
        return ResponseEntity.ok(memberService.getMemberScore(memberId));
    }

    @Operation(summary = "멤버 구인 구직 횟수 조회")
    @GetMapping("/{id}/RRCount")
    public ResponseEntity<MemberRRCountResponse> getMemberRRCount(@PathVariable("id") final Integer memberId) {
        return ResponseEntity.ok(memberService.getMemberRRCount(memberId));
    }

    @Operation(summary = "멤버 비밀번호 수정")
    @PatchMapping("/{id}/passwordUpdate")
    public ResponseEntity<Void> updateMemberPasswd(@PathVariable("id") final Integer memberId, @RequestBody final MemberPasswdUpdateRequest request) {
        memberService.updatePasswd(memberId, request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "멤버 탈퇴")
    @PatchMapping("/{id}/draw")
    public ResponseEntity<Void> withDraw(@PathVariable("id") final Integer memberId) {
        memberService.draw(memberId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "멤버 정지")
    @PatchMapping("/{id}/ban")
    public ResponseEntity<Void> banMember(@PathVariable("id") final Integer memberId) {
        memberService.ban(memberId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "멤버 복구")
    @PatchMapping("{id}/general")
    public ResponseEntity<Void> generalMember(@PathVariable("id") final Integer memberId) {
        memberService.general(memberId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "멤버 검색")
    @GetMapping("/search")
    public ResponseEntity<List<MemberListResponse>> search(
            @RequestParam(required = false) final String name,
            @RequestParam(required = false) final String nickname,
            @RequestParam(required = false) final String email,
            @RequestParam(required = false) final Integer reportedCnt
    ) {
        List<MemberListResponse> list = memberService.findBySearchCond(name, nickname, email, reportedCnt);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "닉네임 중복 확인")
    @GetMapping("/check-nickname")
    public ResponseEntity<NicknameCheckResponse> checkNickname(
            @RequestParam final String nickname
    ) {
        return ResponseEntity.ok(memberService.NicknameCheck(nickname));
    }
}
