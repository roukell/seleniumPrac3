package PDFautomation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PDFautomation {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "//Users//yi-linglo//Documents//webDrivers//chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void verifyContentInPDF() {
        // PDF URL
        String url = "http://www.pdf995.com/samples/pdf.pdf";
        driver.get(url);

        try {
            String pdfContent = readPdfContent(url);
            Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"));
        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public static String readPdfContent(String url) throws IOException {
        URL pdfURL = new URL(url);
        InputStream in = pdfURL.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = getPageCount(doc);
        System.out.println("Total pages: " + numberOfPages);
        String content = new PDFTextStripper().getText(doc);
        doc.close();

        return content;
    }

    public static int getPageCount(PDDocument doc) {
        int pageCount = doc.getNumberOfPages();
        return pageCount;
    }
}
