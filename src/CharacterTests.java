public class CharacterTests {

    public static void main(String[] args) {

        //Character Dofus=new Character("Dofus",new Move("Kick",20),new Move("Jab",30));
       // Character Tak=new Character("Tak",new Move("Slap",20),new Move("Claw",30));

      //  Dofus.displayCharacter();
      //  Tak.displayCharacter();

        try{
            Character Dof=new CharacterBuilder()
                    .setName("Erik")
                    .setBerserkerLevel(23)
                    .setHealthPool(200)
                    .setMoveOne(new Move("Elbow",13))
                    .BuildCharacter();
            Dof.displayCharacter();


            Character Tak=new CharacterBuilder()
                    .setName("Tak")
                    .setHealthPool(140)
                    .setBerserkerLevel(40)
                    .BuildCharacter();
            Tak.displayCharacter();
        }
        catch (InputValidationException e){
            System.out.println(e.getMessage());
        }


    }
}
