
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static boolean radMode = false;
    public static String equation = "";
    public static String previousAnswer = "";
    private static JTextField txtCalc;
    //Global for our buttons (Needed for Action listener)
    private static JButton one, two, three, four, five, six, seven, eight, nine, rad, deg, fact, leftBrack, rightBrack, modulo, clear, pi, sinInverse, cosInverse, tanInverse, sin, cos, tan, log, squareRoot, divide, multiply, add, subtract, zero, decimal, exponent, answer, equals, negative, radical;
    private static ActionListener oneListener, twoListener, threeListener, fourListener, fiveListener, sixListener, sevenListener, eightListener, nineListener, radListener, degListener, factListener, leftBrackListener, rightBrackListener, moduloListener, clearListener, piListener, sinInverseListener, cosInverseListener, tanInverseListener, sinListener, cosListener, tanListener, logListener, squareRootListener, divideListener, multiplyListener, addListener, subtractListener, zeroListener, decimalListener, exponentListener, answerListener, equalsListener, negativeListener, radicalListener;
    private JLabel label;
    private final JFrame frame;
    public GUI() { //creation of GUI //Kaven 01/14/23
        //Constructor for gui
        frame = new JFrame();


        //All of these are the creation of a push button //Kaven 01/14/2023
        deg = new JButton("deg");
        rad = new JButton("rad");
        fact = new JButton("!");
        leftBrack = new JButton("(");
        rightBrack = new JButton(")");
        zero = new JButton("0");
        decimal = new JButton(".");
        modulo = new JButton("!");
        divide = new JButton("/");
        pi = new JButton("π");
        exponent = new JButton("x^y");
        log = new JButton("log(");
        sinInverse = new JButton("sin^-1(");
        sin = new JButton("sin(");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        multiply = new JButton("x");
        squareRoot = new JButton("√");
        radical = new JButton("x√");
        negative = new JButton("(-)");
        cosInverse = new JButton("cos^-1(");
        cos = new JButton("cos(");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        subtract = new JButton("-");
        equals = new JButton("=");
        answer = new JButton("Ans");
        clear = new JButton("CE");
        tanInverse = new JButton("tan^-1(");
        tan = new JButton("tan(");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        add = new JButton("+");


        //constructors
        JPanel txtPanel = new JPanel(new BorderLayout());
        frame.setContentPane(txtPanel);
        txtCalc = new JTextField("0");
        txtCalc.setEditable(false);//makes the
        txtCalc.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panel = new JPanel(new GridLayout(4, 9));//creates a grd layout for our calculator buttons to be placed //Kaven 01/13/23

        //Adds all the buttons to the gui //Kaven 01/15/2023
        panel.add(txtCalc);
        panel.add(deg);
        panel.add(rad);
        panel.add(fact);
        panel.add(leftBrack);
        panel.add(rightBrack);
        panel.add(zero);
        panel.add(decimal);
        panel.add(modulo);
        panel.add(divide);
        panel.add(pi);
        panel.add(exponent);
        panel.add(log);
        panel.add(sinInverse);
        panel.add(sin);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(multiply);
        panel.add(squareRoot);
        panel.add(radical);
        panel.add(negative);
        panel.add(cosInverse);
        panel.add(cos);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(subtract);
        panel.add(equals);
        panel.add(answer);
        panel.add(clear);
        panel.add(tanInverse);
        panel.add(tan);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(add);

        txtPanel.add(txtCalc, BorderLayout.NORTH);
        txtPanel.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon("calc.png");
        frame.setIconImage(img.getImage());
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator by Kaven Muraleitharan");
        frame.pack();
        frame.setVisible(true);
    }

    static void changePreviousAnswer(String ans) {
        previousAnswer = ans;
    }

    private static void buttonListeners(ActionListener listenerName, JButton buttonName, String buttonFunction) { //This is a function that listens to each and every button pressed in the calculator //Kaven 1/14/2023
        listenerName = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equation == "SYNTAX ERROR")
                    equation = "";
                else if (buttonFunction == "CE")
                    equation = "";
                else if (buttonFunction == "=") {
                    Calculator calculator = new Calculator(equation, radMode, previousAnswer);
                    try {
                        equation = calculator.calculating(equation);
                    } catch (ScriptException ex) {
                        System.out.println("SYNTAX ERROR GUI");
                    }
                } else if (buttonFunction == "deg") {
                    equation = "DEG MODE ON";
                    radMode = false;
                } else if (buttonFunction == "rad") {
                    equation = "RAD MODE ON";
                    radMode = true;
                } else if (buttonFunction == "π") {
                    equation += 3.14159265;
                } else {
                    equation += buttonFunction;
                }
                txtCalc.setText(equation);
                System.out.println("User input:" + buttonFunction);
                System.out.println("Total Equation:" + equation);
            }
        };
        buttonName.addActionListener(listenerName);
    }

    public static void main(String[] args) {
        new GUI();
        //Listeners for each button.
        buttonListeners(oneListener, one, "1");
        buttonListeners(twoListener, two, "2");
        buttonListeners(threeListener, three, "3");
        buttonListeners(fourListener, four, "4");
        buttonListeners(fiveListener, five, "5");
        buttonListeners(sixListener, six, "6");
        buttonListeners(sevenListener, seven, "7");
        buttonListeners(eightListener, eight, "8");
        buttonListeners(nineListener, nine, "9");
        buttonListeners(radListener, rad, "rad");
        buttonListeners(degListener, deg, "deg");
        buttonListeners(factListener, fact, "!");
        buttonListeners(leftBrackListener, leftBrack, "(");
        buttonListeners(rightBrackListener, rightBrack, ")");
        buttonListeners(zeroListener, zero, "0");
        buttonListeners(decimalListener, decimal, ".");
        buttonListeners(moduloListener, modulo, "!");
        buttonListeners(divideListener, divide, "/");
        buttonListeners(piListener, pi, "π");
        buttonListeners(exponentListener, exponent, "^");
        buttonListeners(logListener, log, "log(");
        buttonListeners(sinInverseListener, sinInverse, "sin^-1(");
        buttonListeners(sinListener, sin, "sin(");
        buttonListeners(multiplyListener, multiply, "x");
        buttonListeners(squareRootListener, squareRoot, "^(1/2)");
        buttonListeners(radicalListener, radical, "^(1/");
        buttonListeners(negativeListener, negative, "-");
        buttonListeners(cosInverseListener, cosInverse, "cos^-1(");
        buttonListeners(cosListener, cos, "cos(");
        buttonListeners(subtractListener, subtract, "–");
        buttonListeners(equalsListener, equals, "=");
        buttonListeners(answerListener, answer, previousAnswer);
        buttonListeners(clearListener, clear, "CE");
        buttonListeners(tanInverseListener, tanInverse, "tan^-1(");
        buttonListeners(tanListener, tan, "tan(");
        buttonListeners(addListener, add, "+");
        String newEquation = equation;
    }
}