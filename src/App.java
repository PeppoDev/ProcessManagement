import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProcessQueue queue = new ProcessQueue(32);

        System.out.println("You have an array that simulates a memory of a PC " +
                "(Limit = 32 process at the same time). How many process do you want create?");

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        for (int i = 0; i < len; i++) {
            String randomWord = Utils.generateRandomWord();
            System.out.println(randomWord);
            new Node(randomWord, queue);
        }
    }
}
