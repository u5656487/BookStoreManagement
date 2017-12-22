package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	
	/**
	 * 查询所有用户
	 * select * from book;
	 * 参数列表：无
	 * 返回：List<Book>
	 */
	public List<Book> query();
	/**
	 * 按id查询用户
	 * 		select * from book where bookid = ?
	 * 		参数列表： int bookid;
	 * 		返回值： Book
	 */
	public Book queryBookById(int bookid);
	/**
	 * 增加书籍
	 * 	insert into book (bookid,bookname,bookprice,bookauthor,bookpress,bookdate)
	 * 	values (?,?,?,?,?,?)
	 * 参数：Book book
	 *
	 * String bookname,String bookprice,String bookauthor,String bookpress,String bookdate
	 * 返回值：boolean
	 * 
	 */
	public boolean addBook(Book book);
	
	
	
	/**
	 * 修改书籍数据
	 * 		update book set bookid = ?, bookname = ?,
	 * 				 bookprice = ?, bookpress = ?,
	 * 				bookauthor = ?, bookdate = ?
	 * 		参数列表 Book book
	 * 		返回值boolean
	 */
	public boolean updateBook(Book book);
	
	/**
	 * 删除用户数据
	 * 		delete from book where bookid=?
	 * 		参数列表 int bookid
	 * 		返回值boolean
	 */
	public boolean deleteBookById(int bookid);
	/**
	 * 查询用户数据
	 * 		select from user where 1=1 
	 * 		and id=?
	 * 		and username=?
	 * 		and nickname=?
	 * 
	 * 		参数列表 String id,String username,String nickname
	 * 		返回值List<User>
	 */
	public List<Book> queryBooksBypage (int pageIndex);
	
	/**
	 * 查询总页数
	 * 		select ceil(count(1)/?) from user
	 *返回值：int
	 *参数：int pageSize
	 *
	 */
	public int queryPageTotal();
	
}
