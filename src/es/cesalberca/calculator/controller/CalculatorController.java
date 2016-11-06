package es.cesalberca.calculator.controller;

import es.cesalberca.calculator.model.CalculatorModel;
import es.cesalberca.calculator.observer.Observer;
import es.cesalberca.calculator.view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cesar
 */
public class CalculatorController implements Observer {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController (CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculationListener(new CalculateListener());
        this.view.addOperationListener(new OperationListener());
        this.model.registerObserver(this);
    }

    private class CalculateListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            int numberUserPressed = Integer.parseInt(((JButton)e.getSource()).getText());
            model.addToNumbers(numberUserPressed);
        }
    }

    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operationPressed = ((JButton)e.getSource()).getText();

            switch (operationPressed) {
                case "+":
                    break;
                case "-":
                    break;
                case "x":
                    break;
                case "/":
                    break;
                case "=":
                    break;
            }
        }
    }

    @Override
    public void update() {
        view.setNumber(model.getNumber());
    }
}
