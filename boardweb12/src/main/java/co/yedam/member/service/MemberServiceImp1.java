package co.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DateSource;
import co.yedam.member.Member;
import co.yedam.member.mapper.MemberMapper;

public class MemberServiceImp1 implements  MemberService{
	SqlSession session = DateSource.getInstance().openSession(true);
	//openSession(true) 기본값은 false	//true -> 자동커밋하게 만듦.
    MemberMapper mapper = session.getMapper(MemberMapper.class); 
	// BoardMapper.class 실행되는 시점에 class의 정보를 읽고 객체를 만들어줌.
	@Override
	
	public Member loginCheck(Member member) {
		return mapper.selectMember(member);
		
	}

	
}
