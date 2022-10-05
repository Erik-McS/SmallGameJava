import java.util.Random;

public class BerserkerCharacter extends Character{
    private Character character;

    final private int multiplier = 3;
    Random rand = new Random();
    public BerserkerCharacter(Character character) {
        super(character.getName(), character.getMoveOne(), character.getMoveTwo(), character.getSpecialMove());
        this.character = character;
    }
    public int getMoveOneDMG(){return (this.character.getMoveOne().getDamage()+ rand.nextInt(3))*multiplier;}
    public int getMoveTwoDMG(){
        return (this.character.getMoveTwo().getDamage()+ rand.nextInt(30))*multiplier;
    }
    public int getMoveSPDMG(){return this.character.getSpecialMove().getDamage()*multiplier;}
}
