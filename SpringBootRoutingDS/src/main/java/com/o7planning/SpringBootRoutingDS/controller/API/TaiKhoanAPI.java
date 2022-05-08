package com.o7planning.SpringBootRoutingDS.controller.API;

import java.util.List;

import com.o7planning.SpringBootRoutingDS.dao.TaiKhoanDAO;
import com.o7planning.SpringBootRoutingDS.model.TaiKhoanModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaiKhoanAPI {
        @Autowired
        private TaiKhoanDAO taiKhoanDAO;

        @GetMapping(path = {"/benthanh/taikhoan", "/tandinh/taikhoan"})
        ResponseEntity<ResponseObj> findAllTaiKhoan() {
        List<TaiKhoanModel> foundTaiKhoan = taiKhoanDAO.queryAllTaiKhoan();
        return !foundTaiKhoan.isEmpty() ?
        ResponseEntity.status(HttpStatus.OK).body(
        new ResponseObj("Ok", "Query successfully", foundTaiKhoan)
        //you can replace "ok" with your defined "error code"
        ):
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        new ResponseObj("Failed", "Cannot found", null)
        );
        }

        @GetMapping(path = { "/benthanh/taikhoanbt", "/tandinh/taikhoantd" })
        ResponseEntity<ResponseObj> findTaiKhoan() {
                List<TaiKhoanModel> foundTaiKhoan = taiKhoanDAO.queryTaiKhoan();
                return !foundTaiKhoan.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(
                                new ResponseObj("Ok", "Query successfully", foundTaiKhoan)
                // you can replace "ok" with your defined "error code"
                )
                                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                                                new ResponseObj("Failed", "Cannot found", null));
        }
}
