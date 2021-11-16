import java.io.*;

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
                if((line >= 65 && line <= 90) || line == 32)
                {
                    write.write(line);
                }
            }
            write.close();
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
            String vowels = "AEIOU";

            while((line = reader.read()) != -1)
            {
                count++;
                if(vowels.contains(Character.toString((char)line)))
                {
                    countV++;
                }
            }
            write.write("total number of chars in string: " + count + "\nnumber of vowels: " + countV +
                    "\nPercentage of vowels: " + ((double)countV/count) * 100 + "%");
            write.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}