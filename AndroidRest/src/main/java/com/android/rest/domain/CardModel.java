package com.android.rest.domain;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Data
@AllArgsConstructor
public class CardModel {

    private Long id;

    private String cardNo;

    private String description;

    private Date date;

    private Boolean approved = false;

    private String userName;

    private String hospitalName;

    public static List<CardModel> getCardModel(List<Card> cards)
    {
        List<CardModel>  cardModels= new ArrayList<>();
        for (Card card:cards)
        {
            cardModels.add(new CardModel(card.getId(),card.getCardNo(),card.getDescription(),card.getDate(),card.getApproved(),
                    card.getUser().getUsername(),card.getHospital().getHname()));

        }
        return cardModels;
    }
    public static CardModel getCardModel(Card card)
    {


            return  new CardModel(card.getId(),card.getCardNo(),card.getDescription(),card.getDate(),card.getApproved(),
                    card.getUser().getUsername(),card.getHospital().getHname());
    }

}
