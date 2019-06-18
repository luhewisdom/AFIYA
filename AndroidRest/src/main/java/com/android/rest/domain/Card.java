package com.android.rest.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cardNo;

    private Date date;

    @PrePersist
    void cardDate(){

        this.date = new Date();
    }

    @Column(columnDefinition = "boolean default false")
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name="fx_user")
    private User user;

    @OneToOne
    @JoinColumn(name="fx_hospital")
    private Hospital hospital;

}
