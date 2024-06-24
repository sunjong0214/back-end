package com.WalkiePaw.domain.chatroom.entity;

import com.WalkiePaw.domain.common.BaseEntity;
import com.WalkiePaw.domain.member.entity.Member;
import com.WalkiePaw.domain.board.entity.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chatroom extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "chatroom_id")
    private Integer id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private ChatroomStatus status;
    private String latestMessage;
    private LocalDateTime latestMessageTime;

    public Chatroom(Board board, Member member) {
        this.board = board;
        this.member = member;
        this.status = ChatroomStatus.GENERAL;
    }

    public void update() {

    }

//    /**
//     * Chatroom 생성 메서드
//     * @param board 어떤 게시물과 연결된 채팅인지, board의 작성자가 채팅을 받는 member가 된다.
//     * @param member 채팅을 시작한 member
//     */
//    public Chatroom createChatroom(Board board, Member member) {
//        return new Chatroom(board, member);
//    }
}
