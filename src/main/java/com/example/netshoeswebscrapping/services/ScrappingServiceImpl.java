package com.example.netshoeswebscrapping.services;

import com.example.netshoeswebscrapping.entities.Product;
import com.example.netshoeswebscrapping.exceptions.InvalidUrlException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ScrappingServiceImpl implements ScrappingService{
    @Override
    public Product fetchProduct(String url) throws IOException, InvalidUrlException {
        if(!url.contains("https://www.netshoes.com.br/")) {
            throw new InvalidUrlException("Invalid URL", 400);
        }

        Document document = Jsoup.connect(url).get();

        String title = fetchTitle(document);
        Double price = fetchPrice(document);
        String imageUrl = fetchImageUrl(document);
        String description = fetchDescription(document);

        return new Product(title, price, imageUrl, description);

    }


    private String fetchTitle(Document document) {
        Element element = document.getElementsByClass("short-description").first();
        Element titleTag = element.getElementsByTag("h1").first();
        return titleTag.text();
    }
    private Double fetchPrice(Document document) {
        Element element = document.getElementById("hiddenPriceSaleInCents");
        return Double.parseDouble(element.val()) / 100;
    }
    private String fetchImageUrl(Document document) {
        Element element = document.getElementsByClass("photo-figure").first();
        Element image = element.getElementsByTag("img").first();
        return image.attr("src");

    }
    private String fetchDescription(Document document) {
        Element element = document.getElementById("features");
        Element descriptionElement = element.getElementsByTag("p").first();
        return descriptionElement.text();
    }
}
