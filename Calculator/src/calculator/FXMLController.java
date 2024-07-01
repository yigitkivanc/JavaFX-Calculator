/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yigit
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void button9(ActionEvent event) {
        textField.setText(textField.getText() + "9");
    }

    @FXML
    private void button7(ActionEvent event) {
        textField.setText(textField.getText() + "7");
    }

    @FXML
    private void button8(ActionEvent event) {
        textField.setText(textField.getText() + "8");
    }

    @FXML
    private void button6(ActionEvent event) {
        textField.setText(textField.getText() + "6");
    }

    @FXML
    private void button5(ActionEvent event) {
        textField.setText(textField.getText() + "5");
    }

    @FXML
    private void button4(ActionEvent event) {
        textField.setText(textField.getText() + "4");
    }

    @FXML
    private void button3(ActionEvent event) {
        textField.setText(textField.getText() + "3");
    }

    @FXML
    private void button2(ActionEvent event) {
        textField.setText(textField.getText() + "2");
    }

    @FXML
    private void button1(ActionEvent event) {
        textField.setText(textField.getText() + "1");
    }

    @FXML
    private void button0(ActionEvent event) {
        textField.setText(textField.getText() + "0");
    }

    @FXML
    private void buttoncomma(ActionEvent event) {
        textField.setText(textField.getText() + ".");

    }

    @FXML
    private void buttonMinus(ActionEvent event) {
        textField.setText(textField.getText() + "-");
    }

    @FXML
    private void buttonMultiply(ActionEvent event) {
        textField.setText(textField.getText() + "x");
    }

    @FXML
    private void buttonDivide(ActionEvent event) {
        textField.setText(textField.getText() + "/");
    }

    @FXML
    private void buttonPlus(ActionEvent event) {
        textField.setText(textField.getText() + "+");
    }

    @FXML
    private void buttonCalculate(ActionEvent event) {

        Calculate calculate = new Calculate();
        ArrayList<Float> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        String[] characters = textField.getText().split("(?<=[-+x/^])|(?=[-+x/^])");

        for (int i = 0; i < characters.length; i++) {
            if (characters[0].equals("-") || characters[0].equals("+")) {
                if (i % 2 == 0) {
                    operators.add(characters[i]);
                } else {
                    numbers.add(Float.parseFloat(characters[i]));
                }
            } else {
                if (i % 2 == 0) {
                    numbers.add(Float.parseFloat(characters[i]));
                } else {
                    operators.add(characters[i]);
                }
            }
        }
        for (int i = 0; i < operators.size(); i++) {

            String operator = operators.get(i);
            Float number1 = numbers.get(i);
            Float number2 = numbers.get(i + 1);

            if (operator.equals("^")) {
                Float result = calculate.Calculating(number1, number2, operator);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }

        }

        for (int i = 0; i < operators.size(); i++) {

            String operator = operators.get(i);
            Float number1 = numbers.get(i);
            Float number2 = numbers.get(i + 1);

            if (operator.equals("x") || operator.equals("/")) {
                Float result = calculate.Calculating(number1, number2, operator);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }

        }
        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            Float number1 = numbers.get(i);
            Float number2 = numbers.get(i + 1);
            Float result = calculate.Calculating(number1, number2, operator);
            numbers.set(i, result);
            numbers.remove(i + 1);
            operators.remove(i);
            i--;

        }

        textField.setText(String.valueOf(numbers.get(0)));

    }

    @FXML
    private void buttonDelete(ActionEvent event) {
        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
    }

    @FXML
    private void buttonClear(ActionEvent event) {
        textField.setText("");
    }

    @FXML
    private void buttonExp(ActionEvent event) {
        textField.setText(textField.getText() + "^");
    }

    @FXML
    private void buttonSquareRoot(ActionEvent event) {
        Calculate calculate = new Calculate();
        float result = calculate.scientificCalculating(Float.parseFloat(textField.getText()), "√");
        textField.setText(String.valueOf(result));

    }

    @FXML
    private void buttonSin(ActionEvent event) {
    Calculate calculate = new Calculate();
    float angle = Float.parseFloat(textField.getText());
    float result = calculate.scientificCalculating(angle, "sin");

    float tolerance = (float) 1e-6;
    if (Math.abs(result) < tolerance) {
        result = 0.0f;
    } else {
        int decimalPlaces = 6;
        result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
    }

    textField.setText(String.valueOf(result));
}

    @FXML
    private void buttonCos(ActionEvent event) {
        Calculate calculate = new Calculate();
        float angle = Float.parseFloat(textField.getText());
        float result = calculate.scientificCalculating(angle, "cos");

        float tolerance = (float) 1e-6;
        if (Math.abs(result) < tolerance) {
            result = 0.0f;
        } else {

            int decimalPlaces = 6;
            result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
        }

        textField.setText(String.valueOf(result));
    }
@FXML
 private void buttonTan(ActionEvent event) {
    Calculate calculate = new Calculate();
    float angle = Float.parseFloat(textField.getText());
    float result = calculate.scientificCalculating(angle, "tan");

    float tolerance = (float) 1e-6;
    if (Math.abs(result) < tolerance) {
        result = 0.0f;
    } else {
        int decimalPlaces = 6;
        result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
    }

    textField.setText(String.valueOf(result));
}

@FXML
private void buttonCot(ActionEvent event) {
    Calculate calculate = new Calculate();
    float angle = Float.parseFloat(textField.getText());
    float result = calculate.scientificCalculating(angle, "cot");

    float tolerance = (float) 1e-6;
    if (Math.abs(result) < tolerance) {
        result = 0.0f;
    } else {
        int decimalPlaces = 6;
        result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
    }

    textField.setText(String.valueOf(result));
}

@FXML
private void buttonCosec(ActionEvent event) {
    Calculate calculate = new Calculate();
    float angle = Float.parseFloat(textField.getText());
    float result = calculate.scientificCalculating(angle, "cosec");

    float tolerance = (float) 1e-6;
    if (Math.abs(result) < tolerance) {
        result = 0.0f;
    } else {
        int decimalPlaces = 6;
        result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
    }

    textField.setText(String.valueOf(result));
}

@FXML
private void buttonSec(ActionEvent event) {
    Calculate calculate = new Calculate();
    float angle = Float.parseFloat(textField.getText());
    float result = calculate.scientificCalculating(angle, "sec");

    float tolerance = (float) 1e-6;
    if (Math.abs(result) < tolerance) {
        result = 0.0f;
    } else {
        int decimalPlaces = 6;
        result = Math.round(result * Math.pow(10, decimalPlaces)) / (float) Math.pow(10, decimalPlaces);
    }

    textField.setText(String.valueOf(result));
}

}
