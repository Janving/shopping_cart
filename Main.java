package tess;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    static String tansform(long number) {

    	String a = String.valueOf(number);
    	int length = a.length();
    	
    	String digit="";
    	String num="";
    	String zh="";
    	boolean zerointerval =true;//“零”的间隔输出
    	//int comma=0;//控制逗号输出;
    	for (int i=0;i<a.length();i++) {
    		if(length==2) {
    			digit="十";
    			
    		}else if(length==3) {
    			digit="百";
    		}else if(length==4) {
    			digit="千";
    		}else if(length==5) {
    			digit="万";
    		}else if(length==6) {
    			digit="十万";
    		}else if(length==7) {
    			digit="百万";
    		}else if(length==8) {
    			digit="千万";
    		}else if(length==9) {
    			digit="亿";
    		}else if(length==10) {
    			digit="十亿";
    		}else if(length==11) {
    			digit="百亿";
    		}else if(length==12) {
    			digit="千亿";
    		}else if(length==13) {
    			digit="万亿";
    		}else if(length==1) {
    			digit="";
    		}
    		
    		String s=(String) (a.subSequence(i,i+1));
    		
    		
    		if(s.equals("1")) {
    			num="一";
    		}else if(s.equals("2")) {
    			num="二";
    		}
    		else if(s.equals("3")) {
    			num="三";
    		}else if(s.equals("4")) {
    			num="四";
    		}else if(s.equals("5")) {
    			num="五";
    		}
    		else if(s.equals("6")) {
    			num="六";
    		}
    		else if(s.equals("7")) {
    			num="七";
    		}else if(s.equals("8")) {
    			num="八";
    		}else if(s.equals("9")) {
    			num="九";
    		}else if(s.equals("0")) {
    			
    			if(zerointerval) {//如果可以输出“零”
    				num="零";
    				digit="";
    				zerointerval=false;//当输出第一个零后，后面的数为0也不会输出零，如1003不是一千零零三
    			}else {
    				num="";
        			digit="";
    			}
    			
    		}
    		
    		length--;
    		if(!digit.equals("")) {
    			zerointerval=true;//当输出其他数字后，零又再可以被输出
    		}
    		
    		
    		//拼接中文,防止输出更多的亿和万
    		if(digit.contains("亿")) {
    			
    			zh=zh.replace("亿", "");
    		}
    		if(digit.contains("万")){
    			
    		    zh=zh.replace("万亿", "wanyi");
    		    zh=zh.replace("万","");
    		    zh=zh.replace("wanyi", "万亿");
    		}
    		
    		zh=zh+num+digit;
    		
    	}
    	
    	
        zh=deletezero(zh);
    	zh=addcomma(zh);
		return zh;
    	

    }
	/*如果最后一位数字是零，则删掉
	 * 
	 */
    public static String deletezero(String zh){
    	
    	String lasts=(String) (zh.subSequence(zh.length()-1, zh.length()));
    	
    	if(lasts.equals("零")) {
    		zh=zh.substring(0, zh.length()-1);
    	}
    	
		return zh;
    }
    
    /*每四个汉字加一个逗号
     * 
     */
    public static String addcomma(String zh) {
    	String s="";
    	String newzh="";
    	System.out.println("不加逗号："+zh);
    	for(int i=0;i<zh.length();i++) {
    		s=zh.substring(i, i+1);
    		if(i%4==0&&i>0) {
    			newzh=newzh+",";
    		}
    		newzh=newzh+s;
    	}
    	return newzh;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        long _number;
        _number = Long.parseLong(in.nextLine().trim());
  
        res = tansform(_number);
        System.out.println(res);
    }
}