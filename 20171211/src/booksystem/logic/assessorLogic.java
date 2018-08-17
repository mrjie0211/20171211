package booksystem.logic;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import booksystem.model.*;
import dbtools.GetSqlSession;
public class assessorLogic {
	//审核信息插入
	public void insert(assessorinfo assessorinfo){
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			sqlSession.insert(
					"booksystem.mapper.booksystemMapper.assessor_add",assessorinfo);
			sqlSession.commit();
			sqlSession.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
	//ok
	public void ok(assessorinfo assessorinfo){
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			sqlSession.update(
					"booksystem.mapper.booksystemMapper.assess_ok",assessorinfo);
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//审核信息显示
	public List<assessorinfo> getAssessor_List_Detail(String title,String keyword,String startPage,String pageSize){
		List<assessorinfo> listassessor=null;
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			assessorinfo assessorinfo=new assessorinfo();
			int sp = 0;
			int ps = Integer.parseInt(pageSize);
			if(startPage != null ){
				sp = Integer.parseInt(startPage);
				sp--;
				sp *= ps;
				 
			}
			assessorinfo.setTitle(title);
			assessorinfo.setKeyword(keyword);
			assessorinfo.setStartPage(sp);
			assessorinfo.setPageSize(ps);
			listassessor=sqlSession.selectList(
					"booksystem.mapper.booksystemMapper.assessor_list",assessorinfo);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i=0;i<listassessor.size();i++){
				assessorinfo assessor=listassessor.get(i);
				String time=sdf.format(assessor.getCtime());
				assessor.setCtimeshow(time);
			}
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listassessor;
		
	}
	//确认删除
	public String detelesure(assessorinfo assessorinfo){
		String result="fail";
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			sqlSession.delete(
					"booksystem.mapper.booksystemMapper.assess_detele",assessorinfo);
			result="success";
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	//拒绝删除
		public String deteleno(assessorinfo assessorinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.assess_setstatus",assessorinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
			
		}
	//确认修改
		public String updatesure(assessorinfo assessorinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				//将status变为1
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.assess_setstatus",assessorinfo);
				String ctable=assessorinfo.getCtable();
				String ctable_linshi=ctable+"_linshi";
				assessorinfo.setCtable(ctable_linshi);
				sqlSession.delete("booksystem.mapper.booksystemMapper.assess_detele", assessorinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}
		//拒绝修改
		public String updateno(assessorinfo assessorinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				assessorinfo assessorinfo2=new assessorinfo();
				assessorinfo2=assessorinfo;
				String ctable=assessorinfo2.getCtable();
				System.out.println(ctable);
				String ctable_linshi=ctable+"_linshi";
				System.out.println(ctable_linshi);
				assessorinfo2.setCtable(ctable_linshi);
				System.out.println(ctable);
				//按表分类
				if(ctable.equals("administrator")){
					//System.out.println("成功进入"+ctable);
					admininfo admininfo=new admininfo();
					//获取临时表的内容
					admininfo=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.assess_selectadminlinshi",assessorinfo2);
				//将表的内容赋值给原表
				//	System.out.print(admininfo.getCode());
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.admin_update", admininfo);
				}
				if(ctable.equals("departmentinfo")){
					//System.out.println("成功进入"+ctable);
					departmentinfo departmentinfo=new departmentinfo();
					//获取临时表的内容
					departmentinfo=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.assess_selectdepartmentlinshi",assessorinfo2);
				//将表的内容赋值给原表
					System.out.print(departmentinfo.getDpCode());
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.department_update", departmentinfo);
				}
				if(ctable.equals("juese")){
					//System.out.println("成功进入"+ctable);
					jueseinfo jueseinfo=new jueseinfo();
					//获取临时表的内容
					jueseinfo=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.assess_selectjueselinshi",assessorinfo2);
				//将表的内容赋值给原表
					//System.out.print(jueseinfo.getJsCode());
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.juese_update", jueseinfo);
				}
				/*
				if(ctable=="administrator"){
					admininfo admininfo=new admininfo();
					admininfo=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.assess_select",assessorinfo2);
				//将表的内容赋值给原表
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.assess_update", assessls);
				}
				if(ctable=="administrator"){
					admininfo admininfo=new admininfo();
					admininfo=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.assess_select",assessorinfo2);
				//将表的内容赋值给原表
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.assess_update", assessls);
				}
				*/
				//删除临时表的内容
				sqlSession.delete("booksystem.mapper.booksystemMapper.assess_detele", assessorinfo2);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}
	//确认添加
		public String addsure(assessorinfo assessorinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.assess_setstatus",assessorinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
			
		}
		//拒绝添加
		public String addno(assessorinfo assessorinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.delete(
						"booksystem.mapper.booksystemMapper.assess_detele",assessorinfo);
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
