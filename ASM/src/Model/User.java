/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buimi
 */
public class User {

    private String username, password;
    boolean role;

    public User() {
    }

    public User(String username, String password, boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public String getRoleAsString() {
        return role ? "giảng viên" : "cán bộ";
    }

    public void setRole(boolean role) {
        this.role = role;
    }

}
