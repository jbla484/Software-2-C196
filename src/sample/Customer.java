package sample;

/**
 * The customer class which allows users to create customers and get/set values of their customers.
 *
 * @author James Blankenship
 * @version 1.0
 */

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
    private String customerCountry;

    /**
     * The default constructor
     */
    Customer() {

    }

    /**
     * The overloaded constructor.
     * @param customerID the customer id to set.
     * @param customerName the customer name to set.
     * @param customerAddress the customer address to set.
     * @param customerPostalCode the customer postal code to set.
     * @param customerPhoneNumber the customer phone number to set.
     * @param customerCreationDate the customer creation date to set.
     * @param customerCreatedBy the customer creator to set.
     * @param customerLastUpdate the customer updated date to set.
     * @param customerLastUpdatedBy the customer updater to set.
     * @param customerDivisionID the customer division id to set.
     */
    Customer(int customerID, String customerName, String customerAddress, String customerPostalCode,
             String customerPhoneNumber, String customerCreationDate, String customerCreatedBy,
             String customerLastUpdate, String customerLastUpdatedBy, int customerDivisionID, String customerCountry) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerCreationDate = customerCreationDate;
        this.customerCreatedBy = customerCreatedBy;
        this.customerLastUpdate = customerLastUpdate;
        this.customerLastUpdatedBy = customerLastUpdatedBy;
        this.customerDivisionID = customerDivisionID;
        this.customerCountry = customerCountry;
    }

    /**
     * Get the customer id of the customer object.
     * @return the customer id.
     */
    public int getId() {
        return customerID;
    }

    /**
     * Set the customer id of the customer object.
     * @param customerID the customer id to be set.
     */
    public void setId(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Get the customer name of the customer object.
     * @return the customer name.
     */
    public String getName() {
        return customerName;
    }

    /**
     * Set the customer name of the customer object.
     * @param customerName the customer name to be set.
     */
    public void setName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get the customer address of the customer object.
     * @return the customer address.
     */
    public String getAddress() {
        return customerAddress;
    }

    /**
     * Set the customer address of the customer object.
     * @param customerAddress the customer address to be set.
     */
    public void setAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Get the customer postal code of the customer object.
     * @return the customer postal code.
     */
    public String getPostalCode() {
        return customerPostalCode;
    }

    /**
     * Set the customer postal code of the customer object.
     * @param customerPostalCode the customer postal code to be set.
     */
    public void setPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    /**
     * Get the customer phone number of the customer object.
     * @return the customer phone number.
     */
    public String getPhoneNumber() {
        return customerPhoneNumber;
    }

    /**
     * Set the customer phone number of the customer object.
     * @param customerPhoneNumber the customer phone number to be set.
     */
    public void setPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * Get the customer creation date of the customer object.
     * @return the customer creation date.
     */
    public String getCreationDate() {
        return customerCreationDate;
    }

    /**
     * Set the customer creation date of the customer object.
     * @param customerCreationDate the customer creation date to be set.
     */
    public void setCreationDate(String customerCreationDate) {
        this.customerCreationDate = customerCreationDate;
    }

    /**
     * Get the customer creator of the customer object.
     * @return the customer creator.
     */
    public String getCreatedBy() {
        return customerCreatedBy;
    }

    /**
     * Set the customer creator of the customer object.
     * @param customerCreatedBy the customer creator to be set.
     */
    public void setCreatedBy(String customerCreatedBy) {
        this.customerCreatedBy = customerCreatedBy;
    }

    /**
     * Get the customer updated date of the customer object.
     * @return the customer updated date.
     */
    public String getLastUpdate() {
        return customerLastUpdate;
    }

    /**
     * Set the customer updated date of the customer object.
     * @param customerLastUpdate the customer updated date to be set.
     */
    public void setLastUpdate(String customerLastUpdate) {
        this.customerLastUpdate = customerLastUpdate;
    }

    /**
     * Get the customer updater of the customer object.
     * @return the customer updater.
     */
    public String getLastUpdatedBy() {
        return customerLastUpdatedBy;
    }

    /**
     * Set the customer updater of the customer object.
     * @param customerLastUpdatedBy the customer updater to be set.
     */
    public void setLastUpdatedBy(String customerLastUpdatedBy) {
        this.customerLastUpdatedBy = customerLastUpdatedBy;
    }

    /**
     * Get the customer division id of the customer object.
     * @return the customer division id.
     */
    public int getDivisionID() {
        return customerDivisionID;
    }

    /**
     * Set the customer division id of the customer object.
     * @param customerDivisionID the customer division id to be set.
     */
    public void setDivisionID(int customerDivisionID) {
        this.customerDivisionID = customerDivisionID;
    }

    /**
     * Get the customer country of the customer object.
     */
    public String getCountry() {
        return customerCountry;
    }

    /**
     * Set the customer country of the customer object.
     */
    public void setCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }
}
