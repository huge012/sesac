package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.MemberVO;

public interface MemberRepository extends CrudRepository<MemberVO, String> {
	// Member를 통해서 profile의 건수를 조회하기
	// JPQL아니고 오리지널 sql
	@Query(value = "select m.mid, count(p.fname) from tbl2_members m left outer join tbl2_profile p on m.mid = p.member_mid group by m.mid", nativeQuery = true)
	public List<Object[]> getProfileCountByMember();

	@Query("select m.mid, count(p) from MemberVO m left outer join ProfileDTO p on m.mid = p.member group by m.mid")
	public List<Object[]> getProfileCountByMember2();
}
