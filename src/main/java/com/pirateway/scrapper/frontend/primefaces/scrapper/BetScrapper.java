package com.pirateway.scrapper.frontend.primefaces.scrapper;

import com.pirateway.scrapper.frontend.primefaces.api.service.IForkService;
import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.pirateway.scrapper.frontend.primefaces.util.ElementsPath.*;

@Component
public class BetScrapper {

    @Autowired
    IForkService forkService;

    public BetScrapper() throws IOException {
        Document doc = Jsoup.connect("https://positivebet.com/ru/bets/index/").get();

        Elements rows = doc.select("div#gridBets.grid-view").select("tbody");
        for (Element row : rows.select("tr")) {
            String forkType = row.select("td").get(0).select("a").get(2).select("img").attr("alt");
            //String forkAge = row.select("td").get(1).select
            System.out.println(forkType);
        }
    }

    public void refresh() throws DataValidateException, IOException {
        Document doc = Jsoup.connect("https://positivebet.com/ru/bets/index/").get();
        Elements rows = doc.select("div#gridBets.grid-view");
        for (Element element : rows.select("tr")) {
            System.out.println(element.text());
        }
                //driver.findElements(By.xpath("//div[@id='gridBets']/table/tbody/tr"));
        /*int i = 1;
        System.out.printf("%2s. %-10s %-45s %-10s %-85s %-85s", " №", "Вид", "Событие", "% дохода", "Ссылка1", "Ссылка2");
        System.out.println();
        for (WebElement row : rows) {
            WebElement forkType = row.findElement(By.xpath(FORK_TYPE));
            WebElement forkAge = row.findElement(By.xpath(FORK_AGE));
            WebElement profit = row.findElement(By.xpath(PROFIT_PERCENT));
            String eventOne, eventTwo;
            WebElement bk1, bk2, link1, link2, coefficient1, coefficient2, move1, move2, fork1, fork2;

            bk1 = row.findElement(By.xpath(EVENT_ONE_BK_NAME));
            bk2 = row.findElement(By.xpath(EVENT_TWO_BK_NAME));
            coefficient1 = row.findElement(By.xpath(EVENT_ONE_COEFFICIENT));
            coefficient2 = row.findElement(By.xpath(EVENT_TWO_COEFFICIENT));
            move1 = row.findElement(By.xpath(EVENT_ONE_MOVING));
            move2 = row.findElement(By.xpath(EVENT_TWO_MOVING));
            fork1 = row.findElement(By.xpath(EVENT_ONE_FORKS_COUNT));
            fork2 = row.findElement(By.xpath(EVENT_TWO_FORKS_COUNT));


            try {
                eventOne = row.findElement(By.xpath(EVENT_ONE_DESCRIPTION_PART_ONE)).getText() +
                        row.findElement(By.xpath(EVENT_ONE_DESCRIPTION_PART_TWO)).getText();

                eventTwo = row.findElement(By.xpath(EVENT_TWO_DESCRIPTION_PART_ONE)).getText() +
                        row.findElement(By.xpath(EVENT_TWO_DESCRIPTION_PART_TWO)).getText();

                link1 = row.findElement(By.xpath(EVENT_ONE_LINK));
                link2 = row.findElement(By.xpath(EVENT_TWO_LINK));


            } catch (Exception e) {
                eventOne = "Скрыто!";
                eventTwo = "Скрыто!";

                link1 = null;
                link2 = null;
            }

           *//* System.out.printf("%2d. %-10s %-45s %-10s %-85s %-85s",
                    i,
                    forkType.getAttribute("title"),
                    eventOne,
                    profit.getText(),
                    link1 != null ? link1.getAttribute("href") : "Скрыто!",
                    link2 != null ? link2.getAttribute("href") : "Скрыто!");*//*

            i++;
            //System.out.println();

            Fork fork = new Fork(
                    String.valueOf(i),
                    "",
                    forkType.getAttribute("alt"),
                    forkAge.getText(),
                    profit.getText());

            fork.setEventOneBk("1) "+bk1.getText());
            fork.setEventOneDescription("1) "+eventOne);
            fork.setEventOneCoefficient("1) "+coefficient1.getText());
            fork.setEventOneLink(link1 != null ? link1.getAttribute("href") : "https://yandex.ru/!");

            fork.setEventTwoBk("2) "+bk2.getText());
            fork.setEventTwoDescription("2) "+eventTwo);
            fork.setEventTwoCoefficient("2) "+coefficient2.getText());
            fork.setEventTwoLink(link2 != null ? link2.getAttribute("href") : "https://yandex.ru/!");


            forkService.create(fork);

        }*/
    }

    public void clear() throws DataValidateException {
        forkService.clear();
    }
}
