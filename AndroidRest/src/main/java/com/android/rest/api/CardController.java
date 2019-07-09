package com.android.rest.api;


import com.android.rest.domain.*;
import com.android.rest.service.CardService;
import com.android.rest.service.HospitalService;
import com.android.rest.service.ReportService;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("/appoint")
@CrossOrigin(origins="*")
public class CardController {

    private CardService cardService;
    private UserService userService;
    private HospitalService hospitalService;
    private ReportService reportService;

    @Autowired
    public CardController(CardService cardService,UserService userService,
                          HospitalService hospitalService,ReportService reportService)
    {
        this.reportService = reportService;
        this.cardService = cardService;
        this.hospitalService = hospitalService;
        this.userService = userService;
    }


    @GetMapping("/appoint/myappoints")
    public List<CardModel>  cardList(@AuthenticationPrincipal UserDetails userDetails){
        User user = userService.findUserByUsername(userDetails.getUsername());
        return  CardModel.getCardModel(cardService.findByUserId(user.getId()));
    }
    @GetMapping("/appoint/myappoints/one")
    public CardModel oneCard(@AuthenticationPrincipal UserDetails userDetails,@PathVariable("cno") String cno){
        return CardModel.getCardModel(cardService.findByCardNo(cno));
    }

    @GetMapping("/appoint/reports")
    public ResponseEntity<List<ReportModel>> getReport(@AuthenticationPrincipal UserDetails userDetails)
    {
        User user1 = userService.findUserByUsername(userDetails.getUsername());
        List<Report> reports = reportService.findByUser(user1);
        if (reports == null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ReportModel.getReportModels(reports),HttpStatus.OK);
    }
    @GetMapping("/appoint/reports/one")
    public ReportModel oneReport(@AuthenticationPrincipal UserDetails userDetails,@PathVariable("rno") String rno){
        return ReportModel.getReportModel(reportService.findByReportNO(rno));
    }
    //////////////////////////////////////////
    @PostMapping(path = "/appoint",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CardModel setAppointment(@Valid  @RequestBody Card card,
                                    @AuthenticationPrincipal User user,
                                    @RequestParam String hospital)
    {
        Hospital hos = hospitalService.findByHname(hospital);
        if(hos == null){
            return null;
        }
        card.setUser(user);
        card.setHospital(hos);
        card.setApproved(false);
        return  CardModel.getCardModel(cardService.save(card));
    }

}
