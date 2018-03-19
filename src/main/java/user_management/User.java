package user_management;

import user_management.security.Password;

public class User {

    private int id;
    private String name;
    private String email;
    private Password password;
    private String strPass;


    public User(int id, String name, String email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String email, String strPass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = new Password(strPass);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword (Password password){
        this.password = password;
    }

    public void setPassword(String strPass) {

        this.password = new Password(strPass);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " - "+ getEmail());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

//        if(obj.equals())
        return false;
    }


}
