package one;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.user;
import one.sql_function;
/**
 * Servlet implementation class accountdeal
 */
@WebServlet("/accountdeal")
public class accountdeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountdeal() {
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
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username_text");
		String password=request.getParameter("password_text");
		user u= new user();
		int ID=0;
		
		HttpSession session=request.getSession();
		
		//���水ť��Ϣ
		String button1=request.getParameter("button1");
		String button3=request.getParameter("button3");
		//�������ݿ�
		try {
			Connection conn=mysqlconnect.connect();
			
			//��¼
			if (button1!=null){
				
				//�����¼�ɹ�
				if (sql_function.login(username, password ,u)){
					
					//�������Ա��¼
					if(username.equals("admin")){
						
						//����javabean
						
						request.setAttribute("user", u);
						
						RequestDispatcher view =request.getRequestDispatcher("admin_jsp.jsp");
						view.forward(request, response);
					}
					
					//�����û���¼
					else{
						
					
						
						ID=u.getID();
						System.out.println("accountdeal_u.Id:"+ID);
						//request.setAttribute("user", u);
						session.setAttribute("user", u);
						RequestDispatcher view =request.getRequestDispatcher("shop/index.jsp");
						view.forward(request, response);
						
					}
				}
				
				//��½ʧ��
				else{
					
					out.print("password or account is Wrong!");
				}
				
			}
			
			//ע��
			if (button3!=null){
				
				String checkcode_text=request.getParameter("checkcode_text");
				String checkcode=(String) session.getAttribute("checkcode");
				if (checkcode.equals(checkcode_text)){
				
				
				    if(sql_function.register(username, password)){
					//ע��ɹ�
					    out.print("register success!");
					    response.sendRedirect("registersuccess.html");
				    }
				    else{
					//ע��ʧ��
					    out.print("The account has been existed!");
					    response.sendRedirect("registerfail.html");
				    }
				
			    }
				
				else{
					
					out.print("��֤�����");
				}
				
				
			              }
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		
		
		doGet(request, response);
		
	}

}
