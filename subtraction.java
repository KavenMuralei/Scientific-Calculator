
class Subtraction extends Calculator{
    //instance variable
    String equation;
    boolean radMode;

    public Subtraction(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String subtraction(){
        //i, x, and y are used to keep track of the current position in the equation string
        int i;
        int y;
        int x;
        //this for loop starts at the position of the subtraction operator and goes backwards, looking for the first non-numeric character
        for (i = equation.indexOf("–") - 1; i < equation.length(); i--) {
            //if the current character is not numeric or it's the beginning of the string, break out of the loop
            if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                i++;
                break;
            }
        }
        // loop through the equation to find the first digit after the - operator
        for (x = i; x < equation.length(); x++) {
            // check for the presence of any operator or the end of the equation
            if (String.valueOf(equation.charAt(x)).equals("-")){
                number += String.valueOf(equation.charAt(x));
            }
            if (Character.isDigit((equation.charAt(x))) || String.valueOf(equation.charAt(x)).equals(".")) {
                number += String.valueOf(equation.charAt(x));
            } else if (x > equation.length() || !Character.isDigit((equation.charAt(x)))) {
                break;
            }
        }
        // loop to find the start of the second number in the equation
        for (y = equation.indexOf("–") + 1; y < equation.length(); y++) {
            if (String.valueOf(equation.charAt(y)).equals("."))
                tempNumber += String.valueOf(equation.charAt(y));
            else if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                y--;
                break;
            } else
                tempNumber += String.valueOf(equation.charAt(y));
        }
        // Perform the subtraction
        fullEquation = Double.parseDouble(number) - Double.parseDouble(tempNumber);
        System.out.println(fullEquation);
        if (opCheck(equation) > 1) {
            //parses the left side of the equation
            equationParse1 = equation.substring(0, i);
            //parses the right side of the equation
            if (y == equation.length())
                equationParse2 = equation.substring(y, equation.length());
            else
                equationParse2 = equation.substring(y + 1, equation.length());
            equation = equationParse1 + fullEquation + equationParse2;//incorporates the rest of the equation to the difference
        } else {
            equation = String.valueOf(fullEquation);
        }
        //resets number and temp number
        number = "";
        tempNumber = "";
        return equation;
    }
}
