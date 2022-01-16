package com.creativerse;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Util {
    public static int pair(int x, int y) {
        double p = 0.5 * (x+y) * (x+y+1) + y;

        return (int) Math.round(p);
    }

    public static int[] unpair(int p) {
        int w = (int) Math.floor((Math.sqrt(8*p + 1) - 1) / 2);
        int t = (int) (0.5 * (Math.pow(w, 2) + w));
        int y = p - t;
        int x = w - y;

        return new int[] {x,y};
    }

    public static String uploadToNftStorage(File file, String API_KEY) throws IOException {
        URL url = new URL("https://api.nft.storage/upload");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST");
        http.addRequestProperty("Authorization", "Bearer " + API_KEY);
        http.setDoOutput(true);

        byte[] b = new byte[(int) file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(b);

        http.connect();
        try(OutputStream out = http.getOutputStream()) {
            out.write(b);
        }

        InputStream input = http.getInputStream(); // THIS IS NEEDED FOR IT TO WORK! AT LEAST HTTP.GETINPUTSTREAM() NEEDS TO BE CALLED! I DONT FUCKING KNOW WHY, JAVA IS A SHIT LANGUAGE. YOU KNOW IN PYTHON THIS SHIT COULD OF BEEN DONE IN LIKE 2-3 LINES OF CODE. OK RANT OVER.
        return new String(input.readAllBytes());
    }
}
