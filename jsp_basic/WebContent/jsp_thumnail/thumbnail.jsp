<%@page import="javax.media.jai.RenderedOp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.awt.Graphics2D, java.awt.image.renderable.ParameterBlock, java.awt.image.BufferedImage,
			javax.media.jai.JAI, javax.media.jai.RenderableOp, javax.imageio.ImageIO,
			com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy,
			java.util.*, java.io.*"    
%>
<%
	ServletContext context = request.getServletContext();
	String imagePath = context.getRealPath("image");
	//out.println(imagePath);
	int size = 1 * 1024 * 1024;
	String filename = "";
	
	try {
		MultipartRequest multi = new MultipartRequest(request, imagePath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement();
		filename = multi.getFilesystemName(file);	//파일명.jpg
	} catch (Exception e) {
		e.getStackTrace();
	}
	
	//이미지 불러오는 객체
	ParameterBlock pb = new ParameterBlock();
	pb.add(imagePath + "/" + filename);
	RenderedOp rOp = JAI.create("fileload", pb); //JAI가 제공하는 코덱사용
	
	//BufferedImage클래스에 이미지 담기
	BufferedImage bi = rOp.getAsBufferedImage();
	BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); //썸네일이미지 객체
	Graphics2D g = thumb.createGraphics();
	g.drawImage(bi, 0, 0, 100, 100, null);
	File file = new File(imagePath + "/sm_" + filename); //섬네일 이미지 출력할 경로
	ImageIO.write(thumb, "jpg", file);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
-원본이미지-<br />
<img src="image/<%=filename %>">
-썸네일 이미지-<br />
<img src="image/sm_<%=filename %>">
</body>
</html>