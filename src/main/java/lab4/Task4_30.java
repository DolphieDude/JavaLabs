package lab4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Task4_30 {

    static class TextFile {
        private final String path;

        private final String description;

        public TextFile(String path, String description) {
            this.path = path;
            this.description = description;
        }

        public String getPath() {
            return path;
        }

        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        HashMap<String, TextFile> files = new HashMap<>();
        TreeSet<String> pathSet = new TreeSet<>();

        String keyToPut = "task4_4";
        files.put(keyToPut, new TextFile("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\Java\\folder\\task4_4.txt",
                "Create an application for viewing a list of items and adding items to the list"));
        pathSet.add(files.get(keyToPut).getPath());

        keyToPut = "task4_15";
        files.put(keyToPut, new TextFile("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\Java\\folder\\task4_15.txt",
                "Create an application for buying products in a store with delivery."));
        pathSet.add(files.get(keyToPut).getPath());

        keyToPut = "task4_26";
        files.put(keyToPut, new TextFile("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\Java\\folder\\anotherfolder\\task4_26.txt",
                "Create an application for adding products and viewing the list of electronic store products."));
        pathSet.add(files.get(keyToPut).getPath());

        keyToPut = "task4_30";
        files.put(keyToPut, new TextFile("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\Java\\folder\\anotherfolder\\task4_30.txt",
                "Create an application to search in a list of files and delete a file from the list."));
        pathSet.add(files.get(keyToPut).getPath());

        keyToPut = "testlab4";
        files.put(keyToPut, new TextFile("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\Java\\folder\\anotherfolder\\testlab4.txt",
                "Tests for lab4."));
        pathSet.add(files.get(keyToPut).getPath());

        String input;
        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current files:");
            for (String name: files.keySet()) {
                System.out.println(name + ": " +
                                   files.get(name).getPath() + " - " + files.get(name).getDescription());
            }

            System.out.print("Choose file by name: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (!files.containsKey(input)) {
                System.out.println("Wrong input");
                continue;
            }
            key = input;

            System.out.print("Open or delete?: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("open")) {
                ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Notepad++\\notepad++.exe",
                        files.get(key).getPath());
                try {
                    pb.start();
                } catch (IOException e) {
                    System.out.println("File doesn't exist");
                }
            } else if (input.equalsIgnoreCase("delete")) {
                files.remove(key);
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Wrong input");
            }

        }
    }
}
