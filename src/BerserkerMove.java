import java.util.Random;

public class BerserkerMove extends Move {

    private Move move;
    final private int multiplier = 3;
    Random rand = new Random();

    public BerserkerMove(Move move){

        this.move=move;
    }
    public String getName(){
        return "Berserker "+move.getName();
    }
    public int getDamage(int range) {
        return (move.getDamage()+rand.nextInt(range))*3;
    }
    public int getDamage(){return (move.getDamage())*3;}
}
