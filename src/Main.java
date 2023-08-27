import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerEmployee managerEmployee = new ManagerEmployee();
        runMain(managerEmployee);

    }
    public static void menu(){
        System.out.println("1. Thêm nhân viên mới.");
        System.out.println("2. In danh sách nhân viên.");
        System.out.println("3. Sửa thông tin nhân viên");
        System.out.println("4. Xóa thông tin nhân viên");
        System.out.println("5. Tìm tất cả nhân viên Experience");
        System.out.println("6. Tìm tất cả nhân viên Fresher");
        System.out.println("7. Tìm tất cả nhân viên Intern");
        System.out.println("8. Tim nhân viên theo ID");
        System.out.println("0. Thoát");
    }
    public static void runMain(ManagerEmployee managerEmployee){
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
       do {
           menu();
           try {
               byte choice = Byte.parseByte(scanner.nextLine());
               switch (choice){
                   case 1:
                       managerEmployee.input(scanner);
                       break;
                   case 2:
                       managerEmployee.showInfo();
                       break;
                   case 3:
                       try {
                           System.out.println("nhap Id chinh sua.");
                           int numberId = Integer.parseInt(scanner.nextLine());
                           managerEmployee.updateEmployee(scanner,numberId);
                       }catch (NumberFormatException numberFormatException){
                           System.out.println("Loi dinh dang khi nhap Id chinh sua.");
                       }
                       catch (Exception e){
                           System.out.println("Loi xay ra trong qua trinh nhap Id chinh sua.");
                       };
                       break;
                   case 4:
                       try {
                           System.out.println("Nhap id de xoa: ");
                           int numberDelete = Integer.parseInt(scanner.nextLine());
                           managerEmployee.deleteEmployee(numberDelete);
                       }catch (NumberFormatException numberFormatException){
                           System.out.println("Loi dinh dang khi nhap Id xoa.");
                       }
                       catch (Exception e){
                           System.out.println("Loi xay ra trong qua trinh nhap Id xoa.");
                       };
                       break;
                   case 5:
                       managerEmployee.findByExperience();
                       break;
                   case 6:
                       managerEmployee.findByFresher();
                       break;
                   case 7:
                       managerEmployee.findByIntern();
                       break;
                   case 8:


                       try {
                           System.out.println("Nhap Id can tim kiem");
                           int idSearch = Integer.parseInt(scanner.nextLine());
                           managerEmployee.findById(idSearch);
                       }catch (NumberFormatException numberFormatException){
                           System.out.println("Loi dinh dang khi nhap Id tim kiem.");
                       }
                       catch (Exception e){
                           System.out.println("Loi xay ra trong qua trinh nhap Id tim kiem");
                       };

                       break;
                   case 0:
                       isExit = false;
                       break;
                   default:
                       System.out.println("Vui long nhap lai");
                       break;

               }
           }catch (NumberFormatException nfe){
               System.out.println("Loi dinh dang nhap String");
               System.out.println("Loi trong qua trinh Chon menu");
           }
           catch (Exception e){
               System.out.println("Loi trong qua trinh nhap Menu");
           }

       }while (isExit);

    }
}
