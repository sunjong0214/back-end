package com.WalkiePaw.presentation.domain.chatroom.dto;

import com.WalkiePaw.domain.chatroom.entity.Chatroom;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatroomListResponse {
    private final Integer id;
    private final String location;
    private final String nickname;
    private final String lastMessage;

    public static ChatroomListResponse from(final Chatroom chatroom) {
        return new ChatroomListResponse(chatroom.getId(), chatroom.getBoard().getLocation(),
                 chatroom.getMember().getNickname(), chatroom.getLatestMessage());
    }
}
