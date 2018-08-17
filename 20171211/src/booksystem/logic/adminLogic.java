package booksystem.logic;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import booksystem.model.*;

import dbtools.GetSqlSession;


public class adminLogic {
	//判断登陆
	public  boolean checkuser(String Code, String pwd){
			boolean flag=false;
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			admininfo admininfo=new admininfo();
			admininfo.setCode(Code);
			admininfo.setPwd(pwd);
			
			admininfo listUserinfo=sqlSession.selectOne(
							"booksystem.mapper.booksystemMapper.checkUser",admininfo);
				//System.out.print(listUserinfo.getJuese());
			int sum=listUserinfo.getStatus();
			if(sum > 0)
				flag = true;
			
			sqlSession.commit();
			sqlSession.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	
	}
	//获取登陆用户权限
	public String GetUserpower(admininfo admininfo){
		String userpower="";
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			userpower=sqlSession.selectOne(
							"booksystem.mapper.booksystemMapper.getUserpower",admininfo);
			sqlSession.commit();
			sqlSession.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userpower;
		
	}
	//获取权限对应的内容
	public String Getpowerms(String userpower){
		String key="";
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			List<menuinfo> listmenu=null;
			String newuserpower="("+userpower+")";
			listmenu=sqlSession.selectList(
							"booksystem.mapper.booksystemMapper.getmenulist",newuserpower);
			for(int i=0;i<listmenu.size();i++){
				menuinfo menuinfo=listmenu.get(i);
				key+=menuinfo.getMaddress()+"#";
			}
			//System.out.print(key);
			sqlSession.commit();
			sqlSession.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
		
		
	}
	
	//获取全部用户信息
	public List<admininfo> getAdmin_List_Detail(String title,String keyword,String startPage,String pageSize){
		List<admininfo> listadmin=null;
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			admininfo admininfo=new admininfo();
			int sp = 0;
			int ps = Integer.parseInt(pageSize);
			if(startPage != null ){
				sp = Integer.parseInt(startPage);
				sp--;
				sp *= ps;
				 
			}
			admininfo.setTitle(title);
			admininfo.setKeyword(keyword);
			admininfo.setStartPage(sp);
			admininfo.setPageSize(ps);
			listadmin=sqlSession.selectList(
					"booksystem.mapper.booksystemMapper.admin_list",admininfo);
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listadmin;
	}
	//假删除
	public String deteleadmin(admininfo admininfo){
		String result="fail";
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			sqlSession.update(
					"booksystem.mapper.booksystemMapper.admin_changestatus",admininfo);
			result="success";
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	//将原来的用户信息插入到临时表
		public String insertlinshi(admininfo admininfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.insert(
						"booksystem.mapper.booksystemMapper.adminlinshi_insert",admininfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
	//修改用户信息
		public void update(admininfo admininfonew){
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.admin_update",admininfonew);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	//获取用户详细信息方法
		public admininfo getAdmin_Detail(admininfo admininfo){
			admininfo list=new admininfo();
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				list=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.getAdmin_Detail",admininfo);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
			
		}
	//添加用户方法
		public String addadmin(admininfo admininfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.insert(
						"booksystem.mapper.booksystemMapper.admin_add",admininfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
	
	
}
