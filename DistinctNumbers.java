import java.util.*;

/**   
   Description:
   Reads ten numbers from the user and displays the unique numbers, removing any duplicates.
*/
public class DistinctNumbers
{
  /**
     Calls "getInput" method and passes the result as parameter to the "display" method.
  */
  public static void main(String[] args)
  {
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~\nDistinct Numbers\n~~~~~~~~~~~~~~~~");
    System.out.println("This program will display each unique number you are about to enter, and will remove any duplicate entries.\nPlease enter ten numbers.");
    System.out.println();
    int[] array1 = getInput();
    System.out.println();
    System.out.println("Here is your list of numbers:");
    display(array1);
    System.out.println();
  }

  /**
     Searches integer array for a specific integer.
     @param a array to be searched
     @param n specific number being searched for in array
     @return if "n" is found in "a": boolean true; otherwise false
  */
  public static boolean found(int[] a, int n)
  {
    boolean result = false; // Variable "result" is false by default.
    for ( int i = 0; i < a.length; i++ )
    {
      if ( a[i] == n )
      { 
        result = true; // Adjusts "result" variable to true if number already exists in the array.
        break;
      }
    }
    return result;
  }

  /**
     Reads the user's input and stores input values in an array.
     @return integer array of user inputs with all duplicate numbers filtered out 
  */
  public static int[] getInput()
  {
    int[] array = new int[10];
    Scanner console = new Scanner(System.in);
    int input;
    int index = 0;
    boolean zeroUsed = false;
    for ( int i = 0; i < array.length; i++ )
    {
      System.out.print("Enter a number: ");
      input = console.nextInt();
      if ( input == 0 && zeroUsed == false ) // Special condition, array will accept 0 from user only once.
      { 
        array[index] = input;
        index++;
        zeroUsed = true;
      }      
      boolean valueExists = found(array, input);
      if ( valueExists == false )
      { 
        array[index] = input;
        index++; // Only increases array index when a unique number is added.
      }
    } 
    int[] result = Arrays.copyOf(array, index); // Creates a copy to eliminate empty spaces.
    return result;
  }

  /**
     Displays contents of an array as a terminal output.
     @param a array of integer values to be displayed
  */
  public static void display(int[] a)
  {
    System.out.print("{");
    for ( int i = 0; i < a.length; i++ )
    {
      System.out.print(a[i]);
      if ( i < a.length - 1 )
      { 
        System.out.print(", ");
      }
    }
    System.out.println("}");
  }
}
