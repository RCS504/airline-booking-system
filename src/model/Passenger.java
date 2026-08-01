package model;

public class Passenger {
    private String name;
    private String idNumber;
    private String contact;

    public Passenger(String name, String idNumber, String contact) {
        this.name = name;
        this.idNumber = idNumber;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return (name + " [" + idNumber + "] " + contact);
    }
}
