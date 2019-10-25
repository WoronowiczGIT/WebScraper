package services.taskManagers.tasks;

import models.Data;
import org.apache.log4j.Logger;
import services.presenters.Presenter;
import services.readers.SiteReader;

import java.io.IOException;
import java.util.List;

public class HtmlElementPresenter implements TimedTask {
    private static final Logger logger = Logger.getLogger(HtmlElementPresenter.class.getName());
    private SiteReader reader;
    private Presenter presenter;
    private Data model;

    public HtmlElementPresenter(SiteReader reader, Presenter presenter, Data model) {
        this.reader = reader;
        this.presenter = presenter;
        this.model = model;
    }

    @Override
    public void run() {
        String url = model.getUrl();
        try {
            List<String> elements = reader.fetchElements(url);
            presenter.present(elements);
        } catch (IOException e) {
            logger.error("Failed to execute task.");
            System.exit(-1);
        }
    }

    @Override
    public Long getTime() {
        return Long.parseLong(model.getTime());
    }
}
