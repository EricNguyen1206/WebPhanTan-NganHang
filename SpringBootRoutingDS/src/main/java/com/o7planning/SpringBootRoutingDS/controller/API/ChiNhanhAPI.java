package com.o7planning.SpringBootRoutingDS.controller.API;
import java.util.List;
import java.util.Optional;

import com.o7planning.SpringBootRoutingDS.dao.ChiNhanhDAO;
import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChiNhanhAPI {
    
    @Autowired
    private ChiNhanhDAO chiNhanhDAO;

    @GetMapping(path = {"/benthanh/chinhanh", "/tandinh/chinhanh"})
    ResponseEntity<ResponseObj> findAllChiNhanh() {
        List<ChiNhanhModel> foundChiNhanh = chiNhanhDAO.queryAllChiNhanh();
        return !foundChiNhanh.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundChiNhanh)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }

    @GetMapping(path = {"/benthanh/chinhanhbt", "/tandinh/chinhanhtd"})
    ResponseEntity<ResponseObj> findChiNhanh() {
        Optional<ChiNhanhModel> foundChiNhanh = chiNhanhDAO.queryChiNhanh();
        return foundChiNhanh.isPresent() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundChiNhanh)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }
}
