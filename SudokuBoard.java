import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import javax.swing.JTextField; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.awt.Color;

public class SudokuBoard implements ActionListener {
    JFrame frame=new JFrame(); //creates frame
    JTextField[][] grid; //names the grid of buttons

    Grid game = new Grid();
    int width = 9;
    int length = 9;
    JButton button = new JButton();

    public SudokuBoard() {
        BorderLayout lay = new BorderLayout();
        frame.setLayout(lay);

        Container gridFrame = new Container();
        GridLayout gridLayout = new GridLayout(width, length);
        gridFrame.setLayout(gridLayout);
        frame.add(gridFrame, BorderLayout.WEST);

        frame.add(button, BorderLayout.EAST);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);

        grid = new JTextField[width][length]; //allocate the size of grid
        for (int y=0; y<length; y++){
            for (int x=0; x<width; x++){
                int val = game.getCellAtCoords(x, y).getValue();
                String text = val == 0 ? "" : "" + val;
                grid[x][y]=new JTextField(text); //creates new button
                gridFrame.add(grid[x][y]); //a  dds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }

    public void actionPerformed(ActionEvent e) {

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row ++) {
                System.out.println("text: " + grid[row][col].getText());
                if (!grid[row][col].getText().equals("")) {
                    game.getCellAtCoords(row, col).setValue(Integer.parseInt(grid[row][col].getText()));
                } else {
                    game.getCellAtCoords(row, col).setValue(0);
                }
            }
        }

        if (game.checkBoard()) {
            System.out.println("All good so far.");
        } else {
            System.out.println("Something is wrong.");
        }
    }

    public static void main(String[] args) {
        new SudokuBoard();//makes new ButtonGrid with 2 parameters
    }
}
