/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Yigit
 */
public class Calculate {

    public float Calculating(float number1, float number2, String operatorr) {

        switch (operatorr) {
            case "+":
                return number1 + number2;
            case "x":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "-":
                return number1 - number2;
            case "^":
                return (float) Math.pow(number1, number2);
        }
        return 0;

    }

    public float scientificCalculating(float number, String operatorr) {
        switch (operatorr) {
            case "sin":
                return (float) Math.sin(Math.toRadians(number));
            case "cos":
                return (float) Math.cos(Math.toRadians(number));
            case "tan":
                return (float) Math.tan(Math.toRadians(number));
            case "cot":
                return (float) (1 / Math.tan(Math.toRadians(number)));
            case "cosec":
                return (float) (1 / Math.sin(Math.toRadians(number)));
            case "sec":
                return (float) (1 / Math.cos(Math.toRadians(number)));
            case "√":
                return (float) (Math.sqrt(number));
        }
        return 0;
    }

}
