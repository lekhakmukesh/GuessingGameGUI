import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Text field for the users guess
    private JTextField txtGuess;
    // Label to show the high/low message to the user
    private JLabel lblOutput;
    // Creating a variable to store the random number
    private int theNumber;

    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(108, 11, 212, 14);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblNewLabel);

        JLabel lblGuessTheNumber = new JLabel("Guess the number between 1 - 100");
        lblGuessTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblGuessTheNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGuessTheNumber.setBounds(0, 71, 221, 14);
        getContentPane().add(lblGuessTheNumber);

        txtGuess = new JTextField();
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(234, 68, 86, 20);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        JButton btnGuess = new JButton("Click to Guess");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                checkGuess();

            }
        });
        btnGuess.setBounds(134, 138, 122, 23);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Enter the number above and click to guess");
        lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(10, 195, 414, 36);
        getContentPane().add(lblOutput);
    }

    // main method of the program
    public static void main (String[] args) {

        // creating the object of the Guessing game class to execute all the method on the class
        GuessingGame guessingGame = new GuessingGame();
        // calling newGame method to start the game
        guessingGame.newGame();
        // setting the size of the Displayed window
        guessingGame.setSize(new Dimension(500, 500));
        // setting the frame visible
        guessingGame.setVisible(true);
    }

    //Method to check the Too High or Too Low Guessed Number
    public void checkGuess() {
        // To get the users entered number
        String guessText = txtGuess.getText();
        // To send the message to user after user enters the number
        String message = "";

        // using Try Catch Finally to handle the possible exception in the program
        try {
            // Converting the Users guessed number from String to integer
            int guess = Integer.parseInt(guessText);

            // Checking if the number user guessed is correct or not
            if(guess > theNumber) {
                // if the entered number is higher then the program shows this message
                message = guess + " was too high!!! Please try again";
                lblOutput.setText(message);
            }
            else if(guess < theNumber) {
                // if the entered number is lower then the program shows this message
                message = guess + " was too low!!! Please try again";
                lblOutput.setText(message);
            }
            else {
                // if the entered number is correct then the program congratulate the user
                message = guess + " was right!!! Congratulation You Win !!!!";
                lblOutput.setText(message);
                // calling newGame() method to restart the game again to make the game continuously
                newGame();
            }
        }
        catch(Exception e ) {
            lblOutput.setText("The entered number is not valid. Please enter whole number");
        }
        finally {
            // put the cursor on the Text Box to so that user does not have to use mouse to put cursor there
            txtGuess.requestFocus();
            // selects the text in the text box
            txtGuess.selectAll();
        }

    }

    // method to create random number from 1-100 using Math.random
    public void newGame() {
        theNumber = (int)(Math.random()* 100 + 1);
    }
}
