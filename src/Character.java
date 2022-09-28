import  java.util.Random;

public class Character {

    private String name;
    private int healthPool=150;
    // each character has 2 moves
    private Move moveOne=new Move();
    private Move moveTwo=new Move();
    private Random rand=new Random();

    public String getMoveOne() {
        return "Move: "+moveOne.getName()+", Base Damage: "+moveOne.getDamage();
    }
    public String getMoveTwo() {
        return "Move: "+moveTwo.getName()+", Base Damage: "+moveTwo.getDamage();
    }

    public Character(String name, Move moveOne,Move moveTwo){
        try{
            setName(name);
            this.moveOne=moveOne;
            this.moveTwo=moveTwo;
        }
        catch(InputValidationException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws InputValidationException{

        if (name.equals("")){
            throw new InputValidationException("Invalid Character Name: Null");
        }
        else if(name.matches("(\\p{Upper})(\\p{Lower}){1,10}")){
                this.name=name;
            }
        else {throw new InputValidationException("Invalid Character Name:"+name);}
    }
    public int getHealthPool() {
        return healthPool;
    }
    public void setHealthPool(int healthPool) {
        this.healthPool = healthPool;
    }

    public int getMoveOneDMG(){
        return this.moveOne.getDamage()+ rand.nextInt(20);
    }
    public int getMoveTwoDMG(){
        return this.moveTwo.getDamage()+ rand.nextInt(10);
    }
    public void displayCharacter(){
        System.out.println("Character: "+getName());
        System.out.println("Move 1: "+getMoveOne());
        System.out.println("Move 2: "+getMoveTwo());
    }
}
