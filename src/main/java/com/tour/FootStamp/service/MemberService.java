package com.tour.FootStamp.service;


import com.tour.FootStamp.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public Optional<Member> findOne(String memberId);

    public List<Member> findMembers();

    public String join(Member member);
}
