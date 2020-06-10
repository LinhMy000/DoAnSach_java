/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.util.ArrayList;
import java.util.List;
import Table.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface SachDAO {
    public List<Sach> getlist();
}
   