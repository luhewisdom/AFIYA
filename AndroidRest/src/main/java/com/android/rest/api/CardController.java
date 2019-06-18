package com.android.rest.api;


import com.android.rest.domain.Card;
import com.android.rest.domain.User;
import com.android.rest.service.CardService;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/appoint")
@CrossOrigin("*")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;


    @GetMapping("/myappoint")
    public List<Card>  cardList(@AuthenticationPrincipal UserDetails userDetails){
        User user = userService.findUserByUsername(userDetails.getUsername());
        return  cardService.findByUserId(user.getId());
    }


    @PostMapping(path = "/appoint",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Card setAppointment( @RequestBody Card card)
    {
        return cardService.save(card);
    }
}
