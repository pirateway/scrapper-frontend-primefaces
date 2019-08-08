package com.pirateway.scrapper.frontend.primefaces.scrapper;

import com.pirateway.scrapper.frontend.primefaces.api.service.IForkService;
import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.pirateway.scrapper.frontend.primefaces.util.ElementsPath.*;

@Component
public class BetScrapper {

    @Autowired
    IForkService forkService;

    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    private final WebDriver driver;

    public BetScrapper() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://positivebet.com/ru/bets/index");
    }

    public void refresh() throws DataValidateException {
        driver.navigate().refresh();
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='gridBets']/table/tbody/tr"));
        int i = 1;
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

           /* System.out.printf("%2d. %-10s %-45s %-10s %-85s %-85s",
                    i,
                    forkType.getAttribute("title"),
                    eventOne,
                    profit.getText(),
                    link1 != null ? link1.getAttribute("href") : "Скрыто!",
                    link2 != null ? link2.getAttribute("href") : "Скрыто!");*/

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

        }
    }

    public void clear() throws DataValidateException {
        forkService.clear();
    }
}
