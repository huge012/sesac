package com.sesac.springBootMVCProject.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Modifying;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(exclude="files2") @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="tbl2_pdsboard") @EqualsAndHashCode(of="pid")
public class PDSBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String pname;
	private String pwriter;
	
	// cascade : 연관관계 있는 테이블에도 변화를 줌, fetch : eager - 조회할 때 연관 테이블도 함께 조회
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="pdsno")  //PDSFile칼럼에 생성, 그러나 PDSFile에선 접근 불가
	private List<PDSFile> files2;
	
	
}
