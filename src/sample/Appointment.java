package sample;

public class Appointment {

    private int id;
    private String title;
    private String description;
    private String location;
    private String type;
    private String start;
    private String end;
    private String creationDate;
    private String createdBy;
    private String updated;
    private String updatedBy;
    private int customerID;
    private int userID;
    private int contactID;

    /**
     * The overloaded constructor.
     * @param id the appointment id to set.
     * @param title the appointment title to set.
     * @param description the appointment description to set.
     * @param location the appointment location to set.
     * @param type the appointment type to set.
     * @param start the appointment start to set.
     * @param end the appointment end to set.
     * @param creationDate the appointment creation date to set.
     * @param createdBy the appointment creator to set.
     * @param updated the appointment updated date to set.
     * @param updatedBy the appointment updater to set.
     * @param customerID the appointment customer id to set.
     * @param userID the appointment user id to set.
     * @param contactID the appointment contact id to set.
     */
    Appointment(int id, String title, String description, String location, String type, String start, String end,
                String creationDate,  String createdBy, String updated, String updatedBy, int customerID, int userID,
                int contactID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.updated = updated;
        this.updatedBy = updatedBy;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     * The default constructor
     */
    Appointment() {

    }

    /**
     * Get the appointment id of the appointment object.
     * @return the appointment id.
     */
    public int getID() {
        return id;
    }

    /**
     * Set the appointment id of the appointment object.
     * @param id the id value to be set.
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Get the appointment title of the appointment object.
     * @return the appointment title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the appointment title of the appointment object.
     * @param title the appointment title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the appointment description of the appointment object.
     * @return the appointment description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the appointment description of the appointment object.
     * @param description the appointment description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the appointment location of the appointment object.
     * @return the appointment location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the appointment location of the appointment object.
     * @param location the appointment location to be set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the appointment type of the appointment object.
     * @return the appointment type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the appointment type of the appointment object.
     * @param type the appointment type to be set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the appointment start of the appointment object.
     * @return the appointment start.
     */
    public String getStart() {
        return start;
    }

    /**
     * Set the appointment start of the appointment object.
     * @param start the appointment start to be set.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Get the appointment end of the appointment object.
     * @return the appointment end.
     */
    public String getEnd() {
        return end;
    }

    /**
     * Set the appointment end of the appointment object.
     * @param end the appointment end to be set.
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Get the appointment creation of the appointment object.
     * @return the appointment creation.
     */
    public String getCreation() {
        return creationDate;
    }

    /**
     * Set the appointment creation of the appointment object.
     * @param creationDate the appointment creation to be set.
     */
    public void setCreation(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Get the appointment creator of the appointment object.
     * @return the appointment creator.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Set the appointment creator of the appointment object.
     * @param createdBy the appointment creator to be set.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get the appointment updated date of the appointment object.
     * @return the appointment update date.
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Set the appointment updated date of the appointment object.
     * @param updated the appointment updated date to be set.
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * Get the appointment updater of the appointment object.
     * @return the appointment updater.
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Set the appointment updater of the appointment object.
     * @param updatedBy the appointment updater to be set.
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Get the customer id of the appointment object.
     * @return the customer id.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Set the customer id of the appointment object.
     * @param customerID the customer id to be set.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Get the user id of the appointment object.
     * @return the user id.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set the user id of the appointment object.
     * @param userID the user id to be set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get the contact id of the appointment object.
     * @return the contact id.
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * Set the contact id of the appointment object.
     * @param contactID the contact id to be set.
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
}
