package lv.rvt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RandomWordGenerator {
    private static final String API_URL = "https://random-word-api.vercel.app/api?words=1&length=5";

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to generate a new word. Type 'exit' to return to the menu.");

        while (true) {
            String input = scanner  .nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                String word = fetchRandomWord();
                String savedword = word;
                System.out.println("Generated word hidden: " + word.replaceAll(".", "_"));
                System.out.println("Generated word: " + savedword);
            } catch (IOException | InterruptedException e) {
                System.out.println("Failed to fetch word: " + e.getMessage());
            }
        }
    }

    private String fetchRandomWord() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().replace("[", "").replace("]", "").replace("\"", "");
    }
}
