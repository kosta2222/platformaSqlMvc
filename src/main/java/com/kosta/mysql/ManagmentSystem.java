package com.kosta.mysql;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ManagmentSystem{
private static Connection conn;
private static ManagmentSystem instance;
private FileInputStream fin;
private Properties ht;
private static String URL="";
private static String USERNAME="";
private static  String PASSWORD="";
private static String DB_NAME="";
private static String DRIVER="";
Logger logger=null;

private ManagmentSystem(String pathToConfig){
     logger=Logger.getLogger(ManagmentSystem.class.getName());
ht=new Properties();
try{
fin=new FileInputStream(pathToConfig);
if(fin!=null){
ht.load(fin);
fin.close();
}

}catch(FileNotFoundException e){
//System.out.println("Ne mogu naiti conf fail ["+e+"]");
logger.log(Level.SEVERE,"Ne mogu naiti conf fail",e );
}
catch(IOException e){
//System.out.println("Oshibka chteniya conf faila ["+e+"]");
logger.log(Level.SEVERE,"Oshibka chteniya conf faila ",e );
}
URL=(String)ht.get("url");
DB_NAME=(String)ht.get("db_name");
USERNAME=(String)ht.get("username");
PASSWORD="";
DRIVER=(String)ht.get("driver");


try{
Class.forName(DRIVER);

}catch(Exception e){

logger.log(Level.SEVERE,"Proizoshla oshibka pri sozdanii draivera",e );
return;
}
}
public static synchronized ManagmentSystem getInstance(String pathToConfig){
        if(instance == null) {
            instance = new ManagmentSystem(pathToConfig);
        }
        return instance;
    }
public  Connection getConn(){

 try{
     conn=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);

}catch(SQLException e){
//    ex.printStackTrace();
logger.logp(Level.SEVERE,"ManagmentSystem","getConn","Proizoshla oshibka pri sozdanii soedineniya",e );
}
return conn;
}
}




 

