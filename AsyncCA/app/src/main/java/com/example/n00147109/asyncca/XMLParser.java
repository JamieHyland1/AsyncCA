package com.example.n00147109.asyncca;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by N00147109 on 23/02/2017.
 */
public class XMLParser {

    public static List<Stock> parseFeed(String content) {


        List<Stock> stockList;
        try {
            Boolean inDataItemTag = false;

            String currentTag = " ";

            Stock stock = null;

            stockList = new ArrayList<>();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(new StringReader(content));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTag = parser.getName();

                        if (currentTag == "Stock") {
                            inDataItemTag = true;
                            Stock stock1 = new Stock();
                            stockList.add(stock1);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName() == "Stock") {
                            inDataItemTag = false;
                        }
                        currentTag = "";
                        break;
                    case XmlPullParser.TEXT:
                        if (inDataItemTag && stock != null) {
                            switch (currentTag) {
                                case "Ticker":
                                    stock.setTicker(parser.getText());
                                    break;
                                case "Date":
                                    stock.setDate(parser.getText());
                                    break;
                                case "High":
                                    stock.setHigh(Double.parseDouble(parser.getText()));
                                    break;
                                case "Low":
                                    stock.setLow(Double.parseDouble(parser.getText()));
                                    break;
                                case "Open":
                                    stock.setOpen(Double.parseDouble(parser.getText()));
                                    break;
                                case "Close":
                                    stock.setClose(Double.parseDouble(parser.getText()));
                                    break;
                            }
                        }
                        break;
                }
                eventType = parser.next();


            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
        return stockList;


        //  return null;
    }
}
