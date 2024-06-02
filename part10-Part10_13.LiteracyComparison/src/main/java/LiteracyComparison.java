
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {

        List<Literacy> literacyList = new ArrayList<>();

        try {

            literacyList = Files.lines(Paths.get("literacy.csv"))
                    .map(line -> {
                        String[] parts = line.split(",");
                        String gender = parts[2].trim().replace(" (%)", "");
                        return new Literacy(parts[0].trim(),
                                parts[1].trim(),
                                gender,
                                parts[3].trim(),
                                Integer.valueOf(parts[4]),
                                Double.valueOf(parts[5]));
                    })
                    .sorted()
                    .collect(Collectors.toList());

            literacyList.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
