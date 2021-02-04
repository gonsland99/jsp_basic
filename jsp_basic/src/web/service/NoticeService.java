package web.service;

public class NoticeService {
	//오버로딩
	public List<Notice> getNoticeList(){
		return getNoticeList("title","",page);
	}
	public List<Notice> getNoticeList(int page){
		return getNoticeList("title","",page);
	}
	public List<Notice> getNoticeList(String field, String query, int page){
		return null;
	}
	
	public int getNoticeCount() {
		return 0; 
	}
	public int getNoticeCount(String field, String query) {
		return 0; 
	}
	public Notice getNotice(int id) {
		return null;
	}
	public Notice getNextNotice(int id) {
		return null;
	}
	public Notice getPrevNotice(int id) {
		return null;
	}
}
