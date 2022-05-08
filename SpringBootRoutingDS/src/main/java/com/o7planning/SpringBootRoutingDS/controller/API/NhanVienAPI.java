package com.o7planning.SpringBootRoutingDS.controller.API;
import java.util.List;

import com.o7planning.SpringBootRoutingDS.dao.NhanVienDAO;
import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NhanVienAPI {
    @Autowired
    private NhanVienDAO nhanVienDAO;

    @GetMapping(path = {"/benthanh/nhanvien", "/tandinh/nhanvien"})
    ResponseEntity<ResponseObj> findAllNhanVien() {
        List<NhanVienModel> foundNhanVien = nhanVienDAO.queryAllNhanVien();
        return !foundNhanVien.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundNhanVien)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }

    @GetMapping(path = {"/benthanh/nhanvienbt", "/tandinh/nhanvientd"})
    ResponseEntity<ResponseObj> findNhanVien() {
        List<NhanVienModel> foundNhanVien = nhanVienDAO.queryNhanVien();
        return !foundNhanVien.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundNhanVien)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }
}
