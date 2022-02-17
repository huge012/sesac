package com.sesac.springBootMVCProject.vo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter // 자동생성....setter는 직접구현함
@AllArgsConstructor
@Builder
@ToString
public class PageVO {
	private static final int DEFAULT_SIZE = 10; // 한 페이지에 몇 줄
	private static final int DEFAULT_MAX_SIZE = 50; // 페이지 최대 수

	int page;
	int size;
	String type;
	String keyword;

	public PageVO() {
		this.page = 1;
		this.size = DEFAULT_SIZE;
	}

	public void setPage(int page) {
		this.page = page < 0 ? 1 : page;
	}

	public void setSize(int size) {
		this.size = size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE ? DEFAULT_SIZE : size;
	}

	// direction 0 - 오름차순, 1 - 내림차순, String... props - 전개연산자(배열과 유사)
	public Pageable makePaging(int direction, String... props) {
		Sort.Direction dir = direction == 0 ? Direction.DESC : Direction.ASC;
		// 0이 곧 1페이지이므로 page-1 처리해줘야 java에 맞음
		return PageRequest.of(this.page - 1, this.size, dir, props);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
