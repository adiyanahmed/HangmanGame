/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.util.Scanner;

/**
 *
 * @author 073259129
 */
public class HangmanGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
       
  System.out.println("Welcome to the Hangman game");
  char roundActive = ('y');
          
  while (roundActive == 'y'){
      
        int numOfGuesses = 8; //number of guesses
        String alphabet = ("a b c d e f g h i j k l m n o p q r s t u v w x y z"); //string for list of alphabets
        String dash = ""; 
        String secretWord;
        
        System.out.println("Please enter the secret word:"); //asks for the word to guess
        secretWord = keyboard.nextLine();
        System.out.println(" ");
                
        for (int letterCount = 0; letterCount < secretWord.length(); letterCount++) { //dashes out the word 
            dash = dash + "-";
        }

//clears the screen so the secret word isn't displayed 
        for (int count = 0; count <= 40; count++) { //refreshes the screen for player 2 
            System.out.println(" ");
        }

        System.out.println("Letters left: " + alphabet);
        System.out.println("the word to guess is: " + dash);

//starting the game after word has been selected 
        do {
            int alphabetPos = 0;
            int letterPos = 0; //position of guessed letter in the secret word 
            boolean letterFound = false;
            System.out.print("Enter the letter you would like to guess: ");
            char letterGuessed = keyboard.next().charAt(0);

//updating the secret word and number of guesses
            do {
                letterPos = secretWord.indexOf(letterGuessed, letterPos);
                //if letter found 
                if (letterPos >= 0) { 
                    letterFound = true;
                    dash = dash.substring(0, letterPos) + secretWord.substring(letterPos, letterPos + 1) + dash.substring(letterPos + 1); //replacing dashes in the word with found letters
                    letterPos = letterPos + 1;

                }
            } while (letterPos >= 0);

            //if letter not found
            if (letterFound == false) {
                System.out.println(" "); 
                System.out.println("Wrong letter");
                System.out.println(" ");
                numOfGuesses = numOfGuesses - 1; //subtracting guesses if wrong
            }

//graphics for each stage of the game
            switch (numOfGuesses) {
                case 7:
                    System.out.println("  +---+\n"
                            + "  |   |\n"
                            + "      |\n"
                            + "      |\n"
                            + "      |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 6:
                    System.out.println("+---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + "      |\n"
                            + "      |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 5:
                    System.out.println(" +---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + "  |   |\n"
                            + "      |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 4:
                    System.out.println("+---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + " /|   |\n"
                            + "      |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 3:
                    System.out.println("  +---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + " /|\\  |\n"
                            + "      |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 2:
                    System.out.println("  +---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + " /|\\  |\n"
                            + " /    |\n"
                            + "      |\n"
                            + "=========''', '''");
                    break;

                case 1:
                    System.out.println(" +---+\n"
                            + "  |   |\n"
                            + "  O   |\n"
                            + " /|\\  |\n"
                            + " / \\  |\n"
                            + "      |\n"
                            + "=========''']");
                    break;

                case 0: //death
                    System.out.println(" ___________.._______\n"
                            + "| .__________))______|\n"
                            + "| | / /      ||\n"
                            + "| |/ /       ||\n"
                            + "| | /        ||.-''.\n"
                            + "| |/         |/  _  \\\n"
                            + "| |          ||  `/,|\n"
                            + "| |          (\\\\`_.'\n"
                            + "| |         .-`--'.\n"
                            + "| |        /Y . . Y\\\n"
                            + "| |       // |   | \\\\\n"
                            + "| |      //  | . |  \\\\\n"
                            + "| |     ')   |   |   (`\n"
                            + "| |          ||'||\n"
                            + "| |          || ||\n"
                            + "| |          || ||\n"
                            + "| |          || ||\n"
                            + "| |         / | | \\\n"
                            + "\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|\n"
                            + "|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\n"
                            + "| |        \\ \\        | |\n"
                            + ": :         \\ \\       : :  \n"
                            + ". .          `'       . .");
                    break;
            }

//updating list of alphabets to display after every guess
            alphabetPos = alphabet.indexOf(letterGuessed);
            if (alphabetPos == -1) { //if the letter is not found in the list of alphabets
                System.out.println(" ");
                System.out.println("You have already guessed this letter!!");
            }

            if (alphabetPos != -1) { //if the letter is found in the list of alphabets
                alphabet = alphabet.substring(0, alphabetPos) + '-' + alphabet.substring(alphabetPos + 1);
            }

//printing out all the previously updated information
            System.out.println(" ");
            System.out.println("The word to guess is: " + dash);
            System.out.println(" ");
            System.out.println("Guesses left:" + numOfGuesses);
            System.out.println("Letters left:" + alphabet);
        } while ((numOfGuesses > 0) && (dash.indexOf('-') != -1));

//message displayed if win/lose
        if (numOfGuesses != 0) {
            System.out.println(" ");
            System.out.println("The Governor Called! You’re Saved!"); //win case
 
        } else {
            System.out.println(" ");
            System.out.println("Hangman!"); //lose case
 

        }
 //play again
            System.out.println("Would you like to play again? (y/n)");         
            roundActive = keyboard.next().charAt(0);
            String gunk = keyboard.nextLine(); //removing the buffered 'enter' input in the keyboard 
    }
  
 //if player chooses not to play 
  if (roundActive == 'n'){
      System.out.println("Thanks for playing !"); //end game
  }
  
  

}
    
}

