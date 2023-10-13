package com.hireme.user.service;

import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.entity.MessagesEntity;

import java.util.List;

public interface CommunicationService {
    public MessagesDTO sendMessage(String userId, MessagesEntity message);
    public List<MessagesDTO> getMessages(String userId);
    public Long getUnreadMessagesCount(String userId);
}
