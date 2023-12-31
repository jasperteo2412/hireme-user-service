package com.hireme.user.service.impl;

import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.mapper.EntityToDtoMapper;
import com.hireme.user.repository.CommunicationRepository;
import com.hireme.user.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    @Autowired
    private EntityToDtoMapper entityToDtoMapper;
    @Autowired
    private CommunicationRepository communicationRepository;

    public MessagesDTO sendMessage(String userId, MessagesEntity message) {

        Date timestamp = new Date();
        message.setSentDateTime(timestamp);
        message.setReadIndicator("N");

        MessagesEntity result = communicationRepository.save(message);
        MessagesDTO response = entityToDtoMapper.convertMessageEntityToDto(result);

        return response;
    }

    public List<MessagesDTO> getMessages(String userId) {

        List<MessagesEntity> receivedMessages = communicationRepository.findBySentTo(userId);
        List<MessagesEntity> sentMessages = communicationRepository.findBySentFrom(userId);
        List<MessagesEntity> allMessages = new ArrayList<>();
        allMessages.addAll(receivedMessages);
        allMessages.addAll(sentMessages);
        List<MessagesDTO> response = entityToDtoMapper.convertMessageEntityToDto(allMessages);

        return response;
    }

    public String updateMessages(List<MessagesEntity> updateMessage) {
        for(int i = 0; i < updateMessage.size(); i++){
            communicationRepository.save(updateMessage.get(i));
        }
        return "update_success";
    }

    public Long getUnreadMessagesCount(String userId) {
        Long result = communicationRepository.countBySentToAndReadIndicator(userId, "N");

        return result;
    }
}
