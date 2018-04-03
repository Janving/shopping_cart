package shop;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.goodbean;
import one.mysqlconnect;
import util.DBUtil;

/**
 * Servlet implementation class return_index
 */
@WebServlet("/rs")
public class return_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public return_search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String search_key=request.getParameter("search_text");
		
		String sql="SELECT * FROM web.good where good_name like '%"+search_key+"%'";
		
		//String sql="SELECT * FROM web.good where good_name like %?%";
		
		Connection conn;
		try {
			conn = mysqlconnect.connect();
			Statement st= conn.createStatement();
			ResultSet rs;
			rs=st.executeQuery(sql);
			
			//使用LIst传值
			List<goodbean> l= new ArrayList<goodbean>();
			
		    while(rs.next()){
				
				goodbean g= new goodbean();
				g.setGood_ID(rs.getInt("good_ID"));
				g.setGood_name(rs.getString("good_name"));
				g.setGood_price(rs.getFloat("good_price"));
				g.setGood_description(rs.getString("good_description"));
				g.setGood_image(rs.getString("good_image"));
				l.add(g);
				
			}
			
			request.setAttribute("return_list", l);
			
			
			RequestDispatcher view =request.getRequestDispatcher("shop/search_result.jsp");
		    view.forward(request, response);
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
		
	}

}
