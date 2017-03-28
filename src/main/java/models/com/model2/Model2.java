package models.com.model2;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model2{
public String[][] resultSetToArr(ResultSet rs,int n_stroki,int m_kolonki){
String arr[][]=new String[n_stroki][m_kolonki];
    try {

        for(int i=0;i<m_kolonki;i++){
            rs.next();
        for(int j=0;j<n_stroki;j++){

                arr[i][j]=rs.getString(j+1);

        }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return arr;
}

}

