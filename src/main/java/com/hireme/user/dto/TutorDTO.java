package com.hireme.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TutorDTO {

    private int tutorId;
    private String tutorName;
    private String tutorBio;
    private String tutorLevel;

}

