package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {
    private String winningCode1 = "XXX";
    private String winningCode2 = "OOO";

    List<JButton> buttonList = new ArrayList<>();
    int counter;

    {
        counter = 0;

    }

    public Main() {
        setSize(600, 600);
        setTitle("Circle and Cross game");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.addActionListener(this);
            add(button);
            buttonList.add(button);

        }
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> new Main());

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        counter++;
        JButton button = (JButton) e.getSource(); // parsowanie na przycisk dlatego w nawiasie
        if (counter % 2 == 0) {
            button.setText("O");
        } else {
            button.setText("X");
        }
        button.setEnabled(false);
        String lane1 = buttonList.get(0).getText() + buttonList.get(1).getText() + buttonList.get(2).getText();
        String lane2 = buttonList.get(3).getText() + buttonList.get(4).getText() + buttonList.get(5).getText();
        String lane3 = buttonList.get(6).getText() + buttonList.get(7).getText() + buttonList.get(8).getText();
        String lane4 = buttonList.get(0).getText() + buttonList.get(3).getText() + buttonList.get(6).getText();
        String lane5 = buttonList.get(1).getText() + buttonList.get(4).getText() + buttonList.get(7).getText();
        String lane6 = buttonList.get(2).getText() + buttonList.get(5).getText() + buttonList.get(8).getText();
        String lane7 = buttonList.get(0).getText() + buttonList.get(4).getText() + buttonList.get(8).getText();
        String lane8 = buttonList.get(2).getText() + buttonList.get(4).getText() + buttonList.get(6).getText();

        List<String> charsCombinations = new ArrayList<>();
        charsCombinations.add((lane1));
        charsCombinations.add(lane2);
        charsCombinations.add(lane3);
        charsCombinations.add(lane4);
        charsCombinations.add(lane5);
        charsCombinations.add(lane6);
        charsCombinations.add(lane7);
        charsCombinations.add(lane8);
        boolean victory = false;
        for (String value :
                charsCombinations
        ) {
            if (value.equals(winningCode1)) {
                JOptionPane.showMessageDialog(null, "Player X win ! :)");
                dispose();
                victory = true;
            } else if (value.equals(winningCode2)) {
                JOptionPane.showMessageDialog(null, "Player O win :)");
                dispose();
                victory = true;
            }

        }
        if (victory == false && counter == 9) {
            JOptionPane.showMessageDialog(null, "Nobody won, press OK and play again");
            dispose();
        }

    }
}




