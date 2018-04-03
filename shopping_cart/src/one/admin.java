package one;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
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
		String add=request.getParameter("add");
		String change=request.getParameter("change");
		String delete=request.getParameter("delete");
		PrintWriter out=response.getWriter();
		try {
			
			Connection conn=mysqlconnect.connect();
			Statement st=conn.createStatement();
			if(add!=null){
				if (checked(st,out)){
					String sql="insert into account(username,userpassword) values('��','110301')";
					
					st.executeUpdate(sql);
					out.print("����ɹ�");
				}
				else{
					out.print("���Ѿ����ڣ�");
				}
			}
			
			if(change!=null){
				if(!checked(st,out)){
					String sql="update account set userpassword='123456' where username='��'";
				
					st.executeUpdate(sql);
				
					out.print("�޸�����ɹ�");
					}
				
				else{
					out.print("�û�������");
				}
			}
			
			
			if(delete!=null){
				if(!checked(st,out)){
					String sql="delete from account where username='��'";
					
					st.executeUpdate(sql);
					out.print("ɾ���ɹ�!");
				}
				else{
					out.print("�û�������");
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
	}
	
	boolean checked(Statement st,PrintWriter out) throws SQLException{
		
		String sql="select * from account where username='��'";
		ResultSet rs;
		rs=st.executeQuery(sql);
		
		while(rs.next()){
			
			return false;
		}
		return true;
	}

}
