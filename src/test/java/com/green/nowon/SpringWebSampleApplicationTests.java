package com.green.nowon;

import com.green.nowon.domain.entity.*;
import com.green.nowon.security.MyRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

@SpringBootTest
class SpringWebSampleApplicationTests {


	//멤버엔티티에 접근할 멤레포
	@Autowired
	MemberEntityRepository mrepo;
	//패스워드인코딩
	@Autowired
	PasswordEncoder pe;

	//@Test
	void 회원가입이잘되는지() {
		mrepo.save(MemberEntity.builder()
				.name("관리자")
				.email("admin@test.com")
				.pass(pe.encode("1234"))
				.build()
				.addRole(MyRole.USER)
				.addRole(MyRole.ADMIN)
		);
	}
	@Autowired
	DestinationEntityRepository destRepo;

	@Commit
	@Transactional
	//@Test
	void 배송지입력테스트() {
		mrepo.findById(1L).orElseThrow()
				.addAddress(DestinationEntity.builder()
						.zonecode("54321")
						.address("주소임니둥3")
						.build());

	}

	}
}
