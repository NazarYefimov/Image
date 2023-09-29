package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter HTTP status code: ");
            int code = scanner.nextInt();

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(code);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Очистити буфер введення
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
