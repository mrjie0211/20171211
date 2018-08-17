package booksystem.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import booksystem.model.jueseinfo;
import dbtools.GetSqlSession;

public class jueseLogic {
	//��ȡȫ����ɫ��Ϣ(����ҳ����ʾ)
		public List<jueseinfo> getJuese_List_Detail(String title,String keyword,String startPage,String pageSize){
			List<jueseinfo> listjuese=null;
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				jueseinfo jueseinfo=new jueseinfo();
				int sp = 0;
				int ps = Integer.parseInt(pageSize);
				if(startPage != null ){
					sp = Integer.parseInt(startPage);
					sp--;
					sp *= ps;
					 
				}
				jueseinfo.setTitle(title);
				jueseinfo.setKeyword(keyword);
				jueseinfo.setStartPage(sp);
				jueseinfo.setPageSize(ps);
				listjuese=sqlSession.selectList(
						"booksystem.mapper.booksystemMapper.juese_list",jueseinfo);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return listjuese;
		}
		//��ȡȫ����ɫ��Ϣ(�����û����ʱ��ȡ��Ϣ)
		public List<jueseinfo> getJuese_Lb(){
			List<jueseinfo> listjuese=null;
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				listjuese=sqlSession.selectList(
						"booksystem.mapper.booksystemMapper.juese_Lb");
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return listjuese;
		}
		//��ɫ��ɾ��
		public String detelejuese(jueseinfo jueseinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.juese_changestatus",jueseinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
		//��ӽ�ɫ����
		public String addjuese(jueseinfo jueseinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.insert(
						"booksystem.mapper.booksystemMapper.juese_add",jueseinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
		//��ȡ��ɫ��ϸ��Ϣ����
		public jueseinfo getJuese_Detail(jueseinfo jueseinfo){
			jueseinfo list=new jueseinfo();
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				list=sqlSession.selectOne(
						"booksystem.mapper.booksystemMapper.getJuese_Detail",jueseinfo);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
			
		}
		
		//��ԭ���Ľ�ɫ��Ϣ���뵽��ʱ��
		public String insertlinshi(jueseinfo jueseinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.insert(
						"booksystem.mapper.booksystemMapper.jueselinshi_insert",jueseinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
//�޸Ľ�ɫ��Ϣ
		public void update(jueseinfo jueseinfonew){
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.juese_update",jueseinfonew);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}

}
