package com.o7planning.SpringBootRoutingDS.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;
import com.o7planning.SpringBootRoutingDS.model.Form.FormatData;
import com.o7planning.SpringBootRoutingDS.model.Form.ResponseObj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/vi/nhanvien")
public class NhanVienController {

    private HashAPI hashAPI = new HashAPI();
    private FormatData formatData = new FormatData();

    
    private boolean checkAuthor(ModelMap model, HttpSession session){

        String maChiNhanh = (String) session.getAttribute("codecn");
        String quyen = (String) session.getAttribute("role");

        if(maChiNhanh == null || quyen == null) return false;

        return true;
    }

    @GetMapping(path = "/")
    public String viewNhanVien(ModelMap model, HttpSession session){
        if(!checkAuthor(model, session)) return "redirect:/login";

        String uriCN = "http://localhost:8080/";
        String uriNV = "http://localhost:8080/";
        if(session.getAttribute("role").equals("NGANHANG")){
            if(session.getAttribute("codecn").equals("BENTHANH")){
                uriNV += "benthanh/nhanvien";
                uriCN += "benthanh/chinhanh";
            } else {
                uriNV += "tandinh/nhanvien";
                uriCN += "tandinh/chinhanh";
            }
            //model.addAttribute("listCN", chiNhanhDAO.queryAllChiNhanh());
            //model.addAttribute("listNV", nhanVienDAO.queryAllNhanVien());
        }
        else {
            if(session.getAttribute("codecn").equals("BENTHANH")){
                uriNV += "benthanh/nhanvienbt";
                uriCN += "benthanh/chinhanhcn";
            } else {
                uriNV += "tandinh/nhanvientd";
                uriCN += "tandinh/chinhanhtd";
            }
            //model.addAttribute("listCN", chiNhanhDAO.queryChiNhanh());
            //model.addAttribute("listNV", nhanVienDAO.queryNhanVien());
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseObj resultCN = restTemplate.getForObject(uriCN, ResponseObj.class);
        ResponseObj resultNV = restTemplate.getForObject(uriNV, ResponseObj.class);


        List<ChiNhanhModel> cn = hashAPI.hashDataAPIChiNhanh(resultCN.getData().toString());
        List<NhanVienModel> nv = hashAPI.hashDataAPINhanVien(resultNV.getData().toString());

        cn = formatData.FormatChiNhanhOut(cn);
        nv = formatData.FormatNhanVienOut(nv);

        model.addAttribute("listCN", cn);
        model.addAttribute("listNV", nv);
        return "nhanvien";
    }


    // @GetMapping(path = "/test")
    // public String test1(){

    //     String url = "http://localhost:8080/benthanh/nhanvien";
    //     String url2 = "http://localhost:8080/benthanh/nhanvienbt";
    //     HashAPI hashAPI = new HashAPI();

    //     try {
    //         RestTemplate restTemplate = new RestTemplate();
    //         ResponseObj result = restTemplate.getForObject(url, ResponseObj.class);
    //         ResponseObj result2 = restTemplate.getForObject(url2, ResponseObj.class);
            
    //         List<NhanVienModel> nv1 = hashAPI.hashDataAPINhanVien(result.getData().toString());
    //         List<NhanVienModel> nv2 = hashAPI.hashDataAPINhanVien(result2.getData().toString());

    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }

    //     return "taikhoan";
    // }
}
