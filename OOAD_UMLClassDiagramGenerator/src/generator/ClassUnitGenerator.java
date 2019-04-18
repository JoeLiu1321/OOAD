package generator;

import java.awt.FontMetrics;
import java.awt.Graphics;

import diagrams.Drawable;
import shapes.ClassFormat;

public class ClassUnitGenerator {
	private ClassFormat format;
	private int x,y,width,height;
	public ClassUnitGenerator(){
		x=0;
		y=0;
		width=200;
		height=200;
	}
	
	public Drawable generateClassFormat(ClassFormat format) {
		this.format=format;
		int width=this.width,height=this.height;
		int x=this.x,y=this.y,middle=(x*2+width)/2,padding=5;
		Drawable drawable=new Drawable() {
			@Override
			public void draw(Graphics g) {
//				FontMetrics m =g.getFontMetrics();
//				int lineHeight=m.getHeight();
//				g.drawRect(x,y,width,height);
//				y=drawClassName(g,middle,y+lineHeight);
//				
//				y+=lineHeight;
//				g.drawLine(x, y,x+width,y);
//				
//				y=drawVariable(g,x+padding,y);
//				
//				y+=lineHeight;
//				g.drawLine(x, y,x+width,y);
//				
//				y=drawMethod(g,x+padding,y);
				
			}
			
		};
		return drawable;
		
	}
	
	private int drawVariable(Graphics g,int x,int y) {
		FontMetrics m =g.getFontMetrics();
		int lineHeight=m.getHeight();
		for(String variable:format.getVariables()) {
			y+=lineHeight;
			g.drawString(variable, x, y);
		}
		return y;
	}
	
	private int drawMethod(Graphics g,int x,int y) {
		FontMetrics m =g.getFontMetrics();
		int lineHeight=m.getHeight();
		for(String method:this.format.getMethods()) {
			y+=lineHeight;
			g.drawString(method, x, y);
		}
		return y;
	}
	
	private int drawClassName(Graphics g,int x,int y) {
		g.drawString(this.format.getClassName(), x, y);
		return y;
	}
	
}
