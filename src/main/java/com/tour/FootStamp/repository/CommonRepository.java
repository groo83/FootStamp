package com.tour.FootStamp.repository;

import com.tour.FootStamp.entity.Member;

import java.util.List;
import java.util.Optional;

public interface CommonRepository {
    Member save(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
