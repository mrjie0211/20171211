package booksystem.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import booksystem.model.departmentinfo;
import dbtools.GetSqlSession;

public class departmentLogic {
	//��ȡȫ��������Ϣ(������ʾ)
		public List<departmentinfo> getDepartment_List_Detail(String title,String keyword,String startPage,String pageSize){
			List<departmentinfo> listdepartment=null;
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				departmentinfo departmentinfo=new departmentinfo();
				int sp = 0;
				int ps = Integer.parseInt(pageSize);
				if(startPage != null ){
					sp = Integer.parseInt(startPage);
					sp--;
					sp *= ps;
					 
				}
				departmentinfo.setTitle(title);
				departmentinfo.setKeyword(keyword);
				departmentinfo.setStartPage(sp);
				departmentinfo.setPageSize(ps);
				listdepartment=sqlSession.selectList(
						"booksystem.mapper.booksystemMapper.department_list",departmentinfo);
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return listdepartment;
		}
		//��ȡȫ��������Ϣ(�����û����ʱ��ȡ����)
		public List<departmentinfo> getDepartment_Lb(){
			List<departmentinfo> listdepartment=null;
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				departmentinfo departmentinfo=new departmentinfo();
				listdepartment=sqlSession.selectList(
						"booksystem.mapper.booksystemMapper.department_Lb");
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return listdepartment;
		}
		//���ż�ɾ��
		public String deteledepartment(departmentinfo departmentinfo){
			String result="fail";
			try{
				SqlSession sqlSession =GetSqlSession.getSqlSession();
				sqlSession.update(
						"booksystem.mapper.booksystemMapper.department_changestatus",departmentinfo);
				result="success";
				sqlSession.commit();
				sqlSession.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
			
		}
		//��Ӳ��ŷ���
				public String adddepartment(departmentinfo departmentinfo){
					String result="fail";
					try{
						SqlSession sqlSession =GetSqlSession.getSqlSession();
						sqlSession.insert(
								"booksystem.mapper.booksystemMapper.department_add",departmentinfo);
						result="success";
						sqlSession.commit();
						sqlSession.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return result;
					
				}
		//��ȡ������ϸ��Ϣ����
				public departmentinfo getDepartment_Detail(departmentinfo departmentinfo){
					departmentinfo list=new departmentinfo();
					try{
						SqlSession sqlSession =GetSqlSession.getSqlSession();
						list=sqlSession.selectOne(
								"booksystem.mapper.booksystemMapper.getDepartment_Detail",departmentinfo);
						sqlSession.commit();
						sqlSession.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					return list;
					
				}
				
		//��ԭ���Ĳ�����Ϣ���뵽��ʱ��
				public String insertlinshi(departmentinfo departmentinfo){
					String result="fail";
					try{
						SqlSession sqlSession =GetSqlSession.getSqlSession();
						sqlSession.insert(
								"booksystem.mapper.booksystemMapper.departmentlinshi_insert",departmentinfo);
						result="success";
						sqlSession.commit();
						sqlSession.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					return result;
					
				}
	//�޸Ĳ�����Ϣ
				public void update(departmentinfo departmentinfonew){
					try{
						SqlSession sqlSession =GetSqlSession.getSqlSession();
						sqlSession.update(
								"booksystem.mapper.booksystemMapper.department_update",departmentinfonew);
						sqlSession.commit();
						sqlSession.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
				}

}
