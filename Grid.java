import java.util.ArrayList;
public class Grid
{
    private ArrayList<ArrayList<Square>> basic = new ArrayList<ArrayList<Square>>();
    public Grid(){
        int[] r0c0 = {0,0,6,0,1,8,5,0,0};
        basic.add(0, new ArrayList<Square>());
        basic.get(0).add(0, new Square(r0c0));
        int[] r0c1 = {0,0,7,0,0,9,0,0,0};
        basic.get(0).add(1, new Square(r0c1));
        int[] r0c2 = {3,0,0,0,5,0,0,6,4};
        basic.get(0).add(2, new Square(r0c2));

        int[] r1c0 = {9,2,0,0,0,0,0,0,0};
        basic.add(1, new ArrayList<Square>());
        basic.get(1).add(0, new Square(r1c0));
        int[] r1c1 = {0,8,0,7,6,3,0,9,0};
        basic.get(1).add(1, new Square(r1c1));
        int[] r1c2 = {0,0,0,0,0,0,0,7,5};
        basic.get(1).add(2, new Square(r1c2));

        int[] r2c0 = {6,3,0,0,9,0,0,0,2};
        basic.add(2, new ArrayList<Square>());
        basic.get(2).add(0, new Square(r2c0));
        int[] r2c1 = {0,0,0,3,0,0,4,0,0};
        basic.get(2).add(1, new Square(r2c1));
        int[] r2c2 = {0,0,8,5,2,0,6,0,0};
        basic.get(2).add(2, new Square(r2c2));
    }

    public Cell getCellAtCoords(int x, int y) {
        Square square = basic.get(y/3).get(x/3);
        return square.getBasic().get(y%3).get(x%3);
    }

    public boolean checkBoard(){
        int counter = 0;

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {

                if (getCellAtCoords(row, col).getValue() >= 9
                    && getCellAtCoords(row, col).getValue() <= 0) {
                    return false;
                }

                for (int k = 0; k < 9; k++){

                    if (getCellAtCoords(row, col).getValue() != 0) {
                        if (getCellAtCoords(row, col).getValue() == getCellAtCoords(row, k).getValue()) {
                            counter += 1;
                        }
                        if (getCellAtCoords(row, col).getValue() == getCellAtCoords(k, col).getValue()) {
                            counter += 1;
                        }
                        if (basic.get(col/3).get(row/3).getBasic().get(k/3).get(k%3).getValue() == getCellAtCoords(row, col).getValue()) {
                            counter += 1;
                        }
                    }
                }
                if (counter > 3) {
                    return false;
                }
                counter = 0;
            }
        }
        return true;
    }


    public String toString() {
        String hold = "";
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                hold += getCellAtCoords(i, j).getValue();
            }
            hold += "\n";
        }
        return hold;
    }


    public static void main(String[] args){
        Grid grid = new Grid();
        System.out.print(grid.toString());
    }
}
