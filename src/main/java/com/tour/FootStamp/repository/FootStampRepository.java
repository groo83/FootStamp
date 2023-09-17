package com.tour.FootStamp.repository;

import com.tour.FootStamp.dto.FootStampDto;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FootStampRepository {
    private final EntityManager em;

    @Autowired
    public FootStampRepository(EntityManager em) {
        this.em = em;
    }

    public FootStampDto save(FootStampDto footStamp) {
        em.persist(footStamp);
        return footStamp;
    }
}
