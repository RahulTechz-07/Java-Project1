import com.sun.corba.se.impl.presentation.rmi.StubFactoryStaticImpl;

import java.util.*;
import java.util.stream.*;
public class Student {
    private int sno;
    private String name,branch;
    private double cgpa;
    private boolean companyStatus;
    private String comapany;

    Student()
    {
        super();
    }
    public int getSno() {
        return sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa=" + cgpa +
                ", companyStatus=" + companyStatus +
                ", comapany='" + comapany + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getSno() == student.getSno() && Double.compare(student.getCgpa(), getCgpa()) == 0 && isCompanyStatus() == student.isCompanyStatus() && Objects.equals(getName(), student.getName()) && Objects.equals(getBranch(), student.getBranch()) && Objects.equals(getComapany(), student.getComapany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getName(), getBranch(), getCgpa(), isCompanyStatus(), getComapany());
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public boolean isCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(boolean companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getComapany() {
        return comapany;
    }

    public void setComapany(String comapany) {
        this.comapany = comapany;
    }

    public Student(int sno, String name, String branch, double cgpa, boolean companyStatus, String comapany) {
        this.sno = sno;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.companyStatus = companyStatus;
        this.comapany = comapany;
    }
    public Student[] getEligibleStudents(Student[] students,String branch,double cgpa)
    {
        List<Student> list = Arrays.asList(students);
      List<Student> list1=  list.stream().filter(student -> student.cgpa>=cgpa && Objects.equals(student.branch, branch) && !student.companyStatus).collect(Collectors.toList());

      Student[] student = new Student[list1.size()];
      int i =0 ;
      for(Student j: list1)
          student[i++]= j;
      return student;
    }
    public int getPlacedStudentsCount(Student[] student)
    {
        List<Student> list = Arrays.asList(student);
        return (int)list.stream().filter(Student::isCompanyStatus).count();
    }
    public Student getStudent(Student[] student, int sno)
    {

        for(Student i : student)
            if(i.sno == sno)
                return i;
        return null;
    }
    public void updatePlacementStatusAndSort(Student[] students, int sno, String comapany)
    {
        for(Student i : students)
            if(i.sno == sno)
            {
                i.companyStatus=true;
                i.comapany=comapany;
            }
  Arrays.sort(students,(a,b) -> Double.compare(b.cgpa,a.cgpa));
    }
}
