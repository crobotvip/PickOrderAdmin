package com.crobot.pickorderadmin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getJsoupTest() throws Exception{
        Document doc= (Document) Jsoup.connect("http://blog.csdn.net/crobot007").post();
        Elements items = doc.select("span.link_title>a[href]");
        Elements items_detail = doc.select("div.article_description");
        Elements items_read_count = doc.select("span.link_view");
        System.out.println(doc.toString());

    }
}