import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try {
            // Creating two characters
            Character dofus= new CharacterBuilder()
                    .setName("Dofus")
                    .setMoveOne(new Move("Kick",12))
                    .setMoveTwo(new Move("Jab",10))
                    .setSpecialMove(new Move("Explosion",50))
                    .setBerserkerLevel(30)
                    .BuildCharacter();

            Character tak = new CharacterBuilder()
                    .setName("Tak")
                    .setMoveOne(new Move("Slap", 12))
                    .setMoveTwo(new Move("Claw", 10))
                    .setSpecialMove(new Move("Nova", 50))
                    .setBerserkerLevel(40)
                    .BuildCharacter();

            boolean invalidChoice = true;
            Scanner sc = new Scanner(System.in);
            int selectMove;
            // Main loop, while run until one of the character drops to 0 or less
            do {
                // will store the damage value
                int damage;
                // Loop to get player 1 selection
                do {
                    System.out.println("Player One select a move: \n" +
                            "1: " + dofus.getMoveOneName() + '\n' +
                            "2: " + dofus.getMoveTwoName() + "\n" +
                            "3, Special: " + dofus.getSpecialMoveName() + "\n" +
                            "Choice: ");
                    selectMove = sc.nextInt();
                    // need the getLine() as a workaround for the nextInt()
                    sc.nextLine();
                    // check if choice is either 1,2,3
                    if (selectMove > 0 && selectMove < 4)
                        invalidChoice = false;
                }
                while (invalidChoice);
                // reseting for the next loop
                invalidChoice = true;

                if (selectMove == 1) {
                    // Move 1 selected
                    // get the damage
                    damage = dofus.getMoveOneDMG();
                    System.out.println("Player One hit for " + damage + " points with " + dofus.getMoveOneName());
                    // deduct the damage from the currentHealth value
                    tak.setCurrentHealth(tak.getCurrentHealth() - damage);
                    // increment the energy level by 10 ( as defined in the character class)
                    dofus.setEnergyLevel(dofus.getEnergyLevel() + dofus.getEnergyIncrease());
                    System.out.println(dofus.getName() + " now has " + dofus.getEnergyLevel() + " energy");
                } else if (selectMove == 2) {
                    damage = dofus.getMoveTwoDMG();
                    System.out.println("Player One hit for " + damage + " points with " + dofus.getMoveTwoName());
                    tak.setCurrentHealth(tak.getCurrentHealth() - damage);
                    dofus.setEnergyLevel(dofus.getEnergyLevel() + dofus.getEnergyIncrease());
                    System.out.println(dofus.getName() + " now has " + dofus.getEnergyLevel() + " energy");
                } else if (dofus.getEnergyLevel() == 50) {
                    damage = dofus.getMoveSPDMG();
                    System.out.println("Player One hit for " + damage + " points with " + dofus.getSpecialMove());
                    tak.setCurrentHealth(tak.getCurrentHealth() - damage);
                } else System.out.println("Not enough energy, you missed");

                if (tak.getCurrentHealth() <= 0) {
                    System.out.println(tak.getName() + " is dead\n" +
                            "HP: " + tak.getCurrentHealth() + "\n" +
                            "Player One wins");
                    break;
                } else {
                    System.out.println(tak.getName() + " is still standing\n" +
                            "HP: " + tak.getCurrentHealth());
                    if (tak.getCurrentHealth() <= tak.getBerserkLevel() && tak.getCurrentHealth() > 0) {
                        System.out.println(tak.getName() + " is now Berserk, damage is increased");
                        tak = new BerserkerCharacter(tak);
                    }
                }
                do {
                    System.out.println("Player Two select a move: \n" +
                            "1: " + tak.getMoveOneName() + '\n' +
                            "2: " + tak.getMoveTwoName() + "\n " +
                            "3, Special: " + tak.getSpecialMove() + "\n" +
                            "Choice: ");
                    selectMove = sc.nextInt();
                    sc.nextLine();
                    if (selectMove > 0 && selectMove < 4)
                        invalidChoice = false;
                }
                while (invalidChoice);
                invalidChoice = true;
                if (selectMove == 1) {
                    damage = tak.getMoveOneDMG();
                    System.out.println("Player Two hit for " + damage + " points");
                    dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                    tak.setEnergyLevel(tak.getEnergyLevel() + tak.getEnergyIncrease());
                    System.out.println(tak.getName() + " now has " + tak.getEnergyLevel() + " energy");
                } else if (selectMove == 2) {
                    damage = tak.getMoveTwoDMG();
                    System.out.println("Player Two hit for " + damage + " points");
                    dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                    tak.setEnergyLevel(tak.getEnergyLevel() + tak.getEnergyIncrease());
                    System.out.println(tak.getName() + " now has " + tak.getEnergyLevel() + " energy");
                } else if (tak.getEnergyLevel() == 50) {
                    damage = tak.getMoveSPDMG();
                    System.out.println("Player One hit for " + damage + " points with " + tak.getSpecialMove());
                    dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                } else System.out.println("Not enough energy, you missed");

                if (dofus.getCurrentHealth() <= 0) {
                    System.out.println(dofus.getName() + " is dead\n" +
                            "HP: " + dofus.getCurrentHealth() + "\n" +
                            "Player Two wins");
                    break;
                } else {
                    System.out.println(dofus.getName() + " is still standing\n" +
                            "HP: " + dofus.getCurrentHealth() + "\n");
                    if (dofus.getCurrentHealth() <= dofus.getBerserkLevel() && dofus.getCurrentHealth() > 0) {
                        System.out.println(dofus.getName() + " is now Berserk, damage is increased");
                        dofus = new BerserkerCharacter(dofus);
                    }
                }
            }
            while (true);
        }
    catch(
    InputValidationException e) {System.out.println(e.getMessage());}
    }
}