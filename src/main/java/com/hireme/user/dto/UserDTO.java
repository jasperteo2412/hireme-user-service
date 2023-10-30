package com.hireme.user.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private int userId;
    private String userName;
    private String email;
    private String password;

}
