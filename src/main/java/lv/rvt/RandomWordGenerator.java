package lv.rvt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RandomWordGenerator {
    private static final String API_URL = "https://random-word-api.vercel.app/api?words=1&length=5";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to generate a new word. Type 'exit' to quit.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                String word = fetchRandomWord();
                System.out.println(word);
            } catch (IOException | InterruptedException e) {
                System.out.println("Failed to fetch word: " + e.getMessage());
            }
        }
    }

    private static String fetchRandomWord() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().replace("[", "").replace("]", "").replace("\"", "");
    }
}