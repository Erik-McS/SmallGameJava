public class CharacterBuilder {

    private Character defaultChar=new Character();

    public CharacterBuilder setName(String name) throws InputValidationException{
        defaultChar.setName(name);
        return this;
    }
    public CharacterBuilder setHealthPool(int healthPool) throws InputValidationException{
        defaultChar.setCurrentHealth(healthPool);
        defaultChar.setHealthPool(healthPool);
        return this;
    }
    public CharacterBuilder setMoveOne(Move moveOne){
        defaultChar.setMoveOne(moveOne);
        return this;
    }
    public CharacterBuilder setMoveTwo(Move moveTwo){
        defaultChar.setMoveTwo(moveTwo);
        return this;
    }
    public CharacterBuilder setSpecialMove(Move specialMove){
        defaultChar.setSpecialMove(specialMove);
        return this;
    }
    public CharacterBuilder setEnergyLevel(int energyLevel){
        defaultChar.setEnergyLevel(energyLevel);
        return this;
    }
    public CharacterBuilder setBerserkerLevel(int berserkerLevel) throws InputValidationException{
        defaultChar.setBerserkLevel(berserkerLevel);
        return this;
    }
    public CharacterBuilder setEnergyIncrease(int energyIncrease) throws InputValidationException{
        defaultChar.setEnergyIncrease(energyIncrease);
        return this;
    }
    public Character BuildCharacter(){
        return defaultChar;
    }
}
