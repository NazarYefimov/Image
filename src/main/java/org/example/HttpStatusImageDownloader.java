package org.example;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String imageUrl = checker.getStatusImage(code);

            // Використовуємо java.net.URL для завантаження картинки
            URL url = new URL(imageUrl);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(code + ".jpg");

            byte[] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Картинка була завантажена та збережена як " + code + ".jpg");
        } catch (Exception e) {
            throw new Exception("Не вдалося завантажити картинку: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try {
            downloader.downloadStatusImage(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            downloader.downloadStatusImage(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
