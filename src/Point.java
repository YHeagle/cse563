
import java.awt.Color;
import java.awt.Graphics;
public class Point{

	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g)
	{   
		g.setColor(Color.black);
		g.fillOval(x-2, y-2, 4, 4);
		
	}
}
