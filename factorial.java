
class Factorial extends Calculator{
    //instance variable
    String equation;
    boolean radMode;
    //Constructor
    public Factorial(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String factorial(){
        //i and x are used to keep track of the current position in the equation string
        int i;
        int x;
        //this for loop starts at the position of the factorial and goes backwards, looking for the first non-numeric character
        for (i = equation.indexOf("!") - 1; i < equation.length(); i--) {
            if (i < 0 || String.valueOf(equation.charAt(i)).equals("!") || String.valueOf(equation.charAt(i)).equals("^") || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                i++;
                break;
            }
        }// tries finding the first number of the equation
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
        //performs the factorial
        fullEquation = factorial(Double.parseDouble(number));
        equation = String.valueOf(fullEquation);
        return equation;
    }
}
