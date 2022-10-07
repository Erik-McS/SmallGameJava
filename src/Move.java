import java.util.Random;

public class Move {
    private String name;
    private int damage;
    Random rand=new Random();

    public Move(String name, int damage){
        try{
            setName(name);
            setDamage(damage);
        }
        catch(InputValidationException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public Move(){
        this.name="";
        this.damage=0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws InputValidationException{
        if(name.matches("(\\p{Upper}|\\p{Lower})(\\p{Lower}){1,10}")){
            this.name=name;
        }
        else {throw new InputValidationException("Invalid Move Name");}
    }
    public int getDamage(int range) {
        return damage+rand.nextInt(range);
    }
    public int getDamage(){return damage;}
    public void setDamage(int damage) throws InputValidationException{
        if (damage>=10 && damage<=60){
            this.damage=damage;
        }
        else {throw new InputValidationException("Invalid Damage Value");}
    }
}
