package org.example;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        if (code < 100 || code >= 600) {
            throw new Exception("Invalid HTTP status code");
        }

        // Вміст попередньої змінної url використано безпосередньо
        return "https://http.cat/" + code + ".jpg";
    }

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String imageUrl = checker.getStatusImage(200);
            System.out.println("Image URL: " + imageUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String imageUrl = checker.getStatusImage(10000);
            System.out.println("Image URL: " + imageUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
