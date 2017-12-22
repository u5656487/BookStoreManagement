package com.service.impl;

import java.util.List;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.entity.Book;
import com.service.BookService;
import com.util.ConfigUtil;


public class BookServiceImpl implements BookService {
	BookDao bd = new BookDaoImpl();

	@Override
	public List<Book> query() {
		return bd.query();
	}

	@Override
	public Book queryBookById(int bookid) {
		return bd.queryBookById(bookid);
	}

	@Override
	public boolean updateBook(Book book) {
		return bd.updateBook(book);
	}

	@Override
	public boolean deleteBookById(int bookid) {
		return bd.deleteBookById(bookid);
	}

	@Override
	public boolean addBook(Book book) {
		return bd.addBook(book);
	}

	@Override
	public List<Book> queryBooksBypage(int pageIndex) {
		//获取配置文件中配置的每页显示的数量
		int pageSize = Integer.valueOf(
				ConfigUtil.getProValues("page_size"));
		//计算起始位置
		int startNum = (pageIndex - 1) * pageSize;
		return bd.queryBooksBypage(startNum, pageSize);
	}

	@Override
	public int queryPageTotal() {
		//获取配置文件中配置的每页显示的数量
		int pageSize = Integer.valueOf(
				ConfigUtil.getProValues("page_size"));
		return bd.queryPageTotal(pageSize);
	}

}
