package mate.academy.hw10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        Optional<String> optInput = getInputData();
        String inputData = "";
        if (optInput.isPresent()) {
            inputData = optInput.get();
        }
        dataProcessing(inputData);
    }

    private static Optional<String> getInputData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Optional.of(reader.readLine());
        } catch (IOException e) {
            System.out.println("Fatal error");
        }
        return Optional.empty();
    }

    private static void dataProcessing(String inputData) {
        Map<String, Integer> words = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(inputData);
        while (matcher.find()) {
            String key = matcher.group().toLowerCase();
            if (words.containsKey(key)) {
                words.put(key, words.get(key) + 1);
            } else {
                words.put(key, 1);
            }
        }
        words.keySet().stream()
                .peek(String::toLowerCase)
                .sorted(Comparator.naturalOrder())
                .sorted(((o1, o2) -> words.get(o2) - words.get(o1)))
                .limit(10)
                .forEach(System.out::println);
    }
}