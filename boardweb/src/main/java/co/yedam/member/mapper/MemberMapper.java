package co.yedam.member.mapper;

import co.yedam.member.Member;

public interface MemberMapper {
	Member selectMember(Member member);
	int insertMember(Member member);
}
