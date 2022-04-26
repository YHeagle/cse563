import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasClickListener extends MouseAdapter {

	private PointPanel panel;
	
	public CanvasClickListener(PointPanel panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		panel.addPoint(new Point(e.getX(), e.getY()));
	}
	
	
	
	
}
