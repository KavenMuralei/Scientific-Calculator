
class Addition extends Calculator{
    String equation;
    boolean radMode;
    String previousAnswer;
    //Constructor
    public Addition(String stringEquation, boolean radOrDegMode, String ans) {
        //instance variable
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String addition(){
        //i, x, and y are used to keep track of the current position in the equation string
        int i;
        int y;
        int x;
        // loop through the equation to find the first digit before the + operator
        for (i = equation.indexOf("+") - 1; i < equation.length(); i--) {
            // check for the presence of any operator or the start of the equation
            if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                i++;
                break;
            }
        }
        // loop through the equation to find the first digit after the + operator
        for (x = i; x < equation.length(); x++) {
            // check for the presence of any operator or the end of the equation
            if (String.valueOf(equation.charAt(x)).equals("-")){
                number += String.valueOf(equation.charAt(x));
            }
            else if (Character.isDigit((equation.charAt(x))) || String.valueOf(equation.charAt(x)).equals(".") || String.valueOf(equation.charAt(x)).equals("-")) {
                number += String.valueOf(equation.charAt(x));
            } else if (x > equation.length() || !Character.isDigit((equation.charAt(x)))) {
                break;
            }
        }
        x++;
        // loop to find the start of the second number in the equation
        for (y = equation.indexOf("+") + 1; y < equation.length(); y++) {
            if (String.valueOf(equation.charAt(y)).equals(".") || String.valueOf(equation.charAt(y)).equals("-"))
                tempNumber += String.valueOf(equation.charAt(y));
            else if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                y--;
                break;
            } else
                tempNumber += String.valueOf(equation.charAt(y));
        }
        // Perform the addition
        fullEquation = Double.parseDouble(number) + Double.parseDouble(tempNumber);
        System.out.println(fullEquation);
        if (opCheck(equation) > 1) {
            equationParse1 = equation.substring(0, i);

            if (y == equation.length())
                equationParse2 = equation.substring(y, equation.length());
            else
                equationParse2 = equation.substring(y + 1, equation.length());
            equation = equationParse1 + fullEquation + equationParse2;//incorporates the rest of the equation to the sum
        } else {
            equation = String.valueOf(fullEquation);
        }
        //resets number and temp number
        number = "";
        tempNumber = "";
        return equation;
    }
}
