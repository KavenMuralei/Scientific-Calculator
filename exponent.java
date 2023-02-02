
class Exponent extends Calculator{
    //instance variable
    String equation;
    boolean radMode;
    //Constructor
    public Exponent(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String exponent(){
        //i, x, and y are used to keep track of the current position in the equation string
        int i;
        int y;
        int x;
        for (i = equation.indexOf("^") - 1; i < equation.length(); i--) {
            if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                i++;
                break;
            }
        }
        for (x = i; x < equation.length(); x++) {
            // tries finding the first number of the equation
            if (String.valueOf(equation.charAt(x)).equals("-")){
                number += String.valueOf(equation.charAt(x));
            }
            else if (Character.isDigit((equation.charAt(x))) || String.valueOf(equation.charAt(x)).equals(".")) {
                number += String.valueOf(equation.charAt(x));
            } else if (x > equation.length() || !Character.isDigit((equation.charAt(x)))) {
                break;
            }
        }
        x++;
        for (y = equation.indexOf("^") + 1; y < equation.length(); y++) {
            // tries finding the last number of the equation
            if (String.valueOf(equation.charAt(y)).equals("-")){
                tempNumber += String.valueOf(equation.charAt(y));
            }
            else if (String.valueOf(equation.charAt(y)).equals("."))
                tempNumber += String.valueOf(equation.charAt(y));
            else if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                y--;
                break;
            } else
                tempNumber += String.valueOf(equation.charAt(y));
        }
        // Performs the exponent
        fullEquation = Math.pow(Double.parseDouble(number), Double.parseDouble(tempNumber));
        System.out.println(fullEquation);
        if (opCheck(equation) > 1) {
            //parses the left side of the equation
            equationParse1 = equation.substring(0, i);
            if (y == equation.length())
                //parses the right side of the equation
                equationParse2 = equation.substring(y, equation.length());
            else
                equationParse2 = equation.substring(y + 1, equation.length());
            equation = equationParse1 + fullEquation + equationParse2;
        } else {
            equation = String.valueOf(fullEquation);
        }
        //resets number and temNumber
        number = "";
        tempNumber = "";
        return equation;
    }
}
