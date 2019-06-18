package com.android.rest.repository;

import com.android.rest.domain.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepo extends CrudRepository<Card,Long> {
     List<Card> findByUserId(Long id);
     List<Card> findByHospitalId(Long id);
}
