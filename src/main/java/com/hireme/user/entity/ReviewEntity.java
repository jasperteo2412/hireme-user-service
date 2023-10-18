package com.hireme.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name =  "review")
public class ReviewEntity {

    @Id
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "review")
    private String review;

    @Column(name = "name")
    private String name;

}
