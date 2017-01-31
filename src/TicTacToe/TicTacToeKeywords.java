package TicTacToe;

import static TicTacToe.ticTacToe.buttons;

public class TicTacToeKeywords {
    
	public void startNewGame() 
        {  
            TicTacToeModel grid = new TicTacToeModel();
            grid.setNewBoard();
        }
	
	 public static String getMark(int row, int col) 
         {
             TicTacToeModel grid = new TicTacToeModel();
             String mark = grid.getMark(row, col);
             return mark;
         }
         
         public int[] getRowAndCol(String name)
         {
             int row;
             int col;
             int[] coordinates=  new int[2];
             
             row = Integer.parseInt(name.substring(8));
             col = Integer.parseInt(name.substring(9));
             coordinates[0] = row;
             coordinates[1] = col;
             
             return coordinates;
          }
    
    public static void setMark(int row, int col) {
            TicTacToeModel grid = new TicTacToeModel();
            grid.setMark(row,col);        
         }
    
	private static String checkWin() //guess what this does
    {
        int matching = 0;
        String symbol;
        
        // Checking our verticals
        
        for (int c = 0; c < 3; c++)
        {
            symbol = buttons[0][c].getText();
            matching = 0; 
            for (int r = 0; r < 3; r++)
            {
                if (buttons[r][c].getText().equals(symbol))
                    matching++;
            }
            
            if (matching == 3)
            {
                return symbol;
            }
            
        }

        // Checking our horizontals
        
        for (int r = 0; r < 3; r++)
        {
            symbol = buttons[r][0].getText();
            matching = 0; 
            for (int c = 0; c < 3; c++)
            {
                if (buttons[r][c].getText().equals(symbol))
                    matching++;
            }
            
            if (matching == 3)
            {
                return symbol;
            }
        }
        
        //Checking diagonally left to right!
        
        symbol = buttons[0][0].getText();
        matching = 0;
        
        for (int r = 0; r < 3; r++)
        {
            
            if (buttons[r][r].getText().equals(symbol))
                matching++;
            
        }
            
        if (matching == 3)
        {
            return symbol;
        }
        
        //The problem child
        // Checking diagonally right to left
             
        symbol = buttons[0][2].getText();
        matching = 0; 

        for (int r = 0; r < 3; r++)
        {


            if (buttons[r][2-r].getText().equals(symbol))
                matching++;


        }
        
        //Do we win?
        if (matching == 3)
        {
            return symbol;
        }
        
        // No win
        
        return "";
    }
    private static String checkSquares()// checking for a draw
    {
        String val =""; 
        for (int r = 0; r < 3; r++)
            {
                
                for (int c = 2; c >= 0; c--)
                {
                    if (!(buttons[r][c].getText().equals("")))
                    {
                        val = "";
                    }
                    else 
                    {
                        val = "Tie";
                    }
                }
                
            }
        
        return val;   
    }
    
    public static String getTie()
    {
        String val; 
        val = checkSquares();
        return val;
    }
    public static String getWin()
        {
                String symbol;
                symbol = checkWin();
                return symbol;
        }     
 }




