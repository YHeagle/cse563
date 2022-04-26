import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
	
	//Items as global variable in order to add Actionlistener on each of them
	JMenuItem Load;
	JMenuItem Save;
	JMenuItem Clear;
	JMenuItem Run;
	JMenuItem RandomGen;
	JFrame jf;
	
	//panel as global object
	PointPanel panel = new PointPanel();	
	
	public GUI()
	{
		//The overall Jframe
		jf = new JFrame();
		jf.setSize(800, 800);
		jf.setLayout(new FlowLayout());
		jf.setTitle("CSE460 Final Project");
		
		
			 
		jf.setContentPane(panel);		
		panel.addMouseListener(new CanvasClickListener(panel));
		
		//Menu Bar
		JMenuBar jmb = new JMenuBar();
				jf.setJMenuBar(jmb);
				JMenu file = new JMenu("Options");
				file.setMnemonic(KeyEvent.VK_F);
				jmb.add(file);	
				
				
				
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jf.setVisible(true);
		
		
		
		//Options choice
				
		
		
		//Options
		Load = new JMenuItem("Load");
		Load.setMnemonic(KeyEvent.VK_L);
		Load.addActionListener(this);
		file.add(Load);
		
		file.addSeparator();
		
		//number will be fixed by developer
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
		
		
		
		
		//jf.setVisible(true);
		while (true)
			jf.repaint();
	}

	
	// Here is the Actionlistener that will do the job when mouse clicks on it
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//Action listener for Load
		if(arg0.getSource() == Load)
		{  
			
		   chooser.setFileFilter(filter);
		   chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		   response = chooser.showOpenDialog(null);
		   
		   if(response == JFileChooser.APPROVE_OPTION)
		   {
		    file = chooser.getSelectedFile(); 
		    
		    //Display the loaded file (points)
		    
		   }
		   

		   
		}
	    
		else if(arg0.getSource() == Save)
		{
				//Display the save Roaster diagram
				
					//chooser for saving file
					JFileChooser saveChooser = new JFileChooser();
					saveChooser.setDialogTitle("Select a file to save");
					int saveSelection = saveChooser.showSaveDialog(jf);
					
					//if the option is valid
					if (saveSelection == JFileChooser.APPROVE_OPTION) 
					{
					    File fileToSave = saveChooser.getSelectedFile();
					    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					}
				

					    
		}
		
		else if(arg0.getSource() == Clear)
		{
			
			panel.clear();
			
		}
		
		else if(arg0.getSource() == Run)
		{
			
		}
					
		else if(arg0.getSource() == RandomGen)
		{
			panel.randomGenerator();
					
		}
			
		
		
		
		

				
		}
	}
		

	
	
	
