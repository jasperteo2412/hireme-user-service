package com.hireme.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDTO {

    private String error;
    private String errorCode;
    private String exception;
    private String message;

}
