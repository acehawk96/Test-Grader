
import java.util.Scanner;
import java.util.InputMismatchException;  // Import Input Mismatch Exeception
import java.util.ArrayList;  // new
/*
  Haleem Hawkins
  01 May 2020
  Final Project
*/

public class HawkinsFinal
{
  public static void main(String[] args)
  {
    final char ARRAY_SIZE = 25;
    char[] userAnswer = new char[ARRAY_SIZE];  // array for user's answers.
    int questionNumber = 1;  // keep track of question number.
   
    // Ask for 25 answers using a for loop.
    Scanner input = new Scanner(System.in);
      System.out.println("Answer 25 questions with A, B, C, or D."+
      " Two invalid answers on one question will automatically count against you.");
    // start loop
    for (int index = 0; index < userAnswer.length; index++)
    {  
      System.out.println("Question #"+ questionNumber++);
      userAnswer[index] = input.next().charAt(0);
      // change lowercase inputs to uppercase. 
      switch(userAnswer[index])
      {
       case 'a':
          userAnswer[index] = 'A';
          break;
        case 'A':
          break;
        /////////
        case 'b':
          userAnswer[index] = 'B';
          break;
        case 'B':
          break;
        /////////
        case 'c':
          userAnswer[index] = 'C';
        case 'C':
          break; 
         ////////
        case 'd':
          userAnswer[index] = 'D';
          break;
        case 'D':
          break;
        // input validation chance.
        default: 
          System.out.println("Invalid input! You have one more chance... "+
          "Answer with A, B, C, or D please.");
          userAnswer[index] = input.next().charAt(0); //get another input. 
      }
    }
    testResult(userAnswer);  // send userAnswer array to testResult method.
  }
     
     
  /*
     Compare and display test results. 
     @param uAnswer : Array of user inputed answers.
  */ 
  public static void testResult(char[] uAnswer)
  { 
    ArrayList<Integer> quest = new ArrayList<Integer>();
    ArrayList<Character> list = new ArrayList<Character>();
    
    char[] correctAnswer = {'B','D','A','A','C',+  // Answer key 
                            'A','B','A','C','D',+  
                            'B','C','D','A','D',+
                            'C','C','B','D','A',+
                            'B','B','D','D','C'};
     int right = 0;  // correct answer counter.
     int question = 0;  // question number counter.
     
     // loop and compare user answers array and answer key array.
     for (char i = 0; i < uAnswer.length && i < correctAnswer.length; i++)
     { 
       if (uAnswer[i] == correctAnswer[i])  // correct.
       { 
         question++; 
         System.out.println(question +". " + uAnswer[i] +" Correct ");
         right++;
       }
       else if (!(uAnswer[i] == correctAnswer[i]))  // incorrect.
       {  
         question++; 
         System.out.println(question +". " + uAnswer[i] +" is incorrect. The answer is: " + correctAnswer[i]); 
         list.add(uAnswer[i]);  // add answer to list.
         quest.add(question);  // add question number to list.
       }
    }
    
    // Determine pass or fail.
    if (right >= 18)
    {
      System.out.println("\nYou Passed! Total correct answers: "+ right +"/25");
    }
    else if (right < 18)
    {
      System.out.println("\nUnfortunately, you Failed...Total correct answers: "+ right +"/25");
    } 
    displayWrong(quest);  // send question list to displayWrong method.
  }
    
    
  /* 
    Display wrong answers.
    @param quest : list incorrect questions
  */
  public static void displayWrong(ArrayList<Integer> quest)
  { 
    System.out.println("Here is a list of question numbers you answered incorrectly:\n");
    // Convert quest array list to integer and loop through array.
    for (int wrongQuest : quest)
    { 
      System.out.println("Question #"+ wrongQuest);
    }   
  }
}
  
    
