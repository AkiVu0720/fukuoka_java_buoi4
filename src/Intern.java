import java.util.ArrayList;
import java.util.Scanner;

public class Intern extends Employee {
    //1. Attribute
    private String majors;
    private String semester;
    private String universityName;

    //2 SetGet

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    //3 Constructor

    public Intern() {

    }

    public Intern(int empId, String empFullName, String empBirthDay, String empPhone, String empEmail, byte empType, int empCount, String majors, String semester, String universityName) {
        super(empId, empFullName, empBirthDay, empPhone, empEmail, empType, empCount);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    //4. input,output
    public void input(Scanner scanner, ArrayList<Employee>list){
        try {
            super.input(scanner,list);
            System.out.println("Chuyen nganh dang hoc: ");
            this.majors = scanner.nextLine();
            System.out.println("Hoc ki dang hoc: ");
            this.semester = scanner.nextLine();
            System.out.println("Truong dang theo hoc: ");
            this.universityName = scanner.nextLine();
        } catch (Exception e ){
            System.out.println("Exception" +e.getMessage() );
        }
    }
    public void showInfo(){
        super.showInfo();
        System.out.printf("Chuyen Nganh: %3s - Hoc ki: %3s - Truong Hoc: %3s \n", this.majors, this.semester, this.universityName);
    }
}
