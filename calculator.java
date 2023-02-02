
import javax.script.ScriptException;

class Calculator {
    //instance variable
    String previousAnswer;
    String equation;
    boolean radMode;
    String tempNumber = ""; //these 2 string variables are
    String number = "";
    double fullEquation = 0;
    String equationParse1="";
    String equationParse2="";

    //Constructor
    public Calculator(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
        previousAnswer = ans;
    }

    Calculator() {
    }


    public static int opCheck(String string){ //Function that tries to find an operator //Kaven 01/22/23
        // Initialize a counter variable to keep track of the number of operators
        int count=0;
        // Iterate through each character of the input string
        for (int i = 0; i < string.length(); i++) {
            // Check if the current character is one of the specified operators
            if (String.valueOf(string.charAt(i)).equals("–") || String.valueOf(string.charAt(i)).equals("+") || String.valueOf(string.charAt(i)).equals("x") || String.valueOf(string.charAt(i)).equals("/")  || String.valueOf(string.charAt(i)).equals("√") || String.valueOf(string.charAt(i)).equals("^") || String.valueOf(string.charAt(i)).equals("s") || String.valueOf(string.charAt(i)).equals("c") || String.valueOf(string.charAt(i)).equals("t") || String.valueOf(string.charAt(i)).equals("!") || String.valueOf(string.charAt(i)).equals("l")) {
                // If it is, increment the operator count
                count++;
            }
        }
        // Return the final operator count
        return count;
    }
    static double factorial(double n) //equation used to get the factorial of a number
    {
        // Check if the input number is 0
        if (n == 0) {
            // This is the base case for the recursion
            return 1;
        }
        // Check if the input number is greater than 0
        if(n>0) {
            // This is the recursive case, the function calls itself with an updated input value of n-1
            return n*factorial(n-1);
        }
        else {
            // This is the recursive case, the function calls itself with an updated input value of n+1
            return n*factorial(n+1);
        }
    }
    public static int endBracketFinder(String s, int n) { //The purpose of this function is to find the corresponding end bracket for a opening bracket //Kaven 01/25/23
        // Initialize a counter to keep track of the number of opening and closing brackets
        int counter = 0;
        // Initialize the characters to be used for opening and closing brackets
        char opening = '(';
        char closing = ')';
        // Initialize a variable to store the position of the matching bracket, set to -1 by default
        int positionOfMatchingBrack = -1;
        // Initialize a boolean to indicate if a matching bracket has been found
        boolean found = false;

        // Continue iterating through the input string while the current index is less than the length of the string and a matching bracket has not been found
        while (n < s.length() && !found) {

            // Check if the current character is an opening bracket
            if (s.charAt(n) == (opening)) {
                // If it is, increment the counter
                counter++;
            }
            // Check if the current character is a closing bracket
            else if (s.charAt(n) == (closing)) {
                // If it is, decrement the counter
                counter--;
                // Check if the counter is now 0, indicating that a matching bracket has been found
                if (counter == 0) {
                    // If it is, set the position of the matching bracket and set the found variable to true
                    positionOfMatchingBrack = n;
                    found = true;
                }
            }
            // Increment the index to continue iterating through the string
            n++;
        }
        // Return the final position of the matching bracket or -1 if no matching bracket was found
        return positionOfMatchingBrack;
    }


    String calculating(String equation) throws ScriptException{ //Main function that calculates stuff Kaven 01/19/2023

        boolean equationComplete = false;
        try {
            while (!equationComplete) {// polymorphism. If one of these if statments are true it calculates equation through
                if(equation.contains("sin") || equation.contains("cos") || equation.contains("tan") || equation.contains("log")) {
                    TrigAndFact trigAndFact = new TrigAndFact (equation, radMode, previousAnswer);
                    equation = trigAndFact.trigAndFact();
                }
                if (equation.contains("(") || equation.contains(")")) {
                    Bracket bracket = new Bracket (equation, radMode, previousAnswer);
                    equation = bracket.bracket();
                }
                if (equation.contains("^")){
                    Exponent exponent = new Exponent (equation, radMode, previousAnswer);
                    equation = exponent.exponent();
                }
                if (equation.contains("/")) {
                    Division division = new Division (equation, radMode, previousAnswer);
                    equation = division.division();
                }
                if(equation.contains("!")){
                    Factorial factorial = new Factorial (equation, radMode, previousAnswer);
                    equation = factorial.factorial();
                }
                if (equation.contains("x")) {
                    Multiplication multiplication = new Multiplication (equation, radMode, previousAnswer);
                    equation = multiplication.multiplication();
                } else if (equation.contains("–")) {
                    Subtraction subtraction = new Subtraction (equation, radMode, previousAnswer);
                    equation = subtraction.subtraction();

                } else if (equation.contains("+")) {
                    Addition addition = new Addition (equation, radMode, previousAnswer);
                    equation = addition.addition();
                }
                if (!equation.contains("/") && !equation.contains("+") && !equation.contains("x") && !equation.contains("–")) {
                    equationComplete = true;
                }
            }
        }
        
        catch(Exception e){
            equation = "SYNTAX ERROR (CALCULATOR SIDE)";
        }
        return equation;
    }
}
