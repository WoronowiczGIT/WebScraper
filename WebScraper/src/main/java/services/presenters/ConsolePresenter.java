package services.presenters;

import java.util.List;

public class ConsolePresenter implements Presenter {

    @Override
    public void present(List content) {
        content.forEach(System.out::println);
    }
}
