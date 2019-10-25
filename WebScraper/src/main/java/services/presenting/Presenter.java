package services.presenting;

import java.util.List;

public interface Presenter<T> {

    void present(List<T> content);
}
