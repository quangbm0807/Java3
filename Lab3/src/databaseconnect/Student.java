
package databaseconnect;

/**
 *
 * @author buimi
 */
public class Student {
    String MaSV, Hoten, Email, SDT, Diachi;
    boolean gioitinh;

    public Student(String MaSV, String Hoten, String Email, String SDT, String Diachi, boolean gioitinh) {
        this.MaSV = MaSV;
        this.Hoten = Hoten;
        this.Email = Email;
        this.SDT = SDT;
        this.Diachi = Diachi;
        this.gioitinh = gioitinh;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Student() {
    }
    
}
