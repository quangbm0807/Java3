/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buimi
 */
public class Grade {

    private String Hoten, maSV;
    private int tiengAnh, id;
    private int tinHoc;
    private int gdtc;

    public Grade(String Hoten, String maSV, int tiengAnh, int tinHoc, int gdtc) {
        this.Hoten = Hoten;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    // Method to calculate the average score
    public double calculateAverage() {
        double average = (tiengAnh + tinHoc + gdtc) / 3.0;
        return Double.parseDouble(String.format("%.3f", average));
    }

//    public static void main(String[] args) {
//        Grade grade = new Grade("SV001", 80, 75, 90);
//        double average = grade.calculateAverage();
//        System.out.println("Average score: " + average);
//    }
    public int getId() {
        return id;
    }

    
}
