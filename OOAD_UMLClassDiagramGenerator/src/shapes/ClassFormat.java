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
	private Map<String,String> relations;
	public ClassFormat(String className) {
		setClassName(className);
	}

	public String getClassName(){
		return this.className;
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

	public Map<String, String> getRelations() {
		return relations;
	}

	public void setRelations(Map<String, String> relations) {
		this.relations = relations;
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
		int weight=200,height=200;
		int x=100,y=100,middle=(x*2+weight)/2,padding=5;
		
		g.drawRect(x,y,weight,height);
		y=drawClassName(g,middle,y+lineHeight);
		
		y+=lineHeight;
		g.drawLine(x, y,x+weight,y);
		
		y=drawVariable(g,x+padding,y);
		
		y+=lineHeight;
		g.drawLine(x, y,x+weight,y);
		
		y=drawMethod(g,x+padding,y);
		
	}
	
	@Override
	public boolean isDraw() {
		return false;
	}
}
