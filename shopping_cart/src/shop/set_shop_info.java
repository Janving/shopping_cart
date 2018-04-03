package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.mycart;
import bean.user;
import one.mysqlconnect;

/**
 * Servlet implementation class set_shop_info
 */
@WebServlet("/setshop")
public class set_shop_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_shop_info() {
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
		HttpSession session=request.getSession();
		int list=0;
		String button=null;
		String button_delete=null;
		//查看哪个按钮触发了，从而得到商品ID
		while(button==null && button_delete==null){
			list++;
			button=request.getParameter("button"+list);
			button_delete=request.getParameter("button_delete"+list);
			
		}
		
		//System.out.println("list:"+list);
		
		mycart mc=(mycart) session.getAttribute(""+list);
		int count=Integer.parseInt(request.getParameter("count"+list));
		int cart_ID=mc.getCart_ID();
		
		if(button_delete!=null){
			count=0;
		}
		
		
		try {
			
			Connection conn=mysqlconnect.connect();
			
			
			if (count==0)
			{
				String sql_delete="delete from shopping_cart where cart_ID="+cart_ID;
				Statement st= conn.createStatement();
				st.executeUpdate(sql_delete);
				st.close();
				RequestDispatcher view =request.getRequestDispatcher("shop/mycart.jsp");
				view.forward(request, response);
				
			}
			
			else{
				String sql_set=" update shopping_cart set count="+count+" where cart_ID="+cart_ID;
				Statement st=conn.createStatement();
				
				st.executeUpdate(sql_set);
				st.close();
				RequestDispatcher view =request.getRequestDispatcher("shop/mycart.jsp");
				view.forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}

}
