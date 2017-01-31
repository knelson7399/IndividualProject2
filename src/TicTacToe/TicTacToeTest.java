package TicTacToe;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    
            TicTacToeModel grid = new TicTacToeModel();
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            ticTacToe main = new ticTacToe();
            
    
    @Test
	public void testInitialBoardIsEmpty() 
        {
            TicTacToeModel grid = new TicTacToeModel();
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            grid.setNewBoard();
            int taken=0; 
            
            for (int i = 0;i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    if (grid.getMark(i,j) != "")
                    {
                        taken++;
                    }
                }
            }
            assertEquals(taken, 0);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() 
        {
            keywords.setMark(0,2);
            main.playerX = true;
            assertEquals(keywords.getMark(0,2),"X");
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() 
        {
            keywords.setMark(2,0);
            main.playerO = false;
            assertEquals(keywords.getMark(0,2),"O");
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() 
        {
            keywords.setMark(2,0);
            keywords.setMark(2,0);
            
            assertEquals(main.outputlabel, "That's already taken!");
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
            grid.setNewBoard();
            main.playerX = true;
            grid.setMark(0,0);
            assertEquals(main.gameOver,true);
	}
        
        @Test
        public void testGameIsWonByOHorizontallyAcrossTopRow() {
            main.playerX = true;
            String Mark;
            String winner;
            String tie;
            
            grid.setMark(1,1);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(0,1);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(0,0);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(0,2);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(2,2);
            winner =keywords.getWin();
            tie = keywords.getTie();
                        
            assertEquals(winner, "O");
            assertEquals(tie, "");
            
        }
        
	@Test
	public void testGameIsWonByXDiagonallyAcrossTopRow() {
            grid.setNewBoard();
            main.playerX = true;
            String winner;
            String tie;
            String val;
            grid.setMark(0, 0);
            winner =keywords.getWin();
            tie = keywords.getTie();
            keywords.getTie();
            grid.setMark(1,0);
            tie = keywords.getTie();
            winner = keywords.getWin();
            grid.setMark(0,1);
            tie = keywords.getTie();
            winner = keywords.getWin();
            grid.setMark(2,0);
            tie = keywords.getTie();
            winner = keywords.getWin();
            grid.setMark(0,2);
            tie = keywords.getTie();
            winner = keywords.getWin();
            
            assertEquals(winner, "X" );
            assertEquals(tie, "");
            
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
            main.playerX = true;
            String winner;
            String tie;
            String val;
            
            grid.setMark(0,0);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(1,0);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(2,0);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(2,1);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(0,1);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(0,2);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(1,1);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(2,2);
            winner =keywords.getWin();
            tie = keywords.getTie();
            grid.setMark(1,2);
            winner =keywords.getWin();
            tie = keywords.getTie();
            
            assertEquals(tie,"Tie");
            assertEquals(winner, "");
            
	}
    
}
