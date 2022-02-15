package com.sesac.springBootMVCProject.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl2_boards")
@Entity
public class BoardVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가-DB에 따라 알아서, oracle:sequence, mysql:identity
	private Long bno;
	@NonNull // 자바에서 객체 생성 시 필수 (DB에서는 아님)
	@Column(nullable = false) // DB에서 null값 비허용
	private String title;
	private String writer;
	@Column(length = 100) // 최대 길이 설정
	private String content;
	@CreationTimestamp // 생성 시 입력
	private Timestamp regDate;
	@UpdateTimestamp // 생성 시 입력되고 수정 시 수정됨
	private Timestamp updateDate;
}
