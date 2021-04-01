package dog.action;

import java.io.PrintWriter;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog.svc.DogRegistService;
import dog.vo.ActionForward;
import dog.vo.Dog;

public class DogRegistAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogRegistService dogRegistService = new DogRegistService();
		
		//1.파일 업로드
		String saveFolder = "/imgs";
//		String saveFolder = "c:/dogUpload";
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath(saveFolder);
		//System.out.println(realFolder);
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
//		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Dog dog = new Dog(0, 
				          multi.getParameter("kind"),
						  Integer.parseInt(multi.getParameter("price")),
						  image, 
						  multi.getParameter("nation"),
						  Integer.parseInt(multi.getParameter("height")),
						  Integer.parseInt(multi.getParameter("weight")), 
						  multi.getParameter("content"), 
						  0);
		boolean isRegistSuccess = dogRegistService.registDog(dog);
		ActionForward forward = null;
		//2. 파일업로드 결과처리
		if(isRegistSuccess) {
			forward = new ActionForward("dogList.dog", true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
