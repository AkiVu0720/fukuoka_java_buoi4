import javax.swing.*;
import java.util.Scanner;

public class Certificate {
    //1 Attribute
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;
    //2. get,set


    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    //3 Constructor

    public Certificate() {
    }

    public Certificate(String certificatedID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }
    //4 input, output
    public void input(Scanner scanner){
        System.out.println("Nhap thong tin bang Cap: ");
        System.out.println("Ma ID: ");
        this.certificatedID = scanner.nextLine();
        System.out.println("Ho va ten:");
        this.certificateName = scanner.nextLine();
        System.out.println("Xep loai:");
        this.certificateRank = scanner.nextLine();
        System.out.println("Nam Cap: ");
        this.certificatedDate = scanner.nextLine();
    }

}
