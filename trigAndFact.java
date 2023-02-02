
import javax.script.ScriptException;

class TrigAndFact extends Calculator {
    //instance variable
    String equation;
    boolean radMode;

    //Constructor
    public TrigAndFact(String stringEquation, boolean radOrDegMode, String ans) {
        equation = stringEquation;
        radMode = radOrDegMode;
    }

    String trigAndFact() {
        while (equation.contains("sin") || equation.contains("cos") || equation.contains("tan") || equation.contains("log")) {//while loop that loops until there's no trig ratios or logarithms
            //i, y are used to keep track of the current position in the equation string
            int y;
            int i;
            if (equation.contains("sin^-1(")) { // sine inverse
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("sin^-1(") + 7, endBracketFinder(equation, equation.indexOf("sin^-1(") + 6))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                if (radMode) //radians
                    fullEquation = Math.asin(fullEquation); //sin inverse of fullEquation
                else {
                    fullEquation = Math.toDegrees(Math.asin(fullEquation)); //sin inverse of fullEquation in degrees
                }
            }
            if (equation.contains("cos^-1(")) {//cos inverse
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("cos^-1(") + 7, endBracketFinder(equation, equation.indexOf("cos^-1(") + 6))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                if (radMode) //radians
                    fullEquation = Math.acos(fullEquation); //sin inverse of fullEquation
                else {
                    fullEquation = Math.toDegrees(Math.acos(fullEquation)); //sin inverse of fullEquation in degrees
                }
            }
            if (equation.contains("tan^-1(")) {//tan inverse
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("tan^-1(") + 7, endBracketFinder(equation, equation.indexOf("tan^-1(") + 6))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                if (radMode) //radians
                    fullEquation = Math.atan(fullEquation); //sin inverse of fullEquation
                else {
                    fullEquation = Math.toDegrees(Math.atan(fullEquation)); //sin inverse of fullEquation in degrees
                }
            }
            if (equation.contains("sin(")) { //sin
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("sin(") + 4, endBracketFinder(equation, equation.indexOf("sin(") + 3))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                if (radMode)// radians
                    fullEquation = Math.sin(fullEquation);//sin of full equation
                else
                    fullEquation = Math.sin(Math.toRadians(fullEquation));//sin of full equation in degrees
            }
            if (equation.contains("cos(")) { //cos
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("cos(") + 4, endBracketFinder(equation, equation.indexOf("cos(") + 3))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(fullEquation);
                if (radMode)// radians
                    fullEquation = Math.cos(fullEquation);//sin of full equation
                else
                    fullEquation = Math.cos(Math.toRadians(fullEquation));//sin of full equation in degrees
            }
            if (equation.contains("tan(")) {//tan
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("tan(") + 4, endBracketFinder(equation, equation.indexOf("tan(") + 3))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(fullEquation);
                if (radMode)// radians
                    fullEquation = Math.tan(fullEquation);
                else
                    fullEquation = Math.tan(Math.toRadians(fullEquation));
            }
            if (equation.contains("log(")) { //log
                try {
                    fullEquation = Double.parseDouble(calculating(equation.substring(equation.indexOf("log(") + 4, endBracketFinder(equation, equation.indexOf("log(") + 3))));//recursion finding whats inside the bracket
                } catch (ScriptException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(fullEquation);
                fullEquation = Math.log10(fullEquation);
            }
            for (i = equation.indexOf("(") - 1; i < equation.length(); i--) {//finds all the values on the left side of the equation
                if (i < 0 || String.valueOf(equation.charAt(i)).equals("+") || String.valueOf(equation.charAt(i)).equals("–") || String.valueOf(equation.charAt(i)).equals("x") || String.valueOf(equation.charAt(i)).equals("/")) {
                    i++;
                    System.out.println(i);
                    break;
                }
            }
            for (y = endBracketFinder(equation, equation.indexOf("(")) + 1; y < equation.length(); y++) {//finds all the values on the right side of the equation
                if (y > equation.length() || !Character.isDigit((equation.charAt(y)))) {
                    y--;
                    break;
                }
            }
            if (opCheck(equation) > 1) {
                //parses the left side of the string
                equationParse1 = equation.substring(0, i);
                System.out.println(equationParse1);
                if (y == equation.length())
                    //parses the right side of the string
                    equationParse2 = equation.substring(y);
                else
                    equationParse2 = equation.substring(y + 1);

                equation = equationParse1 + fullEquation + equationParse2; // combines the equation
            } else {
                equation = String.valueOf(fullEquation);
            }
        }
        return equation;
    }
}
