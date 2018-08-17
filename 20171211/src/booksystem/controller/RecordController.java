package booksystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booksystem.logic.adminLogic;
import booksystem.logic.recordLogic;
import booksystem.model.admininfo;
import booksystem.model.recordinfo;
@Controller
public class RecordController {
	//显示记录信息
		@AuthPassport
		@RequestMapping(value="/record_list_detail_request")
		public String record_Detail_Request(HttpServletRequest request, Model model){
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
			recordLogic record=new recordLogic();
			List<recordinfo> al = null;
			try{
				al = record.getRecord_List_Detail(title, keyword, startPage, pageSize);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print(al.size());
			model.addAttribute("operateCode",operateCode);
			model.addAttribute("result",result);
			model.addAttribute("title",title);
			model.addAttribute("record_list",al);
			model.addAttribute("keyword",keyword);
			model.addAttribute("startPage",startPage);
			model.addAttribute("pageSize", pageSize);
			return "record";
		}

}
