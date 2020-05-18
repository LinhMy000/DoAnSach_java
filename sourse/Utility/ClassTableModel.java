/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Table.KhachHang;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ClassTableModel {
    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem,String[] listColumn){
        DefaultTableModel dtm =  new DefaultTableModel(){
           public boolean isCellEdiTable(int row, int column){
               return false;
           }
           public Class<?> getColumnClass(int ColumnIndex){
               return ColumnIndex == 6 ? Boolean.class: String.class;
               
           }
        };
        dtm.setColumnIdentifiers(listColumn);
        int column = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows>0){
            for(int i =0;i<rows;i++){
                KhachHang khachhang = listItem.get(i);
                obj = new Object[column];
                obj[0]= khachhang.getMaKH();
                obj[1]= khachhang.getHoTen();
                obj[2]= khachhang.getNgaySinh();
                obj[3]= khachhang.getSdt();
                obj[4]= khachhang.getDiaChi();
                obj[5]= khachhang.getDiem();
                
                dtm.addRow(obj);
                
            }
        }
        
        
        return dtm;
    }
}
