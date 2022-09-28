import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Character dofus=new Character("Dofus",new Move("Kick",12),new Move("Jab",10)
                                        ,new Move("Explosion",50));
        Character tak=new Character("Tak",new Move("Slap",12),new Move("Claw",10)
                                        ,new Move("Nova",50));

        //Player playerOne=new Player("Erik",dofus);
        //Player playerTwo=new Player("Fred",tak);
        int bersekLevel=30;
        boolean invalidChoice=true;
        Scanner sc=new Scanner(System.in);
        int selectMove;
        do
        {
            int damage;
            do
            {
                System.out.println("Player One select a move: \n" +
                        "1: "+dofus.getMoveOneName()+'\n'+
                        "2: "+dofus.getMoveTwoName()+"\n" +
                        "3, Special: "+dofus.getSpecialMoveName()+"\n" +
                        "Choice: ");
                selectMove=sc.nextInt();
                sc.nextLine();
                if (selectMove>0 && selectMove<4)
                    invalidChoice=false;
            }
            while(invalidChoice);
            invalidChoice=true;
            if(selectMove==1){
                damage= dofus.getMoveOneDMG();
                System.out.println("Player One hit for "+damage+" points with "+dofus.getMoveOneName());
                tak.setCurrentHealth(tak.getCurrentHealth()-damage);
                dofus.setEnergyLevel(dofus.getEnergyLevel()+10);
                System.out.println(dofus.getName()+" now has "+dofus.getEnergyLevel()+" energy");
            }
            else if(selectMove==2) {
                damage= dofus.getMoveTwoDMG();
                System.out.println("Player One hit for "+damage+" points with "+dofus.getMoveTwoName());
                tak.setCurrentHealth(tak.getCurrentHealth()-damage);
                dofus.setEnergyLevel(dofus.getEnergyLevel()+10);
                System.out.println(dofus.getName()+" now has "+dofus.getEnergyLevel()+" energy");
            }
            else if (dofus.getEnergyLevel()==50){
                damage= dofus.getMoveSPDMG();
                System.out.println("Player One hit for "+damage+" points with "+dofus.getSpecialMove());
                tak.setCurrentHealth(tak.getCurrentHealth()-damage);
            }
            else System.out.println("Not enough energy, you missed");

            if (tak.getCurrentHealth()<=0){
                System.out.println(tak.getName()+" is dead\n" +
                        "HP: "+tak.getCurrentHealth()+"\n" +
                        "Player One wins");
                break;
            }
            else{
                System.out.println(tak.getName()+" is still standing\n" +
                        "HP: "+tak.getCurrentHealth());
                if(tak.getCurrentHealth()<=bersekLevel && tak.getCurrentHealth()>0){
                    System.out.println(tak.getName()+" is now Berserk, damage is increased");
                    tak=new BerserkerCharacter(tak);
                }
            }
            do
            {
                System.out.println("Player Two select a move: \n" +
                        "1: "+tak.getMoveOneName()+'\n'+
                        "2: "+tak.getMoveTwoName()+"\n "+
                        "3, Special: "+tak.getSpecialMove()+"\n" +
                        "Choice: ");
                selectMove=sc.nextInt();
                sc.nextLine();
                if (selectMove>0 && selectMove<4)
                    invalidChoice=false;
            }
            while(invalidChoice);
            invalidChoice=true;
            if(selectMove==1){
                damage= tak.getMoveOneDMG();
                System.out.println("Player Two hit for "+damage+" points");
                dofus.setCurrentHealth(dofus.getCurrentHealth()-damage);
                tak.setEnergyLevel(tak.getEnergyLevel()+10);
                System.out.println(tak.getName()+" now has "+tak.getEnergyLevel()+" energy");
            }
            else if(selectMove==2){
                damage= tak.getMoveTwoDMG();
                System.out.println("Player Two hit for "+damage+" points");
                dofus.setCurrentHealth(dofus.getCurrentHealth()-damage);
                tak.setEnergyLevel(tak.getEnergyLevel()+10);
                System.out.println(tak.getName()+" now has "+tak.getEnergyLevel()+" energy");
            }
            else if (tak.getEnergyLevel()==50){
                damage= tak.getMoveSPDMG();
                System.out.println("Player One hit for "+damage+" points with "+tak.getSpecialMove());
                dofus.setCurrentHealth(dofus.getCurrentHealth()-damage);
            }
            else System.out.println("Not enough energy, you missed");

            if (dofus.getCurrentHealth()<=0){
                System.out.println(dofus.getName()+" is dead\n" +
                        "HP: "+dofus.getCurrentHealth()+"\n" +
                        "Player Two wins");
                break;
            }
            else{
                System.out.println(dofus.getName()+" is still standing\n" +
                        "HP: "+dofus.getCurrentHealth()+"\n");
                if(dofus.getCurrentHealth()<=bersekLevel && dofus.getCurrentHealth()>0) {
                    System.out.println(dofus.getName() + " is now Berserk, damage is increased");
                    dofus = new BerserkerCharacter(dofus);
                }
            }
        }
        while (true);

    }
}