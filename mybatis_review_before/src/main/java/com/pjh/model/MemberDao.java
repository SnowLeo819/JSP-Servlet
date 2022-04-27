package com.pjh.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
	
	public List<MemberDto> getMemberList(){
		List<MemberDto> memberList = null;
		
		// 1. 연결, 2.마이바티스메서드. 
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberList = sqlSession.selectList("getMemberList");
		
		sqlSession.close();
		return memberList;
	}
	
	public MemberDto getSelectOne(String id) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("getSelectOne",id);
		sqlSession.close();
		return memberDto;
	}
}
