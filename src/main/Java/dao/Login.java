package dao;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: EXAM-19613-20180813-1
 * @author: kangeroo
 * @create: 2018-08-13 09:36
 **/
public class Login {
    public static Boolean login(String name){
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con=JDBCUtils.getConnection();
            String sql="select customer_id from customer where first_name=?";
            st=con.prepareStatement(sql);
            st.setString(1,name);
            rs=st.executeQuery();
            if (rs.next())
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.colseResource(con,st,rs);
        }
        return false;
    }

}
