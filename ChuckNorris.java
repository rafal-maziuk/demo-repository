package weekend_12_13_XX.zad_1_ChuckNorris;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChuckNorris {
    public static void main(String[] args) {
        Set<String> jokeIds = new HashSet<>();
        while (jokeIds.size() < 10) {
            Joke joke = downloadJoke();
            if (!jokeIds.contains(joke.getId())) {
                jokeIds.add(joke.getId());
                System.out.println(joke.getValue());
            }
        }
    }

    private static Joke downloadJoke() {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Chrome");
            try (InputStream inputStream = urlConnection.getInputStream()) {
                Scanner scanner = new Scanner(inputStream);
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    sb.append(line);
                }

                Gson gson = new Gson();
                return gson.fromJson(sb.toString(), Joke.class);
            }
        } catch (IOException e) {
            System.err.println("Pobieranie żartu zakończone niepowodzeniem!");
            e.printStackTrace();
        }
        return null;
    }
}