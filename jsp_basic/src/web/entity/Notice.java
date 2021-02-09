package web.entity;

import java.sql.Date;

public class Notice {
//entity의 역할: java코드화 된 결과값들을 객체화 하여 한번에 forward하여 view와 상호작용
	private int id;
	private String title;
	private Date regdate;
	private String writerId;
	private int hit;
	private String files;
	private String content;
	private boolean pub;
	public Notice() {
	}
	
	public Notice(int id, String title, Date regdate, String writerId, int hit, String files, String content,
			boolean pub) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.writerId = writerId;
		this.hit = hit;
		this.files = files;
		this.content = content;
		this.pub = pub;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getPub() {
		return pub;
	}
	public void setPub(boolean pub) {
		this.pub = pub;
	}

	//toString역할: id, title등 값들을 따로 출력해볼수 있도록
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", regdate=" + regdate + ", writerId=" + writerId + ", hit="
				+ hit + ", files=" + files + ", content=" + content + ", pub=" + pub + "]";
	}
	
	
	
	
	
}
