import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI extends JFrame implements ActionListener 
{
	File file;
	Scanner fileIn;
	JFileChooser chooser = new JFileChooser(".");
	//choose a file type
	FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
	int response;
	// Items as global variable in order to add Actionlistener on each of them
	JMenuItem Load;
	JMenuItem Save;
	JMenuItem Clear;
	JMenuItem Run;
	JMenuItem RandomGen;
	JFrame jf;
<<<<<<< HEAD
	PointPanel panel;

	public GUI() {
		// The overall Jframe
=======
	
	//panel as global object
	PointPanel panel = new PointPanel();	
	
	public GUI()
	{
		//The overall Jframe
>>>>>>> 0f7a587c826740aa1376d03a3f560df44ff3fe0f
		jf = new JFrame();
		jf.setSize(800, 800);
		jf.setLayout(new FlowLayout());
		jf.setTitle("CSE460 Final Project");
<<<<<<< HEAD

		// add point panel
		panel = new PointPanel();
		jf.setContentPane(panel);
		panel.addMouseListener(new CanvasClickListener(panel));

		// Menu Bar
		JMenuBar jmb = new JMenuBar();
		jf.setJMenuBar(jmb);
		JMenu file = new JMenu("Options");
		file.setMnemonic(KeyEvent.VK_F);
		jmb.add(file);

=======
		
		
			 
		jf.setContentPane(panel);		
		panel.addMouseListener(new CanvasClickListener(panel));
		
		//Menu Bar
		JMenuBar jmb = new JMenuBar();
				jf.setJMenuBar(jmb);
				JMenu file = new JMenu("Options");
				file.setMnemonic(KeyEvent.VK_F);
				jmb.add(file);	
				
				
				
		
>>>>>>> 0f7a587c826740aa1376d03a3f560df44ff3fe0f
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
<<<<<<< HEAD

		// Options for menu
=======
		
		
		
		//Options choice
				
		
		
		//Options
>>>>>>> 0f7a587c826740aa1376d03a3f560df44ff3fe0f
		Load = new JMenuItem("Load");
		Load.setMnemonic(KeyEvent.VK_L);
		Load.addActionListener(this);
		file.add(Load);

		file.addSeparator();

		// number will be fixed by developer
		RandomGen = new JMenuItem("Random Generator");
		RandomGen.setMnemonic(KeyEvent.VK_L);
		RandomGen.addActionListener(this);
		file.add(RandomGen);

		file.addSeparator();
		Save = new JMenuItem("Save");
		Save.setMnemonic(KeyEvent.VK_A);
		Save.addActionListener(this);
		file.add(Save);
		file.addSeparator();
		Clear = new JMenuItem("Clear");
		Clear.setMnemonic(KeyEvent.VK_S);
		Clear.addActionListener(this);
		file.add(Clear);

		file.addSeparator();

		Run = new JMenuItem("Run");
		Run.setMnemonic(KeyEvent.VK_Q);
		Run.addActionListener(this);
		file.add(Run);
		file.addSeparator();
		while (true)
			jf.repaint();
	}

	// Here is the Actionlistener that will do the job when mouse clicks on it
	@Override
	public void actionPerformed(ActionEvent arg0) {

		// Action listener for Load
		if (arg0.getSource() == Load) {

			if (response == JFileChooser.APPROVE_OPTION) {

				 //Display the loaded file (points)
				try {
					JFileChooser chosenFile = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("CSE563", "txt");
					chosenFile.setFileFilter(filter);
					int showOpenDialog = chosenFile.showOpenDialog(null);
					if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
						//fileName = chosenFile.getSelectedFile().getAbsolutePath();
						File file = chosenFile.getSelectedFile();
						Scanner myReader = new Scanner(file);
						List<Point> points = new LinkedList<>();
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String[] dataLine = data.split(",");
							Point p = new Point(Integer.parseInt(dataLine[0]), Integer.parseInt(dataLine[1]));
							points.add(p);
						}
						myReader.close();
						panel.setPoints(points);
						jf.repaint();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}

			}

		}

		else if (arg0.getSource() == Save) {
			
<<<<<<< HEAD
			//Display the save Roaster diagram

			String fileName = "";
			FileOutputStream fileOutStream;
			List<Point> points = panel.getPoints();
			StringBuilder fileData = new StringBuilder();
			for (Point p : points) {
				System.out.println(p.getX() + "=x  y=" + p.getY());
				fileData.append("" + p.getX() + ",");
				fileData.append("" + p.getY() + "\n");
			}
			try {
				JFileChooser chosenFile = new JFileChooser();
				int showSaveDialog = chosenFile.showSaveDialog(null);
				if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
					fileName = chosenFile.getSelectedFile().getAbsolutePath() + ".txt";
				}
				fileOutStream = new FileOutputStream(fileName);
				fileOutStream.write(fileData.toString().getBytes());
				fileOutStream.flush();
				fileOutStream.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			} catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, "No file selected");
			}

		}

		else if (arg0.getSource() == Clear) {

		}

		else if (arg0.getSource() == Run) {

=======
			panel.clear();
			
		}
		
		else if(arg0.getSource() == Run)
		{
			ArrayList<Point> gridPoint  = new ArrayList<>();
//			for(int i=0;i<100;i++){
//				gridPoint.add(new Point(i*10,i*20));
//			}
//			gridPoint.add(new Point(1,1));
			Dbscan d = new Dbscan(gridPoint,5);
			ArrayList<ArrayList<Pair>> result= d.runDbscan();
//			for(int i=0;i<x.size();i++){
//				System.out.println();
//				System.out.println(i);
//				for (int j=0;j<x.get(i).size();j++){
//					System.out.print(x.get(i).get(j).point1.toStirng() + "   ");
//					System.out.println(x.get(i).get(j).point2);
//
//				}
//			}
		}
					
		else if(arg0.getSource() == RandomGen)
		{
			panel.randomGenerator();
					
>>>>>>> 0f7a587c826740aa1376d03a3f560df44ff3fe0f
		}

		else if (arg0.getSource() == RandomGen) {

		}

	}
}
