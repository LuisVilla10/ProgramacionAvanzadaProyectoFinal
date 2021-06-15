import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class EliminarProducto extends JFrame{

 	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbNombre;
	private JTextField txtNombre;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	public EliminarProducto(){
	
		super("Eliminar Producto");
		setBounds(100,100,270,120);
		setLayout(new GridLayout(2,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nombre=txtNombre.getText();	

			    try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("delete from PRODUCTO where Nombre='"+nombre+"'");

			     if(numtuplas == 1){
			     	System.out.println("Tupla elminada correctamente");
			     	JOptionPane.showMessageDialog(null, "Los datos se han eliminado correctamente");
			     }

			  	}catch(Exception ex){
		          ex.printStackTrace();
		   		}	
				}
			});
		}	

		public void inicializar(){
			lbNombre= new JLabel("Nombre del Producto");
			txtNombre = new JTextField(10);

			btnEliminar = new JButton("Eliminar");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbNombre);
			add(txtNombre);
			add(btnEliminar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtNombre.setText("");
		}

	public void agregarEventos(){
		btnEliminar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Eliminando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtNombre.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
		
  public static void main(String arg[]){
    EliminarProducto ep = new EliminarProducto();

  }
}