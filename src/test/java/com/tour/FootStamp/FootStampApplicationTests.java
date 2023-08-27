package com.tour.FootStamp;

import com.tour.FootStamp.entity.Member;
import com.tour.FootStamp.repository.MemberRepository;
import com.tour.FootStamp.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FootStampApplicationTests {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("jiyeong");
		member.setId("first_jpa_test");
		member.setPw("1234");
		//when
		String memberId = memberService.join(member);
		//then
		Member findMember = memberRepository.findById(memberId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	@Test
	public void 중복_회원_예외(){
		//given
		Member member1 = new Member();
		member1.setName("psh");

		Member member2 = new Member();
		member2.setName("psh");
		//when
		memberService.join(member1);


		//try catch 대체 assertThrows
		//then
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
	}

	@Test
	public void findAll(){
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		memberRepository.save(member2);

		//when
		List<Member> result = memberRepository.findAll();

		//then
		assertThat(result.size()).isEqualTo(2);
	}
}
