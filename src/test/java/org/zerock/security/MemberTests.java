package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class MemberTests {
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	@Setter(onMethod_ =@Autowired)
	private MemberMapper mapper;
	
	@Test
	public void testInsertMember() {
		String sql = "insert into jinuk_member(userid, userpw, username, phonenumber) values (?,?,?,?)";
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(2,  pwencoder.encode("pw" + i));
				
				if(i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
					if(i >= 10)
						pstmt.setString(4, "010-" + "00" + i + "-00" + i);
					else
						pstmt.setString(4, "010-" + "000" + i + "-000" + i);
				} else if(i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
					pstmt.setString(4, "010-" + "00" + i + "-00" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
					pstmt.setString(4, "010-" + "00" + i + "-00" + i);
				}
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {try {pstmt.close();} catch(Exception e) {}}
				if(con != null) {try {con.close();} catch(Exception e) {}}
			}
		}
	}
	@Test
	public void testInsertAuth() {
		String sql = "insert into jinuk_member_auth (userid, auth) values (?, ?)";
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				if(i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if(i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {try {pstmt.close();} catch(Exception e) {}}
				if(con != null) {try {con.close();} catch(Exception e) {}}
			}
		}
	}
	@Test
	public void testSingup() {
		MemberVO member = new MemberVO();
		member.setUserid("test_id2");
		member.setUserpw("test_pw2");
		member.setUsername("test_name2");
		member.setPhonenumber("010-0000-0002");
		
		mapper.insert(member);
		mapper.insertAuth(member);
		
		log.info(member);
	}
}
