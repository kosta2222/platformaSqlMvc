package models.com.model1;

import com.kosta.mysql.ManagmentSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by papa on 24.03.2017.
 */
public class myModel {
    ManagmentSystem ms;
    Connection connection;
    private FileInputStream fin;
    private Properties ht;
    ResultSet resultSet=null;

    public myModel() {
        String str = System.getProperty("user.home");
        ht = new Properties();
        try {
            fin = new FileInputStream(str + "\\A_platformaSql.dat");
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ms = ManagmentSystem.getInstance(str + "\\A_connect.dat");
        connection = ms.getConn();
    }

    public ResultSet getResult(String c) throws Exception {
    String _createDb=null;
    String _out=null;
        if (c.equals("out")) {
            _out=ht.getProperty("out");
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(_out);
        }
        if(c.equals("createDb")){
            _createDb=ht.getProperty("createDb");
            Statement statement = connection.createStatement();
             statement.executeUpdate(_createDb);
        }


        return resultSet;
}
public int getRows(){
    String _count=ht.getProperty("count");
    int c=0;
    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet1=statement.executeQuery(_count);
        resultSet1.next();
         c=resultSet1.getInt(1);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return c;

}


    }

