package com.hireme.user.controller;

import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.dto.ResponseBodyDTO;
import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.exception.MessageException;
import com.hireme.user.mapper.EntityToDtoMapper;
import com.hireme.user.service.CommunicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestCommunicationController {

    @InjectMocks
    private CommunicationController communicationController;
    @Mock
    private CommunicationService communicationService;
    @Mock
    private EntityToDtoMapper entityToDtoMapper;

    @Test
    public void testPostMessages01() throws MessageException {

        String userId = "test";
        var messageEntity = new MessagesEntity();
        var messageResponse = new MessagesDTO();

        Mockito.when(communicationService.sendMessage(userId, messageEntity)).thenReturn(messageResponse);
        ResponseBodyDTO testResponse = communicationController.postMessages(userId, messageEntity);

        Assertions.assertEquals(HttpStatus.OK.value(), testResponse.getStatus());

    }

    @Test
    public void testPostMessages02() throws MessageException {

        String userId = "test";
        var messageEntity = new MessagesEntity();

        Mockito.when(communicationService.sendMessage(userId, messageEntity)).thenReturn(null);
        ResponseBodyDTO testResponse = communicationController.postMessages(userId, messageEntity);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), testResponse.getStatus());

    }

    @Test
    public void testPostMessages03() throws MessageException {

        String userId = "test";
        var messageEntity = new MessagesEntity();

        Mockito.when(communicationService.sendMessage(userId, messageEntity)).thenThrow(new MessageException());
        ResponseBodyDTO testResponse = communicationController.postMessages(userId, messageEntity);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), testResponse.getStatus());

    }

    @Test
    public void testGetMessages01() throws MessageException {

        String userId = "test";
        List<MessagesDTO> messageResponse = new ArrayList<>();

        Mockito.when(communicationService.getMessages(userId)).thenReturn(messageResponse);
        ResponseBodyDTO testResponse = communicationController.getMessages(userId);

        Assertions.assertEquals(HttpStatus.OK.value(), testResponse.getStatus());

    }

    @Test
    public void testGetMessages02() throws MessageException {

        String userId = "test";
        List<MessagesDTO> messageResponse = new ArrayList<>();

        Mockito.when(communicationService.getMessages(userId)).thenThrow(new MessageException());
        ResponseBodyDTO testResponse = communicationController.getMessages(userId);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), testResponse.getStatus());

    }

    @Test
    public void testUpdateMessages01() throws MessageException {

        String userId = "test";
        List<MessagesEntity> messageEntityList = new ArrayList<>();
        String messageResponse = "update_success";

        Mockito.when(communicationService.updateMessages(messageEntityList)).thenReturn(messageResponse);
        ResponseBodyDTO testResponse = communicationController.updateMessages(userId, messageEntityList);

        Assertions.assertEquals(HttpStatus.OK.value(), testResponse.getStatus());

    }

    @Test
    public void testUpdateMessages02() throws MessageException {

        String userId = "test";
        List<MessagesEntity> messageEntityList = new ArrayList<>();
        String messageResponse = "update_success";

        Mockito.when(communicationService.updateMessages(messageEntityList)).thenThrow(new MessageException());
        ResponseBodyDTO testResponse = communicationController.updateMessages(userId, messageEntityList);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), testResponse.getStatus());

    }
}
