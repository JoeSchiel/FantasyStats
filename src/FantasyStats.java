//Joe Schiel
//To read in projected and actual fantasy scores
// and find the deviation between actual and projected

//TO DO: add player to playerList if they have a projected score
// and are not in playerList already.

//Make playerList and projList index the size of the list

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

public class FantasyStats {
	
	//[i][0] = first name
	//[i][1] = last name
	//[i][2] = team
	//[i][3] = position
	//[i][4] = actual
	//[i][5] = projected
	//[i][6] = deviation
	
	public static int NUM_OF_PLAYERS = 0;
	private static String[ ][ ] playerList;
	public static ArrayList<PlayerObj> playerObjects;
	public static String actualFormat;
	public static String projFormat;
	public static boolean frameSwitch = false;

	public static void main (String[] args) throws FileNotFoundException{
		
		MenuFrame.createFrames();
		
		System.out.println(FantasyStats.frameSwitch);
		
		if(frameSwitch == true){

		//Preparing .txt files	
		Scanner actualFile = new Scanner(new FileReader(actualFormat));
		Scanner projectedFile = new Scanner(new FileReader(projFormat));
		
		String playerString;
		playerObjects = new ArrayList<PlayerObj>();
		ArrayList<String> playerLine = new ArrayList<String>();
		ArrayList<String> playerLine2 = new ArrayList<String>();
		ArrayList<String> projectedLine = new ArrayList<String>();
		ArrayList<String> projectedLine2 = new ArrayList<String>();
		int index = 0;
		int multiArrayIndex = 0;
		int projIndex = 0;
		int projArrayIndex = 0;
		
		//Counter to find the size the array needs to be
		while(actualFile.hasNextLine()){
			actualFile.nextLine();
			NUM_OF_PLAYERS++;
		}
		
		playerList = new String[NUM_OF_PLAYERS][7];
		String[ ][ ] projList = new String[NUM_OF_PLAYERS][3];
		
		actualFile = new Scanner(new FileReader
				("C:/Users/Joe/Documents/FantasyData/FF" +  MenuFrame.positionFileString 
				+"Actual" + MenuFrame.weekFileString  + ".txt"));
		
		while (actualFile.hasNext()){
			playerString = actualFile.next()
									 .replace("\"", "")
									 .replace("," , "")
									 .replace("ÿ", "")
									 .replace("þ", "")
									 .replace("*", "")
									 //.replace("\\u00a0","") //non breaking white space
									 .trim()
									 .toLowerCase()
									 .toString();
			playerLine.add(playerString);
			
		}	
		
		//Preparing the projected file
		while (projectedFile.hasNext()){
			playerString = projectedFile.next()
									 .replace("\"", "")
									 .replace("," , "")
									 .replace("ÿ", "")
									 .replace("þ", "")
									 .replace("*", "")
									 //.replace(" ", "")
									 .trim()
									 .toLowerCase()
									 .toString();
			projectedLine.add(playerString);
			
		}
		
		//remove empty lines if any exist
		// NOTE: Most likely not needed anymore
		for (int i = 0 ; i < playerLine.size()  ; i++) {
			if (playerLine.get(i).toString().length() == 0){
				playerLine.remove(playerLine.get(i));
			}
		}
		
		for (int i = 0 ; i < projectedLine.size()  ; i++) {
			if (projectedLine.get(i).toString().length() == 0){
				projectedLine.remove(projectedLine.get(i));
			}
		}

		//add first name last name and score to one string and to the array.
		//NOTE: String array is no longer needed if values are put in the array

		for (int i = 0 ; i < playerLine.size()  ; i++) {
			String firstName;
			String lastName;
			String team;
			String position;
			String scoreString;
			firstName = playerLine.get(index);
			lastName = playerLine.get(index + 1);
			team = playerLine.get(index + 2);
			position = playerLine.get(index + 3);
			playerList[multiArrayIndex][0] = firstName;
			playerList[multiArrayIndex][1] = lastName;
			playerList[multiArrayIndex][2] = team;
			playerList[multiArrayIndex][3] = position;
			//Try for loop here instead !
				if (playerLine.get(i).toString().charAt(0) == '0' || 
					playerLine.get(i).toString().charAt(0) == '1' ||
					playerLine.get(i).toString().charAt(0) == '2' ||
					playerLine.get(i).toString().charAt(0) == '3' ||
					playerLine.get(i).toString().charAt(0) == '4' ||
					playerLine.get(i).toString().charAt(0) == '5' ||
					playerLine.get(i).toString().charAt(0) == '6' ||
					playerLine.get(i).toString().charAt(0) == '7' ||
					playerLine.get(i).toString().charAt(0) == '8' ||
					playerLine.get(i).toString().charAt(0) == '9'){
							index = i + 1;
							scoreString = playerLine.get(i);
							playerList[multiArrayIndex][4] = scoreString;
							multiArrayIndex++;
							playerLine2.add(firstName + " " + lastName + " " +
											team + " " + position + " " + scoreString);
				}
		}
		
		for (int i = 0 ; i < projectedLine.size()  ; i++) {
			String firstName;
			String lastName;
			String scoreString;
			firstName = projectedLine.get(projIndex);
			lastName = projectedLine.get(projIndex + 1);
			projList[projArrayIndex][0] = firstName;
			projList[projArrayIndex][1] = lastName;
			//Try for loop here instead !
				if (projectedLine.get(i).toString().charAt(0) == '0' || 
					projectedLine.get(i).toString().charAt(0) == '1' ||
					projectedLine.get(i).toString().charAt(0) == '2' ||
					projectedLine.get(i).toString().charAt(0) == '3' ||
					projectedLine.get(i).toString().charAt(0) == '4' ||
					projectedLine.get(i).toString().charAt(0) == '5' ||
					projectedLine.get(i).toString().charAt(0) == '6' ||
					projectedLine.get(i).toString().charAt(0) == '7' ||
					projectedLine.get(i).toString().charAt(0) == '8' ||
					projectedLine.get(i).toString().charAt(0) == '9'){
							projIndex = i + 1;
							scoreString = projectedLine.get(i);
							projList[projArrayIndex][2] = scoreString;
							projArrayIndex++;
							projectedLine2.add(firstName + " " + lastName + " " + scoreString);
				}
		}
		
		//compare player names and add projected score to playerList
		//Need to compare first and last name for exceptions like Josh Mccown/ Luke Mccown
		
		for(int i = 0; i < NUM_OF_PLAYERS ; i++){
			for(int j = 0; j < NUM_OF_PLAYERS ; j++){
					if((playerList[i][0] + playerList[i][1]).equals
					   (projList[j][0] + projList[j][1])){
					   playerList[i][5] = projList[j][2];
					}
					if(playerList[i][1] == null){
						break;
					}
			}
		}
		
		//replaces null values with 0
		for(int i = 0; i < 50 ; i++){
			if (playerList[i][5] == null){
				playerList[i][5] = "0";
			}
		}
		
		//Finds the deviation between actual and projected score and
		//adds that value to playerList
		for(int i = 0; i < 50 ; i++){
			double deviation;
			deviation = Double.parseDouble(playerList[i][4]) - Double.parseDouble(playerList[i][5]);
			playerList[i][6] = (Double.toString(deviation));
		}
		
		playerObjArray();
		Frames.createFrames();
		//MenuFrame.createFrames();
		labelCreate();
		
		actualFile.close();
		projectedFile.close();
		
		frameSwitch = false;
		
		}
	}
	

	
	public static void playerObjArray(){
		for (int i =  0; i < NUM_OF_PLAYERS; i++) {		
			PlayerObj pObj = new PlayerObj();
				pObj.setFirstName(playerList[i][0]);
				pObj.setLastName(playerList[i][1]);
				pObj.setTeam(playerList[i][2]);
				pObj.setPosition(playerList[i][3]);
				pObj.setActualScore(Double.parseDouble(playerList[i][4]));
				pObj.setProjScore(Double.parseDouble(playerList[i][5]));
				pObj.setScoreDeviation(Double.parseDouble(playerList[i][6]));
			
			playerObjects.add(pObj);
	    }
	}
    
    public static void labelCreate(){
		for (int i =  0; i < playerObjects.size(); i++) {
			JLabel label = new JLabel (playerObjects.get(i).getFirstName() + "  " +
									   playerObjects.get(i).getLastName() + "  " +
									   playerObjects.get(i).getTeam() + "  " +
									   playerObjects.get(i).getPosition() + "  " +
									   playerObjects.get(i).getProjScore() + "  " +
									   playerObjects.get(i).getActualScore() + "  " +
									   playerObjects.get(i).getScoreDeviation() );	
			Frames.pane.add(label);	
			/*
			//change color of JLabel
			if(playerObjects.get(i).getScoreDeviation() > 0){
				label.setForeground(Color.green);
			}
			else if(playerObjects.get(i).getScoreDeviation() < 0){
				label.setForeground(Color.red);
			}
			*/
		}
    }
}
