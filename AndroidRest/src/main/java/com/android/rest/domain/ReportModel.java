package com.android.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ReportModel {

    private Long id;


    private String reportNO;


    private String bloodTest;

    private String urinTest;

    private String otherTest;


    private Date reportDate;


    private String  user;

    private String hospital;


    public static List<ReportModel> getReportModels(List<Report> reports)
    {
        List<ReportModel>  reportModels= new ArrayList<>();
        for (Report report:reports)
        {
            reportModels.add(new ReportModel(report.getId(),report.getReportNO(),report.getBloodTest(),
                    report.getUrinTest(),report.getOtherTest(),report.getReportDate(),report.getUser().getUsername(),report.getHospital().getHname()));

        }
        return reportModels;
    }
    public static ReportModel getReportModel(Report report)
    {
        return  new ReportModel(report.getId(),report.getReportNO(),report.getBloodTest(),
                report.getUrinTest(),report.getOtherTest(),report.getReportDate(),report.getUser().getUsername(),report.getHospital().getHname());
    }

}
