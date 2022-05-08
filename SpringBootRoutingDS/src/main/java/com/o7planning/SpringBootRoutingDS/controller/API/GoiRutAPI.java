package com.o7planning.SpringBootRoutingDS.controller.API;
import java.util.List;

import com.o7planning.SpringBootRoutingDS.dao.GoiRutDAO;
import com.o7planning.SpringBootRoutingDS.model.GoiRutModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoiRutAPI {
    @Autowired
    private GoiRutDAO goiRutDAO;

    @GetMapping(path = {"/benthanh/goirut", "/tandinh/goirut"})
    ResponseEntity<ResponseObj> findAllGiaoDichGoiRut() {
        List<GoiRutModel> foundGoiRut = goiRutDAO.queryAllGoiRut();
        return !foundGoiRut.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundGoiRut)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }

    @GetMapping(path = {"/benthanh/goirutbt", "/tandinh/goiruttd"})
    ResponseEntity<ResponseObj> findGiaoDichGoiRut() {
        List<GoiRutModel> foundGoiRut = goiRutDAO.queryGoiRut();
        return !foundGoiRut.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundGoiRut)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }
}
