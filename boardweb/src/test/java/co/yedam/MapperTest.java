package co.yedam;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.mapper.ReplyMapper;

public class MapperTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
//		Reply rep = new Reply();
//		rep.setBoardNo(143);
//		rep.setReply("143번 댓글입니다..");
//		rep.setReplyer("newbie");
//		mapper.insertReply(rep);//mapper 기능 호출
		//mapper.deleteReply(8);//삭제
		
		SearchVO search = new SearchVO();
		search.setBno(143);
		search.setRpage(3);
		
		
		
		mapper.selectList(search) // List<Reply>
		.forEach(reply -> System.out.println(reply.toString()));
		
		
	}

}
