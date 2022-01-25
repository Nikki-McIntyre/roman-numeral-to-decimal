
/**
 * 
 * @author Nikki Mcintyre
 * Will figure out a decimal value from roman numerals
 * I.E.
 * 'VII' returns 7
 * 'IV' returns 4
 */
import java.util.ArrayList;
import java.util.Scanner;
class Solution {
  //the roman numerals and thier decimal value
  private static final int I = 1;
  private static final int V = 5;
  private static final int X = 10;
  private static final int L = 50;
  private static final int C = 100;
  private static final int D = 500;
  private static final int M = 1000;
  public static void main(String[] args) {
    //get the input and send it to the method to solve
    System.out.println("Enter a **valid** roman numerial (there is no error checking yet)"); //TODO: add error checking
    Scanner kbd = new Scanner(System.in);
    int answer = romanToInt(kbd.next());
    kbd.close();
    System.out.println(answer);
  }

  /**
   * 
   * @param s inputted roman numeral
   * @return converted s in decimal 
   */
  public static int romanToInt(String s) {
    //container for the decimal solution
    int answer = 0;
    //ArrayList of the roman numerals that are given
    ArrayList<Character> chars = new ArrayList<Character>();
    //ArrayList of the decimal values of the roman numerals
    ArrayList<Integer> results = new ArrayList<Integer>();
    //add all the characters to the chars arraylist
    for (char c : s.toCharArray()) {
      chars.add(c);
    }
    //add the corresponding decimal values in the appropriate place in the results ArrayList
    for (int i = 0; i < chars.size(); i++){
      if(chars.get(i) == 'I'){
        results.add(I);
      }
      if(chars.get(i) == 'V'){
        results.add(V);
      }  
      if(chars.get(i) == 'X'){
        results.add(X);
      }  
      if(chars.get(i) == 'L'){
        results.add(L);
      }  
      if(chars.get(i) == 'C'){
        results.add(C);
      } 
      if(chars.get(i) == 'D'){
        results.add(D);
      } 
      if(chars.get(i) == 'M'){
        results.add(M);
      }    
    }

    //add the values from the results arraylist up to get a single decimal number
    for(int i = 0; i < results.size(); i++){
      /*
      HOWEVER this is why I can't just add them all up in the previous step. Roman numerials are a little tricky 'VI' = 6 but 'IV' = 4. 
      So I figure out if the current index is smaller than the next index like in the previous example I < V hten the value it actually refelects is V - I or 5 - 1 == 4
      this is true for all the numerals XI = 11 but IX = 9 or 10 - 1 etc 
      */
      if(i != results.size()-1){
        //if it is smaller then I add the results as I just mentioned, larger number - smaller one but then I got to add an extra iteration to I because otherwise I'd be repeating values
        if(results.get(i) < results.get(i+1)){
          answer += ((results.get(i+1)) - (results.get(i)));
          i++;
        }
        //add the value to answer
        else{
          answer += results.get(i);
        }
      }
      else{
        answer += results.get(i);
      }
    }
    //return the answe
    return answer;
  }
    
}