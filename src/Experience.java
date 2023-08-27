import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Experience extends Employee {
    //1. Attribute.
    private byte explnYear;
    private String proSkill;
    //2. Set,Get

    public byte getExplnYear() {
        return explnYear;
    }

    public void setExplnYear(byte explnYear) {
        this.explnYear = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    //3 Constructor.

    public Experience() {
    }

    public Experience(byte explnYear, String proSkill) {
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    public Experience(int empId, String empFullName, String empBirthDay, String empPhone, String empEmail, byte empType, int empCount, byte explnYear, String proSkill) {
        super(empId, empFullName, empBirthDay, empPhone, empEmail, empType, empCount);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    //4 input, output
    public void input(Scanner scanner, ArrayList<Employee> listEmployee){
       try {
           super.input(scanner,listEmployee);
           System.out.println("So nam kinh nghiem: ");
           this.explnYear = Byte.parseByte(scanner.nextLine());
           System.out.println("Ky nang chuyen mon: ");
           this.proSkill = scanner.nextLine();
           super.inputCerticate(scanner);
       } catch (Exception e){
           System.out.println("Exception"+e.getMessage());
       }
    }
    public void  showInfo(){
        super.showInfo();
        System.out.printf("So nam kinh nghiem: %3s \n", this.explnYear);
        System.out.printf(" Ky Nang chuyen Mon: %3s \n", this.proSkill);
    }
}
