import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

public class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
             Bracket temp=new Bracket(next,position);
            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(temp);
                continue;
            }

            else if (next == ')' || next == ']' || next == '}') {
               //any type of opening brcket
                // Process closing bracket, write your code here
                if(opening_brackets_stack.isEmpty()){
                    System.out.println(temp.position+1);
                    return;
                }
                 Bracket top=opening_brackets_stack.pop();
                
                    if(top.Match(next)==true){
                        continue;
                    }
                    else{
                       System.out.println(temp.position+1);
                       return;
                    }

                
            }
            else{
                continue;
            }
            
           
        }
        if(opening_brackets_stack.isEmpty()==false){
            Bracket top=opening_brackets_stack.pop();
            System.out.println(top.position+1);
        }
        else{
             System.out.println("Success");
        }
        
     }
    
        // Printing answer, write your code here
    
}

