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

import org.dakside.booklib.dto.Book;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;

import javax.net.ssl.HttpsURLConnection;

/**
 * Source: GoogleBook
 * http query return a json object
 * 
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class GoogleBookWebApiSearch implements WebSearch {

    private String isbn;
    private Book book;
    private String sourceUrl;

    private final String URL_WEB_SOURCE = "https://www.googleapis.com/books/v1/volumes?q=isbn:";

    public GoogleBookWebApiSearch() {
        this.isbn = "";
        this.sourceUrl = "";
    }

    private boolean isValidString(String inputString) {
        return ((inputString != null) && (!inputString.trim().isEmpty()));
    }

    @Override
    public Book searchByISBN(String isbn) {
        Book book = new Book();
        book.setIsbn(isbn);

        this.sourceUrl = this.URL_WEB_SOURCE + isbn;
        
        try {
            URL urlObj = new URL(this.sourceUrl);

            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            // optional default is GET
            httpCon.setRequestMethod("GET");

            InputStream is = httpCon.getInputStream();

            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray jsonArray = jsonObject.getJsonArray("items");
            JsonString jsonStringInfo;

            if (jsonArray == null) {
                return null;
            }

            JsonObject jsonBookObject = jsonArray.getJsonObject(0);

            if (jsonBookObject == null) {
                return null;
            }

            JsonObject jsonBookInfoObject = jsonBookObject.getJsonObject("volumeInfo");

            if (jsonBookInfoObject == null) {
                return null;
            } else {
                jsonStringInfo = jsonBookInfoObject.getJsonString("title");
                if (jsonStringInfo != null) {
                    if (!this.isValidString(jsonStringInfo.getString())) {
                        return null;
                    } else {
                        book.setTitle(jsonStringInfo.getString());
                    }
                } else {
                    return null;
                }

                JsonArray jsonAuthorArray = jsonBookInfoObject.getJsonArray("authors");

                if ((jsonAuthorArray != null) && (!jsonAuthorArray.isEmpty())) {
                    String authors = "";
                    if (jsonAuthorArray.size() == 1) {
                        authors = jsonAuthorArray.getString(0);
                    } else {
                        int i = 0;
                        while (i < jsonAuthorArray.size() - 1) {
                            authors = authors + jsonAuthorArray.getString(i) + ", ";
                            i++;
                        }
                        authors = authors + jsonAuthorArray.getString(i);
                    }
                    if (this.isValidString(authors)) {
                        book.setAuthor(authors);
                    }
                }

                jsonStringInfo = jsonBookInfoObject.getJsonString("publishedDate");
                if (jsonStringInfo != null) {
                    if (this.isValidString(jsonStringInfo.getString())) {
                        try {
                            book.setYear(Integer.parseInt(jsonStringInfo.getString()));
                        } catch (NumberFormatException ex) {

                        }
                    }
                }

                jsonStringInfo = jsonBookInfoObject.getJsonString("publisher");
                if (jsonStringInfo != null) {
                    if (this.isValidString(jsonStringInfo.getString())) {
                        book.setPublisher(jsonStringInfo.getString());
                    }
                }

                book.setBarcode(isbn);

                jsonStringInfo = jsonBookInfoObject.getJsonString("language");
                if (jsonStringInfo != null) {
                    if (this.isValidString(jsonStringInfo.getString())) {
                        book.setLanguage(jsonStringInfo.getString());
                    }
                }
                
                return book;
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            return null;
        }
    }
}
