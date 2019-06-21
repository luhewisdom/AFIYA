package com.android.rest.api;


import com.android.rest.domain.*;
import com.android.rest.service.CardService;
import com.android.rest.service.HospitalService;
import com.android.rest.service.ReportService;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/staff",produces="application/json")
@CrossOrigin(origins="*")
public class StafController {

    private HospitalService hospitalService;

    private CardService cardService;

    private ReportService reportService;

    private UserService userService;

    @Autowired
    public  StafController(HospitalService hospitalService,
                           CardService cardService,
                           ReportService reportService,
                           UserService userService) {
        this.hospitalService = hospitalService;
        this.cardService = cardService;
        this.reportService = reportService;
        this.userService = userService;
    }




    @PostMapping(path = "/registerHospital",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public HospitalModel createHospital(@RequestBody Hospital hospital, @AuthenticationPrincipal User user) {
        hospital.setUser(user);
        return HospitalModel.getHospitalModel(hospitalService.save(hospital));
    }

    @PutMapping(path = "/updateHospital/{id}",consumes = "application/json")
    public HospitalModel updateHospital(@PathVariable("id") Long id, @RequestParam Hospital hospital)
    {
        return HospitalModel.getHospitalModel(hospitalService.save(hospital));
    }

    @DeleteMapping(path = "/deleteHospital/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHospital(@PathVariable("id") Long id) {
        try {
            hospitalService.deleteById(id);
        } catch (EmptyStackException e) {

        }
    }


    @GetMapping("/appointments")
    public Iterable<CardModel> seeAppointments (@AuthenticationPrincipal User user)
    {
        return CardModel.getCardModel((List<Card>) cardService.findByHospitalUser(user));
    }

    @GetMapping("/appointments/ordered/card")
    public CardModel seeAppointment (@RequestParam("cardno") String cardno)
    {
        return CardModel.getCardModel(cardService.findByCardNo(cardno));
    }

    @GetMapping("/appointments/ordered")
    public Iterable<CardModel> seeInOrder ()
    {
        return CardModel.getCardModel((List<Card>) cardService.findByDateOrderByAsc());
    }
    @PatchMapping(path = "approve/{id}", consumes = "application/json")
    public CardModel updateAppointment (@PathVariable("id") Long id,
                                   @RequestParam("approve") boolean approve,
                                   @RequestParam("desc") String desc,
                                   @AuthenticationPrincipal User user)
    {
        Card card = cardService.findById(id).get();
        card.setApproved(approve);
        card.setDescription(desc);
        return CardModel.getCardModel(cardService.save(card));
    }

    @DeleteMapping(path = "/appointment/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment (@RequestParam("id") Long id,@AuthenticationPrincipal
                                       User user)
    {
        try {
            cardService.deleteById(id);
        } catch (EmptyStackException e) {

        }
    }
    @PostMapping(path = "/report",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportModel createHospital(@RequestBody Report report,@RequestParam("username")String username,  @AuthenticationPrincipal User user) {
        User user1 = userService.findUserByUsername(username);
        Hospital hospital = hospitalService.findByUser(user);

        report.setHospital(hospital);
        report.setUser(user1);
        return ReportModel.getReportModel(reportService.save(report));
    }

}

