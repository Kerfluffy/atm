public class AccountHolder {
    private int SSN;
    private String name;
    private String phone;
    private String address;

    AccountHolder (String name, int ssn, String phone, String address) {
        this.name = name;
        this.SSN = ssn;
        this.phone = phone;
        this.address = address;
    }
    
    /* set time */
    void setName(String name) {
    	this.name = name;
    }
    void setSSN(int SSN) {
    	this.SSN = SSN;
    }
    void setPhone(String phone) {
    	this.phone = phone;
    }
    void setAddress(String address) {
    	this.address = address;
    }
    /* get time */
    String getName() {
        return name;
    }
    int getSSN() {
        return SSN;
    }
    String getPhone() {
        return phone;
    }
    String getAddress() {
        return address;
    }
}