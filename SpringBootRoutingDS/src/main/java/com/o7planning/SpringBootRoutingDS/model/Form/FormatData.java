package com.o7planning.SpringBootRoutingDS.model.Form;

import java.util.List;

import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;

public class FormatData {
    
    public List<NhanVienModel> FormatNhanVienOut(List<NhanVienModel> list){

        for (NhanVienModel nhanVienModel : list) {
            nhanVienModel.setHo(nhanVienModel.getHo().replace("-"," "));
            nhanVienModel.setTen(nhanVienModel.getTen().replace("-"," "));
            nhanVienModel.setDiaChi(nhanVienModel.getDiaChi().replace("-"," "));
        }
        return list;
    }

    public List<NhanVienModel> FormatNhanVienIn(List<NhanVienModel> list){

        for (NhanVienModel nhanVienModel : list) {
            nhanVienModel.setHo(nhanVienModel.getHo().replace(" ","-"));
            nhanVienModel.setTen(nhanVienModel.getTen().replace(" ","-"));
            nhanVienModel.setDiaChi(nhanVienModel.getDiaChi().replace(" ","-"));
        }
        return list;
    }

    public List<ChiNhanhModel> FormatChiNhanhOut(List<ChiNhanhModel> list){

        for (ChiNhanhModel nhanVienModel : list) {
            nhanVienModel.setTenCN(nhanVienModel.getTenCN().replace("-"," "));
            nhanVienModel.setDiaChi(nhanVienModel.getDiaChi().replace("-"," "));
        }
        return list;
    }

    public List<ChiNhanhModel> FormatChiNhanhIn(List<ChiNhanhModel> list){

        for (ChiNhanhModel nhanVienModel : list) {
            nhanVienModel.setTenCN(nhanVienModel.getTenCN().replace(" ","-"));
            nhanVienModel.setDiaChi(nhanVienModel.getDiaChi().replace(" ","-"));
        }
        return list;
    }
}
