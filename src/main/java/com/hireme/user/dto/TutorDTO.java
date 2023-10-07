package com.hireme.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TutorDTO {

    @JsonProperty("tutorId")
    private int tutorId;

    @JsonProperty("tutorName")
    private String tutorName;

    @JsonProperty("tutorBio")
    private String tutorBio;

    @JsonProperty("tutorLevel")
    private String tutorLevel;

}

