import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = {"ant", "baboon", "badger", "bat", "bear","beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"};
        String sercretWord = words[pickword()];
        System.out.println(sercretWord);
        char[] gameWord = sercretWord.toCharArray();
        for(int h = 0; h < gameWord.length; h++){
            gameWord[h] = sercretWord.charAt(h);
        } 
        ArrayList <Character> missedLetters = new ArrayList<>();
        
        char[] blankboard = new char[gameWord.length];
        printBoard(blankboard);

        
        System.out.println(Arrays.toString(gameWord));
        
        int misses = 1;
        System.out.println("Welcome to Animal Hangman, where all the words are animals! Lets Begin!");
        for(int i = 0; i < 7; i++){
            System.out.println("This is the number of misses "+ misses);
           System.out.println(printHangman(misses));
           
            System.out.println("Mystery Word: "+ Arrays.toString(blankboard));
            System.out.println("Missed letters: "+ missedLetters);
            System.out.println("Would you like to guess the 1. letter or 2. a word. (Select 1 or 2)");
            int option = scan.nextInt();
            if(scan.hasNextInt()){
               
                if(option == 2){
                    System.out.println("Type in the word.");
                    scan.nextLine();
                    String guessWord = scan.nextLine();
                    if(guessWord.equals(sercretWord)){
                        System.out.println("You win! The word was " + sercretWord + "!");
                        System.exit(0);
                    } else{
                        misses++;
                        System.out.println("Incorrect");
                    }
            
                } else if(option == 1){
                            int correct = 0;
                            System.out.println("Type in a letter");
                            char guessLetter = scan.next().charAt(0);
                            for(int m = 0; m < gameWord.length; m++){
                                if(guessLetter == gameWord[m]){
                                    blankboard[m] = guessLetter;
                                    correct = 1;
                                } 
                            } if(correct != 1){
                                misses++;
                                missedLetters.add(guessLetter);
                            } correct = 0;
                            
                                
                    } else{
                        System.out.println("Try Again");
                                    while(!(option == 1 || option == 2)){
                                        System.out.println("Please type a valid entry. Type 1 to select a letter or Type 2 to guess the word.");
                                                    option = scan.nextInt();}
                                                    if(option == 2){
                                                        System.out.println("Type in the word.");
                                scan.nextLine();
                                String guessWord = scan.nextLine();
                                if(guessWord.equals(sercretWord)){
                                    System.out.println("You win! The word was " + sercretWord + "!");
                                    System.exit(0);
                                } else{
                                    misses++;
                                    System.out.println("Incorrect");
                                }
                                    } else if(option == 1){
                                        int correct = 0;
                                        System.out.println("Type in a letter");
                                        char guessLetter = scan.next().charAt(0);
                                        for(int m = 0; m < gameWord.length; m++){
                                            if(guessLetter == gameWord[m]){
                                                blankboard[m] = guessLetter;
                                                correct = 1;
                                            } 
                                        } if(correct != 1){
                                            misses++;
                                            missedLetters.add(guessLetter);
                                        } correct = 0;
                                } 
                    }}
                            
                            else{ System.out.println("Invalid entry try again");
                                  

                                             

                                                            }
                                                    }
                        if(misses == 7){
                           System.out.println("You Lose!");
                            }
                        
                            scan.close();        }
                    
                    

        
        
        
    
   

//Chooses a random number thats used to select a word
public static int pickword(){
    double wordNumber =Math.random()*64 + 1;
    return (int)wordNumber;
}
//prints a blank board
public static char[] printBoard(char[] word){
    for(int i = 0; i < word.length; i++){
        word[i]= '_';
    }
    return word;
}
//prints the hangman based off the number of errors/misses
public static String printHangman(int errors){
    switch (errors){
        case 1: return "+---+\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +   //if the user didn't miss any guesses.
        "    |\n" +
        "    |\n" +
        "=========\n"; 
        case 2: return"+---+\n" +
        "|   |\n" +
        "O   |\n" +   //if the user missed one guess.
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n";
        case 3: return"+---+\n" +
        "|   |\n" +
        "O   |\n" +    //if the user missed two guesses.
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n"; 
        case 4: return " +---+\n" +
        " |   |\n" +
        " O   |\n" +   //if the user missed three guesses.
        "/|   |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n"; 
        case 5: return " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n"+   //if the user missed four guesses.
        "     |\n" +
        "     |\n" +
        " =========\n"; 
        case 6: return" +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +  //if the user missed five guesses.
        "/    |\n" +
        "     |\n" +
        " =========\n";
        case 7: return" +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +   //if the user missed six guesses.
        "/ \\  |\n" +
        "     |\n" +
        " =========\n";
        default: return " ";

    }
}
}

 