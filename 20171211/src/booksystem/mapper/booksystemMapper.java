package booksystem.mapper;

import java.util.*;

import booksystem.model.*;


public interface booksystemMapper {
   //�û��ӿ�
    admininfo checkUser(admininfo record);//�û���½�ӿ�
    String getUserpower(admininfo record);//��ȡ�û�Ȩ�޽ӿ�
    List<menuinfo> getmenulist(String newuserpower);//��ȡȨ�޶�Ӧ������
    List<admininfo> admin_list(admininfo record);//�û���ʾ�ӿ�
    admininfo getAdmin_Detail(admininfo record);//�û���ϸ��Ϣ�ӿ�
    int admin_changestatus(admininfo record);//�û���ɾ���ӿ�(״̬�޸Ľӿ�)
    int adminlinshi_insert(admininfo record);//��ʱ�����ӿ�
    int admin_update(admininfo record);//�û�����½ӿ�
    int admin_add(admininfo record);//�û���ӽӿ�
   //���Žӿ�
    List<departmentinfo> department_list(departmentinfo record);//��ȡȫ��������Ϣ
    List<departmentinfo> department_Lb();//�����û����ʱ��ʾ���
    int department_changestatus(departmentinfo record);//���ż�ɾ���ӿ�(״̬�޸Ľӿ�)
    int department_add(departmentinfo record);//������ӽӿ�
    departmentinfo getDepartment_Detail(departmentinfo record);//������ϸ��Ϣ�ӿ�
    int departmentlinshi_insert(departmentinfo record);//��ʱ�����ӿ�
    int department_update(departmentinfo record);//���ű���½ӿ�
   //��ɫ�ӿ�
    List<jueseinfo> juese_list(jueseinfo record);//��ȡȫ����ɫ��Ϣ
    List<jueseinfo> juese_Lb();//�����û����ʱ��ʾ���
    int juese_changestatus(jueseinfo record);//��ɫ��ɾ���ӿ�(״̬�޸Ľӿ�)
    int juese_add(jueseinfo record);//��ɫ��ӽӿ�
    jueseinfo getJuese_Detail(jueseinfo record);//��ɫ��ϸ��Ϣ�ӿ�
    int jueselinshi_insert(jueseinfo record);//��ʱ�����ӿ�
    int juese_update(jueseinfo record);//��ɫ����½ӿ�
   //ͼ��ӿ�
    List<bookinfo> book_list(bookinfo record);//ͼ����ʾ�ӿ�
    bookinfo getBook_Detail(bookinfo record);//ͼ����ϸ��Ϣ�ӿ�
    int book_save_edit(bookinfo record);//ͼ���޸ı���ӿ�
    List<lbinfo> getBook_LB();//��ȡ������
    int addBook(bookinfo record);//���ͼ��
   //���ӿ�
    int assessor_add(assessorinfo record);//���������ӽӿ�
    List<assessorinfo> assessor_list(assessorinfo record);//���������ʾ�ӿ�
    int assess_ok(assessorinfo record);//ȷ�����
    int assess_detele(assessorinfo record);//���ɾ��������
    int assess_setstatus(assessorinfo record);//������ñ�status
    admininfo assess_selectadminlinshi(assessorinfo record);//����ȡ��Ϣ--admin
    departmentinfo assess_selectdepartmentlinshi(assessorinfo record);//����ȡ��Ϣ--department
    jueseinfo assess_selectjueselinshi(assessorinfo record);//����ȡ��Ϣ--juese
    //��־�ӿ�
    int record_add(recordinfo record);//��־������ӽӿ�
    List<recordinfo> record_list(recordinfo record);//��ȡȫ����־��Ϣ
}