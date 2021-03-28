package mvc2.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.svc.BoardListService;
import mvc2.vo.ActionForward;
import mvc2.vo.BoardBean;
import mvc2.vo.PageInfo;

public class BoardListAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount=boardListService.getListCount(); //�? 리�?��?? ??�? �?????.
		articleList = boardListService.getArticleList(page,limit); //리�?��?��?? �?????.
		//�? ???��? ??.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95�? ???��?? ?�림 �?�?.
   		//???? ???��??? 보�?��? ???? ???��? ??(1, 11, 21 ??...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//???? ???��??? 보�?��? �?�?�? ???��? ??.(10, 20, 30 ??...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/board/qna_board_list.jsp");
   		return forward;
   		
	 }

}
