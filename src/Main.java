import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Main
{
    public static void main(String[] args)
    {
        int lineCounter = 0;
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        int character = 0;
        int words = 0;
        String fileName;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);

                while(inFile.hasNextLine())
                {
                    //Keeps track of no. of lines
                    lineCounter++;
                    line = inFile.nextLine();
                    System.out.println(line);
                    //Keeps track of no. of characters
                    character = character + line.length();

                    //Keeps track of no. of words
                    words = words + line.split("\\s").length;
                }

                System.out.println();

                //Gets the name of the file and prints it
                try {
                    fileName = target.toFile().getName();
                    System.out.println("The name of the file is" +fileName);
                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                }


                inFile.close();

                System.out.println("There are " +lineCounter +" lines in this file.");
                System.out.println("There are " +words +" words in this file.");
                System.out.println("There are " +character +" characters in this file.");

            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}