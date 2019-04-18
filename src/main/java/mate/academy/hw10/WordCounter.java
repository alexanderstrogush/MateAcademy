package mate.academy.hw10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(reader.readLine());
            while (matcher.find()) {
                String key = matcher.group().toLowerCase();
                if (words.containsKey(key)) {
                    words.put(key, words.get(key) + 1);
                } else {
                    words.put(key, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        words.keySet().stream()
                .peek(String::toLowerCase)
                .sorted(Comparator.naturalOrder())
                .sorted(((o1, o2) -> words.get(o2) - words.get(o1)))
                .limit(10)
                .forEach(System.out::println);
    }
}