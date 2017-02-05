package edu.jsu.mcis;

public class TicTacToeKeywords {
    
	public void startNewGame() 
        {  
           TicTacToeModel grid = new TicTacToeModel(); 
            if (Main.gameOver == false)
            {
               
                    grid.setNewBoard();
                    System.out.println(grid.getBoard());
                  
                }
            }
	
	 public static String getMark(int row, int col) 
         {
            String mark;
            TicTacToeModel grid = new TicTacToeModel();
            mark = grid.getMark(row,col);
            return mark;
         }
    
    public void setMark(int row, int col) {
            TicTacToeModel grid = new TicTacToeModel();
            grid.setMark(row,col);        
         }
    
	public String getWinner() 
        {
            TicTacToeModel grid = new TicTacToeModel();
            String val = "";
            
            for (int h= 0; h < 3; h++)
            {
                if (grid.board[h][0] == grid.board[h][1]&& grid.board[h][1] == grid.board[h][2])
                {
                    val = grid.board[h][0];
                    Main.gameOver = true;
                }
                else if (grid.board[0][h] == grid.board[1][h] && grid.board[1][h] == grid.board[2][h])
                {
                    val = grid.board[0][h];
                    Main.gameOver = true;
                }
                else
                {
                    
                }
                    for (int j =0; j <3; j++)
                    {
                        String mark= grid.board[h][j];
                        if (mark != "X" || mark != "O")
                        {
                            Main.gameOver=false;
                        }
                        else 
                        { 
                            val= "TIE";
                        }
                        
                        if ((grid.board[0][0] == grid.board[1][1] && grid.board[1][1] == grid.board[2][2]) || (grid.board[2][0] == grid.board[1][1] && grid.board[1][1] == grid.board[2][0]))
                        {
                            val = grid.board[0][0];
                            Main.gameOver = true;
                            
                        }
                    }
            }
              
            return val;
            }
         
            
	}


