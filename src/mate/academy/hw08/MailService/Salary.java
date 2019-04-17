package mate.academy.hw08.MailService;

public class Salary implements MailModel<Integer> {

    private String fromWho;
    private String toWho;
    private int salary;

    public Salary(String fromWho, String toWho, int salary) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.salary = salary;
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
    public Integer getContent() {
        return salary;
    }
}
