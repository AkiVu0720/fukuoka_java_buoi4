import exception.BirthDayException;

import java.util.ArrayList;
import java.util.Scanner;

public class Fresher extends Employee {
    //1. Attributes
    private String graduationDate;
    private String graduationRank;
    private String education;

    //2 Set,get


    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    //3 Constructor


    public Fresher() {
    }

    public Fresher(int empId, String empFullName, String empBirthDay, String empPhone, String empEmail, byte empType, int empCount, String graduationDate, String graduationRank, String education) {
        super(empId, empFullName, empBirthDay, empPhone, empEmail, empType, empCount);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    //4 input, output

    /**
     * xu li dau vao cua class Fresher
     * @param scanner
     * @param employeeArrayList
     * @throws NumberFormatException
     */
    public void input(Scanner scanner, ArrayList< Employee> employeeArrayList) throws NumberFormatException{
        super.input(scanner, employeeArrayList);
        boolean isExit = true;
        do {
                try {
                    System.out.println("Thoi gian tot nghiep:(VD: 2020)");
                    String empYear = scanner.nextLine();
                    String regex = "^\\d{4}$";
                    boolean isYear = empYear.matches(regex);
                    if (isYear) {
                        this.graduationDate = empYear;
                        isExit = false;
                    }
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                }

        } while (isExit);

        isExit = true;
        do {
            System.out.println("Xep loai tot nghiep:");
            String rank = scanner.nextLine();
            switch (rank){
                case "xuat sac": case "gioi": case "yeu": case "trung binh":
                    this.graduationRank = rank;
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui long ghi dung dinh dang.");
                    break;
            }
        }while (isExit);
        System.out.println("Truong tot nghiep:");
        this.education = scanner.nextLine();
    }

    /**
     * hien thi dau ra cua Fresher
     */
    public void showInfo(){
        super.showInfo();
        System.out.printf("Tot Nghiep: %3s - Xep loai: %3s - Truong: %3s \n", this.graduationDate, this.graduationRank, this.education);
    }
}
