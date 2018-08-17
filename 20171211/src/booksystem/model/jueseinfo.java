package booksystem.model;

public class jueseinfo {
	private String JsCode;
	private String JsName;
	private String JsPower;
	private int status;
	private String title;
	private String keyword;
	private int startPage;
	private int pageSize;
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
	public String getJsCode() {
		return JsCode;
	}
	public void setJsCode(String jsCode) {
		JsCode = jsCode;
	}
	public String getJsName() {
		return JsName;
	}
	public void setJsName(String jsName) {
		JsName = jsName;
	}
	public String getJsPower() {
		return JsPower;
	}
	public void setJsPower(String jsPower) {
		JsPower = jsPower;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
