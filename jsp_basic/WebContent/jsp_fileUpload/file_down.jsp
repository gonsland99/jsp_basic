<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>
<%
	//fileCheck.jsp로부터 넘어온 파일이름 
	String fileName = request.getParameter("file_name");
	
	//다운로드 경로 및 객체생성
	String savePath = "upload";
	ServletContext context = getServletContext();
	String sDownloadPath = context.getRealPath(savePath);
	String sFilePath = sDownloadPath + "\\" + fileName;	//다운로드 서버상 물리적경로
	byte b[] = new byte[4096];
	FileInputStream in = new FileInputStream(sFilePath);

	//mimeType 설정
	//
	String sMimeType = getServletContext().getMimeType(sFilePath);
	if(sMimeType == null) {
		sMimeType = "application/octet-stream";
	}	
	response.setContentType(sMimeType);
	String agent = request.getHeader("User-Agent");
	
	//브라우저 종류 확인
	boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
	
	//internetExplorer인 경우 한글, 공백인식에 대한 깨짐방지 
	if(ieBrowser) {
		fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
	} else {
		fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
	}
	
	//모든파일에 대한 다운로드 박스 실행처리
	response.setHeader("Content-Disposition", "attachment; filename = " + fileName);
	
	ServletOutputStream out2 = response.getOutputStream();
	int numRead;
	
	while((numRead = in.read(b, 0, b.length)) != -1) {
		out2.write(b, 0, numRead);
	}
	
	out2.flush();
	out2.close();
	in.close();
%>