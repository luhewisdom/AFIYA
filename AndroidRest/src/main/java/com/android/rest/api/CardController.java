package com.android.rest.api;


import com.android.rest.domain.Card;
import com.android.rest.domain.Hospital;
import com.android.rest.domain.Report;
import com.android.rest.domain.User;
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
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ReportService reportService;


    @GetMapping("/appoint/myappoint")
    public List<Card>  cardList(@AuthenticationPrincipal UserDetails userDetails){
        User user = userService.findUserByUsername(userDetails.getUsername());
        return  cardService.findByUserId(user.getId());
    }


    @PostMapping(path = "/appoint",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Card setAppointment(@Valid  @RequestBody Card card, @AuthenticationPrincipal User user,
                               @RequestParam String hospital)
    {
        Hospital hos = hospitalService.findByHname(hospital);
        if(hos == null){
            return null;
        }

        card.setUser(user);
        card.setHospital(hos);
        return  cardService.save(card);
    }

    @GetMapping("/appoint/report")
    public ResponseEntity<List<Report>> getReport(@AuthenticationPrincipal UserDetails userDetails)
    {
        User user1 = userService.findUserByUsername(userDetails.getUsername());
        List<Report> reports = reportService.findByUser(user1);
        if (reports == null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reports,HttpStatus.OK);
    }

}
