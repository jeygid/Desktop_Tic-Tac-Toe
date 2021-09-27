package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe extends JFrame {

    public static boolean game = false;
    public static String sign = "X";
    public static int currentPlayerNum = 1;
    public static boolean humanTurn;

    public static JButton buttonPlayer1;
    public static JButton buttonStartReset;
    public static JButton buttonPlayer2;
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

        JPanel topPanel = new JPanel();

        GridLayout topPanelLayout = new GridLayout(1, 3);
        topPanel.setLayout(topPanelLayout);

        buttonPlayer1 = new JButton("Human");
        buttonPlayer1.setName("ButtonPlayer1");
        topPanel.add(buttonPlayer1);
        buttonPlayer1.addActionListener(e -> {
            if (buttonPlayer1.getText().equals("Human")) {
                buttonPlayer1.setText("Robot");
            } else if (buttonPlayer1.getText().equals("Robot")) {
                buttonPlayer1.setText("Human");
            }
        });

        buttonStartReset = new JButton("Start");
        buttonStartReset.setName("ButtonStartReset");
        topPanel.add(buttonStartReset);
        buttonStartReset.addActionListener(e -> {

            if (buttonStartReset.getText().equals("Start")) {

                gameStart();

            } else {

                resetGame();

            }
        });

        buttonPlayer2 = new JButton("Human");
        buttonPlayer2.setName("ButtonPlayer2");
        topPanel.add(buttonPlayer2);
        buttonPlayer2.addActionListener(e -> {
            if (buttonPlayer2.getText().equals("Human")) {
                buttonPlayer2.setText("Robot");
            } else if (buttonPlayer2.getText().equals("Robot")) {
                buttonPlayer2.setText("Human");
            }
        });

        add(topPanel);
        add(topPanel, BorderLayout.NORTH);

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 3);
        grid.setLayout(layout);

        buttonA3 = new JButton(" ");
        buttonA3.setName("ButtonA3");
        buttonA3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA3.setFocusPainted(false);
        grid.add(buttonA3);
        buttonA3.addActionListener(e -> {
            makeHumanTurn(buttonA3);
        });

        buttonB3 = new JButton(" ");
        buttonB3.setName("ButtonB3");
        buttonB3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB3.setFocusPainted(false);
        grid.add(buttonB3);
        buttonB3.addActionListener(e -> {
            makeHumanTurn(buttonB3);
        });

        buttonC3 = new JButton(" ");
        buttonC3.setName("ButtonC3");
        buttonC3.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC3.setFocusPainted(false);
        grid.add(buttonC3);
        buttonC3.addActionListener(e -> {
            makeHumanTurn(buttonC3);
        });

        buttonA2 = new JButton(" ");
        buttonA2.setName("ButtonA2");
        buttonA2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA2.setFocusPainted(false);
        grid.add(buttonA2);
        buttonA2.addActionListener(e -> {
            makeHumanTurn(buttonA2);
        });

        buttonB2 = new JButton(" ");
        buttonB2.setName("ButtonB2");
        buttonB2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB2.setFocusPainted(false);
        grid.add(buttonB2);
        buttonB2.addActionListener(e -> {
            makeHumanTurn(buttonB2);
        });

        buttonC2 = new JButton(" ");
        buttonC2.setName("ButtonC2");
        buttonC2.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC2.setFocusPainted(false);
        grid.add(buttonC2);
        buttonC2.addActionListener(e -> {
            makeHumanTurn(buttonC2);
        });

        buttonA1 = new JButton(" ");
        buttonA1.setName("ButtonA1");
        buttonA1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonA1.setFocusPainted(false);
        grid.add(buttonA1);
        buttonA1.addActionListener(e -> {
            makeHumanTurn(buttonA1);
        });

        buttonB1 = new JButton(" ");
        buttonB1.setName("ButtonB1");
        buttonB1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonB1.setFocusPainted(false);
        grid.add(buttonB1);
        buttonB1.addActionListener(e -> {
            makeHumanTurn(buttonB1);
        });

        buttonC1 = new JButton(" ");
        buttonC1.setName("ButtonC1");
        buttonC1.setFont(new Font("Arial", Font.BOLD, 60));
        buttonC1.setFocusPainted(false);
        grid.add(buttonC1);
        buttonC1.addActionListener(e -> {
            makeHumanTurn(buttonC1);
        });

        add(grid);

        JPanel infoPanel = new JPanel();

        labelStatus = new JLabel("Game is not started");
        labelStatus.setName("LabelStatus");
        infoPanel.add(labelStatus);

        add(infoPanel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        menuGame.setName("MenuGame");

        JMenuItem menuHumanHuman = new JMenuItem("Set Human vs Human");
        menuHumanHuman.setName("MenuHumanHuman");
        JMenuItem menuHumanRobot = new JMenuItem("Set Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");
        JMenuItem menuRobotHuman = new JMenuItem("Set Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");
        JMenuItem menuRobotRobot = new JMenuItem("Set Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setName("MenuExit");

        menuHumanHuman.addActionListener(e -> {
            buttonPlayer1.setText("Human");
            buttonPlayer2.setText("Human");
            gameStart();
        });
        menuHumanRobot.addActionListener(e -> {
            buttonPlayer1.setText("Human");
            buttonPlayer2.setText("Robot");
            gameStart();
        });
        menuRobotHuman.addActionListener(e -> {
            buttonPlayer1.setText("Robot");
            buttonPlayer2.setText("Human");
            gameStart();
        });
        menuRobotRobot.addActionListener(e -> {
            buttonPlayer1.setText("Robot");
            buttonPlayer2.setText("Robot");
            gameStart();
        });
        menuExit.addActionListener(e -> dispose());

        menuGame.add(menuHumanHuman);
        menuGame.add(menuHumanRobot);
        menuGame.add(menuRobotHuman);
        menuGame.add(menuRobotRobot);
        menuGame.addSeparator();
        menuGame.add(menuExit);

        menuBar.add(menuGame);
        setJMenuBar(menuBar);

        freezeGrid();
        setVisible(true);

    }

    public static void makeHumanTurn(JButton button) {

        if (!button.getText().equals(" ")) return;

        if (!game) return;

        if (sign.equals("X") && !button.getText().matches("X|O")) {
            button.setText("X");
        } else if (sign.equals("O") && !button.getText().matches("X|O")) {
            button.setText("O");
        }

        checkResult();
        if (!game) {
            if (!labelStatus.getText().equals("Draw")) labelStatus.setText("The Human Player (" + sign + ") wins");
            return;
        }


        if (sign.equals("X")) {
            sign = "O";
        } else if (sign.equals("O")) {
            sign = "X";
        }


        if (currentPlayerNum == 1) {
            currentPlayerNum = 2;
        } else {
            currentPlayerNum = 1;
        }

        if (buttonPlayer1.getText().equals("Robot") || buttonPlayer2.getText().equals("Robot")) {
            labelStatus.setText("The turn of Robot Player (" + sign + ")");
            robotTurn();
        }

        if (!game) {

            if (!labelStatus.getText().equals("Draw")) labelStatus.setText("The Robot Player (" + sign + ") wins");
            return;

        }

        labelStatus.setText("The turn of Human Player (" + sign + ")");
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
            game = false;
            freezeGrid();
            return;
        }

        if (oWins) {
            game = false;
            freezeGrid();
            return;
        }

        if (draw) {
            labelStatus.setText("Draw");
            game = false;
            freezeGrid();
            return;
        }


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
        sign = "X";
        buttonStartReset.setText("Start");
        buttonPlayer1.setEnabled(true);
        buttonPlayer2.setEnabled(true);

        game = false;
        humanTurn = false;
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

    public static void robotTurn() {

        String[][] grid = {
                {buttonA3.getText(), buttonB3.getText(), buttonC3.getText()},
                {buttonA2.getText(), buttonB2.getText(), buttonC2.getText()},
                {buttonA1.getText(), buttonB1.getText(), buttonC1.getText()},
        };

        ArrayList<JButton> list = new ArrayList<>() {{
            if (buttonA3.getText().equals(" ")) add(buttonA3);
            if (buttonA2.getText().equals(" ")) add(buttonA2);
            if (buttonA1.getText().equals(" ")) add(buttonA1);
            if (buttonB3.getText().equals(" ")) add(buttonB3);
            if (buttonB2.getText().equals(" ")) add(buttonB2);
            if (buttonB1.getText().equals(" ")) add(buttonB1);
            if (buttonC3.getText().equals(" ")) add(buttonC3);
            if (buttonC2.getText().equals(" ")) add(buttonC2);
            if (buttonC1.getText().equals(" ")) add(buttonC1);
        }};


        Random rand = new Random();
        list.get(rand.nextInt(list.size())).setText(sign);

        checkResult();
        if (!game) return;

        if (sign.equals("X")) {
            sign = "O";
        } else if (sign.equals("O")) {
            sign = "X";
        }


    }

    public static void gameStart() {

        resetGame();

        buttonStartReset.setText("Reset");
        game = !game;
        buttonPlayer1.setEnabled(false);
        buttonPlayer2.setEnabled(false);

        currentPlayerNum = 1;
        unfreezeGrid();

        if (buttonPlayer1.getText().equals("Robot") && buttonPlayer2.getText().equals("Robot")) {
            while (game) {
                labelStatus.setText("The turn of Robot Player (" + sign + ")");
                robotTurn();
            }
            labelStatus.setText("The Robot Player (" + sign + ") wins");
            return;
        }

        if (buttonPlayer1.getText().equals("Robot")) {
            labelStatus.setText("The turn of Robot Player (" + sign + ")");
            robotTurn();
            currentPlayerNum = 2;
            labelStatus.setText("The turn of Human Player (" + sign + ")");
            return;
        }

        if (buttonPlayer1.getText().equals("Human")) {
            labelStatus.setText("The turn of Human Player (" + sign + ")");
        }

    }


}