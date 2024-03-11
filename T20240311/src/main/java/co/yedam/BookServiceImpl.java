package co.yedam;

import java.awt.print.Book;
import java.util.List;

// 목록 구현 mapper만들기
public class BookServiceImpl implements BookService {
	@Override
	public List<BookVO> bookList() {
		return mapper.bookList();
	}
	
}
