package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.MemberVO;
import com.sesac.springBootMVCProject.vo.ProfileDTO;

public interface ProfileRepository extends CrudRepository<ProfileDTO, Long> {
	
	// 기본 CRUD 작업 : findAll(), findById(), save(), count(), deleteById()
	
	// 규칙에 맞게 메소드 추가 가능
	List<ProfileDTO> findByMember(MemberVO member);
}
