package com.tour.FootStamp.repository;

import com.tour.FootStamp.entity.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemoryMemberRepositoryTest {

    EntityManager ea;
    MemberRepository repository = new MemberRepository(ea);

    @Test
    public void save(){
        //given
        Member member = new Member();
        //member.setName("first_jpa_test");
        member.setName("jyp");
        member.setId("second_jpa_test");
        member.setPw("1234");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setPw("test");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        member1.setPw("test");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
