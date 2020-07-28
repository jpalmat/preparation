package string;

public class RemoveSpecialCharacter {
    public static String removeCharacter(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", " ");
    }
}
