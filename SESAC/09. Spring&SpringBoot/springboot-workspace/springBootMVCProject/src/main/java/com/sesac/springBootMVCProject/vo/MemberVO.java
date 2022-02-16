package com.sesac.springBootMVCProject.vo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"mid"}) // mid가 같으면 같은 객체로 판정
@Entity @Table(name = "tbl2_members")
public class MemberVO {
	
	@Id
	String mid;
	String mpassword;
	String mname;
	@Enumerated(EnumType.STRING) // enum의 타입이 숫자가 아닌 문자 그 자체가 들어가게 설정
	MemberRole mrole;
	
	
}
