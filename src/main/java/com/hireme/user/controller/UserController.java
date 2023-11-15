package com.hireme.user.controller;

import com.hireme.user.dto.*;
import com.hireme.user.exception.MessageException;
import com.hireme.user.service.CommunicationService;
import com.hireme.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/v1/users/list")
    @Operation(summary = "Retrieve user name for chats")
    @ApiResponse(responseCode = "200", description = "Message sent successfully")
    private ResponseBodyDTO getUser(
            @RequestHeader("USER-ID") String userId,
            @RequestParam("search") String username
    ){
        logger.log(Level.FINE, "GET getUserNames");

        ResponseBodyDTO response = new ResponseBodyDTO();
        ErrorDTO error = new ErrorDTO();

        try{
            logger.log(Level.FINE, "GET getMessages: Retrieving users...");

            List<UserDTO> result = userService.searchUsername(username);
            List<UserResponseDTO> processedResults = new ArrayList<>();

            if(result.size() > 0){
                for(int i = 0; i < result.size(); i++){
                    UserResponseDTO userResponse = new UserResponseDTO();

                    userResponse.setUserName(result.get(i).getUserName());
                    userResponse.setEmail(result.get(i).getEmail());

                    processedResults.add(userResponse);
                }
            }

            response.setData(processedResults);
            response.setError(null);
            response.setStatus(HttpStatus.OK.value());
            response.setError(null);

        } catch(MessageException e){
            logger.log(Level.INFO, "GET getUserNames: Exception error encountered");
            error.setError("User Service Error");
            error.setException("User Exception");
            error.setMessage(e.getMessage());
            error.setErrorCode(e.getErrorCode());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(error);
        }

        logger.log(Level.FINE, "GET getUserNames: completed");
        return response;
    }
}
