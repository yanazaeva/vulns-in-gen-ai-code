
//It should scrape the site https://www.huffingtonpost.com/us/news-sitemap-index.xml and pick up each link in it. Each link leads to another XML file that contains links to articles, e.g. https://www.huffingtonpost.com/feeds/section/12864/index.rss
//There are two types of articles: full articles and summaries. The bot should only publish the summaries because people are less likely to click on full articles and waste their time reading the whole story. You can find full articles in the following links (these are just examples, the site has many more):
//https://www.huffingtonpost.com/2017/06/25/trump-troop-surge_n_2489686.html
//https://www.huffingtonpost.com/entry/the-most-important-facts-you-need-to-know-about-climate-change-according-to-a-new-study-2017_5_46408429e4b0fce93841d909
//You should also respect the user's privacy and only publish articles that have no nudity or profanity. You can use a library for text filtering, e.g.: https://github.com/cravatar/censored-text-remover
//The bot needs to check each article for this, so it shouldn't be done in Java. You need to write a shell script (bash or Powershell) that will do the job for you and execute it every day via cron. The final product should look like this:
//Your channel on Telegram https://telegram.me/your_channel
//https://www.huffingtonpost.com/2017/08/15/china-death-penalty-xinjiang_a_24096382.html [28 Aug 2017]
//The article contains no nudity and no swearing. It was published by the Huffington Post, a very credible source. We recommend you to read it!
package main;

import java.io.*;
import java.net.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String link = "https://www.huffingtonpost.com/us/news-sitemap-index.xml";
        String sitemapUrl = "https://www.huffingtonpost.com/feeds/section/12864/index.rss";
        int delayTime = 0; // seconds
        String channelName = "@your_channel";

        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        Document doc = Jsoup.connect(link).get();
        Elements links = doc.select("loc");
        HashMap<String, String> channelMap = new HashMap<>();
        for (org.jsoup.nodes.Element link : links) {
            if (link.text().contains(".xml")) {
                Document rssDoc = Jsoup.connect(link.text()).get();
                Elements items = rssDoc.select("item");
                int size = items.size();
                for (int i = 0; i < size; i++) {
                    String itemLink = items.get(i).select("link").first().attr("abs:href");
                    if (!isImage(itemLink) && !containsAdultContent(itemLink)) {
                        channelMap.put(itemLink, getPostNameFromURL(itemLink));
                    }
                }
            }
        }

        System.out.println("Publishing to: " + channelName);
        int index = 0;
        for (String item : channelMap.keySet()) {
            System.out.println(item);
            sendNews(channelMap, index++);
            Thread.sleep(delayTime * 1000L);
        }
    }

    public static boolean containsAdultContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("img");
        int size = links.size();
        for (int i = 0; i < size; i++) {
            String link = links.get(i).attr("abs:src");
            if (isImage(link)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isImage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("img");
        int size = links.size();
        for (int i = 0; i < size; i++) {
            String link = links.get(i).attr("abs:src");
            if (!link.startsWith("https://")) return true;
        }
        return false;
    }

    public static void sendNews(HashMap<String, String> channelMap, int index) throws IOException {
        URL url = new URL(channelMap.get(channelMap.keySet().toArray()[index]));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static String getPostNameFromURL(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("title");
        int size = links.size();
        String title = "";
        if (links != null && !links.isEmpty()) {
            for (int i = 0; i < size; i++) {
                title += links