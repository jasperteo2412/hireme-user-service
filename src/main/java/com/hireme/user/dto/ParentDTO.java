package com.hireme.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParentDTO {

    private int messageId;
    private String messageBody;
    private Date sentDateTime;
    private String readIndicator;

}
