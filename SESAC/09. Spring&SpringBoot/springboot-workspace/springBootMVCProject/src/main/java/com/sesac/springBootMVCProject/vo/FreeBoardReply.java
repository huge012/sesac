package com.sesac.springBootMVCProject.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "board") //양방향일때 무한loop주의 
@EqualsAndHashCode(of="rno")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_free_replies")
public class FreeBoardReply implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//oracle:sequence, mysql:identity
	Long rno;
	String reply;
	String replyer;
	@CreationTimestamp
	Timestamp regdate;
	@UpdateTimestamp
	Timestamp updatedate;
	
	// 댓글에서 board로 갈 수 있음
	@JsonIgnore // 데이터 조회할 때 board는 가져오지 않게 하는 옵션
	@ManyToOne //댓글여러개는 한개의 board와 연관관계
	FreeBoard board;  //board_bno칼럼이 생성 -> board를 참조하기 위한 PK가 들어옴(외래키가 됨)
	
}

