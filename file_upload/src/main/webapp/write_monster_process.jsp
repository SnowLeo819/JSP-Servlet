<%@page import="com.jjang051.model.MonsterDto"%>
<%@page import="com.jjang051.model.MonsterDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.jjang051.util.ScriptWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String savePath = "upload_monster";
	ServletContext context = this.getServletContext(); // 현재 돌아가는(서비스중인) context
	
	String realPath = context.getRealPath(savePath);
	int fileSize = 1024*1204*100;	
	
	String encoding = "UTF-8";
	DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy(); // 이름 같을 때 처리 방법....
	
	System.out.println(context);    
	System.out.println(realPath);    

	MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding);
	
	String user_title = multipart.getParameter("user_title");
	String user_bg = multipart.getParameter("user_bg");
	String user_link = multipart.getParameter("user_link");
	String user_contents = multipart.getParameter("user_contents");
	String monsterImg = multipart.getOriginalFileName("user_file");
	String monsterRealImg = multipart.getFilesystemName("user_file");
	
	MonsterDao monsterDao = new MonsterDao();
	MonsterDto monsterDto = new MonsterDto();
	
	monsterDto.setTitle(user_title);
	monsterDto.setContents(user_contents);
	monsterDto.setLink(user_link);
	monsterDto.setBg(user_bg);
	monsterDto.setMonsterImg(monsterImg);
	monsterDto.setMonsterRealImg(monsterRealImg);
	
	System.out.println("42==="+monsterDto.toString());

	
	int result = monsterDao.insertMonster(monsterDto);
	if (result > 0) {
		ScriptWriter.alertAndNext(response, "이미지가 업로드 되었습니다.", "/file_upload");
	} else {
		ScriptWriter.alertAndBack(response, "db오류입니다.");
	}
	
	
%>




