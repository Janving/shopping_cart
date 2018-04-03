package one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.user;
import util.DBUtil;

public class sql_function  extends DBUtil{

	
	//登录处理，返回是否值
		static boolean login(String username,String password,user u) throws SQLException{
		
			
			String sql="select * from account where username=?";
			
			ResultSet rs;
			
			rs=commonQuery(sql,username);
			
			
			if(rs.next()){
			
				String sqlpassword=rs.getString("userpassword");
				int ID=rs.getInt("ID");
				u.setID(ID);
				u.setUsername(username);
				u.setUserpssword(password);
				//密码对比
				if(password.equals(sqlpassword)){
					return true;
				
				}
				else{
					return false;
				}
			}
			else{
				return false;
				
			}
			
			
		}
		
		
		//注册，返回是否成功
		static boolean register(String username,String password) throws Exception{
			
		
			
			
			
			String sql2="insert into account (username,userpassword) values(?,?)";
			
			String sql1="select * from account where username=?";
			
			
			ResultSet rs;
			
			
			rs=commonQuery(sql1,username);
			
			//是否有相同账号
			if(rs.next()){
				return false;
			}
			
			
			//没有，则注册
			else{
					commonUpdate(sql2,username,password);
					
				
					return true;
			}
				
		}
		
		
	
}
