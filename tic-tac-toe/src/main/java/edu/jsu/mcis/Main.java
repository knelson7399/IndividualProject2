package edu.jsu.mcis;

import java.awt.Point;
import java.util.Scanner;

public class Main {
    public static final Scanner response = new Scanner(System.in);
    static boolean xTurn = true;
    public static boolean gameOver = false;

    
    private static void viewModel(TicTacToeModel model) 
    {
        TicTacToeModel grid = new TicTacToeModel();
        grid.getBoard();
    }

	public static void main(String[] args) 
        {
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            System.out.println("Welcome to console Tic-Tac-Toe! Would you like to start a new game?");
            String userInput = response.toString();
            if (userInput == "Y")
            {    
            keywords.startNewGame();
            String coordinate;
            int point[] = null;
            String val = null;
            
                while (gameOver== false)
                {
                   System.out.println("Would you like to place a mark or quit?/n M for Mark Q for Quit./n");
                   String command = response.next();
                   if (command == "M")
                    {
                    System.out.println("Enter the coordinates in X,Y format.");
                    coordinate = response.toString();
                    point[0] = Integer.parseInt(coordinate.substring(0));
                    point[0]--;
                    point[1] = Integer.parseInt(coordinate.substring(2));
                    point[1]--;

                    keywords.setMark(point[0],point[1]);
                    val = keywords.getWinner();
                         if (val=="X" || val== "O"){
                              System.out.println(val + " is the winner! Way to go!\nPlay again? Y/N\n");
                              userInput = response.toString();
                              gameOver = false;
                         }
                         else {
                             gameOver = true;
                             System.out.println("Alright, see ya!");
                         }

                    }
                }
            
            
        }
        
    }
}














