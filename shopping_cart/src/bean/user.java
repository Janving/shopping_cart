package bean;

public class user {

	private String username;
	private String userpassword;
	private int ID;
	
	
	public  void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUserpssword(String userpassword){
		
		this.userpassword=userpassword;
		
	}
	
	public String getUserpassword(){
		return userpassword;
		
	}
	
	public void setID(int ID){
		
		this.ID=ID;
		
	}
	
	public int getID(){
		return ID;
		
	}
	
	public user(){
		
	}
	
	
}
