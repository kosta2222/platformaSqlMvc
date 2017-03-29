package models.com.model2;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.com.model1.*;

public class Model2{
public String[][] resultSetToArr(ResultSet rs,int m_kolonki){
    myModel myModel=new myModel();

String arr[][]=null;
    try {
        int n_rows= myModel.getRows();
        arr=new String[n_rows][m_kolonki];

        int i=0;
        while (rs.next()) {
            for(int j=0;j<m_kolonki;j++) {
                arr[i][j] = rs.getString(j+1);
            }
            i++;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return arr;
}

}

