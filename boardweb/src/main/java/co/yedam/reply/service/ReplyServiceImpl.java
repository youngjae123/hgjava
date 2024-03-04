package co.yedam.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;
import co.yedam.reply.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<Reply> replyList(SearchVO search) {
		return mapper.selectList(search);
	}

	@Override
	public boolean addReply(Reply reply) {
		return mapper.insertReply(reply) == 1;
	}

	@Override
	public boolean removeReply(int rno) {
		
		return mapper.deleteReply(rno) == 1;
	}
 
	@Override
	public int totalCount(int bno) {
		return mapper.selectCount(bno);
	}
}
