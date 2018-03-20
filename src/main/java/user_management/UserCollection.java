package user_management;


import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserCollection extends ArrayList<User> {



    public User findById(int id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                return this.get(i);
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEmail().equalsIgnoreCase(email)) {
                return this.get(i);
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException{
        for (int i = 0; i < this.size() ; i++) {
            if(this.get(i).getEmail().toString().equalsIgnoreCase(email) && this.get(i).getPassword().equals(password)){
                        return this.get(i);
                    }
                }
        return null;
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException{
        String emailRegex = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;";
        String passwordRegex = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        for (int i = 0; i < this.size() ; i++) {
            if(!this.get(i).getName().equalsIgnoreCase(name)){
                throw new EmailNotAvailableException();
            }
            else if(!this.get(i).getEmail().equalsIgnoreCase(email) || !email.matches(emailRegex) ){
                throw new InvalidEmailException();
            }
            else if(!password.matches(passwordRegex)){
                throw new PasswordTooSimpleException();
            }
            else{
                this.add(new User(this.size()+1, name, email, password));
            }
        }
         return this.size();
    }
}
