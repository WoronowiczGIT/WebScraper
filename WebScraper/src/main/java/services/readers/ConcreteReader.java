package services.readers;

import configuration.Configuration;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteReader implements SiteReader {
    private static final Logger logger = Logger.getLogger(ConcreteReader.class.getName());
    private final String htmlTag = Configuration.get().getHtmlElement();
    private final Boolean enableMultipleElements = Configuration.get().getEnableMultipleElements();

    @Override
    public List<String> fetchElements(String url) throws IOException {
        List<String> result = new ArrayList<>();

        Document doc = fetchDocument(url);
        logger.info("Document fetched.");

        if (enableMultipleElements) {
            result.add(fetchFirst(doc));
        } else {
            result.addAll(fetchAll(doc));
        }

        logger.info("Html elements fetched.");
        return result;
    }

    private Document fetchDocument(String url) throws IOException {
        return Jsoup.connect(url)
                .followRedirects(true)
                .get();
    }

    private String fetchFirst(Document document) {
        return document
                .select(htmlTag)
                .first()
                .text();
    }

    private List<String> fetchAll(Document document) {
        Elements elements = document.select(htmlTag);
        return elements
                .stream()
                .map(e -> e.text())
                .collect(Collectors.toList());
    }

}
