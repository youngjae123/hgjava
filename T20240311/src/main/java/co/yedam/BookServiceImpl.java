package co.yedam;

import java.awt.print.Book;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

// 목록 구현 mapper만들기
public class BookServiceImpl implements BookService {
	SqlSession session = DataSource.getInstance().openSession(true);
	BookMapper mapper = session.getMapper(BookMapper.class);
	
	@Override
	public List<BookVO> bookList() {
		return mapper.bookList();
	}
	
}
