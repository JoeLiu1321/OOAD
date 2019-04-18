package diagrams;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class UMLClassDiagramDrawer extends JPanel{
	List<Drawable>taskList;
	public UMLClassDiagramDrawer(Drawable task) {
		taskList=new ArrayList<>();
		taskList.add(task);

	}
	public void addTask(Drawable drawable) {
		taskList.add(drawable);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Drawable drawable:taskList)
        	drawable.draw(g);
    }
}
