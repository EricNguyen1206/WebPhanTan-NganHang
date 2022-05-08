package com.o7planning.SpringBootRoutingDS.controller.API;
import java.util.List;

import com.o7planning.SpringBootRoutingDS.dao.ChuyenTienDAO;
import com.o7planning.SpringBootRoutingDS.model.ChuyenTienModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChuyenTienAPI {
    @Autowired
    private ChuyenTienDAO chuyenTienDAO;

    @GetMapping(path = {"/benthanh/chuyentien", "/tandinh/chuyentien"})
    ResponseEntity<ResponseObj> findAllChuyenTien() {
        List<ChuyenTienModel> foundChuyenTien = chuyenTienDAO.queryAllGDChuyenTien();
        return !foundChuyenTien.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundChuyenTien)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }

    @GetMapping(path = {"/benthanh/chuyentienbt", "/tandinh/chuyentientd"})
    ResponseEntity<ResponseObj> findChuyenTien() {
        List<ChuyenTienModel> foundChuyenTien = chuyenTienDAO.queryGDChuyenTien();
        return !foundChuyenTien.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundChuyenTien)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }
}
