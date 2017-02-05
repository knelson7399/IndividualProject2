package edu.jsu.mcis;

import java.util.Arrays;

public class TicTacToeModel {
    
    public static String[][] board;

    public String getMark(int row, int col) {
       return board[row][col];
    }
    
    public void setMark(int row, int col)
    {
        String mark; 
        mark = getMark(row, col);
        
        while (mark=="-")
        {
            
            if (Main.xTurn)
            {
                mark ="X";
                mark = board[row][col];
            }
            else
            {
                mark = "O";
                mark = board[row][col];
            }
        }
        
        
        
    }
    
    public String getBoard()
    {
        String grid = Arrays.toString(board);
        return grid;
    }
    
    public void setNewBoard()
    {
        board = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               board[i][j] = "-";
            }
        }
    }
    
    
    public TicTacToeModel() {
        board = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
        }
       
    }
    
   
}






