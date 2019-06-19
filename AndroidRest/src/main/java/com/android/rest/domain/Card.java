package com.android.rest.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(unique = true)
    private String cardNo;

    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;



    @PrePersist
    void cardDate(){

        this.date = new Date();
    }


    private Boolean approved = false;

    @ManyToOne
    @JoinColumn(name="fx_user")
    private User user;

    @OneToOne
    @JoinColumn(name="fx_hospital")
    private Hospital hospital;
}
