public class BossCharacter {
    private Character character;
    public BossCharacter(Character character){

        this.character=character;

    }
    public void setName(String name) throws InputValidationException{
        character.setName(name);
    }
    public String getMoveOneName() {return character.getMoveOneName();}
    public String getMoveTwoName() {return character.getMoveTwoName();}
    public String getName() {return character.getName();}
    public int getHealthPool() {return character.getHealthPool();}
    public int getEnergyLevel() {return character.getEnergyLevel();}
    public void setEnergyLevel(int energyLevel) {character.setEnergyLevel(energyLevel);}
    public int getCurrentHealth() {return character.getCurrentHealth();}
    public void setCurrentHealth(int currentHealth) {character.setCurrentHealth(currentHealth);}

    public void setHealthPool(int healthPool) throws InputValidationException{
        if (healthPool>0 && healthPool<=20000){
            character.setHealthPool(healthPool);
            character.setCurrentHealth(healthPool);
        }
        else throw new InputValidationException("HealthPool Value out of bound");
    }
    public Move getMoveOne() {return character.getMoveOne();}
    public void setMoveOne(Move moveOne) {character.setMoveOne(moveOne);}
    public Move getMoveTwo() {return character.getMoveTwo();}
    public void setMoveTwo(Move moveTwo) {character.setMoveTwo(moveTwo);}
    public String getSpecialMoveName() {return character.getSpecialMoveName();}
    public Move getSpecialMove() {return character.getSpecialMove();}
    public void setSpecialMove(Move specialMove) {character.setSpecialMove(specialMove);}
    public int getEnergyIncrease() {return character.getEnergyIncrease();}
    public void setEnergyIncrease(int energyIncrease) throws InputValidationException{

        if (energyIncrease>0 && energyIncrease<20)
            character.setEnergyIncrease(energyIncrease);
        else throw new InputValidationException("Energy Increase Value out of bounds");
    }
    // functions that returns the damage. each use the base damage of the Move object
    // adding a random value based on the move type.
    public int getMoveOneDMG(){return character.getMoveOneDMG();}
    public int getMoveTwoDMG(){return character.getMoveTwoDMG();}
    public int getMoveSPDMG(){return character.getMoveSPDMG();}
    public int getBerserkLevel() {return character.getBerserkLevel();}
    public void setBerserkLevel(int berserkLevel) throws InputValidationException{
        character.setBerserkLevel(berserkLevel);

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
}
