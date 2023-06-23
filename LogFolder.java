/* The Leetcode file system keeps a log each time some user performs a change folder operation. 
The operations are described below:
1)- "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
2)- "./" : Remain in the same folder.
3)- "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step. The file system 
starts in the main folder, then the operations in logs are performed. Return the minimum number of operations needed to go 
back to the main folder after the change folder operations.
* Eg 1 : logs = ["d1/","d2/","../","d21/","./"]         Output = 2 
* Eg 2 : logs = ["d1/","d2/","./","d3/","../","d31/"]   Output = 3 
* Eg 3 : logs = ["d1/","../","../","../"]               Output = 0 
*/
import java.util.*;
public class LogFolder
{
      public int MinimumNumberOfOperations(String operations[])
      {
            Stack<String> stack = new Stack<String>();    //* Stack Defined -> O(k)
            for(int i = 0; i < operations.length; i++)    //! Checking -> O(N)
            {
                  if((operations[i].length() >= 3) && (operations[i].substring(operations[i].length() - 3,
                   operations[i].length()) == "../"))    // Checking the last three characters...
                  {
                        if(stack.size() != 0)   // If Stack is not empty...
                              stack.pop();
                  }
                  else if(operations[i].substring(operations[i].length() - 2, operations[i].length()) ==
                   "./")    // Checking only the last two characters...
                  {}
                  else    // Otherwise Pushing the file directory in the Stack...
                        stack.push(operations[i].substring(0, operations[i].length() - 1));
            }
            return stack.size();    // Returning the Stack Size left...
      }
      public static void main(String args[])
      {
            //? Test Case I
            String op1[] = {"d1/","d2/","../","d21/","./"};
            //? Test Case II
            String op2[] = {"d1/","d2/","./","d3/","../","d31/"};
            //? Test Case III
            String op3[] = {"d1/","../","../","../"};
            LogFolder logFolder = new LogFolder();          // Object creation...
            System.out.println("Case 1, Minimum Steps : "+logFolder.MinimumNumberOfOperations(op1));
            System.out.println("Case 2, Minimum Steps : "+logFolder.MinimumNumberOfOperations(op2));
            System.out.println("Case 3, Minimum Steps : "+logFolder.MinimumNumberOfOperations(op3));
      }
}


//! Time Complexity -> O(N)
//* Space Complexity -> O(k)
