import java.util.ArrayList;

public class Square

{
    private ArrayList<ArrayList<Cell>> basic = new ArrayList<ArrayList<Cell>>();

    public Square (int[] h){
        for (int i = 0; i < 3; i++){
            basic.add(i, new ArrayList<Cell>());
            for (int j = i*3; j < i*3+3; j++){
                basic.get(i).add(j-i*3, new Cell(true, h[j]));
            }
        }
    }

    public String toString() {
        String hold = "";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                hold += basic.get(i).get(j).getValue();
            }
            hold += "\n";
        }
        return hold;
    }

    public ArrayList<ArrayList<Cell>> getBasic() {
        return basic;
    }

    public static void main(String[] args){
        int[] vals = {1,2,3,4,5,6,7,8,9};
        Square square = new Square(vals);
        System.out.print(square.toString());
    }
}
