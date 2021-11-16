import java.io.*;
import java.text.DecimalFormat;

//Q1, Q2
/*public class Main {

    public static void main(String[] args) {
	File file = new File("src/sisters.txt");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter write = new FileWriter("src/SISTERS_COPY.TXT", false);

            int line = 0;
            String text = "";

            while((line = reader.read()) != -1)
            {
                if(line >= 97 && line <= 122)
                {
                    line -= 32;
                }
                write.write(line);
            }
            write.close();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

}*/

//Q3
/*public class Main {

    public static void main(String[] args) {
        File file = new File("src/SISTERS_COPY.TXT");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter write = new FileWriter("src/SISTERSCLEAN.TXT", false);

            int line = 0;
            String text = "";

            while((line = reader.read()) != -1)
            {
                if((line >= 65 && line <= 90) || line == 32 || (line >= 97 && line <= 122))
                {
                    write.write(line);
                }
            }
            write.close();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}*/
public class Main {

    public static void main(String[] args) {
        File file = new File("src/SISTERSCLEAN.TXT");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter write = new FileWriter("src/stats.txt", false);

            int line = 0;
            int countV = 0;
            int count = 0;
            String vowels = "AEIOUaeiou";
            String specialChars = "~`!@#$%^&*()-_=+[{]}|;:',<.>/?";
            DecimalFormat df = new DecimalFormat("#.##");

            while((line = reader.read()) != -1)
            {
                if(line != 32)
                {
                    count++;
                }

                if(vowels.contains(Character.toString((char)line)))
                {
                    countV++;
                }
            }
            write.write("total number of chars in string: " + count + "\nnumber of vowels: " + countV +
                    "\nPercentage of vowels: " + df.format((double)countV/count * 100) + "%");
            write.close();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
