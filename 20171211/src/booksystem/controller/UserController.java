package booksystem.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import booksystem.logic.*;
import booksystem.model.admininfo;
import booksystem.model.assessorinfo;
import booksystem.model.departmentinfo;
import booksystem.model.jueseinfo;
import booksystem.model.recordinfo;


@Controller//@Controller注解代码本java类是controller控制层
public class UserController {
	@RequestMapping
	(value="/userLogin")
	public String userLogin( HttpServletRequest request, Model model){
		admininfo admininfo = new admininfo();
		model.addAttribute("userinfo",admininfo);
		return "userLogin";
	}
	//登陆
	@RequestMapping(value="/CheckUser" , method=RequestMethod.POST)
	public String login(@RequestParam("userCode") String operateCode,@RequestParam("pwd") String Pwd, Model model,HttpServletRequest request){
		//System.out.print("userCode="+Code);
		//System.out.print("userpwd="+Pwd);
	
		adminLogic user=new adminLogic();
		boolean flag=false;
		try{
			flag=user.checkuser(operateCode, Pwd);
			//System.out.print(flag);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(flag){
			String ccontent="用户"+operateCode+"登录成功!";
			recordLogic record=new recordLogic();
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			recordinfo.setCtime(new Date());
			record.insert(recordinfo);
			admininfo admininfo=new admininfo();
			admininfo.setCode(operateCode);
			String userpower=user.GetUserpower(admininfo);//获取用户权限
			String key=user.Getpowerms(userpower);//获取权限对应的内容
			HttpSession session = request.getSession();
			session.setAttribute("privilege", key);
			model.addAttribute("operateCode",operateCode);
			//System.out.print(key);
			return "main";
		}
		else
			return "userLogin";					
		
	}
	//显示用户信息
	@AuthPassport
	@RequestMapping(value="/admin_list_detail_request")
	public String admin_Detail_Request(HttpServletRequest request, Model model){
		String operateCode=request.getParameter("operateCode");
		String title = request.getParameter("title");
		//System.out.println("title :" + title);
		String keyword = request.getParameter("keyword");
		//System.out.println("keyword  :" + keyword );
		String pageSize = request.getParameter("pageSize");
		String startPage = request.getParameter("startPage");
		String result=request.getParameter("result");
		//System.out.println("startPage  :" + startPage );
		if(title == null){
			title ="0";
			keyword = "";
			pageSize = "10";
			startPage = "1";
				
		}
		
		if(startPage.equals("0"))
			startPage = "1";
		//System.out.println("startPage  :" + startPage );
		adminLogic admin=new adminLogic();
		List<admininfo> al = null;
		try{
			al = admin.getAdmin_List_Detail(title, keyword, startPage, pageSize);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.print(al.size());
		model.addAttribute("operateCode",operateCode);
		model.addAttribute("result",result);
		model.addAttribute("title",title);
		model.addAttribute("admin_list",al);
		model.addAttribute("keyword",keyword);
		model.addAttribute("startPage",startPage);
		model.addAttribute("pageSize", pageSize);
		return "administrator";
	}
	
	//用户详细信息
		@RequestMapping(value="/admin_edit")
		public String admin_Edit(HttpServletRequest request, Model model){
			String operateCode=request.getParameter("operateCode");
			String Code = request.getParameter("Code");
			String result=request.getParameter("result");
			adminLogic admin=new adminLogic();
			admininfo admininfo=new admininfo();
			admininfo.setCode(Code);
			try{
				admininfo = admin.getAdmin_Detail(admininfo);
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("admininfo",admininfo);
			model.addAttribute("result",result);
			model.addAttribute("operateCode",operateCode);
			return "admin_edit";
		}
	//获取部门信息以及角色信息
		@RequestMapping(value="/admin_Lb")
		public String de_and_js_Lb(HttpServletRequest request,Model model){
			String operateCode=request.getParameter("operateCode");
			departmentLogic department=new departmentLogic();
			jueseLogic juese=new jueseLogic();
			List<departmentinfo> ld=null;
			List<jueseinfo> lj=null;
			try{
				ld=department.getDepartment_Lb();
				lj=juese.getJuese_Lb();
			}
			catch(Exception e) {
			e.printStackTrace();
		}
			model.addAttribute("operateCode",operateCode);
			model.addAttribute("department_Lb",ld);
			model.addAttribute("juese_Lb",lj);
			return "admin_add";
		}
		//添加用户信息
		@RequestMapping(value="/admin_operate",params="type=add")
		public String admin_add(HttpServletRequest request,admininfo admininfo, Model model){
			String Code=admininfo.getCode();
			String operateCode=request.getParameter("operateCode");
			String ctable="administrator";
			String ctable_key="Code";
			String ctype="添加";
			//System.out.print(df.format(new Date()));
			String ccontent="用户"+operateCode+"请求"+ctype+ctable+"中"+ctable_key+"为"+Code+"的信息";
			//System.out.print(operateCode);
			String result="fail";
			//用户
			admininfo.setStatus(0);
			//审查
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setCoperator(operateCode);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtype(ctype);
			assessorinfo.setCcontent(ccontent);
			assessorinfo.setCtable_key_value(Code);
			assessorinfo.setCispass(0);
			assessorinfo.setCtime(new Date());
			//日志
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			recordinfo.setCtime(new Date());
			
			recordLogic record=new recordLogic();
			adminLogic admin=new adminLogic();
			assessorLogic assessor=new assessorLogic();
			try{
				result=admin.addadmin(admininfo);
				assessor.insert(assessorinfo);
				record.insert(recordinfo);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/admin_list_detail_request?result="+result+"&operateCode="+operateCode;
		}
	//修改用户信息
	@RequestMapping(value="/admin_operate",params="type=update")
	public String admin_update(HttpServletRequest request,admininfo admininfonew, Model model){
		String Code=admininfonew.getCode();
		//System.out.print(Code);
		String operateCode=request.getParameter("operateCode");
		String ctable="administrator";
		String ctable_key="Code";
		String ctype="修改";
		//System.out.print(df.format(new Date()));
		String ccontent="用户"+operateCode+"请求"+ctype+ctable+"中"+ctable_key+"为"+Code+"的信息";
		//System.out.print(operateCode);
		String result="fail";
		//用户
		admininfo admininfo=new admininfo();
		admininfo.setCode(Code);
		admininfonew.setStatus(0);
		//审查
		assessorinfo assessorinfo=new assessorinfo();
		assessorinfo.setCoperator(operateCode);
		assessorinfo.setCtable(ctable);
		assessorinfo.setCtable_key(ctable_key);
		assessorinfo.setCtype(ctype);
		assessorinfo.setCcontent(ccontent);
		assessorinfo.setCtable_key_value(Code);
		assessorinfo.setCispass(0);
		assessorinfo.setCtime(new Date());
		//日志
		recordinfo recordinfo=new recordinfo();
		recordinfo.setCcontent(ccontent);
		recordinfo.setCoperator(operateCode);
		recordinfo.setCtime(new Date());
		
		recordLogic record=new recordLogic();
		adminLogic admin=new adminLogic();
		assessorLogic assessor=new assessorLogic();
		try{
			admininfo = admin.getAdmin_Detail(admininfo);//获取原来的用户信息
			result=admin.insertlinshi(admininfo);//将原来的用户信息插入到临时表
			admin.update(admininfonew);//修改至新的数据
			assessor.insert(assessorinfo);
			record.insert(recordinfo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_list_detail_request?result="+result+"&operateCode="+operateCode;
		
	}
	//删除用户信息(假删除)
	@RequestMapping(value="/admin_operate",params="type=detele")
	public String admin_Detele(HttpServletRequest request, Model model){
		String Code=request.getParameter("Code");
		String operateCode=request.getParameter("operateCode");
		String ctable="administrator";
		String ctable_key="Code";
		String ctype="删除";
		//System.out.print(df.format(new Date()));
		String ccontent="用户"+operateCode+"请求"+ctype+ctable+"中"+ctable_key+"为"+Code+"的信息";
		String result="fail";
		//用户
		admininfo admininfo=new admininfo();
		admininfo.setCode(Code);
		admininfo.setStatus(-1);
		//审查
		assessorinfo assessorinfo=new assessorinfo();
		assessorinfo.setCoperator(operateCode);
		assessorinfo.setCtable(ctable);
		assessorinfo.setCtable_key(ctable_key);
		assessorinfo.setCtype(ctype);
		assessorinfo.setCcontent(ccontent);
		assessorinfo.setCtable_key_value(Code);
		assessorinfo.setCispass(0);
		assessorinfo.setCtime(new Date());
		//日志
		recordinfo recordinfo=new recordinfo();
		recordinfo.setCcontent(ccontent);
		recordinfo.setCoperator(operateCode);
		recordinfo.setCtime(new Date());
		
		recordLogic record=new recordLogic();
		adminLogic admin=new adminLogic();
		assessorLogic assessor=new assessorLogic();
		try{
			result=admin.deteleadmin(admininfo);
			assessor.insert(assessorinfo);
			record.insert(recordinfo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_list_detail_request?result="+result+"&operateCode="+operateCode;
	}
	

}
