import org.junit.Test;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: EXAM-19613-20180813-1
 * @author: kangeroo
 * @create: 2018-08-13 09:58
 **/
public class test {
    @Test
    public void login(){
        Connection con = null;
        PreparedStatement st = null;
        int flag=0;
        try {
            con=JDBCUtils.getConnection();
            String sql="insert into film (title,description,language_id) values (?,?,?)";
            st=con.prepareStatement(sql);
            st.setString(1,"test");
            st.setString(2,"test");
            st.setString(3,"1");
            flag=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(flag);
    }
}
