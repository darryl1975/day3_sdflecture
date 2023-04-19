package sg.edu.nus.iss;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // read string/content from argument passed in when running the app
        // e.g. java sg.edu.nus.iss/App arg[0] arg[1] arg[2] ...
        // e.g. java sg.edu.nus.iss/App "c:\data" myfile.txt
        // e.g. java sg.edu.nus.iss/App \\data myfile.txt
        if (args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]); 
            }
        } else {
            System.out.println("You have not pass in any arguments.");
        }

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        // use file object to check if the directory exists
        // create the directory if it doesn't exists
        // Slide 3
        File newDirectory = new File(dirPath);
        if (newDirectory.exists()) {
            System.out.println("Directory " + dirPath + " already created/exists");
        } else {
            newDirectory.mkdir();
        }

        // check whether a file exists in a directory
        // if it doesn't exist, create the file
        File fileData = new File(dirPathFileName);

        if (fileData.exists()) {
            System.out.println(dirPathFileName + " already exists");
        } else {
            fileData.createNewFile();
        }

        String content = "\nI will like to go home early to rest and start coding practice again.";
        String content2 = "\nLet's keep on coding coding coding...";
        FileWriter fileWriter = new FileWriter(dirPathFileName, true);
        fileWriter.write(content);
        fileWriter.write("\n");
        fileWriter.write(content2);
        fileWriter.flush();
        fileWriter.close();

        // another example - a type of decorator pattern
        String content3 = "\nA quick brown fox jumps over the wall.";
        FileWriter fw2 = new FileWriter(dirPathFileName, true);
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.append(content3);
        bw.flush();
        bw.close();
        fw2.close();

        // another example
        String content4 = "\nIts good to buy a macbook with 32GB for your development.";
        FileOutputStream fos = new FileOutputStream(dirPathFileName, true);
        byte[] byteContent = content4.getBytes();
        fos.write(byteContent);
        fos.flush();
        fos.close();

        // another example - with decorator pattern
        String content5 = "\nI am going to buy Apple AirTag this weekend";
        FileOutputStream fos2 = new FileOutputStream(dirPathFileName, true);
        DataOutputStream dos2 = new DataOutputStream(fos2);
        dos2.writeBytes(content5);
        dos2.flush();
        dos2.close();
        fos2.close();

    }
}
