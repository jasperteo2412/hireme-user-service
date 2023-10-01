package com.hireme.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ParentEntity {

    @Id
    @Column(name = "")
    private int messageId;

    @Column(name = "")
    private String messageBody;

    @Column(name = "")
    private Date sentDateTime;

    @Column(name = "")
    private String readIndicator;

}

