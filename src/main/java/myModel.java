

import com.kosta.mysql.ManagmentSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
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
    ResultSet resultSet;

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
    String _out=null;
        if (c.equals("out")) {
            _out=ht.getProperty("out");
        }
        Statement statement = connection.createStatement();
        //String s = "select * from tovari_ceni";
        resultSet = statement.executeQuery(_out);

        return resultSet;
}


    }

