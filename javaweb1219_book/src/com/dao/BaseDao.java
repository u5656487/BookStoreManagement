package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import com.util.ConfigUtil;

public class BaseDao {

	Connection con = null;
	//	Statement stm = null;
	PreparedStatement pre = null;
	protected ResultSet rSet = null;

	/**
	 * 获取connection连接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void getcon() throws ClassNotFoundException, SQLException{
		String driver = ConfigUtil.getProValues("DRIVER");
		String url = ConfigUtil.getProValues("URL");
		String jdbcuser = ConfigUtil.getProValues("USER");
		String jdbcpsw = ConfigUtil.getProValues("PSW");


		//加载mysql驱动
		Class.forName(driver);
		//DriverManager获取Connection连接
		con = DriverManager.getConnection(url, jdbcuser, jdbcpsw);
	}
	/**
	 * 释放资源
	 */
	public void closeSource(){
		try {
			rSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pre.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 查询数据返回结果集
	 *  select * from user where username = ? and psw = ?
	 *  参数列表：String sql,Object[] params
	 * 返回值：ResultSet
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 		
	 */
	public ResultSet exQuery(String sql,Object[] params) throws SQLException, ClassNotFoundException {
		//获取connection连接
		getcon();
		//预执行语句
		pre = con.prepareStatement(sql);

		//判断是否有参数
		if(params != null){
			//设置参数
			for(int i = 0 ;i < params.length; i++){
				pre.setObject(i+1, params[i]);
			}
		}
		//执行sql语句
		rSet = pre.executeQuery();					
		
		return rSet;
	}
	
	/**
	 * 对数据进行增删改（更新）
	 * 	 writesql 语句
	 * 参数列表：String writesql,Object[] params
	 *   返回值：boolean类型判断数据更新是否成功
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean exupdate(String writesql,Object[] params) throws ClassNotFoundException, SQLException{
		boolean bool = false;
		//获取connection连接
		getcon();
		//预执行语句
		pre = con.prepareStatement(writesql);
		//判断是否有参数，若有则设置参数
		if(params !=null ){
			for(int i = 0 ; i < params.length; i++)
			pre.setObject(i+1, params[i]);
		}
		
		//执行SQL语句
		int n = pre.executeUpdate();
		
		//若更新的行数若不为0，说明更新成功,返回true
		if(n > 0){
			bool = true;
		}
		//closeSource();
		return bool;
		
	}
	

}
