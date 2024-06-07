package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public boolean load() {
        try (Scanner input = new Scanner(Paths.get(file))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split(":");
                this.dictionary.putIfAbsent(parts[0], parts[1]);
                this.dictionary.putIfAbsent(parts[1], parts[0]);
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean save() {
        ArrayList<String> words = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(this.file)) {
            for (String key : this.dictionary.keySet()) {
                if (!(words.contains(key))) {
                    String translation = this.dictionary.get(key);
                    words.add(translation);
                    writer.println(key + ":" + translation);
                }
            }
            writer.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
        this.dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        return this.dictionary.get(word);
    }

    public void delete(String word) {
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(this.dictionary.get(word));
            this.dictionary.remove(word);
        }
    }

}
