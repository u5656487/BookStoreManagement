package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.entity.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BookService bs = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		//获取参数，进行逻辑判断
		String action = req.getParameter("action");

		//由action参数来判断，调用对应的方法
		if ("queryBook".equals(action)) {
			bookQuery(req, resp);
		}else if ("bookDetail".equals(action)) {
			queryBookById(req, resp);
		}else if ("bookUpdate".equals(action)) {
			updateBook(req, resp);
		}else if ("deleteBookById".equals(action)) {
			deleteBookById(req, resp);
		}else if ("bookAdd".equals(action)) {
			addBook(req, resp);
		}
		
		
	}	
	

	private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean bool = false;
//		String bookid = req.getParameter("bookid");
		String bookname =req.getParameter("bookname");
		String bookprice =req.getParameter("bookprice");
		String bookauthor =req.getParameter("bookauthor");
		String bookpress =req.getParameter("bookpress");
		String bookdate =req.getParameter("bookdate");
		//将参数赋值给user对象
		Book book = new Book();
//		book.setBookid(Integer.valueOf(bookid));
		book.setBookname(bookname);
		book.setBookprice(bookprice);
		book.setBookpress(bookpress);
		book.setBookauthor(bookauthor);
		book.setBookdate(bookdate);
		//调用逻辑
		bool = bs.addBook(book);
		
		if (bool) {
			req.getSession().setAttribute("message", 11);
			resp.sendRedirect("index.jsp");
		}else{
			req.getSession().setAttribute("message", 12);
			resp.sendRedirect("index.jsp");
		}
		
	}

	public void bookQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int pi = 0;
		// 当前页
		String pageIndex = req.getParameter("pageIndex");
		// 判断是否第一次进入index.jsp页面
		if (pageIndex == null || pageIndex.length() <= 0) {
			// 如果是第一次就显示第一页的数据
			pi = 1;
		} else {
			// 当用户传参要去的页时
			pi = Integer.valueOf(pageIndex);
		}
		
		// 调用分页查询
		List<Book> list = bs.queryBooksBypage(pi);

		// 调用总页数查询逻辑
		int totalpage = bs.queryPageTotal();
		// 将总页数存入四大作用域
		req.setAttribute("total", totalpage);
		// 将查询结果放入四大作用域
		req.setAttribute("list", list);
		// 将当前页存入四大作用域
		req.setAttribute("pageIndex", pi);
		// 转发
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	public void queryBookById(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String bookid = req.getParameter("bookid");
		//调用删除逻辑 
		Book book = bs.queryBookById(Integer.valueOf(bookid));
		//转发到BookDetail.jsp页面
		req.setAttribute("book", book);
		req.getRequestDispatcher(req.getParameter("toPage")).forward(req, resp);
	}
	
	public void deleteBookById(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String bookid = req.getParameter("bookid");
		boolean bool = bs.deleteBookById(Integer.valueOf(bookid));	
		
		if (bool) {
			req.getSession().setAttribute("message", 31);
			resp.sendRedirect("index.jsp");
		}else{
			req.getSession().setAttribute("message", 32);
			resp.sendRedirect("index.jsp");
		}	
	}

	public void updateBook(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		//获取表单参数
		String bookid = req.getParameter("bookid");
		String bookname =req.getParameter("bookname");
		String bookprice =req.getParameter("bookprice");
		String bookauthor =req.getParameter("bookauthor");
		String bookpress =req.getParameter("bookpress");
		String bookdate =req.getParameter("bookdate");
		//将参数赋值给user对象
		Book book = new Book();
		book.setBookid(Integer.valueOf(bookid));
		book.setBookname(bookname);
		book.setBookprice(bookprice);
		book.setBookpress(bookpress);
		book.setBookauthor(bookauthor);
		book.setBookdate(bookdate);
		//调用更新逻辑
		boolean bool = bs.updateBook(book);
		
		if (bool) {
			req.getSession().setAttribute("message", 21);
			resp.sendRedirect("index.jsp");
		}else{
			req.getSession().setAttribute("message", 22);
			resp.sendRedirect("index.jsp");
		}	
	}

}
