package model;
/*
CREATE TABLE  IF NOT EXISTS  users(
        user_name VARCHAR(50),
        psw VARCHAR(50),
        logged_in boolean,
        privilege ENUM('admin','mod','usr'),
        email_address VARCHAR(100) UNIQUE,
        reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        template_id INT UNSIGNED,
        PRIMARY KEY (user_name),
        FOREIGN KEY(template_id) REFERENCES template(template_id)
        );
*/
public class User {
    String usrName;
    String password;
    boolean loggedIn;
    Privilege privilege;
    String emailAddress;
    String registrationDate;
    int templateId;

    public User(String usrName) {
        this.usrName = usrName;
    }

    public User(String usrName, String password, boolean loggedIn, Privilege privilege, String emailAddress, String registrationDate, int templateId) {
        this.usrName = usrName;
        this.password = password;
        this.loggedIn = loggedIn;
        this.privilege = privilege;
        this.emailAddress = emailAddress;
        this.registrationDate = registrationDate;
        this.templateId = templateId;
    }

    public String getUsrName() {
        return usrName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }
}
