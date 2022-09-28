import  java.util.Random;

public class Character{

    private String name;
    private int healthPool;
    private int currentHealth;
    private Move moveOne=new Move();
    private Move moveTwo=new Move();
    private Move specialMove=new Move();
    private Random rand=new Random();
    private int energyLevel;

    public Character(String name, Move moveOne,Move moveTwo,Move specialMove){
        try{
            setName(name);
            this.moveOne=moveOne;
            this.moveTwo=moveTwo;
            this.specialMove=specialMove;
            this.energyLevel=0;
            this.currentHealth=150;
            this.healthPool=150;
        }
        catch(InputValidationException e){System.out.println("Error: "+e.getMessage());}
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
    public String getMoveOneName() {return moveOne.getName();}
    public String getMoveTwoName() {return moveTwo.getName();}
    public String getName() {return name;}
    public int getHealthPool() {return healthPool;}
    public int getEnergyLevel() {return energyLevel;}
    public void setEnergyLevel(int energyLevel) {this.energyLevel = energyLevel;}
    public int getCurrentHealth() {return currentHealth;}
    public void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}
    public Move getMoveOne() {return moveOne;}
    public void setMoveOne(Move moveOne) {this.moveOne = moveOne;}
    public Move getMoveTwo() {return moveTwo;}
    public void setMoveTwo(Move moveTwo) {this.moveTwo = moveTwo;}
    public String getSpecialMoveName() {return specialMove.getName();}
    public Move getSpecialMove() {return specialMove;}
    public void setSpecialMove(Move specialMove) {this.specialMove = specialMove;}
    public int getMoveOneDMG(){return this.moveOne.getDamage()+ rand.nextInt(3);}
    public int getMoveTwoDMG(){
        return this.moveTwo.getDamage()+ rand.nextInt(30);
    }
    public int getMoveSPDMG(){return specialMove.getDamage();}
    public void displayCharacter(){
        System.out.println("Character: "+getName());
        System.out.println("Move 1: "+getMoveOne());
        System.out.println("Move 2: "+getMoveTwo());
    }
}
