package VetWithoutBorder.Entities;

public enum AnimalType {
    DOG     ("Chien"),
    CAT     ("Chat"),
    RABBIT  ("Lapin"),
    BIRD    ("Oiseau"),
    FERRET  ("Furret"),
    HORSE   ("Cheval"),
    MOUSE   ("Souris"),
    HAMSTER ("Hamster"),
    RACCOON ("Raton");
    private final String stringValue;
    AnimalType(final String s) { stringValue = s; }
    public String toString() { return stringValue; }
}