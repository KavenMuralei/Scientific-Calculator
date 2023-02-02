
class Multiplication extends Calculator{
    //instance variable
    String equation;
    boolean radMode;
    //Constructor
    public Multiplication(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String multiplication(){
        //i, x, and y are used to keep track of the current position in the equation string
        int i;
        int y;
        int x;
        //this for loop starts at the position of the times operator and goes backwards, looking for the first non-numeric character
        for (i = equation.indexOf("x") - 1; i < equation.length(); i--) {
            //if the current character is not numeric or it's the beginning of the string, break out of the loop
            if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                i++;//increment to get out of the position
                System.out.println(i);
                break;
            }
        }// tries finding the first number of the multiplication equation
        for (x = i; x < equation.length(); x++) {
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
        //Looks for second number
        for (y = equation.indexOf("x") + 1; y < equation.length(); y++) {
            if (String.valueOf(equation.charAt(y)).equals("."))
                tempNumber += String.valueOf(equation.charAt(y));
            else if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                y--;
                break;
            } else
                tempNumber += String.valueOf(equation.charAt(y));
        }
        // Perform the multiplication
        fullEquation = Double.parseDouble(number) * Double.parseDouble(tempNumber);
        if (opCheck(equation) > 1) {
            //parses the left side of the equation
            equationParse1 = equation.substring(0, i);
            //parses the right side of the equation
            if (y == equation.length())
                equationParse2 = equation.substring(y, equation.length());
            else
                equationParse2 = equation.substring(y + 1, equation.length());
            equation = equationParse1 + fullEquation + equationParse2;//incorporates the rest of the equation to the product
        } else {
            equation = String.valueOf(fullEquation);
        }
        //resets number and tem number
        number = "";
        tempNumber = "";
        return equation;
    }
}
