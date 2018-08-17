package booksystem.mapper;

import java.util.*;

import booksystem.model.*;


public interface booksystemMapper {
   //用户接口
    admininfo checkUser(admininfo record);//用户登陆接口
    String getUserpower(admininfo record);//获取用户权限接口
    List<menuinfo> getmenulist(String newuserpower);//获取权限对应的内容
    List<admininfo> admin_list(admininfo record);//用户显示接口
    admininfo getAdmin_Detail(admininfo record);//用户详细信息接口
    int admin_changestatus(admininfo record);//用户假删除接口(状态修改接口)
    int adminlinshi_insert(admininfo record);//临时表插入接口
    int admin_update(admininfo record);//用户表更新接口
    int admin_add(admininfo record);//用户添加接口
   //部门接口
    List<departmentinfo> department_list(departmentinfo record);//获取全部部门信息
    List<departmentinfo> department_Lb();//用于用户添加时显示类别
    int department_changestatus(departmentinfo record);//部门假删除接口(状态修改接口)
    int department_add(departmentinfo record);//部门添加接口
    departmentinfo getDepartment_Detail(departmentinfo record);//部门详细信息接口
    int departmentlinshi_insert(departmentinfo record);//临时表插入接口
    int department_update(departmentinfo record);//部门表更新接口
   //角色接口
    List<jueseinfo> juese_list(jueseinfo record);//获取全部角色信息
    List<jueseinfo> juese_Lb();//用于用户添加时显示类别
    int juese_changestatus(jueseinfo record);//角色假删除接口(状态修改接口)
    int juese_add(jueseinfo record);//角色添加接口
    jueseinfo getJuese_Detail(jueseinfo record);//角色详细信息接口
    int jueselinshi_insert(jueseinfo record);//临时表插入接口
    int juese_update(jueseinfo record);//角色表更新接口
   //图书接口
    List<bookinfo> book_list(bookinfo record);//图书显示接口
    bookinfo getBook_Detail(bookinfo record);//图书详细信息接口
    int book_save_edit(bookinfo record);//图书修改保存接口
    List<lbinfo> getBook_LB();//获取书的类别
    int addBook(bookinfo record);//添加图书
   //审查接口
    int assessor_add(assessorinfo record);//审查数据添加接口
    List<assessorinfo> assessor_list(assessorinfo record);//审查内容显示接口
    int assess_ok(assessorinfo record);//确认审查
    int assess_detele(assessorinfo record);//审查删除表内容
    int assess_setstatus(assessorinfo record);//审查设置表status
    admininfo assess_selectadminlinshi(assessorinfo record);//审查获取信息--admin
    departmentinfo assess_selectdepartmentlinshi(assessorinfo record);//审查获取信息--department
    jueseinfo assess_selectjueselinshi(assessorinfo record);//审查获取信息--juese
    //日志接口
    int record_add(recordinfo record);//日志数据添加接口
    List<recordinfo> record_list(recordinfo record);//获取全部日志信息
}