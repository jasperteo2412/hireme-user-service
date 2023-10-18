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
@Table(name =  "rating")
public class RatingEntity {

    @Id
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating")
    private float rating;

    @Column(name = "name")
    private String name;

}
