package com.o7planning.SpringBootRoutingDS.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import com.o7planning.SpringBootRoutingDS.dao.ChiNhanhDAO;
import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class PublicController {

    @Autowired
    private ChiNhanhDAO chiNhanhDAO;

    @GetMapping(path = "/home" )
    public String home(ModelMap model, HttpSession session) {
        if(session.getAttribute("role") == null) return "redirect:/login";
        List<ChiNhanhModel> listCN = chiNhanhDAO.queryAllChiNhanh();
        model.addAttribute("chinhanh", listCN);

        return "home";
    }

    @GetMapping(path = { "/", "/login" })
    public String loginGet(ModelMap model, HttpSession session) {

        if(session.getAttribute("role") != null) return "redirect:/vi/nhanvien/";
        List<ChiNhanhModel> listCN = chiNhanhDAO.queryAllChiNhanh();
        model.addAttribute("chinhanh", listCN);

        return "index";
    }

    @PostMapping(path = "/login")
    public String loginPost(ModelMap model,
            @RequestParam("chinhanh") String chinhanh,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        // handling login
        String url = "http://localhost:8080/" + chinhanh.trim() + "/" + username.trim() + "/" + password.trim() + "/login";
        System.out.println(url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseObj result = restTemplate.getForObject(url, ResponseObj.class);
            
            if (Objects.equals(result.getStatus(), "Ok")){

                // String data = result.getData().toString().replaceAll("}", "").toString();
                // String[] listData = data.split(",");
                
                // session.setAttribute("nameuser", listData[0].toString().split("=")[1].toString());
                // session.setAttribute("codenv", listData[1].toString().split("=")[1].toString());
                // session.setAttribute("codecn", listData[2].toString().split("=")[1].toString());
                // session.setAttribute("role", listData[3].toString().split("=")[1].toString());
                HashAPI api = new HashAPI();
                Hashtable<String, String> data = api.hashDataAPILogin(result.getData().toString());
                session.setAttribute("nameuser", data.get("nameuser"));
                session.setAttribute("codenv", data.get("codenv"));
                session.setAttribute("codecn", data.get("codecn"));
                session.setAttribute("role", data.get("role"));

                return "redirect:/vi/nhanvien/";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        model.addAttribute("message", "Tài khoản hoặc mật khẩu sai với chi nhánh");
        
        List<ChiNhanhModel> listCN = chiNhanhDAO.queryAllChiNhanh();
        model.addAttribute("chinhanh", listCN);

        return "index";
    }

    @GetMapping(path = "/logout")
    public String logout(ModelMap model, HttpSession session){

        session.removeAttribute("nameuser");
        session.removeAttribute("codenv");
        session.removeAttribute("role");
        session.removeAttribute("codecn");
        return "index";
    }

    @GetMapping(path = "/403")
    public String error403(ModelMap model) {
        return "403";
    }

    @GetMapping(path = "/nhanvien")
    public String nhanVien() {
        return "nhanvien";
    }
    @GetMapping(path = "/khachhang")
    public String khachHang() {
        return "khachhang";
    }
    @GetMapping(path = "/taikhoan")
    public String taiKhoan() {
        return "taikhoan";
    }
    @GetMapping(path = "/thongke")
    public String thongKe() {
        return "thongke";
    }
}
