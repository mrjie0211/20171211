package booksystem.model;

public class departmentinfo {
	private String DpCode;
	private String DpName;
	private String DpPhone;
	private int status;
	private String title;
	private String keyword;
	private int startPage;
	private int pageSize;
	public String getDpCode() {
		return DpCode;
	}
	public void setDpCode(String dpCode) {
		DpCode = dpCode;
	}
	public String getTitle() {
		return title;
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
	public String getDpName() {
		return DpName;
	}
	public void setDpName(String dpName) {
		DpName = dpName;
	}
	public String getDpPhone() {
		return DpPhone;
	}
	public void setDpPhone(String dpPhone) {
		DpPhone = dpPhone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
