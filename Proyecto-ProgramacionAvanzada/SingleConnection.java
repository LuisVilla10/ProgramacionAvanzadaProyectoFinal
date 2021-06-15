import java.sql.*;
import javax.swing.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Vector;

public class SingleConnection{
	String user;
	String pass;
	String url;
	Connection conn;
	Statement stm;


	public SingleConnection() {
		user = "system";
		pass = "calamardo";
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		conn = null;
		stm = null;

	}

	public void driver() throws SQLException {
		 try {
            
            URLClassLoader classLoader = ((URLClassLoader) ClassLoader.getSystemClassLoader());
            Method metodoAdd = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
            metodoAdd.setAccessible(true);

            URL url2 = new URL("file:///C:/Users/luisa/Documents/Proyecto-ProgramacionAvanzada/ojdbc6.jar");
            
            metodoAdd.invoke(classLoader, new Object[] { url2 });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

	/*------------------------------------------------------------------------------------------------*/
   public int actualizarCliente(String atributo, String nuevo, String id) throws SQLException{
        stm = conn.createStatement();
        try{
            int r=0;
            r= stm.executeUpdate("update CLIENTE set "+atributo+" = '" + nuevo + "'" + " where IDCLIENTE= '" + id + "'");
            return r;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    }

    public int actualizarTienda(String atributo, String nuevo, int id) throws SQLException{
        stm = conn.createStatement();
        try{
            int r=0;
            r= stm.executeUpdate("update Tienda set "+atributo+" = '" + nuevo + "'" + " where NUMTIENDA= '" + id + "'");
            return r;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    }  


    /*public int actualizarRegistro(String atributo, String nuevo, int id) throws SQLException{
        stm = conn.createStatement();
        try{
            int r=0;
            r= stm.executeUpdate("update REGISTRO set "+atributo+" = '" + nuevo + "'" + " where NUMREGISTRO = '" + id + "'");
            return r;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    }  */           

    public int actualizarProducto(String atributo, String nuevo, String id) throws SQLException{
        stm = conn.createStatement();
        try{
            int r=0;
            r= stm.executeUpdate("update PRODUCTO set "+atributo+" = '" + nuevo + "'" + " where IDPRODUCTO = '" + id + "'");
            return r;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    } 

	/*------------------------------------------------------------------------------------------------*/
	public JScrollPane datosTabla(String sql){
		ArrayList columnNames = new ArrayList();
       	ArrayList data = new ArrayList();
		try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            
            for (int i = 1; i <= columns; i++)
                columnNames.add( md.getColumnName(i) );

            while (rs.next()){
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                    row.add(rs.getObject(i));
                
                data.add(row);
            }
            rs.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++){
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
                subVector.add(subArray.get(j));
            
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));
 
        JTable table = new JTable(dataVector, columnNamesVector){
           
            public Class getColumnClass(int column){
                for (int row = 0; row < getRowCount(); row++){
                    Object object = getValueAt(row, column);
                    if (object != null)
                        return object.getClass();
                    
                }
                 
                return Object.class;
            }
        };
        
        JScrollPane scroll = new JScrollPane(table);
       return scroll;

    }

    public void cerrar() throws SQLException{
		
		conn.close();
		stm.close();
	}
}
    

	