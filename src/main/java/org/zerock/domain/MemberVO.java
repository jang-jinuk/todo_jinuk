package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String phonenumber;
	private boolean enabled;
	private Date regDate;
	private Date updateDate;
}
