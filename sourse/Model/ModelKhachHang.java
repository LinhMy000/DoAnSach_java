/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connection.KhachHangDAO;
import Table.KhachHang;
import java.util.List;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ModelKhachHang {
    KhachHangDAO  khd = null;

    public ModelKhachHang() {
        this.khd = new KhachHangDAO();
    }
    
  

    public List<KhachHang> getList() {
        return khd.getList();
    }
    
     public int createOrUpdate(KhachHang khachhang){
        return khd.createOrUpdate(khachhang);
        
    }
     public int DeLeTe(KhachHang khachhang){
         return khd.DeLeTe(khachhang);
     }
     
     
}
