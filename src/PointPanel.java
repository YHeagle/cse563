import java.awt.Color;
import java.awt.Graphics;
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
	
	ArrayList<Point> gridPoint  = new ArrayList<>();
	Dbscan d = new Dbscan(gridPoint,50);
	
	ArrayList<ArrayList<Pair>> result= d.runDbscan();
	
	public int X1, X2, Y1, Y2;
	
	@Override
	public void paint(Graphics arg0) {
		
		for (int i = 0; i < result.size(); i++) {
	        for (int j = 0; j < result.get(i).size(); j++) {
	        	X1=result.get(i).get(j).point1.getX();
	        	Y1=result.get(i).get(j).point1.getY();
	        	X2=result.get(i).get(j).point2.getX();
	        	Y2=result.get(i).get(j).point2.getY();
	        	
	        	arg0.setColor(Color.red);
	        	arg0.drawLine(X1, Y1, X2, Y2);
	        	
	        	try {
					arg0.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        }
	    }
		
		for(Point p : points)
		{
			p.draw(arg0);
			
		}
	}
	
	public List<Point> getPoints(){
		return points;
	}
	
	public void setPoints(List<Point> points){
		this.points = points;
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
