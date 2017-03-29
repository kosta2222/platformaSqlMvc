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

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void viewJframe(){
        JFrame jf=new JFrame();

        String [][]  arr= model2.resultSetToArr(resultSet,4);
        String [] arr2={"1","2","3","4"};
        JTable jTable=new JTable(arr,arr2);
        jf.add(jTable);
        jf.setSize(500,700);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
