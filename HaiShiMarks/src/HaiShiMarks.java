import java.util.Arrays;
import java.util.Scanner;

public class HaiShiMarks {
    //b) get marks for each student
    public static double[][] getMarks(int numTests, int numStudents, Scanner input) {
        //initialize a 2d array of the size of the amount of students as rows and tests as columns
        double[][] marks = new double[numStudents][numTests];
        //iterates through each row
        for(int i = 0; i < numStudents; i++) {
            System.out.println("Enter all the marks for student " + i + ": ");

            //iterates through all the columns in that row
            for(int j = 0; j < numTests; j++) {
                System.out.print("mark " + j + ": ");
                //get input for the marks and put them in their array positions
                marks[i][j] = Double.parseDouble(input.nextLine());
            }
        }
        System.out.println();
        //return the array of marks
        return marks;
    }

    //c) calculate the average test mark of each student and put them into an array
    public static double[] calcAvgs(double[][] marks, int numStudents, int numTests) {
        //initialize a new 1d array of length of the amount of students
        double[] stuAvgs = new double[numStudents];
        double currStudentTotal = 0;

        //iterates through each student and calculates their averages
        for(int i = 0; i < numStudents; i++) {
            for(int j = 0; j < numTests; j++)
            {
                //adds the test marks to the current total
                currStudentTotal += marks[i][j];
            }
            //calculates the average and puts it into the array of averages
            stuAvgs[i] = (currStudentTotal / numTests);
            currStudentTotal = 0;
        }
        //return the averages array
        return stuAvgs;
    }

    //d) Print nicely all the marks for all students, and their averages.
    //e) Calculate and print the class average (can be the average of the averages).
    public static void printMarks(double[][] marks, double[] stuAvgs) {
        //assigns the dimensions of the array to length variables
        int lenr = marks.length;
        int lenc = marks[0].length;


        System.out.println("The test marks: ");
        //iterate through the whole array and print out the marks
        for(int i = 0; i < lenr; i++) {
            //prints out the student and "marks: "
            System.out.println("Student " + i);
            System.out.print("marks: ");
            for(int j = 0; j < lenc - 1; j++)
            {
                //prints out all of the marks except for the last one followed by a comma and space
                System.out.printf("%.1f, ", marks[i][j]);
            }
            //prints out the final mark
            System.out.printf("%.1f, ", marks[i][lenc - 1]);
            //prints the students average
            System.out.printf("average: %.1f\n", stuAvgs[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //initializing all the variables
        double[][] marks;
        int numTests;
        int numStudents;
        double[] stuAvgs;
        double highest = -1;
        int indexHighest = 0;
        double total = 0;
        double classAvg;
        Scanner input = new Scanner(System.in);

        System.out.println("MARKS PROGRAM");

        //a) get the number of students and number of Tests
        System.out.print("Enter the number of students: ");
        //gets input from keyboard for amount of students
        numStudents = Integer.parseInt(input.nextLine());

        //initalizes a averages array of length students for use in c)
        stuAvgs = new double[numStudents];

        System.out.print("Enter the number of tests: ");
        //gets input from keyboard for amount of tests
        numTests = Integer.parseInt(input.nextLine());
        System.out.println();

        //calling the functions for b) c) d) and e)
        marks = getMarks(numTests, numStudents, input);
        stuAvgs = calcAvgs(marks, numStudents, numTests);
        printMarks(marks, stuAvgs);

        //e) Calculate and print the class average (can be the average of the averages).
        for(int i = 0; i < stuAvgs.length; i++) {
            total += stuAvgs[i];
        }
        classAvg = (total / numStudents);

        System.out.printf("Class average: %.1f\n", (total / numStudents));
        System.out.println();

        //f)determine the student with highest average, ignoring ties
        //for loop that iterates through the entire averages array
        for(int i = 0; i < stuAvgs.length; i++) {
            //if the average at index i is greater than the current highest mark, set that to the highest mark
            if(stuAvgs[i] > highest) {
                highest = stuAvgs[i];
                indexHighest = i;
            }
        }
        //print out the student with the highest average and their average
        System.out.printf("Highest average: Student %d, average %.1f\n", indexHighest, highest);
        System.out.println();

        //g)Determine and print the student(s) whose averages are greater than or equal to the class average.
        System.out.println("Students above class average: ");
        //for loop that iterates through the entire averages array
        for(int i = 0; i < stuAvgs.length; i++) {
            //if the average at index i is greater than the class average print the student with that average out
            if(stuAvgs[i] > classAvg) {
                System.out.println("Student " + i);
            }
        }
    }
}