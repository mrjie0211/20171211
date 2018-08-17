 package booksystem.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import booksystem.model.bookinfo;
import booksystem.model.lbinfo;
import dbtools.GetSqlSession;

public class bookLogic {
	//获取分页图书信息
	public List<bookinfo> getBook_List_Detail(String title, String keyword, String startPage, String pageSize) {
		List<bookinfo> listBookinfo=null;
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			bookinfo bookinfo=new bookinfo();
			int sp = 0;
			int ps = Integer.parseInt(pageSize);
			if(startPage != null ){
				sp = Integer.parseInt(startPage);
				sp--;
				sp *= ps;
				 
			}
			bookinfo.setTitle(title);
			bookinfo.setKeyword(keyword);
			bookinfo.setStartPage(sp);
			bookinfo.setPageSize(ps);
			
			 listBookinfo=sqlSession.selectList(
							"booksystem.mapper.booksystemMapper.book_list",bookinfo);
			/*System.out.print("true");
			for(int i=0; i<listBookinfo.size();i++){
				userinfo = listUserinfo.get(i);
				System.out.println(userinfo.getId()+""
						+ userinfo.getUsername()+" "+userinfo.getPassword()
						);
			}	*/
			
			sqlSession.commit();
			sqlSession.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return listBookinfo;
		}
	//获取图书详细内容方法
	public bookinfo getBook_Detail(String BookCode){
		bookinfo b=new bookinfo();
		b.setBookCode(BookCode);
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			b=sqlSession.selectOne(
					"booksystem.mapper.booksystemMapper.getBook_Detail",b);
			sqlSession.commit();
			sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b;
		
	}
	//保存修改的图书信息
	public void book_save(String BookCode,String BookName,String Booktpip,String Author,
		String	Cbs,String Position,String Lb,String Isbn,String Content){
		try{
		bookinfo b=new bookinfo();
		b.setBookCode(BookCode);
		b.setBookName(BookName);
		b.setBooktpip(Booktpip);
		b.setAuthor(Author);
		b.setCbs(Cbs);
		b.setPosition(Position);
		b.setLb(Lb);
		b.setIsbn(Isbn);
		b.setContent(Content);
		SqlSession sqlSession =GetSqlSession.getSqlSession();
		sqlSession.update(
				"booksystem.mapper.booksystemMapper.book_save_edit",b);
		sqlSession.commit();
		sqlSession.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
//获取图书类别
	public List<lbinfo> getBook_Lb() {
		List<lbinfo> listlbinfo=null;
		try{
			SqlSession sqlSession =GetSqlSession.getSqlSession();
			 listlbinfo=sqlSession.selectList(
							"booksystem.mapper.booksystemMapper.getBook_LB");
			sqlSession.commit();
			sqlSession.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return listlbinfo;
		}
//添加图书
	public String book_add(bookinfo bookinfo){
		String result="fail";
		try{
		SqlSession sqlSession =GetSqlSession.getSqlSession();
		sqlSession.insert(
				"booksystem.mapper.booksystemMapper.addBook",bookinfo);
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
