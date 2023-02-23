package utils;

public class Comment {
    private int counter = 1;
    public void printStep(String message) {
        System.out.println("STEP " + counter + ": " + message.toUpperCase());
        counter++;
    }
}
