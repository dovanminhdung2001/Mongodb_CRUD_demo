package controller;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/check")
    @ResponseBody
    public ResponseEntity<List<User>> check () {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/check2")
    public String check2() {
        return "check2";
    }

    @GetMapping("/check3")
    @ResponseBody
    public ResponseEntity<?> check3() {
        return  new ResponseEntity<>(new JSONWrappedObject("{","}","ok"),HttpStatus.OK);
    }
}
