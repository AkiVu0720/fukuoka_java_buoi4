import java.util.ArrayList;
import java.util.Scanner;

public class ManagerEmployee {
     private  ArrayList<Employee> employeeArrayList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public ManagerEmployee() {
        this.employeeArrayList = new ArrayList<Employee>();
    }
    public void input(Scanner scanner){
        boolean isExitAdd = true;
        Employee employee = null;
        do {
            try {

                System.out.println("1. Thêm nhân viên có kinh nghiệm");
                System.out.println("2. Thêm nhân viên mới ra trường");
                System.out.println("3. Thêm nhân viên thực tập");
                System.out.println("0. Thoát");
                byte choice = Byte.parseByte(scanner.nextLine());
                switch (choice){
                    case 1:
                        employee = new Experience();
                        employee.input(scanner,this.employeeArrayList);
                        employee.setEmpType(choice);
                        this.addEmployee(employee);
                        break;
                    case 2:
                        employee = new Fresher();
                        employee.input(scanner,this.employeeArrayList);
                        employee.setEmpType(choice);
                        this.addEmployee(employee);
                        break;
                    case 3:
                        employee = new Intern();
                        employee.input(scanner,this.employeeArrayList);
                        employee.setEmpType(choice);
                        this.addEmployee(employee);
                        break;
                    case 0:
                        isExitAdd = false;
                        break;
                    default:
                        System.out.println("Vui long nhap lai");
                }
            }catch (NumberFormatException nfe){
                System.out.println("Loi nhap String.");
                System.out.println(nfe);
            }
            catch (Exception ex){
                System.out.println("Loi trong qua trinh nhap nhan vien");
                System.out.println(ex);
            };
        }while (isExitAdd);
    }
    public void showInfo (){
        for (Employee emp : this.employeeArrayList) {
            emp.showInfo();
        }
    }
    public void addEmployee( Employee employee){
        this.employeeArrayList.add(employee);
    }

    public Employee findUseId(int employeeId){
        for (Employee emp: employeeArrayList) {
            if (emp.getEmpId()==employeeId){
                return emp;
            }
        }
    }
    public void updateEmployee(Scanner scanner, int id){
        Employee employee = findUseId(id);
        if (employee == null){
            System.out.println("id khong ton tai.");
        }
        employee.input(scanner,this.employeeArrayList);
    }
    public void deleteEmployee(int id){
        Employee employee = findUseId(id);
        if (employee == null){
            System.out.println("id khong ton tai.");
        }else {
        try {
            this.employeeArrayList.remove(employee);
        }catch (NullPointerException nullPointerException){
            System.out.println("Loi mang rong trong khi xoa thong tin.");
        }catch (Exception e){
            System.out.println("Loi trong qua trinh xoa thong tin");
        }
        }
    }
    public void findByExperience(){
        Experience experience = null;
        ArrayList<Employee> experienceArrayList1 = new ArrayList<>();
        for (Employee emp : this.employeeArrayList) {
            if (emp instanceof Experience ){
                experience = (Experience) emp;
                experienceArrayList1.add(emp);
            }
        }
        if (experience!=null){
            for ( Employee exper : experienceArrayList1
            ) {
                exper.showInfo();
            }
        }


    }
    public void findByIntern(){
        Intern intern = null;
        ArrayList<Employee>internArrayList1 = new ArrayList<>();
        for (Employee emp : this.employeeArrayList) {
            if (emp instanceof Intern ){
                intern = (Intern) emp;
                internArrayList1.add(emp);
            }
        }
        if (intern!=null){
            for (Employee intern1 :internArrayList1
                 ) {
                intern1.showInfo();
            }
        }
    }
    public void findByFresher(){
        Fresher fresher = null;
        ArrayList<Employee>fresherArrayList1 = new ArrayList<>();
        for (Employee emp : this.employeeArrayList) {
            if (emp instanceof Fresher ){
                fresher = (Fresher)emp;
                fresherArrayList1.add(emp);
            }
        }
        if (fresher!=null){
            for (Employee fresher1:fresherArrayList1
                 ) {
                fresher1.showInfo();
            }
        }
    }
    public void findById(int employeeId ){
        Employee employee = findUseId(employeeId);
        employee.showInfo();
    }
}
