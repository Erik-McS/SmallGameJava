
public class Character{

    private String name;
    private int healthPool;
    private int currentHealth;
    private Move moveOne=new Move();
    private Move moveTwo=new Move();
    private Move specialMove=new Move();
    private int energyLevel;
    private int berserkLevel;
    private int energyIncrease;

    public Character(String name, Move moveOne,Move moveTwo,Move specialMove){
        // assigning all values
        try{
            setName(name);
            this.moveOne=moveOne;
            this.moveTwo=moveTwo;
            this.specialMove=specialMove;
            this.energyLevel=0;
            this.currentHealth=150;
            this.healthPool=150;
            this.berserkLevel=30;
            this.energyIncrease=10;
        }
        catch(InputValidationException e){System.out.println("Error: "+e.getMessage());}
    }
    public Character(){
        this.name="Default Character";
        this.energyLevel=0;
        this.currentHealth=150;
        this.healthPool=150;
        this.berserkLevel=30;
        this.energyIncrease=10;
        this.moveOne=new Move("Kick",12);
        this.moveTwo=new Move("Jab",10);
        this.specialMove=new Move("Explosion",50);
    }
    public void setName(String name) throws InputValidationException{
        // checking that the name string is not empty
        if (name.equals("")){
            throw new InputValidationException("Invalid Character Name: Null");
        }
        // name needs to start with an upper, 10 chars max
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
    public void setHealthPool(int healthPool) throws InputValidationException{
        if (healthPool>0 && healthPool<=20000){
            this.healthPool=healthPool;
            this.setCurrentHealth(healthPool);
        }
        else throw new InputValidationException("HealthPool Value out of bound");
    }
    public Move getMoveOne() {return moveOne;}
    public void setMoveOne(Move moveOne) {this.moveOne = moveOne;}
    public Move getMoveTwo() {return moveTwo;}
    public void setMoveTwo(Move moveTwo) {this.moveTwo = moveTwo;}
    public String getSpecialMoveName() {return specialMove.getName();}
    public Move getSpecialMove() {return specialMove;}
    public void setSpecialMove(Move specialMove) {this.specialMove = specialMove;}
    public int getEnergyIncrease() {return energyIncrease;}
    public void setEnergyIncrease(int energyIncrease) throws InputValidationException{

        if (energyIncrease>0 && energyIncrease<20)
            this.energyIncrease = energyIncrease;
        else throw new InputValidationException("Energy Increase Value out of bounds");
    }
    // functions that returns the damage. each use the base damage of the Move object
    // adding a random value based on the move type.
    public int getMoveOneDMG(){
        if(getCurrentHealth()<getBerserkLevel()){
            this.moveOne=new BerserkerMove(moveOne);
        }
        return this.moveOne.getDamage(3);
    }
    public int getMoveTwoDMG(){
        if(getCurrentHealth()<getBerserkLevel()){
            this.moveTwo=new BerserkerMove(moveTwo);
        }
        return this.moveTwo.getDamage(30);
    }
    public int getMoveSPDMG(){
        if(getCurrentHealth()<getBerserkLevel())
            this.specialMove=new BerserkerMove(specialMove);
        return specialMove.getDamage();}
    public int getBerserkLevel() {return berserkLevel;}
    public void setBerserkLevel(int berserkLevel) throws InputValidationException{
        if(berserkLevel>0 && berserkLevel<=40)
            this.berserkLevel = berserkLevel;
        else throw new InputValidationException("Berserk Level out of bounds");
    }
    // Display the character info
    public void displayCharacter(){
        System.out.println("Character: "+getName());
        System.out.println("Move 1: "+getMoveOneName());
        System.out.println("Move 2: "+getMoveTwoName());
        System.out.println("Special move: "+getSpecialMoveName());
        System.out.println("Health Pool: "+getHealthPool());
        System.out.println("Berserk Level: "+getBerserkLevel());
        System.out.println("Energy Increase: "+getEnergyIncrease());
    }

    public static class characterBuilder{

        private String name;
        private int healthPool;
        private int currentHealth;
        private Move moveOne=new Move();
        private Move moveTwo=new Move();
        private Move specialMove=new Move();
        private int energyLevel;
        private int berserkLevel;
        private int energyIncrease;
        public characterBuilder name(String name) throws InputValidationException{
            // checking that the name string is not empty
            if (name.equals("")){
                throw new InputValidationException("Invalid Character Name: Null");
            }
            // name needs to start with an upper, 10 chars max
            else if(name.matches("(\\p{Upper})(\\p{Lower}){1,10}")){
                this.name=name;
                return this;
            }
            else {throw new InputValidationException("Invalid Character Name:"+name);}
        }

    }
}
