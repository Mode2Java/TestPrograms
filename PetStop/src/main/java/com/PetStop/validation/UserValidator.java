package com.PetStop.validation;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Component; 

import org.springframework.validation.Errors; 

import org.springframework.validation.ValidationUtils; 

import org.springframework.validation.Validator;

import com.PetStop.model.User;
import com.PetStop.service.UserService; 

 

@Component 

public class UserValidator  implements Validator  

{ 

 @Autowired 

    private UserService userService; 

 

    @Override 

    public boolean supports(Class<?> aClass) { 

        return User.class.equals(aClass); 

    } 

    @Override 

    public void validate(Object o, Errors errors) { 

        User user = (User) o; 

 

 

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty"); 

        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) { 

            errors.rejectValue("userName", "Size.userForm.userName"); 

        } 

        if (userService.searchByUserName(user.getUserName()) != null) { 

            errors.rejectValue("userName", "Duplicate.userForm.userName"); 

        } 

 

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty"); 

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) { 

            errors.rejectValue("password", "Size.userForm.password"); 

        } 

 

        if (!user.getPasswordConfirm().equals(user.getPassword())) { 

            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm"); 

        } 

    } 

} 

  

 

 