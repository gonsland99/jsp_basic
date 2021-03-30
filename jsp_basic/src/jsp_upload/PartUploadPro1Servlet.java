package jsp_upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/partUploadPro1")
//파일이 0바이트보다 커지면 지정경로에 저장
@MultipartConfig(fileSizeThreshold=0, location = "D:\\gon\\java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jsp_basic\\upload")
public class PartUploadPro1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String writer = request.getParameter("writer");
		Part part = request.getPart("partFile1");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String contentDisposition = part.getHeader("content-disposition");
		String uploadFileName = getUploadFileName(contentDisposition);
		part.write(uploadFileName);
		out.println("작성자: " + writer + "업로드파일: " + uploadFileName);
	}
	//브라우저가 IE인 경우처리
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		int firstOutosIndex = contentSplitStr[2].indexOf("\"");
		int lastOutosIndex = contentSplitStr[2].lastIndexOf("\"");
		uploadFileName = contentSplitStr[2].substring(firstOutosIndex + 1, lastOutosIndex);
		return uploadFileName;
	}
	
}
