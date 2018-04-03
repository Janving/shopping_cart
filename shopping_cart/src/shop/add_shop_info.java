package shop;

import util.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import bean.user;
import one.mysqlconnect;

/**
 * Servlet implementation class add_shop_info
 */
@WebServlet("/add_shop_info")
public class add_shop_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_shop_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String good_ID=request.getParameter("good_ID");
		String count=request.getParameter("count");
		System.out.print(good_ID+"   "+count);
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		user u=(user)session.getAttribute("user");
		String username=u.getUsername();
		int good_ID= (int) session.getAttribute("buy_good_ID");
		int user_ID=u.getID();
		
		int count=Integer.parseInt(request.getParameter("count_text"));
		//System.out.println(username+"   "+user_ID+"    "+good_ID);
		
		//检查商品数量
		if(count<1){
			out.print("商品数量必须大于一");
		}
		
		
	
		
		try {
			
			
			Connection conn=mysqlconnect.connect();
			
			
			
			//查看是否购买了同类商品，是则添加数量
			//String sql2="Select * from web.shopping_cart where purchaser_ID='"+user_ID+"' and good_ID='"+good_ID+"'";
			String sql2="Select * from web.shopping_cart where purchaser_ID=? and good_ID=?";
			
			
			//Statement st2=conn.createStatement();
			ResultSet rs2;
			rs2=DBUtil.commonQuery(sql2,user_ID,good_ID);
			//rs2=st2.executeQuery(sql2);
			int shop_count=0;
			int cart_ID=0;
			while(rs2.next()){
				cart_ID=rs2.getInt("cart_ID");
				shop_count=rs2.getInt("count");
				
			}
			
			if (shop_count>0){
				
				count=count+shop_count;
				
				//String sql_countUpdate="UPDATE web.shopping_cart SET count="+count+" WHERE cart_ID='"+cart_ID+"'";
				String sql_countUpdate="UPDATE web.shopping_cart SET count=? WHERE cart_ID=?";
				
				DBUtil.commonUpdate(sql_countUpdate, count,cart_ID);
				//Statement st_countUpdate=conn.createStatement();
				//st_countUpdate.executeUpdate(sql_countUpdate);
				
				RequestDispatcher view =request.getRequestDispatcher("shop/mycart.jsp");
				view.forward(request, response);
				
			}
			
			
			
			//插入新的购物车信息
			else{
			   // String sql3="insert into web.shopping_cart(purchaser_ID,good_ID,count)values ('"+user_ID+"','"+good_ID+"','"+count+"')";
				String sql3="insert into web.shopping_cart(purchaser_ID,good_ID,count)values (?,?,?)";
				
			    //Statement st3=conn.createStatement();
			   // st3.executeUpdate(sql3);
			
				DBUtil.commonUpdate(sql3, user_ID,good_ID,count);
			    System.out.print("加入购物车成功");
			    request.setAttribute("good_ID",good_ID);
			    RequestDispatcher view =request.getRequestDispatcher("shop/mycart.jsp");
			    view.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
		
		
		doGet(request, response);
	}

}
