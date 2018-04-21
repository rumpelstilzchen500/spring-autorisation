package com.rumpel.util;


import com.rumpel.dao.UserDAO;
import com.rumpel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatior implements Validator {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        User user = (User) o;
        if(userDAO.getOne(user.getEmail())!=null){
            errors.rejectValue(
                    "email", "", "Этот имеил уже существует");
        }
    }
}
