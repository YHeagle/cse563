import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;
public class PointPanel extends JPanel
{
	
	private List<Point> points = new LinkedList<Point>();
	
	public void addPoint(Point point)
	{
		points.add(point);
		//this.repaint();
	}
	
	@Override
	public void paint(Graphics arg0) {
		for(Point p : points)
		{
			p.draw(arg0);
		}
	}
	
	
	
	

}
