import java.util.Comparator;

    
    public class PlayerObj {
    	private String firstName;
    	private String lastName;
    	private String team;
    	private String position;
    	private double projectedScore;
    	private double actualScore;
    	private double scoreDeviation;
    	
    	public PlayerObj(){
    		//this.firstName = firstName;
    		//this.lastName = lastName;
    		//this.projectedScore = projectedScore;
    		//this.actualScore = actualScore;
    		//this.scoreDeviation = scoreDeviation;
    		
    	}
    	
    	public String getFirstName() {
			   return firstName;
			} 
		
		public void setFirstName(String n) {
			   firstName = n;
			}
		
		public String getLastName() {
			   return lastName;
			} 
		
		public void setLastName(String n) {
			   lastName = n;
			} 
		
		public String getTeam() {
			   return team;
			} 
		
		public void setTeam(String n) {
			   team = n;
			} 
		
		public String getPosition() {
			   return position;
			} 
		
		public void setPosition(String n) {
			   position = n;
			} 
		
		public double getProjScore() {
			   return projectedScore;
			} 
		
		public void setProjScore(double d) {
			projectedScore = d;
			} 
		
		public double getActualScore() {
			   return actualScore;
			} 
		
		public void setActualScore(double d) {
			actualScore = d;
			} 
		
		public double getScoreDeviation() {
			   return scoreDeviation;
			} 
		
		public void setScoreDeviation(double d) {
			scoreDeviation = d;
			} 
		
		//Method to sort by projected score
		
		//public int compareTo(PlayerObj o){
		//	int compareProj = (int)((PlayerObj) o).getProjScore();
		//	return (int)this.projectedScore - compareProj;
		//}
		
		public static Comparator<PlayerObj> firstNameComparator = new Comparator<PlayerObj>() {
			public int compare(PlayerObj n1, PlayerObj n2) {
				   String firstName1 = n1.getFirstName().toLowerCase();
				   String firstName2 = n2.getFirstName().toLowerCase();
				   return firstName2.compareTo(firstName1);
			}
		};
		
		public static Comparator<PlayerObj> lastNameComparator = new Comparator<PlayerObj>() {
			public int compare(PlayerObj n1, PlayerObj n2) {
				   String lastName1 = n1.getLastName().toLowerCase();
				   String lastName2 = n2.getLastName().toLowerCase();
				   return lastName2.compareTo(lastName1);
			}
		};
		
		public static Comparator<PlayerObj> projScoreComparator = new Comparator<PlayerObj>() {
			public int compare(PlayerObj s1, PlayerObj s2) {
				  	int score1 = (int)s1.getProjScore();
				    int score2 = (int)s2.getProjScore();
				    return score2 - score1;
			}
		};
		public static Comparator<PlayerObj> actualScoreComparator = new Comparator<PlayerObj>() {
			public int compare(PlayerObj s1, PlayerObj s2) {
				  	int score1 = (int)s1.getActualScore();
				    int score2 = (int)s2.getActualScore();
				    return score2 - score1;
			}
		};
		public static Comparator<PlayerObj> scoreDeviationComparator = new Comparator<PlayerObj>() {
			public int compare(PlayerObj s1, PlayerObj s2) {
				  	int score1 = (int)s1.getScoreDeviation();
				    int score2 = (int)s2.getScoreDeviation();
				    return score2 - score1;
			}
		};


		/*
		@Override
		public int compareTo(Object o) {
			int compareProj = (int)((PlayerObj) o).getActualScore();
			return compareProj - (int)this.actualScore;
		}
	    */
    }