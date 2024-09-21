package SANJAY;
import java.util.Scanner;

public class STUDENT_GRADE_CALCULATOR {
    public static void main(String[] args){
        int total=0;
        System.out.print("Enter the total number of subjects :");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int[] marks = new int[n];
        for(int i=0;i<n;i++) {
            int mark;
            do{
                System.out.print("Enter the marks obtained in Subject Number " + (i + 1)+" (out of 100) : ");
                mark=num.nextInt();
                if(mark<0 || mark>100) {
                    System.out.println("Invalid input! please enter marks in the range 1 to 100");
                }
            }while (mark<0 || mark>100);
            marks[i] = mark;
            total += marks[i];
        }
        double average_per = (double) total/n;

        String grade ;
        if(average_per>=90){
            grade = "A+";
        }
        else if (average_per>=80) {
            grade = "A";
        }
        else if (average_per>=70) {
            grade = "B+";
        }
        else if (average_per>=60) {
            grade = "B";
        }
        else if (average_per>=50) {
            grade = "C+";
        }
        else if (average_per>=35) {
            grade = "C";
        }
        else {
            grade = "Fail";
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-15s%-20s%-10s%n", "TOTAL MARKS", "AVERAGE PERCENTGE", "GRADE");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-15d%-20.2f%-10s%n", total, average_per, grade);
        System.out.println("--------------------------------------------------------");
    }
}
