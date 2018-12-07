/*LotteryApp.java

Suheab
Maria
Michael

06 Dec 2018
*/


import java.util.*;

public class LotteryApp{

	//data members
	private int numberOfLines;
	private String result="";
	private int[] guessedNumbers=new int[6];
	private int[] secretNumberList=new int[6];
	private int[] matchedNumbers=new int[6];

	private int guessedNumberCounter[]={0,0,0,0};
	private int totalGuessedNumbers=0;
	private boolean wonTheLottery;
	private int amountWon=0;

	//constructor
	public LotteryApp (int num){
		setNumberOfLines(num); 		// sets how many lines will be played when the game starts
	}


	//getter and setter for amountWon variable
	public int getAmountWon(){
		return amountWon;
	}
	public void setAmountWon(int amountWon){
		this.amountWon=amountWon;
	}

	//getter for correctly guessed numbers in the line
	public int[] getMatchedNumbers(){
		return matchedNumbers;
	}
	//add a new number to correcly guessed numbers list
	public void setMatchedNumbers(int index, int matchedNumber){
		this.matchedNumbers[index]=matchedNumber;
	}

	//holds the variable that stores if the lottery is won
	public boolean isWonTheLottery(){
		return this.wonTheLottery;
	}

	public void setWonTheLottery(boolean wonTheLottery){
		this.wonTheLottery=wonTheLottery;
	}

	//store the number of correctly guessed numbers in the line
	public int getTotalGuessedNumbers(){
		return totalGuessedNumbers;
	}
	public void setTotalGuessedNumbers(int x){
		this.totalGuessedNumbers=x;
	}

	//another setter for  correctly guessed numbers. This methods adds one for the total guessed numbers.
	//we can use setTotalGuessedNumbers with two different usages.
	//1. setTotalGuessedNumbers()
	//2. setTotalGuessedNumbers(int)
	public void setTotalGuessedNumbers(){
		this.totalGuessedNumbers++;
	}

	//get and set the total guessed number Array
	public int[] getGuessedNumberCounter(){
		return this.guessedNumberCounter;
	}

	public void setGuessedNumberCounter(int currentGame){
		this.guessedNumberCounter[currentGame]++;
	}

	//set and get the guessed numbers in the line
	public int[] getGuessedNumbers(){
		return this.guessedNumbers;
	}

	public void setGuessedNumbers(String input){

		 String[] temp=input.split(",");//splits the numbers the player selected between the  commas
	      for(int i=0; i<temp.length;i++){
	    	  this.guessedNumbers[i]=Integer.parseInt(temp[i]);
	    	}
	}


	//sets and gets the 6 secret random numbers
	 public void setSecretNumbers(){
	      Random rnd=new Random();

	      for (int i=0; i<6; i++)
	    	  secretNumberList[i]=rnd.nextInt(40)+1;
     }

	 public int[] getSecretNumbers(){
	     return secretNumberList;
    }


	 //sets and gets the number of lines in this game
	 public int getNumberOfLines(){
		return numberOfLines;
	}
	public void setNumberOfLines(int numberOfLines){
		this.numberOfLines=numberOfLines;
	}


	//sets and gets the result string that will be displayed in the history at the end of the game
	public String getResult(){
		return this.result;
	}
	public void appendToResult(String result){
		this.result+=result;
	}






}
