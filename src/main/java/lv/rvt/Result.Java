package lv.rvt;

public class Result {
    private static final String FILE_NAME = "data.csv";

    public static void saveResult(boolean success, int attempts, String correctWord, String lastGuess) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            String timestamp = LocalDateTime.now().toString();
            writer.write(String.format("%s,%s,%d,%s,%s\n", 
                timestamp, 
                success ? "WIN" : "LOSE", 
                attempts, 
                correctWord, 
                lastGuess));
        } catch (IOException e) {
            System.out.println("Failed to save result: " + e.getMessage());
        }
    }
}
