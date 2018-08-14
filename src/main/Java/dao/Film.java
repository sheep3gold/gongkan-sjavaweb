package dao;

import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: EXAM-19613-20180813-1
 * @author: kangeroo
 * @create: 2018-08-13 10:45
 **/
public class Film {
    public static List getFilm() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List list=new ArrayList();
        try {
            con=JDBCUtils.getConnection();
            String sql="select f.film_id,f.title,f.description,l.name from film f,language l where f.language_id=l.language_id order by f.film_id";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            ResultSetMetaData md=rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                Map<String,Object> rowData = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.colseResource(con,st,rs);
        }
        return list;
    }
    public static boolean deleteFilm(String id){
        Connection con = null;
        PreparedStatement st = null;
        int flag=0;
        try {
            con=JDBCUtils.getConnection();
            String sql="delete from film where film_id=?";
            st=con.prepareStatement(sql);
            st.setString(1,id);
            flag=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag == 1;
    }
    public static boolean addFilm(String title,String description,String language){
        Connection con = null;
        PreparedStatement st = null;
        int flag=0;
        try {
            con=JDBCUtils.getConnection();
            String sql="insert into film (title,description,language_id) values (?,?,?)";
            st=con.prepareStatement(sql);
            st.setString(1,title);
            st.setString(2,description);
            st.setString(3,language);
            flag=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag == 1;
    }
    public static boolean updateFilm(String title,String description,String language,String id){
        Connection con = null;
        PreparedStatement st = null;
        int flag=0;
        try {
            con=JDBCUtils.getConnection();
            String sql="update film set title=?,description=?,language_id=? where film_id=?";
            st=con.prepareStatement(sql);
            st.setString(1,title);
            st.setString(2,description);
            st.setString(3,language);
            st.setString(4,id);
            flag=st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag==1;
    }
}
