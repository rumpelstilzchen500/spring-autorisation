package com.rumpel;

import com.rumpel.dao.UserDAO;
import com.rumpel.model.User;
import com.rumpel.util.UserValidatior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserValidatior userValidatior;

    //static List <User> users = new ArrayList<>();

    @GetMapping("/users")
    public String getUsers(Model model) throws SQLException {
        model.addAttribute("users", /*users*/ userDAO.getAll());
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model){
        model.addAttribute("user", new User());
        return "/sign_up";
    }

/*    @PostMapping("/users/new")
    public String signUp(@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("email") String email){

        users.add(new User(name, surname, email));
        return "redirect:/users";
    }*/

    @PostMapping("/users/new")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {
        userValidatior.validate(user, result);
        if (result.hasErrors()){
            return "/sign_up";
        }
        userDAO.add(user);
        //users.add(user);
        return "redirect:/users";
    }
}
