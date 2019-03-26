package mate.academy.hw01;

public class Diamond {
    public static void main(String[] args) {
        drawDiamond(9);
        System.out.println();
        drawDiamond(6);
    }

    private static void drawDiamond(int maxCountCharacters) {
        int j = 1;
        for (int i = maxCountCharacters; i > 0; i -= 1, j += 1) {
            drawLine(" ", i);
            drawLine("* ", j);
            System.out.println();
        }
        j = maxCountCharacters - 1;
        for (int i = 2; i <= maxCountCharacters; i += 1, j -= 1) {
            drawLine(" ", i);
            drawLine("* ", j);
            System.out.println();
        }
    }

    private static void drawLine(String character, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(character);
        }
    }
}
