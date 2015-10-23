import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frames {
	
	public static JFrame mainJFrame;
	public static Container pane;
	private static  JButton nameB;
	private static  JButton projB;
	private static  JButton actualB;
	private static  JButton deviationB;
	
	public static void createFrames(){
	
	mainJFrame = new JFrame();
	mainJFrame.setTitle("Fantasy Stats"); 
	mainJFrame.setSize(800, 600);
	mainJFrame.setVisible(true); 
	
	pane = mainJFrame.getContentPane();
    pane.setLayout(new GridLayout(FantasyStats.NUM_OF_PLAYERS + 4 , 1)); //  rows  column
    
    //creating buttons
    nameB = new JButton("Sort by name");
    nameB.addActionListener(new ButtonHandler());
    projB = new JButton("Sort by projected score");
    projB.addActionListener(new ButtonHandler());
    actualB = new JButton("Sort by actual score");
    actualB.addActionListener(new ButtonHandler());
    deviationB = new JButton("Sort by deviation");
    deviationB.addActionListener(new ButtonHandler());
    
    pane.add(nameB);
    pane.add(projB);
    pane.add(actualB);
    pane.add(deviationB);
    
    mainJFrame.setVisible(true);
    
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
    private static class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent ae){
        	
        	if (ae.getSource() == nameB){
        		pane.removeAll();
        		Collections.sort(FantasyStats.playerObjects, PlayerObj.lastNameComparator);
        		pane.add(nameB);
        	    pane.add(projB);
        	    pane.add(actualB);
        	    pane.add(deviationB);
        		FantasyStats.labelCreate();
        		pane.revalidate();
        		pane.repaint();
        	}
        	else if (ae.getSource() == projB){
        		pane.removeAll();
        		Collections.sort(FantasyStats.playerObjects, PlayerObj.projScoreComparator);
        		pane.add(nameB);
        	    pane.add(projB);
        	    pane.add(actualB);
        	    pane.add(deviationB);
        		FantasyStats.labelCreate();
        		pane.revalidate();
        		pane.repaint();
        		
        	}
        	else if (ae.getSource() == actualB){
        		pane.removeAll();
        		Collections.sort(FantasyStats.playerObjects, PlayerObj.actualScoreComparator);
        		pane.add(nameB);
        	    pane.add(projB);
        	    pane.add(actualB);
        	    pane.add(deviationB);
        		FantasyStats.labelCreate();
        		//mainJFrame.validate();
        		//mainJFrame.repaint();
        		pane.revalidate();
        		pane.repaint();
        	}
        	else if (ae.getSource() == deviationB){
        		pane.removeAll();
        		Collections.sort(FantasyStats.playerObjects, PlayerObj.scoreDeviationComparator);
        		pane.add(nameB);
        	    pane.add(projB);
        	    pane.add(actualB);
        	    pane.add(deviationB);
        		FantasyStats.labelCreate();
        		pane.revalidate();
        		pane.repaint();
        		
  
        	}
        
        }
     }
	
}
