package booksystem.model;
import java.util.Date;

public class assessorinfo {
	private int id;
	private String coperator;
	private String ctable;
	private String ctable_key;
	private String ctable_key_value;
	private String ctype;
	private String ccontent;
	private Date ctime;
	private String ctimeshow;
	public String getCtimeshow() {
		return ctimeshow;
	}
	public void setCtimeshow(String ctimeshow) {
		this.ctimeshow = ctimeshow;
	}
	private int cispass;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoperator() {
		return coperator;
	}
	public void setCoperator(String coperator) {
		this.coperator = coperator;
	}
	public String getCtable() {
		return ctable;
	}
	public void setCtable(String ctable) {
		this.ctable = ctable;
	}
	public String getCtable_key() {
		return ctable_key;
	}
	public void setCtable_key(String ctable_key) {
		this.ctable_key = ctable_key;
	}
	public String getCtable_key_value() {
		return ctable_key_value;
	}
	public void setCtable_key_value(String ctable_key_value) {
		this.ctable_key_value = ctable_key_value;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date df) {
		this.ctime = df;
	}
	public int getCispass() {
		return cispass;
	}
	public void setCispass(int cispass) {
		this.cispass = cispass;
	}
	
	

}
