package com.sesac.springBootMVCProject.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(exclude = "replies") // 양방향이기때문에 무한루프를 조심해야 함, 참조되는 요소는 빼는게 좋음
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_freeboards")
@EqualsAndHashCode(of = "bno")
public class FreeBoard  { // 댓글을 여러개 달고 싶음
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)//oracle:sequence, mysql:identity
	private Long bno;
    @NonNull
    @Column(nullable = false)  
	private String title;
	private String writer;
	@Column(length = 100)
	private String content;	
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;	
	
	// board에서 댓글로 갈 수 있음
	// 하나의 게시글에 여러개의 댓글, mappedBy : board라는 컬럼에 메여있음을 의미
	@BatchSize(size = 100)
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	List<FreeBoardReply> replies;
	
}
