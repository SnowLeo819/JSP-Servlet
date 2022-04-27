package com.TISpjh.model;

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
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
	
	public int idCheck(String id) {
		int result =0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.selectOne("idCheck",id);

		sqlSession.close();		
		return result;
	}

	public MemberDto getLoggedMember(MemberDto pMemberDto) {
		MemberDto memberDto = new MemberDto();
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("getLoggedMember",pMemberDto);
		
		sqlSession.close();
		return memberDto;
	}
	
	public int deleteMember(MemberDto memberDto) {
		int result =0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.selectOne("deleteMember",memberDto);
		sqlSession.commit();

		sqlSession.close();		
		return result;
	}

	public int updateMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.selectOne("updateMember",memberDto);
		sqlSession.commit();

		sqlSession.close();	
		return result;
	}
}
