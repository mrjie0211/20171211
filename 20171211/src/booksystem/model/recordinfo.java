package booksystem.model;

import java.util.Date;


public class recordinfo {
	private int id;
	private Date ctime;
	private String ctimeshow;
	private String ccontent;
	private String coperator;
	private String title;
	private String keyword;
	private int startPage;
	private int pageSize;
	public String getTitle() {
		return title;
	}
	public String getCtimeshow() {
		return ctimeshow;
	}
	public void setCtimeshow(String ctimeshow) {
		this.ctimeshow = ctimeshow;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCoperator() {
		return coperator;
	}
	public void setCoperator(String coperator) {
		this.coperator = coperator;
	}
	

}
