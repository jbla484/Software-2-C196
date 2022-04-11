package sample;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPostalCode;
    private String customerPhoneNumber;
    private String customerCreationDate;
    private String customerCreatedBy;
    private String customerLastUpdate;
    private String customerLastUpdatedBy;
    private int customerDivisionID;

    public int getId() {
        return customerID;
    }

    public void setId(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return customerName;
    }

    public void setName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return customerAddress;
    }

    public void setAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPostalCode() {
        return customerPostalCode;
    }

    public void setPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    public String getPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCreationDate() {
        return customerCreationDate;
    }

    public void setCreationDate(String customerCreationDate) {
        this.customerCreationDate = customerCreationDate;
    }

    public String getCreatedBy() {
        return customerCreatedBy;
    }

    public void setCreatedBy(String customerCreatedBy) {
        this.customerCreatedBy = customerCreatedBy;
    }

    public String getLastUpdate() {
        return customerLastUpdate;
    }

    public void setLastUpdate(String customerLastUpdate) {
        this.customerLastUpdate = customerLastUpdate;
    }

    public String getLastUpdatedBy() {
        return customerLastUpdatedBy;
    }

    public void setLastUpdatedBy(String customerLastUpdatedBy) {
        this.customerLastUpdatedBy = customerLastUpdatedBy;
    }

    public int getDivisionID() {
        return customerDivisionID;
    }

    public void setDivisionID(int customerDivisionID) {
        this.customerDivisionID = customerDivisionID;
    }
}
