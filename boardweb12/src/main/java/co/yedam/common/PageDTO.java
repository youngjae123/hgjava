package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page;
	private int starPage, endPage; // 현재보여지는 페이지를 기준으로.
	private boolean prev, next;
	
	public PageDTO(int page, int totalCnt) {
			this.page = page;
			int realEnd = (int) Math.ceil(totalCnt/10.0) * 10 ; // 실제 마지막 페이지.
									//ceil 올림.
			
			this.endPage = (int) Math.ceil(page/10.0) * 10;
			this.starPage = this.endPage - 9 ;
			
			this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
			
			this.prev = this.starPage > 1;
			this.next = this.endPage < realEnd;
			
	}
}
