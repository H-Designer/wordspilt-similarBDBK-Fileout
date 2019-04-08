package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.add_dao;
import information.infor;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//String  search=request.getParameter("search");
		HttpSession session = request.getSession();
		String title=request.getParameter("title");
		//System.out.println(title);
		//基本信息情况
		List<infor> information = new ArrayList<infor>();
		add_dao dao=new add_dao();
		information=dao.select(title);
		//System.out.println(information);
		request.setAttribute("information", information);
		session.setAttribute("information", information);
		if(information!=null)
		{
			response.sendRedirect("../search.jsp"); 
		}
		else
		{
			JOptionPane.showMessageDialog(null, "查询内容为空");	
			 response.sendRedirect("../search.jsp"); 
		}
		//request.getRequestDispatcher("/search.jsp").forward(request, response);	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
