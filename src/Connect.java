import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Connect {
	
	public static void main(String args[]){
		
		Connection conn = null;
		String className = "com.ibm.db2.jcc.DB2Driver";
		String path = "jdbc:db2://localhost:50000/LOGIN";
		String user = "lao";
		String pass = "invalid";
		String sql = null;
		ResultSet rs =null;
		Statement st = null;
		
		//Scanner sc = new Scanner(System.in);
		
		try{
			//register path or class to memory
			Class.forName(className);
		
		conn = DriverManager.getConnection(path,user,pass);
		
		//System.out.println("Enter query: ");
		//String query = sc.nextLine();
		
		sql = "select * from userinfo order by firstname desc";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()){
			String firstN = rs.getString("firstname");
			String lastN = rs.getString("lastname");
			String gender = rs.getString("gender");
			
			
			System.out.println(firstN+ "\t" +lastN+ "\t" +gender);
			//System.out.println(firstN);
		}
		
		
		
		
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				//System.out.print("Connection found.");
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
