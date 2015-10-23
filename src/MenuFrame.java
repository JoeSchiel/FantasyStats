import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuFrame {
	
	public static JFrame menuFrame;
	private static Container pane;
	public static String positionFileString;
	public static String weekFileString;
	private static JButton qbB;
	private static JButton rbB;
	private static JButton wrB;
	private static JButton teB;
	private static JButton defenseB;
	private static JButton kB;
	private static JButton week1;
	private static JButton week2;
	private static JButton week3;
	private static JButton week4;
	private static JButton week5;
	private static JButton week6;
	
	public static void createFrames(){
	
		menuFrame = new JFrame();
		menuFrame.setTitle("Fantasy Stats"); 
		menuFrame.setSize(800, 600);
		menuFrame.setVisible(true); 
	
	pane = menuFrame.getContentPane();
    pane.setLayout(new GridLayout(3 , 2)); //  rows  column
    
    //creating buttons
    qbB = new JButton("QB");
    qbB.addActionListener(new ButtonHandler());
    rbB = new JButton("RB");
    rbB.addActionListener(new ButtonHandler());
    wrB = new JButton("WR");
    wrB.addActionListener(new ButtonHandler());
    teB = new JButton("TE");
    teB.addActionListener(new ButtonHandler());
    defenseB = new JButton("Defense");
    defenseB.addActionListener(new ButtonHandler());
    kB = new JButton("K");
    kB.addActionListener(new ButtonHandler());
    week1 = new JButton("week1");
	week1.addActionListener(new ButtonHandler());
	week2 = new JButton("week2");
	week2.addActionListener(new ButtonHandler());
	week3 = new JButton("week3");
	week3.addActionListener(new ButtonHandler());
	week4 = new JButton("week4");
	week4.addActionListener(new ButtonHandler());
	week5 = new JButton("week5");
	week5.addActionListener(new ButtonHandler());
	week6 = new JButton("week6");
	week6.addActionListener(new ButtonHandler());
    
    pane.add(qbB);
    pane.add(rbB);
    pane.add(wrB);
    pane.add(teB);
    pane.add(defenseB);
    pane.add(kB);
    
    menuFrame.setVisible(true);
    
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
    private static class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent ae){
        	
        	if (ae.getSource() == qbB){
        		positionFileString = "QB";
        		popWeekMenu();

        	}
        	else if (ae.getSource() == rbB){
        		positionFileString = "RB";
        		popWeekMenu();
        		
        	}
        	else if (ae.getSource() == wrB){
        		positionFileString = "WR";
        		popWeekMenu();

        	}
        	else if (ae.getSource() == teB){
        		positionFileString = "TE";
        		popWeekMenu();

        	}
        	else if (ae.getSource() == defenseB){
        		positionFileString = "DEFENSE";
        		popWeekMenu();

        	}
        	else if (ae.getSource() == kB){
        		positionFileString = "K";
        		popWeekMenu();

        	}
        	
        	else if(ae.getSource() == week1){
        		pane.removeAll();
        		weekFileString = "Week1";
        		FantasyStats.frameSwitch = true;
        		FantasyStats.actualFormat = ("C:/Users/Joe/Documents/FantasyData/FF"
        		+ positionFileString + "Actual" + weekFileString + ".txt");
        		FantasyStats.projFormat = ("C:/Users/Joe/Documents/FantasyData/FF"
        		+ MenuFrame.positionFileString + "Proj" + MenuFrame.weekFileString + ".txt");
        		System.out.println(FantasyStats.actualFormat);
        		//System.out.println(FantasyStats.frameSwitch);      		
        		
        	}        
        }
     }
    
    public static void popWeekMenu(){
    	pane.removeAll();
    	pane.add(week1);
    	pane.add(week2);
    	pane.add(week3);
    	pane.add(week4);
    	pane.add(week5);
    	pane.add(week6);
    	pane.revalidate();
		pane.repaint();
    	
    	
    }
	
}
