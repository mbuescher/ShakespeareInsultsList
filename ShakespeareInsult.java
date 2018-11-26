/**
 *  Creates a whole mess of Shakespearean insults,
 *  two adjectives followed by a noun.
 *  
 *  Precondition:
 *      Three files exist, each holding NUM_WORDS words.  
 *      File Names: 
 *        shakespeare-1.txt  (adjectives)
 *        shakespeare-2.txt  (adjectives)
 *        shakespeare-3.txt  (nouns)
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class ShakespeareInsult
{
  private ArrayList<String> adjective1;
  private ArrayList<String> adjective2;
  private ArrayList<String> noun;
  private final int NUM_WORDS = 30;
  
  
/** Constructor gets insulting words from files  */
  public ShakespeareInsult()
  {
    // Initialize the arrays for words
    adjective1 = new ArrayList<String>();
    adjective2 = new ArrayList<String>();
    noun = new ArrayList<String>();
    
    // Read the words from the files
    readFile (adjective1, "shakespeare-1.txt");
    readFile (adjective2, "shakespeare-2.txt");
    readFile (noun, "shakespeare-3.txt");
  }
  
  // Reads NUM_WORDS words from a file (one word per line).
  // Stores the words in the String array wordList.
  // If the file doesn't exist, exits the program with an error message.
  private void readFile (ArrayList<String> wordList, String fileName)
  {
    // open the file
    File file = new File(fileName);
    Scanner input = null;
    try
    {
        input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 

    // read the words from the file, one per line
    for (int i = 0; i < NUM_WORDS; i++)
      wordList.add(input.nextLine());
    input.close();
  }
  
  /**
   * Creates a Shakespearean insult based on three lists of 
   * insulting words.
   * @return an insult  
   */
  public String getInsult()
  {
    int i;
    String insult = "Thou art a ";
    i = (int)(Math.random() * NUM_WORDS);
    insult += adjective1.get(i) + " ";
    i = (int)(Math.random() * NUM_WORDS);
    insult += adjective2.get(i) + " ";
    i = (int)(Math.random() * NUM_WORDS);
    insult += noun.get(i) + " !";
    
    return insult;
  }
  
  /**  Main program.
    *  Loads the word lists; asks the user how many insults to generate.
    */
  public static void main (String[] args)
  {
    Scanner keyboard = new Scanner (System.in);
    ShakespeareInsult insultList = new ShakespeareInsult();
    
    System.out.print("How many insults? ");
    int numInsults = keyboard.nextInt();
    
    for (int i = 0; i < numInsults; i++) 
      System.out.println (insultList.getInsult());
    
    keyboard.close();
  }
}