package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.sesac.springBootMVCProject.repository.PDSBoardRepository;
import com.sesac.springBootMVCProject.repository.PDSFileRepository;
import com.sesac.springBootMVCProject.vo.PDSBoard;
import com.sesac.springBootMVCProject.vo.PDSFile;

import lombok.extern.java.Log;

@Commit
@SpringBootTest
@Log
public class PDSBoardFileTest {
	
	@Autowired
	PDSBoardRepository bRepo;
	
	@Autowired
	PDSFileRepository fRepo;
	
	//@Test
	public void test1() {
		log.info("------------- OneToMany 연습 : DB insert --------------");
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			List<PDSFile> fileList = new ArrayList<>();
			IntStream.rangeClosed(100, 105).forEach(j->{
				fileList.add(PDSFile.builder().pdsfilename("파일_"+i+"_"+j+".png").build());				
			});
			
			PDSBoard board = PDSBoard.builder()
					.pname("새싹"+i)
					.pwriter("user"+(i%2))
					.files2(fileList)
					.build();
			// PDSFile과 PDSBoard 둘 다 입력됨 -> cascade 설정때문
			bRepo.save(board);
		});
	}
	
	//@Test
	public void test2() {
		log.info("------------- OneToMany 연습 : Eager --------------");
		bRepo.findAll().forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void test3() {
		log.info("------------- OneToMany 연습 : Eager --------------");
		bRepo.findAll().forEach(b->{
			// board에서 첨부파일 정보 및 개수 확인 가능
			System.out.println(b.getPid()+" ========> 첨부파일 : "+b.getFiles2().size()+"개");
		});
	}
	
	//@Test
	public void test4() {
		log.info("------------- OneToMany 연습 : delete --------------");
		fRepo.deleteById(137L);
		fRepo.deleteById(138L);
		fRepo.deleteById(129L);
		fRepo.deleteById(130L);
		fRepo.deleteById(131L);
		fRepo.deleteById(141L);
		fRepo.deleteById(122L);
	}
	
	// 일대다 단방향에서의 update - 맨 위에 @Commit도 해야함(Test이기때문)
	//@Transactional
	//@Test
	public void test5() {
		log.info("------------- OneToMany 연습 : Modifying --------------");
		bRepo.updatePDSFile(126L, "sesac.jpg");
		bRepo.updatePDSFile(127L, "sesac.jpg");
		bRepo.updatePDSFile(134L, "sesac.jpg");
		bRepo.updatePDSFile(139L, "sesac.jpg");
		bRepo.updatePDSFile(144L, "sesac.jpg");
	}
	
	//@Test
	public void test6() {
		log.info("------------- OneToMany 연습 : One 수정 + Many 추가 --------------");
		bRepo.findById(121L).ifPresentOrElse(b->{
			System.out.println(b);
			System.out.println(b.getFiles2().size()+"건");
			System.out.println("-----수정-----");
			b.setPname("수정새싹1");
			b.setPwriter("찔레");
			b.getFiles2().add(PDSFile.builder().pdsfilename("추가첨부파일1.png").build());
			bRepo.save(b);
		}, ()->{
			System.out.println("해당 Board는 존재하지 않습니다.");
		});
	}
}
