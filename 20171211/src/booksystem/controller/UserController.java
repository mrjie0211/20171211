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


@Controller//@Controllerע����뱾java����controller���Ʋ�
public class UserController {
	@RequestMapping
	(value="/userLogin")
	public String userLogin( HttpServletRequest request, Model model){
		admininfo admininfo = new admininfo();
		model.addAttribute("userinfo",admininfo);
		return "userLogin";
	}
	//��½
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
			String ccontent="�û�"+operateCode+"��¼�ɹ�!";
			recordLogic record=new recordLogic();
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			recordinfo.setCtime(new Date());
			record.insert(recordinfo);
			admininfo admininfo=new admininfo();
			admininfo.setCode(operateCode);
			String userpower=user.GetUserpower(admininfo);//��ȡ�û�Ȩ��
			String key=user.Getpowerms(userpower);//��ȡȨ�޶�Ӧ������
			HttpSession session = request.getSession();
			session.setAttribute("privilege", key);
			model.addAttribute("operateCode",operateCode);
			//System.out.print(key);
			return "main";
		}
		else
			return "userLogin";					
		
	}
	//��ʾ�û���Ϣ
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
	
	//�û���ϸ��Ϣ
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
	//��ȡ������Ϣ�Լ���ɫ��Ϣ
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
		//����û���Ϣ
		@RequestMapping(value="/admin_operate",params="type=add")
		public String admin_add(HttpServletRequest request,admininfo admininfo, Model model){
			String Code=admininfo.getCode();
			String operateCode=request.getParameter("operateCode");
			String ctable="administrator";
			String ctable_key="Code";
			String ctype="���";
			//System.out.print(df.format(new Date()));
			String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
			//System.out.print(operateCode);
			String result="fail";
			//�û�
			admininfo.setStatus(0);
			//���
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setCoperator(operateCode);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtype(ctype);
			assessorinfo.setCcontent(ccontent);
			assessorinfo.setCtable_key_value(Code);
			assessorinfo.setCispass(0);
			assessorinfo.setCtime(new Date());
			//��־
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
	//�޸��û���Ϣ
	@RequestMapping(value="/admin_operate",params="type=update")
	public String admin_update(HttpServletRequest request,admininfo admininfonew, Model model){
		String Code=admininfonew.getCode();
		//System.out.print(Code);
		String operateCode=request.getParameter("operateCode");
		String ctable="administrator";
		String ctable_key="Code";
		String ctype="�޸�";
		//System.out.print(df.format(new Date()));
		String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
		//System.out.print(operateCode);
		String result="fail";
		//�û�
		admininfo admininfo=new admininfo();
		admininfo.setCode(Code);
		admininfonew.setStatus(0);
		//���
		assessorinfo assessorinfo=new assessorinfo();
		assessorinfo.setCoperator(operateCode);
		assessorinfo.setCtable(ctable);
		assessorinfo.setCtable_key(ctable_key);
		assessorinfo.setCtype(ctype);
		assessorinfo.setCcontent(ccontent);
		assessorinfo.setCtable_key_value(Code);
		assessorinfo.setCispass(0);
		assessorinfo.setCtime(new Date());
		//��־
		recordinfo recordinfo=new recordinfo();
		recordinfo.setCcontent(ccontent);
		recordinfo.setCoperator(operateCode);
		recordinfo.setCtime(new Date());
		
		recordLogic record=new recordLogic();
		adminLogic admin=new adminLogic();
		assessorLogic assessor=new assessorLogic();
		try{
			admininfo = admin.getAdmin_Detail(admininfo);//��ȡԭ�����û���Ϣ
			result=admin.insertlinshi(admininfo);//��ԭ�����û���Ϣ���뵽��ʱ��
			admin.update(admininfonew);//�޸����µ�����
			assessor.insert(assessorinfo);
			record.insert(recordinfo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_list_detail_request?result="+result+"&operateCode="+operateCode;
		
	}
	//ɾ���û���Ϣ(��ɾ��)
	@RequestMapping(value="/admin_operate",params="type=detele")
	public String admin_Detele(HttpServletRequest request, Model model){
		String Code=request.getParameter("Code");
		String operateCode=request.getParameter("operateCode");
		String ctable="administrator";
		String ctable_key="Code";
		String ctype="ɾ��";
		//System.out.print(df.format(new Date()));
		String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
		String result="fail";
		//�û�
		admininfo admininfo=new admininfo();
		admininfo.setCode(Code);
		admininfo.setStatus(-1);
		//���
		assessorinfo assessorinfo=new assessorinfo();
		assessorinfo.setCoperator(operateCode);
		assessorinfo.setCtable(ctable);
		assessorinfo.setCtable_key(ctable_key);
		assessorinfo.setCtype(ctype);
		assessorinfo.setCcontent(ccontent);
		assessorinfo.setCtable_key_value(Code);
		assessorinfo.setCispass(0);
		assessorinfo.setCtime(new Date());
		//��־
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
