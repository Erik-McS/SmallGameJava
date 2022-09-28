import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Character Dofus=new Character("Dofus",new Move("Kick",10),new Move("Jab",20));
        Character Tak=new Character("Tak",new Move("Slap",10),new Move("Claw",20));

        Player playerOne=new Player("Erik",Dofus);
        Player playerTwo=new Player("Fred",Tak);
        int healthChar1=Dofus.getHealthPool();
        int healthChar2=Tak.getHealthPool();

        boolean invalidChoice=true;
        Scanner sc=new Scanner(System.in);
        int selectMove;
        do
        {
            int damage;
            do
            {
                System.out.println("Player One select a move: \n" +
                        "1: "+Dofus.getMoveOne()+'\n'+
                        "2: "+Dofus.getMoveTwo()+"\n Choice: ");
                selectMove=sc.nextInt();
                sc.nextLine();
                if (selectMove==1 || selectMove==2)
                    invalidChoice=false;
            }
            while(invalidChoice);
            invalidChoice=true;
            if(selectMove==1){
                damage= Dofus.getMoveOneDMG();
                System.out.println("Player One hit for "+damage+" points");
                healthChar2-= damage;
            }
            else {
                damage= Dofus.getMoveTwoDMG();
                System.out.println("Player One hit for "+damage+" points");
                healthChar2-= damage;
            }
            if (healthChar2<=0){
                System.out.println(Tak.getName()+" is dead\n" +
                        "HP: "+healthChar2+"\n" +
                        "Player One wins");
                break;
            }
            else{
                System.out.println(Tak.getName()+" is still standing\n" +
                        "HP: "+healthChar2+"\n");
            }

            do
            {
                System.out.println("Player Two select a move: \n" +
                        "1: "+Tak.getMoveOne()+'\n'+
                        "2: "+Tak.getMoveTwo()+"\n Choice: ");
                selectMove=sc.nextInt();
                sc.nextLine();
                if (selectMove>0 && selectMove<3)
                    invalidChoice=false;
            }
            while(invalidChoice);
            invalidChoice=true;
            if(selectMove==1){
                damage= Tak.getMoveOneDMG();
                System.out.println("Player Two hit for "+damage+" points");
                healthChar1-= damage;
            }
            else {
                damage= Tak.getMoveTwoDMG();
                System.out.println("Player Two hit for "+damage+" points");
                healthChar1-= damage;
            }
            if (healthChar1<=0){
                System.out.println(Dofus.getName()+" is dead\n" +
                        "HP: "+healthChar1+"\n" +
                        "Player Two wins");
                break;
            }
            else{
                System.out.println(Dofus.getName()+" is still standing\n" +
                        "HP: "+healthChar1+"\n");
            }
        }
        while (true);

    }
}