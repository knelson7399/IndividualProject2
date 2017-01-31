package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author Kris Nelson
 */
public class ticTacToe extends JPanel
{
    //variables determining turns
    static boolean playerX = true;
    static boolean playerO = false;
    static boolean gameOver = false;
    
    
    //an array of buttons!
    static JButton[][] buttons;
    JLabel outputlabel;   
    //our label(now empty) centered
    
    String component;
    
    class ButtonListener2 implements ActionListener { //this is the actual game logic
        private final JButton myButton;
        ticTacToe main = new ticTacToe();
        TicTacToeKeywords keywords = new TicTacToeKeywords();
        
        public ButtonListener2(JButton button) {
            TicTacToeKeywords keywords = new TicTacToeKeywords();
            myButton = button;
            component = button.getName();
            keywords.getRowAndCol(component);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            if (main.playerX == true)
            {
                
                if (myButton.getText().equals(""))
                {
                        myButton.setText("X");
                        main.outputlabel.setText("O's Turn");
                        main.playerX = false;
                        main.playerO = true; 
                }
                else
                {
                    main.outputlabel.setText("That's already taken!");
                }
                
            }
            
            else if (main.playerO == true)
            {
                if (myButton.getText().equals(""))
                {
                        myButton.setText("O");
                        main.outputlabel.setText("X's Turn");
                        main.playerX = true;
                        main.playerO = false; 
                        main.gameOver = false;
                }
                else
                {
                    main.outputlabel.setText("That's already taken!");
                }
            }
            
            if ( keywords.getWin().equals("X") ) {
                main.outputlabel.setText("X Wins!");
                main.gameOver= true;
            }
            else if ( keywords.getWin().equals("O") ) {
                main.outputlabel.setText("O Wins!");
                main.gameOver = true;
            }
            
            else if (keywords.getTie()=="Tie" && keywords.getWin().equals(""))
            {
               main.outputlabel.setText("Tis a draw!");
               main.gameOver = true;
            }
            
        }
    }    

    public ticTacToe ()//Round one, fight
    {
        //how to lay out the actual buttons
        setLayout(new GridLayout(3 /* rows */, 3 /* cols */));
        TicTacToeModel grid = new TicTacToeModel();
        outputlabel = new JLabel("", SwingConstants.CENTER);
        
        //text for our dynamic label
        outputlabel.setText("Game Start!!");
        outputlabel.setPreferredSize(new Dimension(300, 25));
        buttons =  new JButton[3][3];
        
        for (int i = 0; i < 3; ++i) {
    
            for (int j = 0; j < 3; ++j) {
                //creating buttons to be used for our game as well as listeners then adding them to our panel
                
                buttons[i][j] = new JButton();
                buttons[i][j].setName("Location"+i+j);
                buttons[i][j].addActionListener((ActionListener) this);
                add(buttons[i][j]);

            }
    
        }        
        //how big is our window? dis big
        setPreferredSize(new Dimension(300, 300));
    }
    
    public static void main(String[] args) {
        //to name our window
        JFrame frame = new JFrame("Tic-Tac-WHOA");
        //how do we close? By pressing x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //this one I had to look up so I could work with the label and the buttons
        Container pane = frame.getContentPane();
        //this one is our panel
        ticTacToe panel = new ticTacToe();
        
        //this is for the label, where it goes 
        pane.add(panel.getOutputLabel(), BorderLayout.PAGE_START);
        //this is for the buttons
        pane.add(panel, BorderLayout.PAGE_END);
        
        //gotta take up as much room as we can
        frame.pack();
        //need to see it
        frame.setVisible(true);
        
    }

    
    public JLabel getOutputLabel() {
        
        //need to get my hands on that label so I can change it
        return outputlabel;
        
    }
    
}