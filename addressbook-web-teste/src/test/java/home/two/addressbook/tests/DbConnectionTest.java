package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import home.two.addressbook.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by ndya on 21.12.2016.
 */
public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");
      //"jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id")).withGroupName(rs.getString("group_name")).
                withFooter(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(groups);


    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}
