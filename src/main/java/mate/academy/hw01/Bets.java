package mate.academy.hw01;

public class Bets {
    public static void main(String[] args) {
        System.out.println(footballGame(3, 1, 3, 1)); // 2
        System.out.println(footballGame(3, 1, 2, 0)); // 1
        System.out.println(footballGame(3, 1, 1, 2)); // 0
        System.out.println(footballGame(1, 2, 1, 2)); // 2
        System.out.println(footballGame(1, 2, 0, 1)); // 1
        System.out.println(footballGame(1, 2, 0, 0)); // 0
        System.out.println(footballGame(2, 2, 0, 0)); // 1
    }

    private static int footballGame(int scoreA, int scoreB, int betA, int betB) {
        int result = ((scoreA == betA) && (scoreB == betB)) ? 2 : ((scoreA < scoreB) == (betA < betB)) ? 1 : 0;
        return result;
    }
}
