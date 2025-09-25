import java.util.Scanner;
import java.util.ArrayList;

class Conversation implements ConversationRequirements {
  
  // Attributes 
  String username;
  /**
   * Constructor 
   */
  Conversation(String name) {
    this.username = name;
  }

  /**
   * Starts and runs the conversation with the user
   * @return converation transcript as a string
   */
  public String chat() {
    // Creates a array to store every line for the transcript
    ArrayList<String> transcript = new ArrayList<String>();
    // Creates a scanner 
    Scanner input = new Scanner(System.in);
    // Reads number of rounds, default is 0
    int rounds = 0;
    System.out.println("$ Java Conversation");
    System.out.println("How many rounds?"); 
    rounds = input.nextInt();
    input.nextLine(); 
    // Starts the conversation with the same opening each time & adds it to the transcript
    String intro = "Hi there! What's on your mind?";
    transcript.add(intro);
    System.out.println(intro);
    // For each number of rounds, the loop takes the user input, generates a response, and adds to the transcript
    for (int i = 0; i < rounds; i++) {
      String inputString = input.nextLine();
      transcript.add(inputString);
      String response = respond(inputString);
      transcript.add(response);
      System.out.println(response);
    }
    // Closes the scanner, ends the conversation, and returns the transcript as a string
    input.close();
    String outro = "See ya!";
    transcript.add(outro);
    System.out.println(outro);
    return transcript.toString();
  }

  /**
   * Prints transcript of conversation
   * @param transcript of the conversation as a string
   */
  public void printTranscript(String transcript) {
    // Re-formats the transcript so it doesn't look like an array
    String newTranscript = transcript.replaceAll(",", "\n");
    String newTranscript1 = newTranscript.replace("[", " ");
    String newTranscript2 = newTranscript1.replace("]", " ");
    // Prints the transcript
    System.out.println("TRANSCRIPT:");
    System.out.println(newTranscript2);
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response  
   */
  public String respond(String inputString) {
    // Defines an empty return string
    String returnString = "";
    // Splits the input string by words
    String regex = "[\\s]";
    String[] myArray = inputString.split(regex);
    // For every word in the input string array, checks if a mirror word is present & replaces it. 
    for (String s : myArray) {
      if (s.equals("I")) {
        returnString += "you ";
      } else if (s.equals("me")) {
        returnString += "you ";
      } else if (s.equals("am")) {
        returnString += "are ";
      } else if (s.equals("you")) {
        returnString += "I ";
      } else if (s.equals("my")) {
        returnString += "your ";
      } else if (s.equals("your")) {
        returnString += "my ";
        // If it isn't a mirror word, just adds the original word to the return string
      } else {
        returnString += s + " ";
      }
    // If no replacements were made, then it returns a random canned response from the list
    } if (returnString.trim().equals(inputString)) {
      String[] responses = {"Mhm.", "Interesting.", "Tell me more.", "Go on."};
      int randomIndex = (int) (Math.random() * responses.length);
      returnString = responses[randomIndex];
    } 
    return returnString;
  } 
  

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation("kate");
    String transcript = myConversation.chat();
    myConversation.printTranscript(transcript);
  }
}
