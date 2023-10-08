package com.hireme.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tutor_table")
public class TutorEntity {

    @Id
    @Column(name = "tutor_id")
    private Integer tutorId;

    @Column(name = "tutor_name")
    private String tutorName;

    @Column(name = "tutor_bio")
    private String tutorBio;

    @Column(name = "tutor_level")
    private String tutorLevel;

}

