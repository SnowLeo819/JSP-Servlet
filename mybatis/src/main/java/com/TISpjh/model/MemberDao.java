package com.TISpjh.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

//DataBaseAccessObject
public class MemberDao {
	public List<MemberDto> getAllMemberList() {
		List<MemberDto> memberList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactiory.getSqlSession();
		memberList = sqlSession.selectList("getAllMemberList");
		sqlSession.close();
		
		return memberList;
	}
}
