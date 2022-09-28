public class Player {
    private String name;
    private Character chosenCharacter;

    public Player(String name,Character character) {
        this.name=name;
        this.chosenCharacter=character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Character getChosenCharacter() {
        return chosenCharacter;
    }

    public void setChosenCharacter(Character chosenCharacter) {
        this.chosenCharacter = chosenCharacter;
    }
}
