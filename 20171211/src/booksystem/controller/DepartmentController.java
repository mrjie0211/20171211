package booksystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import booksystem.logic.assessorLogic;
import booksystem.logic.departmentLogic;
import booksystem.logic.recordLogic;
import booksystem.model.assessorinfo;
import booksystem.model.departmentinfo;
import booksystem.model.recordinfo;
@Controller
public class DepartmentController {
	//��ʾ������Ϣ
		@AuthPassport
		@RequestMapping(value="/department_list_detail_request")
		public String department_Detail_Request(HttpServletRequest request, Model model){
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
			departmentLogic department=new departmentLogic();
			List<departmentinfo> al = null;
			try{
				al = department.getDepartment_List_Detail(title, keyword, startPage, pageSize);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print(al.size());
			model.addAttribute("operateCode",operateCode);
			model.addAttribute("result",result);
			model.addAttribute("title",title);
			model.addAttribute("department_list",al);
			model.addAttribute("keyword",keyword);
			model.addAttribute("startPage",startPage);
			model.addAttribute("pageSize", pageSize);
			return "department";
		}
		//ת����ӽ���
		@RequestMapping(value="/department_Lb")
		public String de_Lb(HttpServletRequest request,Model model){
			String operateCode=request.getParameter("operateCode");
			model.addAttribute("operateCode",operateCode);
			return "department_add";
		}
		
		//ɾ��������Ϣ(��ɾ��)
		@RequestMapping(value="/department_operate",params="type=detele")
		public String department_Detele(HttpServletRequest request, Model model){
			String Code=request.getParameter("Code");
			String operateCode=request.getParameter("operateCode");
			String ctable="departmentinfo";
			String ctable_key="DpCode";
			String ctype="ɾ��";
			//System.out.print(df.format(new Date()));
			String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
			String result="fail";
			//�û�
			departmentinfo departmentinfo=new departmentinfo();
			departmentinfo.setDpCode(Code);
			departmentinfo.setStatus(-1);
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
			departmentLogic department=new departmentLogic();
			assessorLogic assessor=new assessorLogic();
			try{
				result=department.deteledepartment(departmentinfo);
				assessor.insert(assessorinfo);
				record.insert(recordinfo);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/department_list_detail_request?result="+result+"&operateCode="+operateCode;
		}
		//��Ӳ���
				@RequestMapping(value="/department_operate",params="type=add")
				public String department_add(HttpServletRequest request,departmentinfo departmentinfo, Model model){
					String DpCode=departmentinfo.getDpCode();
					String operateCode=request.getParameter("operateCode");
					String ctable="departmentinfo";
					String ctable_key="DpCode";
					String ctype="���";
					//System.out.print(df.format(new Date()));
					String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+DpCode+"����Ϣ";
					//System.out.print(operateCode);
					String result="fail";
					//�û�
					departmentinfo.setStatus(0);
					//���
					assessorinfo assessorinfo=new assessorinfo();
					assessorinfo.setCoperator(operateCode);
					assessorinfo.setCtable(ctable);
					assessorinfo.setCtable_key(ctable_key);
					assessorinfo.setCtype(ctype);
					assessorinfo.setCcontent(ccontent);
					assessorinfo.setCtable_key_value(DpCode);
					assessorinfo.setCispass(0);
					assessorinfo.setCtime(new Date());
					//��־
					recordinfo recordinfo=new recordinfo();
					recordinfo.setCcontent(ccontent);
					recordinfo.setCoperator(operateCode);
					recordinfo.setCtime(new Date());
					
					recordLogic record=new recordLogic();
					departmentLogic department=new departmentLogic();
					assessorLogic assessor=new assessorLogic();
					try{
						result=department.adddepartment(departmentinfo);
						assessor.insert(assessorinfo);
						record.insert(recordinfo);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return "redirect:/department_list_detail_request?result="+result+"&operateCode="+operateCode;
				}
	//������ϸ��Ϣ
	@RequestMapping(value="/department_edit")
		public String department_Edit(HttpServletRequest request, Model model){
					String operateCode=request.getParameter("operateCode");
					String Code = request.getParameter("Code");
					String result=request.getParameter("result");
					departmentLogic department=new departmentLogic();
					departmentinfo departmentinfo=new departmentinfo();
					departmentinfo.setDpCode(Code);
					try{
						departmentinfo = department.getDepartment_Detail(departmentinfo);
							
					}catch(Exception e) {
						e.printStackTrace();
					}
					model.addAttribute("departmentinfo",departmentinfo);
					model.addAttribute("result",result);
					model.addAttribute("operateCode",operateCode);
					return "department_edit";
				}
	//�޸Ĳ�����Ϣ
		@RequestMapping(value="/department_operate",params="type=update")
		public String department_update(HttpServletRequest request,departmentinfo departmentinfonew, Model model){
			String Code=departmentinfonew.getDpCode();
			//System.out.print(Code);
			String operateCode=request.getParameter("operateCode");
			String ctable="departmentinfo";
			String ctable_key="DpCode";
			String ctype="�޸�";
			//System.out.print(df.format(new Date()));
			String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
			//System.out.print(operateCode);
			String result="fail";
			//�û�
			departmentinfo departmentinfo=new departmentinfo();
			departmentinfo.setDpCode(Code);
			departmentinfonew.setStatus(0);
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
			departmentLogic department=new departmentLogic();
			assessorLogic assessor=new assessorLogic();
			try{
				departmentinfo = department.getDepartment_Detail(departmentinfo);//��ȡԭ�����û���Ϣ
				result=department.insertlinshi(departmentinfo);//��ԭ�����û���Ϣ���뵽��ʱ��
				department.update(departmentinfonew);//�޸����µ�����
				assessor.insert(assessorinfo);
				record.insert(recordinfo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/department_list_detail_request?result="+result+"&operateCode="+operateCode;
			
		}
		

}
