package booksystem.logic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import booksystem.model.admininfo;
import booksystem.model.recordinfo;
import dbtools.GetSqlSession;
		//添加记录
public class recordLogic {
	public void insert(recordinfo recordinfo){
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			sqlSession.insert(
					"booksystem.mapper.booksystemMapper.record_add",recordinfo);
			sqlSession.commit();
			sqlSession.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
	//获取全部信息
		public List<recordinfo> getRecord_List_Detail(String title,String keyword,String startPage,String pageSize){
			List<recordinfo> listrecord=null;
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				recordinfo recordinfo=new recordinfo();
				int sp = 0;
				int ps = Integer.parseInt(pageSize);
				if(startPage != null ){
					sp = Integer.parseInt(startPage);
					sp--;
					sp *= ps;
					 
				}
				recordinfo.setTitle(title);
				recordinfo.setKeyword(keyword);
				recordinfo.setStartPage(sp);
				recordinfo.setPageSize(ps);
				listrecord=sqlSession.selectList(
						"booksystem.mapper.booksystemMapper.record_list",recordinfo);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for(int i=0;i<listrecord.size();i++){
					recordinfo record=listrecord.get(i);
					String time=sdf.format(record.getCtime());
					record.setCtimeshow(time);
				}
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return listrecord;
		}

}
