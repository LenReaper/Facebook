import java.sql.SQLException;

public class FBConnectorUsingDB {

	public static void main(String[] args) throws SQLException {
		DBConnectionPicker dbc = new DBConnectionPicker();
		dbc.fblogin();
	}

}
