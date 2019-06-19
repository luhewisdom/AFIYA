package com.android.rest.repository;

import com.android.rest.domain.Card;
import com.android.rest.domain.User;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CardRepo extends CrudRepository<Card,Long> {
     List<Card> findByUserId(Long id);
     List<Card> findByHospitalId(Long id);
     Iterable<Card> findByHospitalUser(User user);
     Card findByCardNo(String cardno);
     Iterable<Card> findAllByOrderByDateAsc();
     Iterable<Card> findAllByDateBetween(Date start,Date end);



}
