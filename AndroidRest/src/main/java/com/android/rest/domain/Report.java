package com.android.rest.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Report {

    @Id
    private Long id;


    private String bloodTest;

    private String urinTest;

    private String otherTest;

    private Date reportDate;

    @PrePersist
    void reportDate()
    {
        this.reportDate = new Date();
    }


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

}
