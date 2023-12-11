import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        String FILE_NAME = "C:\\Users\\denaa\\JavaProjects231\\practice2\\src\\data.txt", FILE_NAME1 = "C:\\Users\\denaa\\JavaProjects231\\practice2\\src\\output.txt";
        ArrayList<String> lines = new ArrayList<>();
        Map<String, String[]> sortedMap = new TreeMap<>();

        try (Scanner input = new Scanner(new File(FILE_NAME))) {
            while (input.hasNextLine()) {
                String New = input.nextLine();
                lines.add(New);
            }
            for (String line : lines)
                System.out.println(line);
        } catch (FileNotFoundException e) {
            System.err.format("File not found: %s%n", FILE_NAME);
        }
        for (String line : lines) {
            String[] splitter = line.split(" ");
            System.out.println(Arrays.toString(splitter));

            String[] arr = {};

            String[] array = sortedMap.getOrDefault(splitter[0],arr);
            String o;
            o = splitter[1];


            String[] newArray = Arrays.copyOf(array, array.length + 1);
            System.out.println(Arrays.toString(newArray));

            newArray[newArray.length - 1] = String.valueOf(o.charAt(3));
            System.out.println(Arrays.toString(newArray));


            sortedMap.put(splitter[0], newArray);
        }
        PrintWriter write;
        try {
            new FileWriter(FILE_NAME1, false).close();
            write = new PrintWriter(new FileWriter(FILE_NAME1, true));
            for (Map.Entry<String, String[]> entry : sortedMap.entrySet()) {
                System.out.println(Arrays.toString(entry.getValue()));
                write.print(entry.getKey()+"  ");
                write.println(Arrays.toString(entry.getValue()));
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
