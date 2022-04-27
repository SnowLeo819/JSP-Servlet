package com.TISpjh.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

//DataBaseAccessObject
public class MemberDao {
	
	public int getMemberTotal(String search_select, String search_word) {
		int result = 0;

		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word); 
		
		SqlSession seqlSession = MyBatisConnectionFactory.getSqlSession();
		result = seqlSession.selectOne("getMemberTotal",searchMap);
		seqlSession.close();
		
		return result;
	}
	
	public List<MemberDto> getMemberList(int start,int end, String search_select, String search_word) {
		List<MemberDto> memberList = null;
		
		HashMap<String, Object> memberMap = new HashMap<>();
		memberMap.put("start", start);
		memberMap.put("end", end);
		memberMap.put("searchSelect", search_select);
		memberMap.put("searchWord", search_word);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberList = sqlSession.selectList("getMemberList", memberMap);
		sqlSession.close();
		
		return memberList;
	}
	
//	public List<MemberDto> getAllMemberList() {
//		List<MemberDto> memberList = null;
//		
//		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
//		memberList = sqlSession.selectList("getAllMemberList");
//		sqlSession.close();
//		
//		return memberList;
//	}
	
	public MemberDto getSelectOne(String id) {
		MemberDto memberDto = new MemberDto();
		
		System.out.println(id);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("getMemberSelectOne", id);   //MemberMapper.xml 에 정의된 id값 
		
		sqlSession.close();
		return memberDto;
	}
	
	public MemberDto getLoggedMember(MemberDto pMemberDto) {
		MemberDto memberDto = new MemberDto();
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("getLoggedMember", pMemberDto);
		
		sqlSession.close();
		return memberDto;
	}
	
	public int deleteMember(MemberDto memberDto) {
		 int result = 0;
		 
		 SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		 result =sqlSession.delete("deleteMember",memberDto);
		 sqlSession.commit();
		 
		 sqlSession.close();
		 return result;
	}
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto) ;
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
	
	public int updateMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("updateMemeber",memberDto) ;
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
	
	public int idCheck(String id) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck",id);
		
		sqlSession.close();
		return result;
	} 
}
