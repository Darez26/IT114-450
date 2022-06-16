package M3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;
import java.util.Scanner;



public class NumberGuesser4 {
    private int maxLevel = 1;
    private int level = 1;
    private int strikes = 0;
    private int maxStrikes = 5;
    private int number = -1;
    private boolean pickNewRandom = true;
    private Random random = new Random();
    private String fileName = "ng4.txt";
    private String[] fileHeaders = {"Level", "Strikes", "Number", "MaxLevel"};//used for demo readability

    private void saveState(){
        String[] data = {level+"", strikes+"", number +"", maxLevel+""};
        String output = String.join(",", data);
        //Note: we don't need a file reference as FileWriter creates the file if it doesn't exist
        try (FileWriter fw = new FileWriter(fileName)) {
			fw.write(String.join(",", fileHeaders));
            fw.write("\n");//new line
            fw.write(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void loadState(){
        File file = new File(fileName);
		if (!file.exists()) {
            //Not providing output here as it's expected for a fresh start
			return;
		}
		try (Scanner reader = new Scanner(file)) {
            int lineNumber = 0;
			while (reader.hasNextLine()) {
				String text = reader.nextLine();
                //System.out.println("Text: " + text);
                if(lineNumber == 1){
                    String[] data = text.split(",");
                    String level = data[0];
                    String strikes = data[1];
                    String number = data[2];
                    String maxLevel = data[3];
                    int temp = strToNum(level);
                    if(temp > -1){
                        this.level = temp;
                    }
                    temp = strToNum(strikes);
                    if(temp > -1){
                        this.strikes = temp;
                    }
                    temp=strToNum(number);
                    if(temp > -1){
                        this.number = temp;
                        pickNewRandom = false;
                    }
                    temp = strToNum(maxLevel);
                    if(temp > -1){
                        this.maxLevel = temp;
                    }
                }
                lineNumber++;
			}
		} catch (FileNotFoundException e) {//specific exception
			e.printStackTrace();
		} catch (Exception e2) {//any other unhandled exception
			e2.printStackTrace();
		}
        System.out.println("Loaded state");
    }

    

    /***
     * Gets a random number between 1 and level.
     * 
     * @param level (level to use as upper bounds)
     * @return number between bounds
     */
    private void generateNewNumber(int level) {
        int range = 9 + ((level - 1) * 5);
        System.out.println("Welcome to level " + level);
        System.out.println(
                "I picked a random number between 1-" + (range + 1) + ", let's see if you can guess.");
        number = random.nextInt(range) + 1;
    }

    private void win() {
        System.out.println("That's right!");
        level++;// level up!
        strikes = 0;
    }

    private boolean processCommands(String message) {
        boolean processed = false;
        if (message.equalsIgnoreCase("quit")) {
            System.out.println("Tired of playing? No problem, see you next time.");
            processed = true;
        }
        //TODO add other conditions here
        return processed;
    }

    private void lose() {
        System.out.println("Uh oh, looks like you need to get some more practice.");
        System.out.println("The correct number was " + number);
        strikes = 0;
        level--;
        if (level < 1) {
            level = 1;
        }
    }

    private void processGuess(int guess) {
        if (guess < 0) {
            return;
        }
        System.out.println("You guessed " + guess);
        if (guess == number) {
            win();
            pickNewRandom = true;
        } else {
            System.out.println("That's wrong");
            strikes++;
            
            if (strikes >= maxStrikes) {
                lose();
                pickNewRandom = true;
            }
            else{
                saveState();
            }
        }
        
    }

    private int strToNum(String message) {
        int guess = -1;
        try {
            guess = Integer.parseInt(message.trim());
        } catch (NumberFormatException e) {
            System.out.println("You didn't enter a number, please try again");
        }catch(Exception e2){
            System.out.println("Null message received");
        }
        return guess;
    }
    
    public void start() {
        try (Scanner input = new Scanner(System.in);) {
            System.out.println("Welcome to NumberGuesser4.0");
            System.out.println("To exit, type the word 'quit'.");
            loadState();
            System.out.println("Please enter the game mode you wish to play \n Press 1 for Hard \n Press 2 for Medium \n Press 3 for Easy");
                
            int gamemode = input.nextInt();
            gameMode(gamemode);
            input.nextLine();
            do {
                if (pickNewRandom) {
                    generateNewNumber(level);
                
                    saveState();
                    pickNewRandom = false;
                }
                
                 
                System.out.println("Type a number and press enter");
                //we'll want to use a local variable here
                //so we can feed it into multiple functions
                String message = input.nextLine();
                // early termination check
                if (processCommands(message)) {
                    //command handled; don't proceed with game logic
                    break;
                }
                //this is just to demonstrate we can return a value and pass it into another method
                int guess = strToNum(message);
                processGuess(guess);
                tempHint(guess);
                //the following line is the same as the above two lines
                //processGuess(getGuess(message));
            } while (true);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Goodbye.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("Thanks for playing!");
    }
    // UCID: 31485020
    // June 15, 2022
    // Explanation : In order to give a hot or cold hint to the user I first needed to find out how many numbers the user 
    // was away from the actual result. By subractcing the real number from the guess and taking the absolute value, I can find 
    // how far away the guess is. Since I want to give more  "tempture", I created 5 temperatures : Boiling, hot, warm, cold and Freezing
    // If the guess was 3 numbers away from the answer they would receive boiling as a message, if the number was 10 numbers away they would
    // get warm.  Any number with a distance of 15 digits from the target would get cold. For each guess there will be an if and else statement 
    // that will be evaluated. 
    private void tempHint(int guess)
    {
        int farAway =  Math.abs(guess-number);

        if(farAway <=3)
        {
            System.out.println("Its boiling in here! Your really close to the answer!");
        }
        else if(farAway<=5)
        {
            System.out.println("Getting Hotter!");
        }
        else if (farAway <=10)
        {
            System.out.println("Its warm in here! Keep going in this direction");
        }
        else if(farAway <=15)
        {
            System.out.println("Bring a sweater its getting cold in the game room");
        }
        else
        {
            System.out.println("BRRRR!!! It's FREEZING try go in the other direction!!");
        }
        

    }
    // UCID: 31485020
    // June 15, 2022
    // Explanation : To create a game mode which adjusts the game strikes per level I created a simple function that would utilze a switch statement.
    // During the intial start of the start function, I would ask the user for a number which will determine how many max strikes they can aquire.  
    //If the User puts 1 then they will enter "hard" mode and will have 3 chances to find the target number. Since this function runs in the 
    // beginning of the start function but before the do while loop it sets the max strikes for the whole game. The only tricky part was I 
    // needed to remember to clear the scanner before the loop begins so that it would be empty and ready for the users input. 
    private void gameMode(int mode)
    {
        switch(mode)
        {
            case 1: 
                maxStrikes = 3; // hard
                break;
            case 2:
                maxStrikes = 5; // medium
                break;
            case 3:
                maxStrikes = 8; // easy
                break;
        }
    }
    public static void main(String[] args) {
        NumberGuesser4 ng = new NumberGuesser4();
        ng.start();
    }
}