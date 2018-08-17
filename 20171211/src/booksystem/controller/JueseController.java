package booksystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booksystem.logic.assessorLogic;
import booksystem.logic.jueseLogic;
import booksystem.logic.recordLogic;
import booksystem.model.assessorinfo;
import booksystem.model.jueseinfo;
import booksystem.model.recordinfo;
@Controller
public class JueseController {
	//��ʾ�û���Ϣ
		@AuthPassport
		@RequestMapping(value="/juese_list_detail_request")
		public String juese_Detail_Request(HttpServletRequest request, Model model){
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
			jueseLogic juese=new jueseLogic();
			List<jueseinfo> al = null;
			try{
				al = juese.getJuese_List_Detail(title, keyword, startPage, pageSize);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print(al.size());
			model.addAttribute("operateCode",operateCode);
			model.addAttribute("result",result);
			model.addAttribute("title",title);
			model.addAttribute("juese_list",al);
			model.addAttribute("keyword",keyword);
			model.addAttribute("startPage",startPage);
			model.addAttribute("pageSize", pageSize);
			return "juese";
		}
		//ɾ���û���Ϣ(��ɾ��)
		@RequestMapping(value="/juese_operate",params="type=detele")
		public String admin_Detele(HttpServletRequest request, Model model){
			String Code=request.getParameter("Code");
			String operateCode=request.getParameter("operateCode");
			String ctable="juese";
			String ctable_key="JsCode";
			String ctype="ɾ��";
			//System.out.print(df.format(new Date()));
			String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
			String result="fail";
			//�û�
			jueseinfo jueseinfo=new jueseinfo();
			jueseinfo.setJsCode(Code);
			jueseinfo.setStatus(-1);
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
			jueseLogic juese=new jueseLogic();
			assessorLogic assessor=new assessorLogic();
			try{
				result=juese.detelejuese(jueseinfo);
				assessor.insert(assessorinfo);
				record.insert(recordinfo);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/juese_list_detail_request?result="+result+"&operateCode="+operateCode;
		}
		//ת����ӽ���
				@RequestMapping(value="/juese_Lb")
				public String de_Lb(HttpServletRequest request,Model model){
					String operateCode=request.getParameter("operateCode");
					model.addAttribute("operateCode",operateCode);
					return "juese_add";
				}
		//��Ӳ���
		@RequestMapping(value="/juese_operate",params="type=add")
		public String juese_add(HttpServletRequest request,jueseinfo jueseinfo, Model model){
				String JsCode=jueseinfo.getJsCode();
				String operateCode=request.getParameter("operateCode");
				String ctable="juese";
				String ctable_key="JsCode";
				String ctype="���";
				//System.out.print(df.format(new Date()));
				String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+JsCode+"����Ϣ";
				//System.out.print(operateCode);
				String result="fail";
				//�û�
				jueseinfo.setStatus(0);
				//���
				assessorinfo assessorinfo=new assessorinfo();
				assessorinfo.setCoperator(operateCode);
				assessorinfo.setCtable(ctable);
				assessorinfo.setCtable_key(ctable_key);
				assessorinfo.setCtype(ctype);
				assessorinfo.setCcontent(ccontent);
				assessorinfo.setCtable_key_value(JsCode);
				assessorinfo.setCispass(0);
				assessorinfo.setCtime(new Date());
				//��־
				recordinfo recordinfo=new recordinfo();
				recordinfo.setCcontent(ccontent);
				recordinfo.setCoperator(operateCode);
				recordinfo.setCtime(new Date());
				
				recordLogic record=new recordLogic();
				jueseLogic juese=new jueseLogic();
				assessorLogic assessor=new assessorLogic();
				try{
					result=juese.addjuese(jueseinfo);
					assessor.insert(assessorinfo);
					record.insert(recordinfo);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return "redirect:/juese_list_detail_request?result="+result+"&operateCode="+operateCode;
			}
		//��ɫ��ϸ��Ϣ
		@RequestMapping(value="/juese_edit")
			public String department_Edit(HttpServletRequest request, Model model){
						String operateCode=request.getParameter("operateCode");
						String Code = request.getParameter("Code");
						String result=request.getParameter("result");
						jueseLogic juese=new jueseLogic();
						jueseinfo jueseinfo=new jueseinfo();
						jueseinfo.setJsCode(Code);
						try{
							jueseinfo = juese.getJuese_Detail(jueseinfo);
								
						}catch(Exception e) {
							e.printStackTrace();
						}
						model.addAttribute("jueseinfo",jueseinfo);
						model.addAttribute("result",result);
						model.addAttribute("operateCode",operateCode);
						return "juese_edit";
					}
		//�޸Ľ�ɫ��Ϣ
				@RequestMapping(value="/juese_operate",params="type=update")
				public String department_update(HttpServletRequest request,jueseinfo jueseinfonew, Model model){
					String Code=jueseinfonew.getJsCode();
					//System.out.print(Code);
					String operateCode=request.getParameter("operateCode");
					String ctable="juese";
					String ctable_key="JsCode";
					String ctype="�޸�";
					//System.out.print(df.format(new Date()));
					String ccontent="�û�"+operateCode+"����"+ctype+ctable+"��"+ctable_key+"Ϊ"+Code+"����Ϣ";
					//System.out.print(operateCode);
					String result="fail";
					//�û�
					jueseinfo jueseinfo=new jueseinfo();
					jueseinfo.setJsCode(Code);
					jueseinfonew.setStatus(0);
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
					jueseLogic juese=new jueseLogic();
					assessorLogic assessor=new assessorLogic();
					try{
						jueseinfo = juese.getJuese_Detail(jueseinfo);//��ȡԭ���Ľ�ɫ��Ϣ
						result=juese.insertlinshi(jueseinfo);//��ԭ���Ľ�ɫ��Ϣ���뵽��ʱ��
						juese.update(jueseinfonew);//�޸����µ�����
						assessor.insert(assessorinfo);
						record.insert(recordinfo);
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return "redirect:/juese_list_detail_request?result="+result+"&operateCode="+operateCode;
					
				}

		

}
