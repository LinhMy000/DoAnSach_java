/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Table.Sach;
import Connection.SachDAO;
import Connection.SachDAOImpl;
import java.util.List;


public class SachServiceImpl implements SachService {
    private SachDAO sachDAO = null;
    
    public SachServiceImpl(){
        this.sachDAO = new SachDAOImpl();
    }
    @Override
    public List<Sach> getlist(){
        return sachDAO.getlist();
    }
}
