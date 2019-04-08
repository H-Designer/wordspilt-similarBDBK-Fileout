package servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java2Word.Jacob.JacobTest;
import Similar.CosineSimilarAlgorithm;
import Similar.JsoupUtil;
import dao.add_dao;
import information.infor;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


/**
 * Servlet implementation class OutputServlet
 */
@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String title = request.getParameter("title");
			String YWcontent = request.getParameter("content");
    		String BKcontent =null;
    		if(title.contains("（")) 
    		{
    			String[] split = title.split("（");
    			title = split[0];
    		}
    		BKcontent = JsoupUtil.URLLoader("https://baike.baidu.com/item/"+title);
    		//System.out.println(BKcontent);
    		double result = CosineSimilarAlgorithm.cosSimilarityByString(BKcontent,YWcontent);
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    		String date = df.format(new Date());// new Date()为获取当前系统时间
    		HttpSession session = request.getSession();
    		
    		//高频词接受
    		String hotword= CosineSimilarAlgorithm.hotword;
    		//String[] Hotword = hotword.split("{");
    		String word1 = hotword.replace("{", "");
    		String word2 = word1.replace("}", "");
    		String[] Hotword = word2.split(",");
    		int len=Hotword.length;
    		String[] spword =new String[len];
    		String[] spHotword =new String[len];
    		String num=null;
    		for(int i=0,  j=0; i<len;i++)
    		{
        		 spword = Hotword[i].split("=");
        		 num = spword[1];
        		 if(!num.equals("1"))
        		 {
        			spHotword[j]=spword[0];
        			j++;
        		 }
    		}
    		for(int i=0;i<spHotword.length;i++)
    		{
    			if(spHotword[i]!=null)
        			{
	    				YWcontent = YWcontent.replaceAll(spHotword[i].trim(), "<font color='red' >" + spHotword[i].trim() + "</font>");
	    				System.out.println(i+spHotword[i]);
        			}
    		}
    		System.out.println(YWcontent);
    		request.setAttribute("YWcontent", YWcontent);
    		session.setAttribute("YWcontent", YWcontent);
    		request.setAttribute("title", title);
    		session.setAttribute("title", title);
    		request.setAttribute("BKcontent", BKcontent);
    		session.setAttribute("BKcontent", BKcontent);
    		request.setAttribute("date", date);
    		session.setAttribute("date", date);
    		request.setAttribute("spHotword", spHotword);
    		session.setAttribute("spHotword", spHotword);
    		response.sendRedirect("../preview.jsp"); 
    		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
