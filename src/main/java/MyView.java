import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;

/**
 * Created by papa on 26.03.2017.
 */
public class MyView  {
    String s=null;
    public MyView() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        myModel model=new myModel();
        try {
            s=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultSet resultSet=null;
        try {
             resultSet=model.getResult(s);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) +"|" +
                        resultSet.getString(3)+"|" +resultSet.getString(4)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
