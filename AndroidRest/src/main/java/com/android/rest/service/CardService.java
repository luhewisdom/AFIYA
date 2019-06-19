package com.android.rest.service;

import com.android.rest.domain.Card;
import com.android.rest.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CardService {
    public Card save(Card Card);

    public List<Card> findByUserId(Long id);

    public List<Card> findByHospital(Long id);

    public Iterable<Card> saveAll(Iterable<Card> Cards);

    Optional<Card> findById(Long id);


    public Optional<Card> findOneById(Long id);


    boolean existsById(Long id);

    Iterable<Card> findAll();

    Iterable<Card> findAllById(Iterable<Long> ids);

    Iterable<Card> findByHospitalUser(User user);

    Card findByCardNo(String cardno);

    Iterable<Card> findByDateOrderByAsc();

    Iterable<Card> findByDateBetween(Date start, Date end);

    //Page<Card> findAll(Pageable pageable);

    long count();

    void deleteById(Long id);

    void delete(Card Card);

    void deleteAll(Iterable<Card> Cards);

    void deleteAll();

}
