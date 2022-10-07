import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

public class OnePlayerMode {

    public static void main(String[] args) {


        try {
            // Creating two characters
            Character dofus= new CharacterBuilder()
                    .setName("Dofus")
                    .setMoveOne(new Move("Kick",12))
                    .setMoveTwo(new Move("Jab",10))
                    .setSpecialMove(new Move("Explosion",50))
                    .setBerserkerLevel(30)
                    .setHealthPool(1500)
                    .BuildCharacter();

            BossCharacter boss = new BossCharacter(new CharacterBuilder()
                    .setName("Boss")
                    .setMoveOne(new Move("Slap", 12))
                    .setMoveTwo(new Move("Claw", 10))
                    .setSpecialMove(new Move("Nova", 50))
                    .setBerserkerLevel(40)
                    .setHealthPool(3000)
                    .BuildCharacter()
            );

            boolean invalidChoice = true;
            int ultimatecount=0;
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
                    boss.setCurrentHealth(boss.getCurrentHealth() - damage);
                    // increment the energy level by 10 ( as defined in the character class)
                    dofus.setEnergyLevel(dofus.getEnergyLevel() + dofus.getEnergyIncrease());
                    System.out.println(dofus.getName() + " now has " + dofus.getEnergyLevel() + " energy");
                } else if (selectMove == 2) {
                    damage = dofus.getMoveTwoDMG();
                    System.out.println("Player One hit for " + damage + " points with " + dofus.getMoveTwoName());
                    boss.setCurrentHealth(boss.getCurrentHealth() - damage);
                    dofus.setEnergyLevel(dofus.getEnergyLevel() + dofus.getEnergyIncrease());
                    System.out.println(dofus.getName() + " now has " + dofus.getEnergyLevel() + " energy");
                } else if (dofus.getEnergyLevel() >= 40) {
                    damage = dofus.getMoveSPDMG();
                    System.out.println("Player One hit for " + damage + " points with " + dofus.getSpecialMoveName());
                    boss.setCurrentHealth(boss.getCurrentHealth() - damage);
                    dofus.setEnergyLevel(0);
                } else System.out.println("Not enough energy, you missed");

                if (boss.getCurrentHealth() <= 0) {
                    System.out.println(boss.getName() + " is dead\n" +
                            "HP: " + boss.getCurrentHealth() + "\n" +
                            "Player One wins");
                    break;
                } else {
                    System.out.println(boss.getName() + " is still standing\n" +
                            "HP: " + boss.getCurrentHealth());
                    if (boss.getCurrentHealth() <= boss.getBerserkLevel() && boss.getCurrentHealth() > 0) {
                        System.out.println(boss.getName() + " is now Berserk, damage is increased");

                    }
                }

                // random selection of the Boss move.
                int choice=new Random().nextInt(2)+1;

                if(boss.getEnergyLevel()>=40){
                    damage = boss.getMoveSPDMG();
                    System.out.println(boss.getName()+" hit for " + damage + " points with " + boss.getSpecialMoveName());
                    dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                    boss.setEnergyLevel(0);
                    ultimatecount++;
                    if(ultimatecount<3)
                        System.out.println(boss.getName()+" is "+ultimatecount+" step closer to unleash Ultimate");
                    else System.out.println(boss.getName()+" will unleash his ultimate next turn!");
                }
                else if(ultimatecount==3){
                    damage = boss.getMoveSPDMG()*2;
                    System.out.println(boss.getName()+" hit for " + damage + " points with Ultimate " + boss.getSpecialMoveName());
                    dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                    ultimatecount=0;
                }

                else {
                    if (choice == 1) {
                        damage = boss.getMoveOneDMG();
                        System.out.println(boss.getName()+ " hit for " + damage + " points with "+boss.getMoveOneName());
                        dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                        boss.setEnergyLevel(boss.getEnergyLevel() + boss.getEnergyIncrease());
                        System.out.println(boss.getName() + " now has " + boss.getEnergyLevel() + " energy");
                    } else if (choice == 2) {
                        damage = boss.getMoveTwoDMG();
                        System.out.println(boss.getName()+ " hit for " + damage + " points with "+boss.getMoveTwoName());
                        dofus.setCurrentHealth(dofus.getCurrentHealth() - damage);
                        boss.setEnergyLevel(boss.getEnergyLevel() + boss.getEnergyIncrease());
                        System.out.println(boss.getName() + " now has " + boss.getEnergyLevel() + " energy");
                    }
                }

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

                    }
                }
            }
            while (true);
        }
        catch(
                InputValidationException e) {System.out.println(e.getMessage());}
    }
}
