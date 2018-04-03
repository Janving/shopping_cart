package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	 public  static PreparedStatement pstmt;
	 public static ResultSet rs;
	 public static Connection conn;
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/web";
	private static String user="sa";
	private static String password="000";
	

	public static Connection getConnection()  throws SQLException,Exception{
	
		
		Class.forName(driver);
		System.out.println("Sussce driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println("login");
		
			return conn;
		
		}
	
	/*
	 * 增删
	 * */
	public static int commonUpdate(String sql,Object ...params) throws SQLException, Exception{
		int result=0;
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			if(params!=null && params.length>0){
				setvalues(pstmt, params);
				
			}
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		closeAll(null,pstmt,conn);
		return result;
	}
	
	/**
	 * 查
	 * */
	public static ResultSet commonQuery(String sql,Object ...params){
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			if(params!=null && params.length>0){
				setvalues(pstmt, params);
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	/**
	 * 关闭所有
	 * */
	public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @throws Exception 
	 * */
	protected static void setvalues(PreparedStatement pstmt,Object ...params) throws Exception{
		for(int i=0;i<params.length;i++){
			Object obj=params[i];
			pstmt.setObject(i+1, obj);
		}
	}
}
