package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeModel {
    

    static JButton[][] buttons = new JButton[3][3];
    
    ticTacToe main = new ticTacToe();
    TicTacToeKeywords keywords = new TicTacToeKeywords();

    public String getMark(int row, int col) {
        String mark = buttons[row][col].getText();       
        return mark;
    }
    
    public void setMark(int row, int col)
    {
        String mark;
        int[] nums = new int[2];
        String name = main.component;
            if (row > 2 && col > 2)
            {
                nums = keywords.getRowAndCol(name);
                row = nums[0];
                col = nums[1];
            }
        mark = getMark(row, col);
        
        if (mark.equals(""))
        {
            ticTacToe main = new ticTacToe();
            if (main.playerX=true)
            {
                buttons[row][col].setText("X");
            }
            else if (main.playerO = true)
            {
                buttons[row][col].setText("O");
            }
        }
        
    }
    
    
    public void setNewBoard()
    {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               buttons[i][j].setText("");
            }
        }
    }
    
    

}
     
       
    
    
   







