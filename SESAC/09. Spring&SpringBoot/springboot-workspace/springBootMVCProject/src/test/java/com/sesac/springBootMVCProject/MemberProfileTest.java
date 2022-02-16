package com.sesac.springBootMVCProject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.repository.MemberRepository;
import com.sesac.springBootMVCProject.repository.ProfileRepository;
import com.sesac.springBootMVCProject.vo.MemberRole;
import com.sesac.springBootMVCProject.vo.MemberVO;
import com.sesac.springBootMVCProject.vo.ProfileDTO;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class MemberProfileTest {

	/* Repository 생성 - interface 구현된 repo 들어옴 */
	@Autowired
	MemberRepository mRepo;
	@Autowired
	ProfileRepository pRepo;
	
	
	//@Test
	public void test1() {
		MemberVO m1 = MemberVO.builder().mid("jy").mname("젼").build();
		MemberVO m2 = MemberVO.builder().mid("jy").mname("젼2").build();
		System.out.println(m1==m2); // 주소 비교
		System.out.println(m1.equals(m2)); // 객체 비교, id가 같으면 같은 객체로 보라고 설정했으므로 true
	}
	
	//@Test
	public void test2() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			MemberVO member = MemberVO.builder()
					.mid("test"+i)
					.mname("테스트"+i)
					.mpassword("1234")
					.mrole( i % 2 == 0 ? MemberRole.Manager : MemberRole.user )
					.build();
			mRepo.save(member);
		});
	}
	
	//@Test
	public void test3() {
		// 컬럼이 있으면 얻어오고 없으면 에러 처리
		// MemberVO member = mRepo.findById("test3").orElseThrow();
		MemberVO member = mRepo.findById("test1").get();
		
		IntStream.rangeClosed(1, 4).forEach(i->{
			ProfileDTO profile = ProfileDTO.builder()
					.fname("내사진"+i)
					.currentYn(i == 4 ? true : false)
					.member(member)
					.build();
			pRepo.save(profile);
		});
	}
	
	//@Test
	public void test4() {
		
		// 특정 멤버 조회
		System.out.println("--------------------- 특정 멤버 조회 --------------------");
		MemberVO member = mRepo.findById("test1").get();
		System.out.println(member);
		System.out.println("-----------------------------------------------------");
		
		// 특정 프로파일 조회
		System.out.println("------------------- 특정 프로파일 조회 ------------------");
		ProfileDTO profile = pRepo.findById(113L).get();
		System.out.println(profile);
		System.out.println("멤버 정보 : "+profile.getMember());
		System.out.println("-----------------------------------------------------");
		
	}
	
	//@Test
	public void test5() {
		System.out.println("------------------- 특정 회원의 프로파일 조회 ------------------");
		MemberVO member = mRepo.findById("test2").get();
		List<ProfileDTO> plist = pRepo.findByMember(member);
		plist.forEach(p->{
			//System.out.println(p);
			log.info(p.toString());
		});
		System.out.println("----------------------------------------------------------");
	}
	
	//@Test
	public void test6() {
		List<Object[]> mylist = mRepo.getProfileCountByMember();
		mylist.forEach(row->{
			System.out.println(Arrays.toString(row));
			for(Object obj:row) {
				System.out.print(obj+"----");
			}
			System.out.println();
		});
	}
	
	//@Test
	public void test7() {
		List<Object[]> mylist = mRepo.getProfileCountByMember2();
		mylist.forEach(row->{
			System.out.println(Arrays.toString(row));
			for(Object obj:row) {
				System.out.print(obj+"----");
			}
			System.out.println();
		});
	}
}
