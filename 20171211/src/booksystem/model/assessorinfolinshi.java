package booksystem.model;

public class assessorinfolinshi {
	//此实体类用于临时存放从临时表获得的数据（修改类型×时使用）
	//admininfo
	private String Code;
	private String Name;
	private String bldepartment;
	private String education;
	private String profession;
	private int age;
	private String adress;
	private String juese;
	private String email;
	private int status;
	private String Pwd;
	//departmentinfo
	private String DpCode;
	private String DpName;
	private String DpPhone;
	//jueseinfo
	private String JsCode;
	private String JsName;
	private String JsPower;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBldepartment() {
		return bldepartment;
	}
	public void setBldepartment(String bldepartment) {
		this.bldepartment = bldepartment;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getJuese() {
		return juese;
	}
	public void setJuese(String juese) {
		this.juese = juese;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getDpCode() {
		return DpCode;
	}
	public void setDpCode(String dpCode) {
		DpCode = dpCode;
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
	

}
