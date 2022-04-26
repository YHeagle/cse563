import java.awt.Graphics;
import java.util.Random;
import java.util.*;
import javax.swing.JPanel;
public class PointPanel extends JPanel
{
	private int randomNum = 50;
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
	
	//clear the point Linkedlist
	public void clear()
	{
		points.clear();
	}
	
	public void randomGenerator()
	{   
		
		Random rand = new Random();
		  				
		for(int i = 0; i < randomNum; i++)
		{   
			int x = rand.nextInt(800);
			int y = rand.nextInt(800);
			points.add(new Point(x, y));
		}
	}
	
	
	
	

}
