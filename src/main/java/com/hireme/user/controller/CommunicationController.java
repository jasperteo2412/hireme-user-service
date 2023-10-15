package com.hireme.user.controller;

import com.hireme.user.dto.ErrorDTO;
import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.dto.ResponseBodyDTO;
import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.exception.MessageException;
import com.hireme.user.service.CommunicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommunicationController {

    static final Logger logger = Logger.getLogger(CommunicationController.class.getName());

    @Autowired
    private CommunicationService communicationService;

    @PostMapping(value = "/v1/messages")
    @Operation(summary = "Send message to other users")
    @ApiResponse(responseCode = "200", description = "Message sent successfully")
    private ResponseBodyDTO postMessages(
            @RequestHeader("USER-ID") String userId,
            @RequestBody MessagesEntity newMessage
            ){
        logger.log(Level.FINE, "POST postMessages");

        ResponseBodyDTO response = new ResponseBodyDTO();
        ErrorDTO error = new ErrorDTO();

        try{
            logger.log(Level.FINE, "POST postMessages: Saving Messages...");
            MessagesDTO result = communicationService.sendMessage(userId, newMessage);

            if(result == null){
                logger.log(Level.FINE, "POST postMessages: Error in saving messages...");
                error.setError("Communication Service Error");
                error.setMessage("Failed to sent message");
                error.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
                error.setException("");
                response.setData(null);
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setError(error);
            }
            else{
                logger.log(Level.FINE, "POST postMessages: Messages saved");
                response.setData("Message was sent successfully");
                response.setError(null);
                response.setStatus(HttpStatus.OK.value());
                response.setError(null);
            }
        } catch(MessageException e){
            logger.log(Level.INFO, "POST postMessages: Exception error encountered");
            error.setError("Communication Service Error");
            error.setException("Message Exception");
            error.setMessage(e.getMessage());
            error.setErrorCode(e.getErrorCode());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(error);
        }

        logger.log(Level.FINE, "POST postMessages: completed");
        return response;
    }

    @GetMapping(value = "/v1/messages")
    @Operation(summary = "Get all logged in user messages")
    @ApiResponse(responseCode = "200", description = "Message retrieved successfully")
    private ResponseBodyDTO getMessages(@RequestHeader("USER-ID") String userId){

        logger.log(Level.FINE, "GET getMessages");

        ResponseBodyDTO response = new ResponseBodyDTO();
        ErrorDTO error = new ErrorDTO();

        try{
            logger.log(Level.FINE, "GET getMessages: Retrieving Messages...");
            List<MessagesDTO> result = communicationService.getMessages(userId);
            response.setData(result);
            response.setError(null);
            response.setStatus(HttpStatus.OK.value());
            response.setError(null);

        } catch(MessageException e){
            logger.log(Level.INFO, "GET getMessages: Exception error encountered");
            error.setError("Communication Service Error");
            error.setException("Message Exception");
            error.setMessage(e.getMessage());
            error.setErrorCode(e.getErrorCode());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(error);
        }

        logger.log(Level.FINE, "GET getMessages: completed");
        return response;
    }

    @PutMapping(value = "/v1/messages")
    @Operation(summary = "Update message read indicator")
    @ApiResponse(responseCode = "200", description = "Message updated successfully")
    private ResponseBodyDTO updateMessages(
            @RequestHeader("USER-ID") String userId,
            @RequestBody List<MessagesEntity> updateMessage){

        logger.log(Level.FINE, "PUT updateMessages");

        ResponseBodyDTO response = new ResponseBodyDTO();
        ErrorDTO error = new ErrorDTO();

        try{
            logger.log(Level.FINE, "GET updateMessages: Updating messages...");
            String result = communicationService.updateMessages(updateMessage);
            response.setData(result);
            response.setError(null);
            response.setStatus(HttpStatus.OK.value());
            response.setError(null);

        } catch(MessageException e){
            logger.log(Level.INFO, "GET updateMessages: Exception error encountered");
            error.setError("Communication Service Error");
            error.setException("Message Exception");
            error.setMessage(e.getMessage());
            error.setErrorCode(e.getErrorCode());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(error);
        }

        logger.log(Level.FINE, "PUT updateMessages: completed");
        return response;
    }

//    @GetMapping(value = "/v1/messages/check")
//    private ResponseBodyDTO getUnreadMessagesCount(@RequestHeader("USER-ID") String userId){
//
//        logger.log(Level.FINE, "GET getUnreadMessagesCount");
//
//        ResponseBodyDTO response = new ResponseBodyDTO();
//        ErrorDTO error = new ErrorDTO();
//
//        try{
//
//            logger.log(Level.FINE, "GET getUnreadMessagesCount: Retrieving unread messages count...");
//            Long result = communicationService.getUnreadMessagesCount(userId);
//            response.setData(result);
//            response.setError(null);
//            response.setStatus(HttpStatus.OK.value());
//            response.setError(null);
//
//        } catch(MessageException e){
//            logger.log(Level.INFO, "GET getUnreadMessagesCount: Exception error encountered");
//            error.setError("Communication Service Error");
//            error.setException("Message Exception");
//            error.setMessage(e.getMessage());
//            error.setErrorCode(e.getErrorCode());
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setError(error);
//        }
//
//        logger.log(Level.FINE, "GET getUnreadMessagesCount: completed");
//        return response;
//    }
}
