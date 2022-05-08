package com.o7planning.SpringBootRoutingDS.controller.API;
import java.util.List;

import com.o7planning.SpringBootRoutingDS.dao.KhachHangDAO;
import com.o7planning.SpringBootRoutingDS.model.KhachHangModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KhachHangAPI {
    
    @Autowired
    private KhachHangDAO khachHangDAO;

    @GetMapping(path = {"/benthanh/khachhang", "/tandinh/khachhang"})
    ResponseEntity<ResponseObj> findAllKhachHang() {
        List<KhachHangModel> foundKhachHang = khachHangDAO.queryAllKhachHang();
        return !foundKhachHang.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundKhachHang)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }

    @GetMapping(path = {"/benthanh/khachhangbt", "/tandinh/khachhangtd"})
    ResponseEntity<ResponseObj> findKhachHang() {
        List<KhachHangModel> foundKhachHang = khachHangDAO.queryKhachHang();
        return !foundKhachHang.isEmpty() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("Ok", "Query successfully", foundKhachHang)
                    //you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("Failed", "Cannot found", null)
            );
    }
}
