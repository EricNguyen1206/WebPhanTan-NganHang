package com.o7planning.SpringBootRoutingDS.controller.API;

import java.util.Optional;

import com.o7planning.SpringBootRoutingDS.model.Form.FormLogin;
import com.o7planning.SpringBootRoutingDS.dao.Form.FormLoginDAO;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAPI {
    
    @Autowired
    private FormLoginDAO formLoginDAO;

    @GetMapping(path = "/{chinhanh}/{username}/{password}/login")
    ResponseEntity<ResponseObj> Login(@PathVariable String chinhanh,@PathVariable String username, @PathVariable String password) {

        try {
            Optional<FormLogin> foundLogin = formLoginDAO.queryLogin(username, password);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundLogin)
                    //you can replace "ok" with your defined "error code"
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObj("Failed", e.getMessage(), null)
            );
        }
    }

    // @GetMapping(path = "/testapi/{chinhanh}/{username}/{password}")
    // private String Loginy(@PathVariable String chinhanh,@PathVariable String username, @PathVariable String password) {
    //     String uri = "http://localhost:8080/"+chinhanh.trim()+"/"+username.trim()+"/"+password.trim();
    //     RestTemplate restTemplate = new RestTemplate();
    //     String result = restTemplate.getForObject(uri, String.class);

    //     return result;
    // }
}
