package com.tour.FootStamp.repository;

import com.tour.FootStamp.dto.FootStampDto;

import com.tour.FootStamp.entity.FootStamp;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootStampRepository extends JpaRepository<FootStamp, Long> {
/*    private final EntityManager em;

    @Autowired
    public FootStampRepository(EntityManager em) {
        this.em = em;
    }

    public FootStamp save(FootStamp footStamp) {
        em.persist(footStamp);
        return footStamp;
    }*/
}
