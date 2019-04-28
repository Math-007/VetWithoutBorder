package VetWithoutBorder.Entities;

public enum AnimalState {
    DEAD    ("decede"),
    ALIVE   ("vivant");
    // vivant  ("vivant");
    private final String stringValue;
    AnimalState(final String s) { stringValue = s; }
    public String toString() { return stringValue; }
}