package one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.user;
import util.DBUtil;

public class sql_function  extends DBUtil{

	
	//��¼���������Ƿ�ֵ
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
				//����Ա�
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
		
		
		//ע�ᣬ�����Ƿ�ɹ�
		static boolean register(String username,String password) throws Exception{
			
		
			
			
			
			String sql2="insert into account (username,userpassword) values(?,?)";
			
			String sql1="select * from account where username=?";
			
			
			ResultSet rs;
			
			
			rs=commonQuery(sql1,username);
			
			//�Ƿ�����ͬ�˺�
			if(rs.next()){
				return false;
			}
			
			
			//û�У���ע��
			else{
					commonUpdate(sql2,username,password);
					
				
					return true;
			}
				
		}
		
		
	
}
