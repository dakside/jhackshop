/*
 * Copyright (C) 2016 Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dakside.booklib.search;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dakside.booklib.dto.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Source: Minh Khai Store
 * http query return html
 * 
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class MinhKhaiWebApiSearch implements WebSearch {

    private String isbn;
    private Book book;
    private String sourceUrl;

    private final String URL_WEB_SOURCE = "http://www.minhkhai.com.vn/store2/index.aspx?q=view&isbn=";

    public MinhKhaiWebApiSearch() {
        this.isbn = "";
        this.sourceUrl = "";
    }

    public MinhKhaiWebApiSearch(String sourceUrl) {
        this.isbn = "";
        this.sourceUrl = sourceUrl;
    }

    @Override
    public Book searchByISBN(String isbn) {
        Book book = new Book();

        this.sourceUrl = this.URL_WEB_SOURCE + isbn; // actual link
        //this.sourceUrl = isbn + ".html"; // for testing locally

        //File input = new File(this.sourceUrl); // for testing locally
        Document doc;

        try {
            //doc = Jsoup.parse(input, "UTF-8", ""); // for testing locally
            doc = Jsoup.connect(this.sourceUrl).get(); // actual link

            //Elements tables = doc.getElementsByTag("table"); 
            
            Element table = doc.getElementsByTag("table").first(); // Get the book information in the table tag (there is most likely only 1 table)
            if (table == null)
                return null;

            //Elements mainInfoTemp = table.getElementsByTag("td"); // Get each row of the table

            Element mainInfo = table.getElementsByTag("td").get(1); // the second row contains the required information
            if (mainInfo == null)
                return null;

            Elements infoListByBTag = mainInfo.getElementsByTag("b"); // get each piece of information by "b" tag
            if (infoListByBTag==null)
                return null;

            // Title;
            book.setTitle(infoListByBTag.first().text().replaceAll("[\\(\\)\\-\\_\\:\\^\\*\\$\\#]", "")); // first <b> tag contains the title

            String mainInfoText = mainInfo.text(); // convert the main information to string

            mainInfoText = mainInfoText.replaceFirst(infoListByBTag.first().text(), "").trim();

            // to get authors' name
            Elements infoListByATag = mainInfo.getElementsByTag("a"); // authors and translators' names just after the first <b> tag with hyperlink
            String author = "";
            for (Element info : infoListByATag) {
                if (!info.text().trim().isEmpty()) {
                    String tempAuthor = "Tác giả: " + info.text().trim();

                    if (mainInfoText.contains(tempAuthor)) {
                        author += this.processSpecialCharacters(info.text());
                    } else {
                        //System.out.println(tempAuthor);
                    }
                    String[] translatorTitle = {"Dịch: ", "Người dịch: ", "Dịch giả: "};
                    for (String translator : translatorTitle) {
                        tempAuthor = translator + info.text().trim();
                        if (mainInfoText.contains(tempAuthor)) {
                            author = author + ", " + this.processSpecialCharacters(info.text());
                            break;
                        }
                    }
                }
            }
            book.setAuthor(author);

            book.setLanguage("vn");
            book.setIsbn(isbn);
            book.setBarcode(isbn);
            
            // get publiser and year
            int yearIdxBTag=0;
            for (Element info : infoListByBTag) {
                //System.out.println(temp);
                if (info.text().toLowerCase().contains("nxb:")) {
                    for (Element info2 : infoListByATag) {
                        if (!info2.text().trim().isEmpty()) {
                            if (mainInfoText.contains("NXB: " + info2.text())) {
                                book.setPublisher(info2.text());
                            }
                        }
                    }
                }
                if (info.text().toLowerCase().contains("xuất bản:")) {
                    yearIdxBTag = infoListByBTag.indexOf(info);
                }
            }
            
            int yearIdxStart = mainInfoText.indexOf(infoListByBTag.get(yearIdxBTag).text()) + infoListByBTag.get(yearIdxBTag).text().length();
            int yearIdxEnd = mainInfoText.indexOf(infoListByBTag.get(yearIdxBTag+1).text());
            String yearString = mainInfoText.substring(yearIdxStart, yearIdxEnd).trim();
            //System.out.println("Year: " + yearString.split("/")[yearString.split("/").length-1]);
            try {
                book.setYear(Integer.parseInt(yearString.split("/")[yearString.split("/").length-1]));
            }
            catch (NumberFormatException ex){
                book.setYear(0);
            }
            catch (NullPointerException ex) {
                book.setYear(0);
            }
            /*
            System.out.println("B tags:");
            for (Element info : infoListByBTag) {
                System.out.println(info.toString());
            }
            System.out.println("----------------------------");
            System.out.println(book.toString());
            //*/
            return book;
        } catch (IOException ex) {
            return null;
        }

        //return book;
    }

    private String processSpecialCharacters(String inputString) {
        String tempStr = inputString.trim().replaceAll("&", ",");

        return tempStr.replaceAll("[\\(\\)\\-\\_\\:\\^\\*\\$\\#]", "");
    }
}
