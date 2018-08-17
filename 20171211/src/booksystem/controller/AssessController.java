package booksystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import booksystem.logic.*;
import booksystem.model.*;
@Controller
public class AssessController {
	//显示要处理的审查内容
	@AuthPassport
	@RequestMapping(value="/assess_list_detail_request")
	public String assess_Detail_Request(HttpServletRequest request, Model model){
		String operateCode=request.getParameter("operateCode");
		String title = request.getParameter("title");
		//System.out.println("title :" + title);
		String keyword = request.getParameter("keyword");
		//System.out.println("keyword  :" + keyword );
		String pageSize = request.getParameter("pageSize");
		String startPage = request.getParameter("startPage");
		String result=request.getParameter("result");
		if(title == null){
			title ="0";
			keyword = "";
			pageSize = "10";
			startPage = "1";
				
		}
		
		if(startPage.equals("0"))
			startPage = "1";
		assessorLogic assessor=new assessorLogic();
		List<assessorinfo> al=null;
		try{
			al=assessor.getAssessor_List_Detail(title, keyword, startPage, pageSize);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("operateCode",operateCode);
		model.addAttribute("result",result);
		model.addAttribute("title",title);
		model.addAttribute("assessor_list",al);
		model.addAttribute("keyword",keyword);
		model.addAttribute("startPage",startPage);
		model.addAttribute("pageSize", pageSize);
		return "assessor_list";
	
	}
	//确认删除
	@RequestMapping(value="assessor_operate",params="type=detelesure")
	public String detelesure(HttpServletRequest request, Model model){
		String id=request.getParameter("id");
		int id2=Integer.parseInt(id);
		String ctable=request.getParameter("ctable");
		String ctable_key=request.getParameter("ctable_key");
		String ctable_key_value=request.getParameter("ctable_key_value");
		String operateCode=request.getParameter("operateCode");
		String ccontent=operateCode+"通过了表"+ctable+"序号为"+ctable_key_value+"的删除";
		String result="fail";
		//审核实体
		assessorinfo assessorinfo=new assessorinfo();
		assessorinfo.setId(id2);
		assessorinfo.setCtable(ctable);
		assessorinfo.setCtable_key(ctable_key);
		assessorinfo.setCtable_key_value(ctable_key_value);
		assessorinfo.setCispass(1);
		//记录信息
		recordinfo recordinfo=new recordinfo();
		recordinfo.setCtime(new Date());
		recordinfo.setCcontent(ccontent);
		recordinfo.setCoperator(operateCode);
		
		assessorLogic assessor=new assessorLogic();
		recordLogic record=new recordLogic();
		try{
			result=assessor.detelesure(assessorinfo);
			assessor.ok(assessorinfo);
			record.insert(recordinfo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
	

}
	//拒绝删除
		@RequestMapping(value="assessor_operate",params="type=deteleno")
		public String deteleno(HttpServletRequest request, Model model){
			String id=request.getParameter("id");
			int id2=Integer.parseInt(id);
			String ctable=request.getParameter("ctable");
			String ctable_key=request.getParameter("ctable_key");
			String ctable_key_value=request.getParameter("ctable_key_value");
			String operateCode=request.getParameter("operateCode");
			String ccontent=operateCode+"拒绝了表"+ctable+"序号为"+ctable_key_value+"的删除";
			String result="fail";
			//审核实体
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setId(id2);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtable_key_value(ctable_key_value);
			assessorinfo.setCispass(-1);
			//记录信息
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCtime(new Date());
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			
			assessorLogic assessor=new assessorLogic();
			recordLogic record=new recordLogic();
			try{
				result=assessor.deteleno(assessorinfo);
				assessor.ok(assessorinfo);
				record.insert(recordinfo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
		

	}
	//确认修改
		@RequestMapping(value="assessor_operate",params="type=updatesure")
		public String updatesure(HttpServletRequest request, Model model){
			String id=request.getParameter("id");
			int id2=Integer.parseInt(id);
			String ctable=request.getParameter("ctable");
			String ctable_key=request.getParameter("ctable_key");
			String ctable_key_value=request.getParameter("ctable_key_value");
			String operateCode=request.getParameter("operateCode");
			String ccontent=operateCode+"通过了表"+ctable+"序号为"+ctable_key_value+"的修改";
			String result="fail";
			//审核实体
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setId(id2);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtable_key_value(ctable_key_value);
			assessorinfo.setCispass(1);
			//记录信息
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCtime(new Date());
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			
			assessorLogic assessor=new assessorLogic();
			recordLogic record=new recordLogic();
			try{
				result=assessor.updatesure(assessorinfo);
				assessor.ok(assessorinfo);
				record.insert(recordinfo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
		

	}
	//拒绝修改
		@RequestMapping(value="assessor_operate",params="type=updateno")
		public String updateno(HttpServletRequest request, Model model){
			String id=request.getParameter("id");
			int id2=Integer.parseInt(id);
			String ctable=request.getParameter("ctable");
			String ctable_key=request.getParameter("ctable_key");
			String ctable_key_value=request.getParameter("ctable_key_value");
			String operateCode=request.getParameter("operateCode");
			String ccontent=operateCode+"拒绝了表"+ctable+"序号为"+ctable_key_value+"的修改";
			String result="fail";
			//审核实体
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setId(id2);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtable_key_value(ctable_key_value);
			assessorinfo.setCispass(-1);
			//记录信息
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCtime(new Date());
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			
			assessorLogic assessor=new assessorLogic();
			recordLogic record=new recordLogic();
			try{
				result=assessor.updateno(assessorinfo);
				assessor.ok(assessorinfo);
				record.insert(recordinfo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
		

	}
		
		//确认添加
		@RequestMapping(value="assessor_operate",params="type=addsure")
		public String addsure(HttpServletRequest request, Model model){
			String id=request.getParameter("id");
			int id2=Integer.parseInt(id);
			String ctable=request.getParameter("ctable");
			String ctable_key=request.getParameter("ctable_key");
			String ctable_key_value=request.getParameter("ctable_key_value");
			String operateCode=request.getParameter("operateCode");
			String ccontent=operateCode+"通过了表"+ctable+"序号为"+ctable_key_value+"的添加";
			String result="fail";
			//审核实体
			assessorinfo assessorinfo=new assessorinfo();
			assessorinfo.setId(id2);
			assessorinfo.setCtable(ctable);
			assessorinfo.setCtable_key(ctable_key);
			assessorinfo.setCtable_key_value(ctable_key_value);
			assessorinfo.setCispass(1);
			//记录信息
			recordinfo recordinfo=new recordinfo();
			recordinfo.setCtime(new Date());
			recordinfo.setCcontent(ccontent);
			recordinfo.setCoperator(operateCode);
			
			assessorLogic assessor=new assessorLogic();
			recordLogic record=new recordLogic();
			try{
				result=assessor.addsure(assessorinfo);
				assessor.ok(assessorinfo);
				record.insert(recordinfo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
		

	}
	//拒绝添加
			@RequestMapping(value="assessor_operate",params="type=addno")
			public String addno(HttpServletRequest request, Model model){
				String id=request.getParameter("id");
				int id2=Integer.parseInt(id);
				String ctable=request.getParameter("ctable");
				String ctable_key=request.getParameter("ctable_key");
				String ctable_key_value=request.getParameter("ctable_key_value");
				String operateCode=request.getParameter("operateCode");
				String ccontent=operateCode+"拒绝了表"+ctable+"序号为"+ctable_key_value+"的添加";
				String result="fail";
				//审核实体
				assessorinfo assessorinfo=new assessorinfo();
				assessorinfo.setId(id2);
				assessorinfo.setCtable(ctable);
				assessorinfo.setCtable_key(ctable_key);
				assessorinfo.setCtable_key_value(ctable_key_value);
				assessorinfo.setCispass(-1);
				//记录信息
				recordinfo recordinfo=new recordinfo();
				recordinfo.setCtime(new Date());
				recordinfo.setCcontent(ccontent);
				recordinfo.setCoperator(operateCode);
				
				assessorLogic assessor=new assessorLogic();
				recordLogic record=new recordLogic();
				try{
					result=assessor.addno(assessorinfo);
					assessor.ok(assessorinfo);
					record.insert(recordinfo);
						
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return "redirect:/assess_list_detail_request?operateCode="+operateCode+"&result="+result;
				

			}
}
