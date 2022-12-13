package com.green.nowon;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringWebSampleApplicationTests {

	@Autowired
	MemberEntityRepository repository;
	@Autowired
	PasswordEncoder encoder;
	@Test
	void 관리자계정생성() {
		repository.save(MemberEntity.builder()
						.email("admin@test.com")
						.name("관리자")
						.pass(encoder.encode("1234"))
				.build().addRole(MyRole.USER).addRole(MyRole.ADMIN));
	}

}
