import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Scanner make it! THIS IS REALLY IMPORTANT wasn't working without it

        //also go thorugh everything the spacing is makeing it hard to read
        //check the getnonoserolengthstring for some reason there is an error message
        //also ask talk to camron tommorow
        ArrayList<String> records = new ArrayList<>(); //array here
        //variables
        int counter = 1;
        int birthyear = 0;
        boolean done = false;
        do {
            // get info
            // check the birth again acting strange
            String firstName = SafeInput.getNonZeroLengthString(in, "Enter First Name:");
            String lastName = SafeInput.getNonZeroLengthString(in, "Enter Last Name:");
            String email = SafeInput.getNonZeroLengthString(in, "Enter Email:");
            birthyear = SafeInput.getRangedInt(in, "Enter Year of Birth:", 1900, 2025);
            String id = String.format("%06d", counter);
            // list add supposed
            String record = String.format("%s,%s,%s,%s,%d", firstName, lastName, id, email, birthyear);
            records.add(record);
            counter++;
            // y/n isn't working? check tommorrow mabye im not writting something correctly
            done = !SafeInput.getYNConfirm(in, "Add another record?");
        } while (!done);
        String fileName = SafeInput.getNonZeroLengthString(in, "Enter filename (no extension):") + ".csv";

        File workingDir = new File(System.getProperty("user.dir"));
        Path file = new File(workingDir + "/src/" + fileName).toPath();

        try { //try try agian. look at the notes this is confusign me

            BufferedWriter writer = Files.newBufferedWriter(file, CREATE);
            PrintWriter out = new PrintWriter(writer);
            for (String rec : records) {
                out.println(rec);
            }
            out.close();
            System.out.println("Data saved to " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();  //error mes masson said this won't work check again later
        }
    }
}