package com.green.nowon;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import org.springframework.security.crypto.password.PasswordEncoder;

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
				.name("admin@test.com")
				.email(pe.encode("1234"))
				.pass("관리자")
				.build()
				.addRole(MyRole.USER)
				.addRole(MyRole.ADMIN)
				);





	}
}
