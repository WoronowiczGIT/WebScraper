package services.managing.tasks;

import models.DataModel;
import org.apache.log4j.Logger;
import services.presenting.Presenter;
import services.reading.SiteReader;

import java.io.IOException;
import java.util.List;

public class HtmlElementPresenter implements Runnable{
    private static final Logger logger = Logger.getLogger(HtmlElementPresenter.class.getName());
    private SiteReader reader;
    private Presenter presenter;
    private DataModel model;

    public HtmlElementPresenter(SiteReader reader, Presenter presenter, DataModel model){
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
}
