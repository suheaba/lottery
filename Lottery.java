/*Lottery.java

Suheab
Maria
Michael

06 Dec 2018
*/

import java.util.*;
import javax.swing.*;

public class Lottery{

List<Integer>secretNumbers=new ArrayList<Integer>();//a list collection stores elements by insertion order. A list maintains indices of its elements so it allows adding, 	 retrieving, modifying, removing elements by an integer index (zero-based index; the first element is at 0-index, the second at 1-index, the third at 2-index, and so on)

  public static void main(String[] args){

	  String numOfLines;
	  int num=0;
	  numOfLines=JOptionPane.showInputDialog(null, "How many lines would you like to play?");
	  num=Integer.valueOf(numOfLines);
	  while (num>3){
		  numOfLines = JOptionPane.showInputDialog(null,"the max num of tries is 3. How many lines would you like to play?");//ask the user for lines intended to play
		  num=Integer.valueOf(numOfLines);//assign the value to num
	  }
	  lotteryApp(num); //starts the game

	  while (JOptionPane.showConfirmDialog(null," do you want to continue playing?", "Info",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ //gives the user the choise of playing again
		   numOfLines=JOptionPane.showInputDialog(null,"How many lines would you like to play?");//choice for the next attempt
		   num=Integer.valueOf(numOfLines);
		   while (num>3){ //limits the lines to three per turn, if more than 3 is selected message comes up and player is asked to choose again
			   numOfLines=JOptionPane.showInputDialog(null,"The maximum number of lines is 3. How many lines would you like to play?");
			   num = Integer.valueOf(numOfLines);
		   }
		   lotteryApp(num);
	   }

	   System.exit(0);//end the game if the player chose no when asked if they want to play again

  }


  public static void lotteryApp(int num){
	  LotteryApp game=new LotteryApp(num);
	  game.setSecretNumbers();
	  //appends these random numbers to the result string
	  game.appendToResult(("Random Numbers : "+Arrays.toString(game.getSecretNumbers())+"\n\n"));

	  //stores the current line Number
	  int currentLine=1;

	  //play for as many lines as the user requests
	  while (currentLine<=game.getNumberOfLines()){
		  game.setGuessedNumbers(JOptionPane.showInputDialog(null,"Please enter a number between 0 and 40 and use comma after each number please"));

		  // compare the guessed numbers with secret numbers
	      for(int i=0; i<6; i++){
	    	  for(int j=0; j<6; j++){
	    		  //if there is a match between guessed and secret
	    		  if(game.getGuessedNumbers()[i]==game.getSecretNumbers()[j]){

	    			 //increase the guessed number counter one, so that we can display every line at the end of the game
	    			  //this is needed to be able to show the history at the end of the game.
	    			 game.setGuessedNumberCounter(currentLine);

	    			 //save correctly guessed numbers, so that every line is displayed at the end of the game
	    			 game.setMatchedNumbers(game.getTotalGuessedNumbers(),game.getGuessedNumbers()[i]);

	    			 //increase the total guessed numbers
	    			 game.setTotalGuessedNumbers();
	    		  }
	    	  }
	      }

	      game.appendToResult("\nAttemp Number : "+ String.valueOf(currentLine)+"\nYour Numbers: "+Arrays.toString(game.getGuessedNumbers()));

	      //print the won amount to the screen by checking the guess number counter
	      if(game.getGuessedNumberCounter()[currentLine]==3)
	    	  game.setAmountWon(100);
	      else if(game.getGuessedNumberCounter()[currentLine]==4)
	    	  game.setAmountWon(250);
	      else if(game.getGuessedNumberCounter()[currentLine]==5)
	    	  game.setAmountWon(1000);
	      else if(game.getGuessedNumberCounter()[currentLine]==6)
	    	  game.setWonTheLottery(true);

	      // display a message if no guessed number matches
	      if(game.getGuessedNumberCounter()[currentLine]==0)
	    	  game.appendToResult("\nYou didn't guess any number correctly, better luck next time!");
	      else {//show the correctly guessed number
	    	  game.appendToResult("\nGuessed Numbers matched: ");
	    	  for(int i=0;i<game.getTotalGuessedNumbers();i++)
	    		  game.appendToResult( game.getMatchedNumbers()[i]+" ");
	      }

	      //if the lottery is won print congratulations...
	      if(game.isWonTheLottery()==true)
	    	  game.appendToResult("\nCONGRUTALTIONS... YOU WON THE LOTTERY\n");
	      else
	    	  game.appendToResult("\nAmount won : € "+game.getAmountWon()+"\n");

	      // go to next line
	      currentLine++;

	      //set line specific variables to default
	      game.setTotalGuessedNumbers(0);
	      game.setWonTheLottery(false);
	      game.setAmountWon(0);
		}

	  //print the end game result
		game.appendToResult("\n");
		for(int i=1;i<=game.getNumberOfLines();i++)
			game.appendToResult("You guessed "+game.getGuessedNumberCounter()[i] +" numbers on line "+i+"\n");

  	  	JOptionPane.showMessageDialog(null,game.getResult());
  }


}