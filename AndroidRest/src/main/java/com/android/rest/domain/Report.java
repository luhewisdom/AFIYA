package com.android.rest.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Report {

    @Id
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private String reportNO;


    private String bloodTest;

    private String urinTest;

    private String otherTest;

    @JsonFormat(pattern = "dd/MM/yyyy")
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
