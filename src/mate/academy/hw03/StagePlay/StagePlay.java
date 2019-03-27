package mate.academy.hw03.StagePlay;

public class StagePlay {

    public static StringBuilder printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();

        for (String role : roles) {
            result.append(role)
                    .append(":\n")
                    .append(printActorReplics(role, textLines))
                    .append("\n");
        }
        return result;
    }

    public static StringBuilder printActorReplics(String role, String[] textLines) {
        StringBuilder replic = new StringBuilder();
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].startsWith(role + ":")) {
                replic.append(i + 1)
                        .append(")")
                        .append(textLines[i].substring(role.length() + 1))
                        .append("\n");

            }
        }
        return replic;
    }
}
