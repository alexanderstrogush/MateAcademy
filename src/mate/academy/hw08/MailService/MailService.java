package mate.academy.hw08.MailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailModel<T>> {

    private Map<String, List<T>> mailBox = new HashMapMod<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailModel mailModel) {
        if (!mailBox.containsKey(mailModel.getTo())) {
            mailBox.put(mailModel.getTo(), new ArrayList<>());
        }
        mailBox.get(mailModel.getTo()).add((T) mailModel.getContent());
    }
}
