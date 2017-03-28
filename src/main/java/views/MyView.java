package views;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.com.model1.*;
import models.com.model2.*;

import javax.swing.*;

/**
 * Created by papa on 26.03.2017.
 */
public class MyView  {
    String s=null;
    ResultSet resultSet=null;
    myModel model=null;
    Model2 model2=null;

    public MyView() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
         model=new myModel();
         model2=new Model2();
        try {
            s=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
             resultSet=model.getResult(s);
             viewJframe();
            /*while (resultSet.next()) {
                System.out.println(resultSet.getString(2) +"|" +
                        resultSet.getString(3)+"|" +resultSet.getString(4)
                );
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void viewJframe(){
        int n=0;
        try {
             n=resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String [][]  arr= model2.resultSetToArr(resultSet,n,4);
        JTable jTable=new JTable(arr,null);
        jTable.setVisible(true);
    }
}
