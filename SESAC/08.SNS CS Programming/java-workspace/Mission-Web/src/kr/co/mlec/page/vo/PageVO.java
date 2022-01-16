package kr.co.mlec.page.vo;

public class PageVO {
	private int page; // 현재 해당 페이지
	private int totalCount; // 게시글 총 갯수
	private int beginPage; // 시작 페이지 
	private int endPage; // 끝 페이지
	private int displayRow; // 보여줄 게시글 갯수
	private int displayPage; // 보여줄 페이지 수 (10개 페이지 )
	boolean prev; // 이전 버튼 유무
	boolean next; // 다음 버튼 유무
	
	public PageVO() {
		page = 1;
		displayRow = 10;
		displayPage = 10;
	}
	
	public PageVO(int page, int totalCount, int beginPage, int endPage, int displayRow, int displayPage, boolean prev,
			boolean next) {
		super();
		this.page = page;
		this.totalCount = totalCount;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.displayRow = displayRow;
		this.displayPage = displayPage;
		this.prev = prev;
		this.next = next;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		paging();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", totalCount=" + totalCount + ", beginPage=" + beginPage + ", endPage="
				+ endPage + ", displayRow=" + displayRow + ", displayPage=" + displayPage + ", prev=" + prev + ", next="
				+ next + "]";
	}
	
	// totalPage 들어오면 자동 계산 - endPage, beginPage, totalPage, prev, next
	private void paging() {
		// 현재의 10번째 페이지 번호
		endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
		
		// 현재의 1번째 페이지 번호
		beginPage = endPage - (displayPage - 1);
		
		// 종합 페이지
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		
		if (totalPage<endPage) {
			endPage = totalPage;
			next = false;
		}
		else {
			next = true;
		}
		prev = (beginPage==1) ? false : true;
	}
	
}
