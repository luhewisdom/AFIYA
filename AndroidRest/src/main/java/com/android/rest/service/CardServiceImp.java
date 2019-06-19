package com.android.rest.service;


import com.android.rest.domain.Card;
import com.android.rest.domain.User;
import com.android.rest.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImp implements CardService {

    public CardRepo cardRepo;

    @Autowired
    public CardServiceImp(com.android.rest.repository.CardRepo CardRepo)
    {
        this.cardRepo = CardRepo;
    }

    @Override
    public Card save(Card Card) {
        return cardRepo.save(Card);
    }

    @Override
    public List<Card> findByUserId(Long id) {
        return cardRepo.findByUserId(id);
    }

    @Override
    public List<Card> findByHospital(Long id) {
        return cardRepo.findByHospitalId(id);
    }

    @Override
    public Iterable<Card> saveAll(Iterable<Card> Cards) {
        return cardRepo.saveAll(Cards);
    }

    @Override
    public Optional<Card> findById(Long id) {
        return  cardRepo.findById(id);
    }

    @Override
    public Optional<Card> findOneById(Long id) {
        return cardRepo.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cardRepo.existsById(id);
    }

    @Override
    public Iterable<Card> findAll() {
        return cardRepo.findAll();
    }

    @Override
    public Iterable<Card> findAllById(Iterable<Long> ids) {
        return cardRepo.findAllById(ids);
    }

    @Override
    public Iterable<Card> findByHospitalUser(User user) {
        return cardRepo.findByHospitalUser(user);
    }

    @Override
    public Card findByCardNo(String cardno) {
        return cardRepo.findByCardNo(cardno);
    }

    @Override
    public Iterable<Card> findByDateOrderByAsc() {
        return cardRepo.findAllByOrderByDateAsc();
    }

    @Override
    public Iterable<Card> findByDateBetween(Date start, Date end) {
        return cardRepo.findAllByDateBetween(start,end);
    }


    @Override
    public long count() {
        return cardRepo.count();
    }

    @Override
    public void deleteById(Long id) {
        cardRepo.deleteById(id);

    }

    @Override
    public void delete(Card Card) {
        cardRepo.delete(Card);

    }

    @Override
    public void deleteAll(Iterable<Card> Cards) {
        cardRepo.deleteAll(Cards);

    }

    @Override
    public void deleteAll() {
        cardRepo.deleteAll();

    }
    
    
}
