package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.BookDao;
import com.entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public List<Book> query() {
		List<Book> list = new ArrayList<Book>();
		
		String sql = "select * from book";
		Object[] params = null;
		
		try {
			//调用查询方法
			rSet = super.exQuery(sql, params);
			//遍历结果集
			while (rSet.next()) {
				Book book = new Book();
				book.setBookid(rSet.getInt("bookid"));
				book.setBookname(rSet.getString("bookname"));
				book.setBookprice(rSet.getString("bookprice"));
				book.setBookauthor(rSet.getString("bookauthor"));
				book.setBookpress(rSet.getString("bookpress"));
				book.setBookdate(rSet.getString("bookdate"));
				list.add(book);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		
		return list;
	}

	public Book queryBookById(int bookid) {
		Book book = new Book();
		String sql = "select * from book where bookid = ? ";
		Object[] params = {bookid};
		try {
			rSet = super.exQuery(sql, params);
			while (rSet.next()) {
				book.setBookid(rSet.getInt("bookid"));
				book.setBookname(rSet.getString("bookname"));
				book.setBookprice(rSet.getString("bookprice"));
				book.setBookpress(rSet.getString("bookpress"));
				book.setBookauthor(rSet.getString("bookauthor"));
				book.setBookdate(rSet.getString("bookdate"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		super.closeSource();
		return book;
	}

	
	@Override
	public boolean updateBook(Book book) {
		boolean bool = false;
		String sql = " update book set "
				+ " bookname = ?,"
				+ " bookprice = ?, bookauthor = ?,"
				+ " bookpress = ?, bookdate = ? where bookid=?";
		Object [] params = {book.getBookname(),
				book.getBookprice(),book.getBookauthor(),
				book.getBookpress(),book.getBookdate(),book.getBookid()};
		try {
			bool = super.exupdate(sql, params);			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		return bool;
	}

	@Override
	public boolean deleteBookById(int bookid) {
		boolean bool = false;
		String sql = "delete from book where bookid=? ";
		Object[] params = {bookid};
		try {
			bool = super.exupdate(sql, params);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		
		return bool;
	}

	@Override
	public boolean addBook(Book book) {
		boolean bool = false;
		String sql = " insert into book "
				+ "(bookid,bookname,bookprice,bookauthor,bookpress,bookdate) "
				+ "values (null,?,?,?,?,?)";
		Object[] params = {book.getBookname(),book.getBookprice(),
				book.getBookauthor(),book.getBookpress(),book.getBookdate()};
		
		try {
			bool = super.exupdate(sql, params);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		
		return bool;
	}

	@Override
	public List<Book> queryBooksBypage(int startNum, int pagesize) {
		List<Book> list = new ArrayList<Book>();
		
		String sql = "select * from book "
				+ "LIMIT ?,?";
		Object [] paras = {startNum,pagesize};
		
		try {
			//调用查询方法
			rSet = super.exQuery(sql, paras);
			//遍历结果集
			while (rSet.next()) {
				Book book = new Book();
				book.setBookid(rSet.getInt("bookid"));
				book.setBookname(rSet.getString("bookname"));
				book.setBookprice(rSet.getString("bookprice"));
				book.setBookauthor(rSet.getString("bookauthor"));
				book.setBookpress(rSet.getString("bookpress"));
				book.setBookdate(rSet.getString("bookdate"));
				list.add(book);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		
		return list;
	}

	@Override
	public int queryPageTotal(int pageSize) {
		int total = 0;
		
		String sql = "SELECT CEIL(count(1)/?) as bookCount FROM book ";
		Object [] objs = {pageSize};
		
		try {
			rSet = super.exQuery(sql, objs);
			while (rSet.next()) {
				//根据别名获取数据
				total = rSet.getInt("bookCount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeSource();
		}
		
		return total;
	}

}
