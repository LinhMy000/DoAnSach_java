/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;


import Table.Sach;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khanh Vo
 */
public class ClassTableModelSach {
   public DefaultTableModel setTableSach(List<Sach> listItem, String[] listColumn)
   {
       DefaultTableModel dtm = new DefaultTableModel(){
           @Override
           public boolean isCellEditable(int row, int column) {
               return false; //To change body of generated methods, choose Tools | Templates.
           }

          @Override
           public Class<?> getColumnClass(int i) {
               return i == 6 ? Boolean.class : String.class ; 
           }
           
          
           
           
       };
       dtm.setColumnIdentifiers(listColumn);
       int columns = listColumn.length;
       Object[] obj = null;
       int rows = listItem.size();
       if(rows > 0){
           for(int i = 0; i<rows; i++){
               Sach sach = listItem.get(i);
               obj = new Object[columns];
               obj[0]= (i+1);
               obj[1] = sach.getMaSach();
               obj[2] = sach.getTenSach();
               obj[3] = sach.getTacGia();
               obj[4] = sach.getGia();
               obj[5] = sach.getSoLuong();
                dtm.addRow(obj);
            }
       }
       return dtm;
   }
}
