

import com.kosta.mysql.ManagmentSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by papa on 24.03.2017.
 */
public class myModel {
ManagmentSystem ms;
Connection connection;
public myModel(){
String str=System.getProperty("user.home");
  ms=ManagmentSystem.getInstance(str+"\\file.dat");
  connection=ms.getConn();
}
    public ResultSet getResult(String c) throws Exception{
        ResultSet resultSet=null;
        if(c.equals("out")){
        Statement statement=connection.createStatement();
        String s="select * from tovari_ceni";
         resultSet=statement.executeQuery(s);}
        return resultSet;



    }
}
