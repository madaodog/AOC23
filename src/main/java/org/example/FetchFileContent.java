package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchFileContent {

    String fileURL;
    String sessionCookie;


    public FetchFileContent(String fileURL, String sessionCookie) {
        this.fileURL = fileURL;
        this.sessionCookie = sessionCookie;
    }

    public String read() throws IOException {
        URL url = new URL(this.fileURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Cookie", "session=" + this.sessionCookie);

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line).append("\n");
                }
                return response.toString();
            }
        } else {
            System.out.println(conn.getResponseCode());
            return null;
        }
    }

}
