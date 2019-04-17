package mate.academy.hw08.MailService;

public class MailMessage implements MailModel<String> {

    private String fromWho;
    private String toWho;
    private String content;

    public MailMessage(String fromWho, String toWho, String content) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return fromWho;
    }

    @Override
    public String getTo() {
        return toWho;
    }

    @Override
    public String getContent() {
        return content;
    }
}
