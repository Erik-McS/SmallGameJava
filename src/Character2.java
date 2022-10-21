import java.util.Objects;

public class Character2 {
    private String name;
    private int healthPool;
    private int currentHealth;
    private Move moveOne;
    private Move moveTwo;
    private Move specialMove;
    private int energyLevel;
    private int berserkLevel;
    private int energyIncrease;

    private Character2(characterBuilder cb){
        this.name=cb.name;
        this.moveOne=cb.moveOne;
        this.moveTwo=cb.moveTwo;
        this.specialMove=cb.specialMove;
        this.berserkLevel=cb.berserkLevel;
        this.currentHealth=cb.currentHealth;
        this.healthPool=cb.healthPool;
        this.energyIncrease= cb.energyIncrease;;
    }
    public String getMoveOneName() {return moveOne.getName();}
    public String getMoveTwoName() {return moveTwo.getName();}
    public String getName() {return name;}
    public int getHealthPool() {return healthPool;}
    public int getEnergyLevel() {return energyLevel;}
    public void setEnergyLevel(int energyLevel) {this.energyLevel = energyLevel;}
    public int getCurrentHealth() {return currentHealth;}

    public Move getMoveOne() {return moveOne;}
    //public void setMoveOne(Move moveOne) {this.moveOne = moveOne;}
    public Move getMoveTwo() {return moveTwo;}
    //public void setMoveTwo(Move moveTwo) {this.moveTwo = moveTwo;}
    public String getSpecialMoveName() {return specialMove.getName();}
    public Move getSpecialMove() {return specialMove;}
    //public void setSpecialMove(Move specialMove) {this.specialMove = specialMove;}
    public int getEnergyIncrease() {return energyIncrease;}
    public void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}

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

    @Override
    public String toString() {
        return "Character2{" +
                "name='" + name + '\'' +
                ", healthPool=" + healthPool +
                ", currentHealth=" + currentHealth +
                ", moveOne=" + moveOne +
                ", moveTwo=" + moveTwo +
                ", specialMove=" + specialMove +
                ", energyLevel=" + energyLevel +
                ", berserkLevel=" + berserkLevel +
                ", energyIncrease=" + energyIncrease +
                '}';
    }
    public static class characterBuilder{
        private String name;
        private int healthPool;
        private int currentHealth;
        private Move moveOne;
        private Move moveTwo;
        private Move specialMove;
        private int energyLevel;
        private int berserkLevel;
        private int energyIncrease;


        public characterBuilder name(String name) throws InputValidationException{
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

        public characterBuilder healthPool(int healthPool) throws InputValidationException{
            if (healthPool>0 && healthPool<=20000){
                this.healthPool=healthPool;
                this.currentHealth(healthPool);
                return this;
            }
            else throw new InputValidationException("HealthPool Value out of bound");
        }

        public characterBuilder currentHealth(int currentHealth) {
            this.currentHealth = currentHealth;
            return this;
        }

        public characterBuilder moveOne(Move moveOne) {
            this.moveOne = moveOne;
            return this;
        }

        public characterBuilder moveTwo(Move moveTwo) {
            this.moveTwo = moveTwo;
            return this;
        }

        public characterBuilder specialMove(Move specialMove) {
            this.specialMove = specialMove;
            return this;
        }

        public characterBuilder energyLevel(int energyLevel) {
            this.energyLevel = energyLevel;
            return this;
        }

        public characterBuilder berserkLevel(int berserkLevel) throws InputValidationException{
            if(berserkLevel>0 && berserkLevel<=40) {
                this.berserkLevel = berserkLevel;
                return this;
            }
            else throw new InputValidationException("Berserk Level out of bounds");
        }

        public characterBuilder energyIncrease(int energyIncrease) throws InputValidationException {
            if (energyIncrease>0 && energyIncrease<20){
                this.energyIncrease = energyIncrease;
                return this;
            }
            else throw new InputValidationException("Energy Increase Value out of bounds");
        }
        public Character2 CBuilder() throws InputValidationException{

            if (Objects.equals(this.name, ""))
                throw new InputValidationException("Name cannot be empty");
            if (this.moveOne==null)
                this.moveOne=new Move("Kick",12);
            if (this.moveTwo==null)
                this.moveTwo=new Move("Jab",10);
            if (this.specialMove==null)
                this.specialMove=new Move("Explosion",50);
            this.energyLevel=0;
            if (this.healthPool==0){
                this.healthPool=150;
                this.currentHealth=150;
            }
            if (this.berserkLevel==0)
                this.berserkLevel=30;
            if (this.energyIncrease==0)
                this.energyIncrease=10;

            return new Character2(this);
        }
    }
}
