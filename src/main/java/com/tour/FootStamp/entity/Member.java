package com.tour.FootStamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해줌
    private String id;

    private String name;

    private String pw;
}
