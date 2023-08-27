import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;


public class Employee {
    //1 Attribute.
    private int empId;
    private String empFullName;
    private String empBirthDay;
    private String empPhone;
    private String empEmail;
    private byte empType;
    private int empCount;
    private ArrayList<Certificate> certificateArrayList;
    //2 Set,Get.

    public ArrayList<Certificate> getCertificateArrayList() {
        return certificateArrayList;
    }

    public void setCertificateArrayList(ArrayList<Certificate> certificateArrayList) {
        this.certificateArrayList = certificateArrayList;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    public String getEmpBirthDay() {
        return empBirthDay;
    }

    public void setEmpBirthDay(String empBirthDay) {
        this.empBirthDay = empBirthDay;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public byte getEmpType() {
        return empType;
    }

    public void setEmpType(byte empType) {
        this.empType = empType;
    }

    public int getEmpCount() {
        return empCount;
    }

    public void setEmpCount(int empCount) {
        this.empCount = empCount;
    }
    //3 Constructor.

    public Employee() {
    }

    public Employee(int empId, String empFullName, String empBirthDay, String empPhone, String empEmail, byte empType, int empCount) {
        this.empId = empId;
        this.empFullName = empFullName;
        this.empBirthDay = empBirthDay;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empType = empType;
        this.empCount = empCount;
    }
    //4 Input, output


    public void input(Scanner scanner, ArrayList<Employee> list) throws NumberFormatException {
        boolean isExit = true;
        do {
            boolean checkId = true;
            try {
                System.out.println("Ma Id:  ");
                int id = Integer.parseInt(scanner.nextLine());
                for (Employee emp : list) {
                    if (emp.empId == id) {
                        checkId = false;
                    }
                }
                if (checkId) {
                    this.empId = id;
                    isExit = false;
                }
            } catch (Exception exception) {
                System.out.println("Loi Exception" + exception.getMessage());
            }
        } while (isExit);

        System.out.println("Ten: ");
        this.empFullName = scanner.nextLine();
        isExit = true;
        do {
            System.out.println("Ngay/Thang/Nam Sinh:");
            String empBirthDay = scanner.nextLine();
            String regex = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
            boolean isBirthDay = empBirthDay.matches(regex);
            if (isBirthDay) {
                this.empBirthDay = empBirthDay;
                isExit = false;
            } else {
                try {
                    throw new BirthDayException("Co loi xay ra, vui long nhap lai dung dinh dang");
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                }
            }
        } while (isExit);
        isExit = true;
        do {
            System.out.println("So dien thoai:");
            String phone = scanner.nextLine();
            String regexPhone = "^(1[ \\-\\+]{0,3}|\\+1[ -\\+]{0,3}|\\+1|\\+)?((\\(\\+?1-[2-9][0-9]{1,2}\\))|(\\(\\+?[2-8][0-9][0-9]\\))|(\\(\\+?[1-9][0-9]\\))|(\\(\\+?[17]\\))|(\\([2-9][2-9]\\))|([ \\-\\.]{0,3}[0-9]{2,4}))?([ \\-\\.][0-9])?([ \\-\\.]{0,3}[0-9]{2,4}){2,3}$";
            boolean isPhone = phone.matches(regexPhone);
            if (isPhone) {
                this.empPhone = phone;
                isExit = false;
            } else {
                try {
                    throw new PhoneException("Co loi xay ra. Vui long nhap lai");
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }
            }
        } while (isExit);
        isExit = true;
        do {
            System.out.println("Email:");
            String email = scanner.nextLine();
            String regexEmail = ".+@.+\\.[a-z]+";
            boolean isEmail = email.matches(regexEmail);
            if (isEmail) {
                this.empEmail = email;
                isExit = false;
            } else {
                try {
                    throw new EmailException("Vui long nhap dung dinh dang email.");
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                }
            }
        } while (isExit);

    }
    public void inputCerticate(Scanner scanner){
        boolean isExit = true;
        do {
        try {
            System.out.println("1. Nhap thong tin chung chi: ");
            System.out.println("0. Thoat");
            byte choice =  Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    Certificate certificate = new Certificate();
                    certificate.input(scanner);
                    this.certificateArrayList.add(certificate);
                    break;
                case 0:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui long nhap lai: ");
                    break;
            }
        }catch (NullPointerException ex1){
            System.out.println("Loi khong co ArrayList");
        }catch (NumberFormatException ex2){
            System.out.println("Loi dinh dang dau vao");
        }
        catch (Exception e){
            System.out.println("Loi trong qua trinh nhap thong tin Chung chi");
        }
        }while (isExit);
    }


    public void showInfo() {
        String type = this.empType == 1 ? "Experience" : this.empType == 2 ? "Fresher" : "Intern";
        System.out.printf("MaId: %3d - Ten: %3s - Kieu nhan vien: %3s \n", this.empId, this.empFullName, type);
    }
}
