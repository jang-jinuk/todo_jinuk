package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
    private MemberMapper mapper;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public MemberServiceImpl(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//    
	@Override
	public void register(MemberVO member) {
	log.info("registerMember....." + member);
	
//	member.setUserpw(passwordEncoder.encode(member.getUserpw()));
	
	mapper.insert(member);
	mapper.insertAuth(member);
	}
}
