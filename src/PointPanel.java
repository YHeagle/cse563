import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.Timer;
public class PointPanel extends JPanel
{
	private int randomNum = 50;
	private List<Point> points = new LinkedList<Point>();
	
	public void addPoint(Point point)
	{
		points.add(point);
		//this.repaint();
	}


	ArrayList<Pair> result = new ArrayList<>();


	@Override
	public void paint(Graphics g) {
		if (result!=null) {
			for (int j=0;j<i && j<result.size();j++) {
				Pair p =result.get(j);
				if (p.point2==null)
					continue;
				g.setColor(Color.red);
				g.drawLine(p.point1.getX(),p.point1.getY(), p.point2.getX(), p.point2.getY());
			}

		}
		for(Point p : points) {
			p.draw(g);
			
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
		result.clear();
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

	public void setResult(ArrayList<Pair> p){
		this.result= p;
	}
	int i=0;
	public void draw(){
		i=0;
		Timer t= new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;

		};

		});
		t.start();
	}
}
