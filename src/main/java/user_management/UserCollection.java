package user_management;


import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserCollection extends ArrayList<User> {

    private UserCollectionInitializer userCollectionInitializer;


    private ArrayList<User> users;

    public UserCollection() throws FileNotFoundException {
        users = UserCollectionInitializer.generate();
    }



    public User findById(int id) {

        for (User user : users){
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user : users){
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException{
            for(User user : users){
                if(user.getEmail().equalsIgnoreCase(email)){
                    if(user.getPassword().equals(password)){
                        return user;
                    }
                }
            }
        return null;
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException{
        String emailRegex = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;";
        String passwordRegex = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        for(User user : users){
            if(!user.getName().equalsIgnoreCase(name)){
                throw new EmailNotAvailableException();
            }
                if(!user.getEmail().equalsIgnoreCase(email) || !email.matches(emailRegex) ){
                    throw new InvalidEmailException();
                }
                    if(!user.getPassword().equals(password) || !password.matches(passwordRegex)){
                        throw new PasswordTooSimpleException();
                    }
           else{
                users.add(new User(users.size()+1, name, email, password));
                }
        }
         return users.size();
    }
}
