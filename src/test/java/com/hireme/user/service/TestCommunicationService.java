package com.hireme.user.service;


import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.mapper.EntityToDtoMapperImpl;
import com.hireme.user.repository.CommunicationRepository;
import com.hireme.user.service.impl.CommunicationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestCommunicationService {

    @InjectMocks
    CommunicationServiceImpl communicationService;
    @Mock
    EntityToDtoMapperImpl entityToDtoMapper;
    @Mock
    CommunicationRepository communicationRepository;

    @Test
    public void testSendMessage01(){

        String userId = "test";
        var messageEntity = new MessagesEntity();
        var testResponse = new MessagesDTO();

        Mockito.when(communicationService.sendMessage(userId, messageEntity)).thenReturn(testResponse);

        Assertions.assertEquals(testResponse, communicationService.sendMessage(userId, messageEntity));
    }

    @Test
    public void testSendMessage02(){

        String userId = "test";
        var messageEntity = new MessagesEntity();
        var testResponse = new MessagesDTO();

        //Test date
        Date timestamp = new Date();
        testResponse.setSentDateTime(timestamp);
        testResponse.setReadIndicator("N");
        var testDtoResponse = testResponse;

        Mockito.when(communicationService.sendMessage(userId, messageEntity)).thenReturn(testDtoResponse);
        var mockResponse = communicationService.sendMessage(userId, messageEntity);

        Assertions.assertEquals(testDtoResponse.getReadIndicator(), mockResponse.getReadIndicator());
        Assertions.assertEquals(testDtoResponse.getSentDateTime(), mockResponse.getSentDateTime());
    }

    @Test
    public void testGetMessages01(){

        String userId = "test";
        List<MessagesDTO> testResponse = new ArrayList<>();

        Mockito.when(communicationService.getMessages(userId)).thenReturn(testResponse);

        Assertions.assertEquals(testResponse, communicationService.getMessages(userId));
    }

//    @Test
//    public void testUpdateMessages01(){
//
//        List<MessagesEntity> messagesEntityList = new ArrayList<>();
//        String testResponse = "update_success";
//
//        Mockito.when(communicationService.updateMessages(messagesEntityList)).thenReturn(testResponse);
//
//        Assertions.assertEquals(testResponse, communicationService.updateMessages(messagesEntityList));
//    }
}
