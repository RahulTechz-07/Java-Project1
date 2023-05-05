import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[3];
        for (int i=0 ; i< 3 ;i++)
            student[i] = new Student(scanner.nextInt(),scanner.next(),scanner.next(),scanner.nextDouble(),scanner.nextBoolean(),scanner.next());
      Student student1 = new Student();
      System.out.println("Enter Eligibility Criteria for Students in branch and cgpa");
       Student[] student2 =student1.getEligibleStudents(student,scanner.next(),scanner.nextDouble());
        for(Student i: student2)
            System.out.println(i);

        System.out.println("Placement Students Count :"+student1.getPlacedStudentsCount(student));
        System.out.println("Enter the Student Sno");
        System.out.println(student1.getStudent(student, scanner.nextInt()));
        System.out.println("Enter the Student Registration no for Updation in Company Status");
        student1.updatePlacementStatusAndSort(student, scanner.nextInt(),scanner.next());
        for (Student i: student)
            System.out.println(i);



    }
}