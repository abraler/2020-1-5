public class User  {
    String name;
    String address;
    String phone;
    int PostalCode;
    String Email;
    String hometelephone;

    public User(String name, String address, String phone, int postalCode, String email, String hometelephone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        PostalCode = postalCode;
        Email = email;
        this.hometelephone = hometelephone;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", PostalCode=" + PostalCode +
                ", Email='" + Email + '\'' +
                ", hometelephone='" + hometelephone + '\'' +
                '}';
    }

    }

