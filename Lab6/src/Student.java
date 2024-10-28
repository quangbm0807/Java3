
/**
 *
 * @author buimi
 */
public class Student {

    private String name;
    private String address;
    private String parentNames;
    private String contact;
    private String standard;
    private int fees;

    // Constructor và các phương thức getter
    // Ví dụ:
    public Student(String name, String address, String parentNames, String contact, String standard, int fees) {
        this.name = name;
        this.address = address;
        this.parentNames = parentNames;
        this.contact = contact;
        this.standard = standard;
        this.fees = fees;
    }

    // Các phương thức getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getParentNames() {
        return parentNames;
    }

    public String getContact() {
        return contact;
    }

    public String getStandard() {
        return standard;
    }

    public int getFees() {
        return fees;
    }
}


