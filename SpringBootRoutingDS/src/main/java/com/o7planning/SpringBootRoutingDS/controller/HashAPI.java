package com.o7planning.SpringBootRoutingDS.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;

public class HashAPI {
    
    
    public List<NhanVienModel> hashDataAPIListNhanVien(String json){
        String[] data = json.split("},");
        List<NhanVienModel> list = new ArrayList<NhanVienModel>();
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace(" ", "");
            data[i] = data[i].replace("{", "");
            data[i] = data[i].replace("}", "");
            
            String[] cut = data.toString().split(",");
            NhanVienModel nhanvien = new NhanVienModel();
            nhanvien.setMaNV(cut[i].split("=").toString());
            nhanvien.setHo(cut[i].split("=").toString());
            nhanvien.setTen(cut[i].split("=").toString());
            nhanvien.setDiaChi(cut[i].split("=").toString());
            nhanvien.setPhai(cut[i].split("=").toString());
            nhanvien.setMaCN(cut[i].split("=").toString());
            nhanvien.setSDT(cut[i].split("=").toString());
            nhanvien.setTTXoa(Boolean.valueOf(cut[i].split("=").toString()));
            list.add(nhanvien);

        }
        return list;
    }

    public List<NhanVienModel> hashDataAPINhanVien(String json){
        List<NhanVienModel> list = new ArrayList<NhanVienModel>();
        String[] data = json.toString().split("},");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace(" ", "");
            data[i] = data[i].replace("{", "");
            data[i] = data[i].replace("}", "");
            
            String[] cut = data[i].toString().split(",");
            NhanVienModel nhanvien = new NhanVienModel();
            nhanvien.setMaNV(cut[0].toString().split("=")[1]);
            nhanvien.setHo(cut[1].toString().split("=")[1]);
            nhanvien.setTen(cut[2].toString().split("=")[1]);
            nhanvien.setDiaChi(cut[3].toString().split("=")[1]);
            nhanvien.setPhai(cut[4].toString().split("=")[1]);
            nhanvien.setMaCN(cut[5].toString().split("=")[1]);
            nhanvien.setSDT(cut[6].toString().split("=")[1]);
            nhanvien.setTTXoa(Boolean.valueOf(cut[7].toString().split("=")[1]));
            list.add(nhanvien);
            
        }

        return list;
    }

    public List<ChiNhanhModel> hashDataAPIChiNhanh(String json){
        List<ChiNhanhModel> list = new ArrayList<ChiNhanhModel>();
        String[] data = json.toString().split("},");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace(" ", "");
            data[i] = data[i].replace("{", "");
            data[i] = data[i].replace("}", "");
        
            String[] cut = data[i].toString().split(",");
            ChiNhanhModel chinhanh = new ChiNhanhModel();
            chinhanh.setMaCN(cut[0].toString().split("=")[1]);
            chinhanh.setTenCN(cut[1].toString().split("=")[1]);
            chinhanh.setDiaChi(cut[2].toString().split("=")[1]);
            chinhanh.setSDT(cut[3].toString().split("=")[1]);
 
            list.add(chinhanh);
        }
        return list;
    }


    public Hashtable<String, String> hashDataAPILogin(String json){

        String data = json.replaceAll("}", "").toString();
        String[] listData = data.split(",");
        Hashtable<String, String> result = new Hashtable<String, String>();
        result.put("nameuser", listData[0].toString().split("=")[1].toString());
        result.put("codenv", listData[1].toString().split("=")[1].toString());
        result.put("codecn", listData[2].toString().split("=")[1].toString());
        result.put("role", listData[3].toString().split("=")[1].toString());

        return result;
    }
}
