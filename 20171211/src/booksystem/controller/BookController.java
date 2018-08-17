package booksystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booksystem.logic.*;
import booksystem.model.*;

@Controller
public class BookController {
	@Autowired
	private bookLogic book;
	@AuthPassport
	@RequestMapping(value="/book_list_detail_request")
	public String book_Detail_Request(HttpServletRequest request, Model model){
		String title = request.getParameter("title");
		//System.out.println("title :" + title);
		String keyword = request.getParameter("keyword");
		//System.out.println("keyword  :" + keyword );
		String pageSize = request.getParameter("pageSize");
		String startPage = request.getParameter("startPage");
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
		
		List<bookinfo> al = null;
		try{
			al = book.getBook_List_Detail(title, keyword, startPage, pageSize);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.print(al.size());
		model.addAttribute("title",title);
		model.addAttribute("book_list",al);
		model.addAttribute("keyword",keyword);
		model.addAttribute("startPage",startPage);
		model.addAttribute("pageSize", pageSize);
		return "book_list_user";
	}
	//图书详细信息
	@RequestMapping(value="/book_edit")
	public String book_Edit(HttpServletRequest request, Model model){
		String BookCode = request.getParameter("BookCode");
		String result="";
		result=request.getParameter("result");
;		//System.out.print(BookCode);
		bookLogic book=new bookLogic();
		bookinfo bookinfo=null;
		try{
			bookinfo = book.getBook_Detail(BookCode);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("bookInfo",bookinfo);
		model.addAttribute("result",result);
		return "book_edit";
	}
	//保存图书
	@RequestMapping(value="/book_save_edit")
	public String book_save(HttpServletRequest request, Model model){
		String BookCode = request.getParameter("bookCode");
		String BookName	 = request.getParameter("bookName");
		String Booktpip = request.getParameter("booktpip");
		String Author = request.getParameter("author");
		String Cbs = request.getParameter("cbs");
		String  Position = request.getParameter("position");
		String  Lb = request.getParameter("lb");
		String  Isbn = request.getParameter("isbn");
		String  Content = request.getParameter("content");
		String result="fail";
		bookLogic book=new bookLogic();
		try{
			book.book_save(BookCode, BookName, Booktpip, Author, Cbs, Position, Lb, Isbn, Content);
			result="success";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "redirect:/book_edit.spring?BookCode="+BookCode+"&result"+result;
	}
	//获取图书类型
	@RequestMapping(value="/book_Lb")
	public String book_Lb(HttpServletRequest request,Model model){
		String result=request.getParameter("result");
		bookLogic book=new bookLogic();
		List<lbinfo> lb=null;
		try{
			lb=book.getBook_Lb();
		}
		catch(Exception e) {
		e.printStackTrace();
	}
		model.addAttribute("result",result);
		model.addAttribute("book_Lb",lb);
		return "book_add";
	}
	//添加图书
	@RequestMapping(value="/book_add")
	public String book_Add(bookinfo bookinfo,Model model){
		String BookCode=bookinfo.getBookCode();
		String BookName=bookinfo.getBookName();
		String Author=bookinfo.getAuthor();
		String Cbs=bookinfo.getCbs();
		String result="fail";
		if(BookCode!="" && BookName!=""&& Author!=""&& Cbs!=""){
		bookLogic book=new bookLogic();
		try{
			result=book.book_add(bookinfo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		return "redirect:/book_Lb?result="+result;
	}
}
