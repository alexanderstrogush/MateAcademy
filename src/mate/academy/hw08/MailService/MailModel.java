package mate.academy.hw08.MailService;

public interface MailModel<T> {

    String getFrom();

    String getTo();

    T getContent();
}
