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
    	boolean zerointerval =true;//���㡱�ļ�����
    	//int comma=0;//���ƶ������;
    	for (int i=0;i<a.length();i++) {
    		if(length==2) {
    			digit="ʮ";
    			
    		}else if(length==3) {
    			digit="��";
    		}else if(length==4) {
    			digit="ǧ";
    		}else if(length==5) {
    			digit="��";
    		}else if(length==6) {
    			digit="ʮ��";
    		}else if(length==7) {
    			digit="����";
    		}else if(length==8) {
    			digit="ǧ��";
    		}else if(length==9) {
    			digit="��";
    		}else if(length==10) {
    			digit="ʮ��";
    		}else if(length==11) {
    			digit="����";
    		}else if(length==12) {
    			digit="ǧ��";
    		}else if(length==13) {
    			digit="����";
    		}else if(length==1) {
    			digit="";
    		}
    		
    		String s=(String) (a.subSequence(i,i+1));
    		
    		
    		if(s.equals("1")) {
    			num="һ";
    		}else if(s.equals("2")) {
    			num="��";
    		}
    		else if(s.equals("3")) {
    			num="��";
    		}else if(s.equals("4")) {
    			num="��";
    		}else if(s.equals("5")) {
    			num="��";
    		}
    		else if(s.equals("6")) {
    			num="��";
    		}
    		else if(s.equals("7")) {
    			num="��";
    		}else if(s.equals("8")) {
    			num="��";
    		}else if(s.equals("9")) {
    			num="��";
    		}else if(s.equals("0")) {
    			
    			if(zerointerval) {//�������������㡱
    				num="��";
    				digit="";
    				zerointerval=false;//�������һ����󣬺������Ϊ0Ҳ��������㣬��1003����һǧ������
    			}else {
    				num="";
        			digit="";
    			}
    			
    		}
    		
    		length--;
    		if(!digit.equals("")) {
    			zerointerval=true;//������������ֺ������ٿ��Ա����
    		}
    		
    		
    		//ƴ������,��ֹ���������ں���
    		if(digit.contains("��")) {
    			
    			zh=zh.replace("��", "");
    		}
    		if(digit.contains("��")){
    			
    		    zh=zh.replace("����", "wanyi");
    		    zh=zh.replace("��","");
    		    zh=zh.replace("wanyi", "����");
    		}
    		
    		zh=zh+num+digit;
    		
    	}
    	
    	
        zh=deletezero(zh);
    	zh=addcomma(zh);
		return zh;
    	

    }
	/*������һλ�������㣬��ɾ��
	 * 
	 */
    public static String deletezero(String zh){
    	
    	String lasts=(String) (zh.subSequence(zh.length()-1, zh.length()));
    	
    	if(lasts.equals("��")) {
    		zh=zh.substring(0, zh.length()-1);
    	}
    	
		return zh;
    }
    
    /*ÿ�ĸ����ּ�һ������
     * 
     */
    public static String addcomma(String zh) {
    	String s="";
    	String newzh="";
    	System.out.println("���Ӷ��ţ�"+zh);
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