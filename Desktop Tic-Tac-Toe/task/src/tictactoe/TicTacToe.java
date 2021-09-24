package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TicTacToe extends JFrame {

    public static boolean turn = true;
    public static JLabel labelStatus;
    public static JButton buttonA3;
    public static JButton buttonA2;
    public static JButton buttonA1;
    public static JButton buttonB3;
    public static JButton buttonB2;
    public static JButton buttonB1;
    public static JButton buttonC3;
    public static JButton buttonC2;
    public static JButton buttonC1;

    public TicTacToe() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Tic Tac Toe");

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 3);
        grid.setLayout(layout);

        buttonA3 = new JButton(" ");
        buttonA3.setName("ButtonA3");
        buttonA3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA3.setFocusPainted(false);
        grid.add(buttonA3);
        buttonA3.addActionListener(e -> {
           makeTurn(buttonA3);
        });

        buttonB3 = new JButton(" ");
        buttonB3.setName("ButtonB3");
        buttonB3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB3.setFocusPainted(false);
        grid.add(buttonB3);
        buttonB3.addActionListener(e -> {
            makeTurn(buttonB3);
        });

        buttonC3 = new JButton(" ");
        buttonC3.setName("ButtonC3");
        buttonC3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC3.setFocusPainted(false);
        grid.add(buttonC3);
        buttonC3.addActionListener(e -> {
            makeTurn(buttonC3);
        });

        buttonA2 = new JButton(" ");
        buttonA2.setName("ButtonA2");
        buttonA2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA2.setFocusPainted(false);
        grid.add(buttonA2);
        buttonA2.addActionListener(e -> {
            makeTurn(buttonA2);
        });

        buttonB2 = new JButton(" ");
        buttonB2.setName("ButtonB2");
        buttonB2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB2.setFocusPainted(false);
        grid.add(buttonB2);
        buttonB2.addActionListener(e -> {
            makeTurn(buttonB2);
        });

        buttonC2 = new JButton(" ");
        buttonC2.setName("ButtonC2");
        buttonC2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC2.setFocusPainted(false);
        grid.add(buttonC2);
        buttonC2.addActionListener(e -> {
            makeTurn(buttonC2);
        });

        buttonA1 = new JButton(" ");
        buttonA1.setName("ButtonA1");
        buttonA1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA1.setFocusPainted(false);
        grid.add(buttonA1);
        buttonA1.addActionListener(e -> {
            makeTurn(buttonA1);
        });

        buttonB1 = new JButton(" ");
        buttonB1.setName("ButtonB1");
        buttonB1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB1.setFocusPainted(false);
        grid.add(buttonB1);
        buttonB1.addActionListener(e -> {
            makeTurn(buttonB1);
        });

        buttonC1 = new JButton(" ");
        buttonC1.setName("ButtonC1");
        buttonC1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC1.setFocusPainted(false);
        grid.add(buttonC1);
        buttonC1.addActionListener(e -> {
            makeTurn(buttonC1);
        });

        add(grid);

        JPanel infoPanel = new JPanel();

        labelStatus = new JLabel("Game is not started");
        labelStatus.setName("LabelStatus");
        infoPanel.add(labelStatus);

        JButton buttonReset  = new JButton("Reset");
        buttonReset.setName("ButtonReset");
        infoPanel.add(buttonReset);
        buttonReset.addActionListener(e -> {
            resetGame();
        });

        add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);


    }

    public static void makeTurn(JButton button) {

        if (turn && !button.getText().matches("X|O")) {
            button.setText("X");
            turn = !turn;
            checkResult();
        } else if (!turn && !button.getText().matches("X|O")){
            button.setText("O");
            turn = !turn;
            checkResult();
        }



    }

    public static void checkResult() {
        
        String[][] grid =

                {
                        {buttonA3.getText(), buttonB3.getText(), buttonC3.getText()},
                        {buttonA2.getText(), buttonB2.getText(), buttonC2.getText()},
                        {buttonA1.getText(), buttonB1.getText(), buttonC1.getText()},
                };

        boolean xWins =

                        ("X".equals(grid[0][0]) && "X".equals(grid[0][1]) && "X".equals(grid[0][2])) ||
                        ("X".equals(grid[1][0]) && "X".equals(grid[1][1]) && "X".equals(grid[1][2])) ||
                        ("X".equals(grid[2][0]) && "X".equals(grid[2][1]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][0]) && "X".equals(grid[2][0])) ||
                        ("X".equals(grid[0][1]) && "X".equals(grid[1][1]) && "X".equals(grid[2][1])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][2]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][1]) && "X".equals(grid[2][2])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][1]) && "X".equals(grid[2][0]));


        boolean oWins =

                        ("O".equals(grid[0][0]) && "O".equals(grid[0][1]) && "O".equals(grid[0][2])) ||
                        ("O".equals(grid[1][0]) && "O".equals(grid[1][1]) && "O".equals(grid[1][2])) ||
                        ("O".equals(grid[2][0]) && "O".equals(grid[2][1]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][0]) && "O".equals(grid[2][0])) ||
                        ("O".equals(grid[0][1]) && "O".equals(grid[1][1]) && "O".equals(grid[2][1])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][2]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][1]) && "O".equals(grid[2][2])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][1]) && "O".equals(grid[2][0]));

        boolean draw = !xWins && !oWins && Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(e -> e.equals(" "));

        if (xWins) {
            labelStatus.setText("X wins");
            freezeGrid();
            return;
        }

        if (oWins) {
            labelStatus.setText("O wins");
            freezeGrid();
            return;
        }

        if (draw) {
            labelStatus.setText("Draw");
            freezeGrid();
            return;
        }

        labelStatus.setText("Game in progress");

    }

    public static void resetGame() {
        buttonA1.setText(" ");
        buttonA2.setText(" ");
        buttonA3.setText(" ");
        buttonB1.setText(" ");
        buttonB2.setText(" ");
        buttonB3.setText(" ");
        buttonC1.setText(" ");
        buttonC2.setText(" ");
        buttonC3.setText(" ");

        labelStatus.setText("Game is not started");
        turn = true;
        unfreezeGrid();
    }

    public static void freezeGrid() {
        buttonA1.setEnabled(false);
        buttonA2.setEnabled(false);
        buttonA3.setEnabled(false);
        buttonB1.setEnabled(false);
        buttonB2.setEnabled(false);
        buttonB3.setEnabled(false);
        buttonC1.setEnabled(false);
        buttonC2.setEnabled(false);
        buttonC3.setEnabled(false);
    }

    public static void unfreezeGrid() {
        buttonA1.setEnabled(true);
        buttonA2.setEnabled(true);
        buttonA3.setEnabled(true);
        buttonB1.setEnabled(true);
        buttonB2.setEnabled(true);
        buttonB3.setEnabled(true);
        buttonC1.setEnabled(true);
        buttonC2.setEnabled(true);
        buttonC3.setEnabled(true);
    }
}