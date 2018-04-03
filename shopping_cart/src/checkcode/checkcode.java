package checkcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class checkcode  {
	
	
	
	private static Random random= new Random();
	private int width;
	private int height;
	private int font_size=20;
	private int x=0;
	private int y=0;
	private int jam=4;
	private String code="";
	private String theCode="";
	
	BufferedImage bufferedImage;
	Graphics graphics ;
	
	
	public checkcode(BufferedImage bufferedImage,Graphics graphics,int width,int height){
		
		this.bufferedImage=bufferedImage;
		this.width=width;
		this.height=height;
		this.graphics=graphics;
		paint(graphics);
	}
	
	public Color getRandomColor(){
		int R=random.nextInt(255);
		int G=random.nextInt(255);
		int B=random.nextInt(255);
		return new Color(R,G,B);
	}
	
	
	public String getRandomString(){
		int num=random.nextInt(9);
		code=num+"";
		return num+"";
		
	}
	
	public void checkCode(Graphics g){
		
		drawBorder(g);
		drawCode(g);
		drawJam(g);
		
		
	}
	
	public void drawBorder(Graphics g){
		
		Color gc=g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setColor(gc);
	}
	
	public void drawCode(Graphics g)
	{
		Color gc = g.getColor();
		theCode="";
		for(int i=0;i<4;i++){
			String string =getRandomString();
			theCode+=string;
			g.setColor(getRandomColor());
			  g.setFont(new Font("宋体", Font.BOLD, font_size));
			  g.drawString(string, x + 5 + (i * 12), y + font_size);
			  
		}
		 g.setColor(gc);
         System.out.println("当前有效验证码："+theCode);
         
	}
	
	
	 public void drawJam(Graphics g) {
	        Color gc = g.getColor();
	        for (int i = 0; i < jam; i++) {
	            g.setColor(getRandomColor());
	            g.drawLine(x + random.nextInt(width), y + random.nextInt(height), x
	                    + random.nextInt(width), y + random.nextInt(height));
	        }
	        g.setColor(gc);
	    }

	    public void paint(Graphics g) {
	        Color c = g.getColor();
	        checkCode(g);
	        g.setColor(c);
	        g.dispose();
	    }
	    public String getCode() {
	        return theCode;
	    }
}
