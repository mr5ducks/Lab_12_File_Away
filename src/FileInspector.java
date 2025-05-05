import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    //everything worked suprising well this time
    //thsi code need a recheck thogh type psvm so it looks well structured.
    public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser(new File("src"));
    chooser.setDialogTitle("Select a Text File");
    int result = chooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = chooser.getSelectedFile();
        int Line = 0;
        int Word = 0;
        int Chara = 0;
        System.out.println("Reading File Contents:\n");

            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // Echo line
                Line++;

                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                        Word += words.length;
                    }
                Chara += line.length();
                }
                System.out.println("File name: " + selectedFile.getName());
                System.out.println("Number of lines= " + Line);
                System.out.println("Number of words= " + Word);
                System.out.println("Number of characters= " + Chara);
            } catch (IOException e) {
                System.err.println("Error reading the file= " + e.getMessage());
            }

        }
    }
}
