package com.android.rest.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class HospitalModel {

    private Long id;

    private String hname;

    private String image;

    private String owendby;

    private String phoneNumbe;

    private String relativeAdress;

    private Long latitude;

    private Long longtuide;


    private String user;

    public static List<HospitalModel> getHosoopitalModel(List<Hospital> hospitals)
    {
        List<HospitalModel>  hospitalModels= new ArrayList<>();
        for (Hospital hospital:hospitals)
        {
            hospitalModels.add(new HospitalModel(hospital.getId(),hospital.getHname(),hospital.getImage(),hospital.getOwendby(),
                    hospital.getPhoneNumbe(),hospital.getRelativeAdress(),hospital.getLatitude(),hospital.getLongtuide(),hospital.getUser().getUsername()));

        }
        return hospitalModels;
    }
    public static HospitalModel getHospitalModel(Hospital hospital)
    {


        return  new HospitalModel(hospital.getId(),hospital.getHname(),hospital.getImage(),hospital.getOwendby(),
                hospital.getPhoneNumbe(),hospital.getRelativeAdress(),hospital.getLatitude(),hospital.getLongtuide(),hospital.getUser().getUsername());
    }

}
