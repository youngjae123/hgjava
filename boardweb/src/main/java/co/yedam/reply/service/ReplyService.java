package co.yedam.reply.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.Center;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyService {
	List<Reply> replyList(SearchVO search);
	boolean addReply(Reply reply);
	boolean removeReply(int rno);
	
	// 댓글전체건수.
	int totalCount(int bno);
	
	// 센터 등록.
	int addCenter(Center[] array);
	
	// 시도정보
	List<Map<String,Object>> getCntSido();
}
