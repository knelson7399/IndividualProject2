package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    
    TicTacToeKeywords keywords = new TicTacToeKeywords();
    TicTacToeModel grid = new TicTacToeModel();
    
    @Test
	public void testInitialBoardIsEmpty() 
        {
            grid.setNewBoard();
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    assertEquals(TicTacToeModel.board[i][j],"-");
                }
            }
        }
	
	@Test
	public void testMarkXInUpperRightCorner() 
        {
            Main.xTurn = true;
            keywords.setMark(0,2);
            String newMark = keywords.getMark(0,2);
            assertEquals(newMark, "X");
        }
	
	@Test
	public void testMarkOInBottomLeftCorner() 
        { 
           
            Main.xTurn = false;
            keywords.setMark(2,0);
            String newMark = keywords.getMark(0,2);
            assertEquals(newMark, "O");
            
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() 
        {
            TicTacToeKeywords grid = new TicTacToeKeywords();
            grid.setMark(2,0);
            String oldMark = grid.getMark(2,0);
            grid.setMark(2, 0);
            String newMark = grid.getMark(2,0);
            assertEquals(oldMark, newMark);
            
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() 
        {
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            keywords.startNewGame();
            keywords.setMark(0,0);
            assertEquals(Main.gameOver, false);
	}
	
        @Test
        public void testToStringWorksCorrectly() 
        {
            TicTacToeModel grid = new TicTacToeModel();
            boolean isString=true;
            
            String mark = grid.getMark(0, 0);
            
            if (mark instanceof String)
            {
                isString = true;
            }
            assertEquals(isString, true);
        }
    
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
            TicTacToeModel grid = new TicTacToeModel();
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            Main.xTurn = true;
            String winner;
            
            grid.setMark(0, 0);
            winner = keywords.getWinner();
            assertEquals(winner, "X");
            grid.setMark(0, 2);
            winner = keywords.getWinner();
            assertEquals(winner, "X");
            grid.setMark(1, 0);
            winner = keywords.getWinner();
            assertEquals(winner, "X");
            grid.setMark(0, 1);
            winner = keywords.getWinner();
            assertEquals(winner, "X");
            grid.setMark(2, 0);
            winner = keywords.getWinner();
            assertEquals(winner, "X");
            
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() 
        {
            Main.xTurn = true;
            TicTacToeModel grid = new TicTacToeModel();
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            String winner;
                        
            grid.setMark(0,0);//x
            winner = keywords.getWinner();
            grid.setMark(0,1);//o
            winner = keywords.getWinner();
            grid.setMark(2,0);//x
            winner = keywords.getWinner();
            grid.setMark(1,0);//o
            winner = keywords.getWinner();
            grid.setMark(1,1);//x
            winner = keywords.getWinner();
            grid.setMark(0,2);//o
            winner = keywords.getWinner();
            grid.setMark(2,1);//x
            winner = keywords.getWinner();
            grid.setMark(2,2);//o
            winner = keywords.getWinner();
            
            assertEquals(winner, "TIE");

	}
    
}
