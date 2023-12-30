package lab3;

public class Contact {
    public String name;
    public String email;
    public String address;

    public Contact(String name, String email, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.address = additionalInfo;
    }

    public String toString() {
        return "Name: " + String.valueOf(name) + " email: " + String.valueOf(email) + " address:" + String.valueOf(address);
    }
}

