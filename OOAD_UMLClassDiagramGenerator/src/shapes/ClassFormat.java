package shapes;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;

import diagrams.Drawable;

public abstract class ClassFormat implements Drawable{
	private String className;
	private List<String> methods;
	private List<String> variables;
	private int x,y,width,height;
	public ClassFormat(String className,int x,int y) {
		setClassName(className);
		setX(x);
		setY(y);
		width=200;
		height=200;
	}
	public String getClassName(){
		return this.className;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}
	
	protected int drawVariable(Graphics g,int x,int y) {
		FontMetrics m =g.getFontMetrics();
		int lineHeight=m.getHeight();
		for(String variable:variables) {
			y+=lineHeight;
			g.drawString(variable, x, y);
		}
		return y;
	}
	
	protected int drawMethod(Graphics g,int x,int y) {
		FontMetrics m =g.getFontMetrics();
		int lineHeight=m.getHeight();
		for(String method:methods) {
			y+=lineHeight;
			g.drawString(method, x, y);
		}
		return y;
	}
	
	protected int drawClassName(Graphics g,int x,int y) {
		g.drawString(className, x, y);
		return y;
	}
	
	@Override
	public void draw(Graphics g) {
		FontMetrics m =g.getFontMetrics();
		int lineHeight=m.getHeight();
		int width=this.width,height=this.height;
		int x=this.x,y=this.y,middle=(x*2+width)/2,padding=5;

		g.drawRect(x,y,width,height);
		y=drawClassName(g,middle,y+lineHeight);
		
		y+=lineHeight;
		g.drawLine(x, y,x+width,y);
		
		y=drawVariable(g,x+padding,y);
		
		y+=lineHeight;
		g.drawLine(x, y,x+width,y);
		
		y=drawMethod(g,x+padding,y);
	}
}
