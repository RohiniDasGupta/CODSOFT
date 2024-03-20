import java.util.*;
public class Grade
{
    public static void main(String args[])
    {
        int total = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of subjects: ");
            int n = sc.nextInt();
            int marks[] = new int[n];
            
            // Take marks obtained in each subject
            for(int i=0; i<n; i++)
            {
                System.out.print("Enter marks obtained in subject "+(i+1)+": ");
                marks[i] = sc.nextInt();
                //if marks are greater than 100 or less than 0, then re-enter marks
                while(marks[i]>100 || marks[i]<0)
                {
                    System.out.println("Marks should be between 0 and 100. Please re-enter marks.");
                    System.out.print("Enter marks obtained in subject "+(i+1)+": ");
                    marks[i] = sc.nextInt();
                }
            }

            // Calculate total marks
            for(int i=0; i<n; i++)
            {
                total = total + marks[i];
            }

            // Calculate average percentage
            double averagePercentage = (total / (double) (n));

            // Grade calculation
            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display results
            System.out.println("Total Marks: " + total);
            System.out.println("Average Percentage: " + averagePercentage);
            System.out.println("Grade: " + grade);
        }
    }
}