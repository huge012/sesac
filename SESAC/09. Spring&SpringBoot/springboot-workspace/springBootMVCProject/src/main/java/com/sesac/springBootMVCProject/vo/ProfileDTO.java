package com.sesac.springBootMVCProject.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"fno"}) // mid가 같으면 같은 객체로 판정
@Entity @Table(name = "tbl2_profile")
public class ProfileDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long fno;
	String fname;
	boolean currentYn;
	
	// 항상 나를 기준으로, Profile 여러개가 하나의 Member의 소유
	// profile이 member를 참조하기때문에 member의 id가 테이블에 들어감
	// 컬럼 이름은 member_mid
	@ManyToOne
	MemberVO member;
}
