
import javax.script.ScriptException;

class Bracket extends Calculator{
    //instance variable
    String equation;
    boolean radMode;
    //Constructor
    public Bracket(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }
    String bracket(){
        if (equation.contains("(") && equation.contains(")")) {
            while (equation.contains("(") && equation.contains(")")) {
                //i and y are used to keep track of the current position in the equation string
                int i;
                int y;
                fullEquation = 0;
                equationParse1 = "";
                equationParse2 = "";
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("(") + 1, endBracketFinder(equation, equation.indexOf("("))))); // This is a recursion of the calculating function to solve the bracket
                } catch (ScriptException e) {
                    equation = "SYNTAX ERROR";//Syntax error if something isnt right
                    throw new RuntimeException(e);
                }
                //this for loop starts at the position of the open bracket and goes backwards, looking for the first non-numeric character
                for (i = equation.indexOf("(") - 1; i < equation.length(); i--) {
                    if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                        i++;//increments to get back in position
                        break;
                    }
                }
                //this for loop starts at the position of the end bracket  and goes forward, looking for the first non-numeric character
                for (y = endBracketFinder(equation, equation.indexOf("(")) + 1; y < equation.length(); y++) {
                    if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                        y--;
                        break;
                    }
                }
                if (opCheck(equation) > 1) {
                    //parses the left side of the equation
                    equationParse1 = equation.substring(0, i);
                    //parses the right side of the equation
                    if (y == equation.length())
                        equationParse2 = equation.substring(y, equation.length());
                    else
                        equationParse2 = equation.substring(y + 1, equation.length());
                    equation = equationParse1 + fullEquation + equationParse2;
                }
                else{
                    equation = String.valueOf(fullEquation);
                }
            }
        }
        else{
            equation = "SYNTAX ERROR";
        }
        return equation;
    }
}
