import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class AgregarProducto extends JFrame{

	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbIdProducto, lbNombre, lbPrecio;
	private JTextField txtIdProducto, txtNombre, txtPrecio;
	private JButton btnAgregar;
	private JButton btnLimpiar;

	public AgregarProducto(){
	
		super("Agregar Producto");
		setBounds(100,100,400,200);
		setLayout(new GridLayout(4,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String idProducto=txtIdProducto.getText();
				String nombre=txtNombre.getText();
				int precio=Integer.parseInt(txtPrecio.getText());					

			   try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("insert into PRODUCTO values('"+idProducto+"','"+nombre+"','"+precio+"')");
			     if(numtuplas == 1){
			     	System.out.println("Tupla insertada correctamente");
			     	JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente");
			     }

			  	}catch(Exception ex){
		          ex.printStackTrace();
		   		}			
				}
			});
		}	

		public void inicializar(){
			lbIdProducto= new JLabel("Id Producto");
			lbNombre = new JLabel("Nombre del Producto");
			lbPrecio = new JLabel("Precio");

			txtIdProducto = new JTextField(10);
			txtNombre = new JTextField(40);
			txtPrecio = new JTextField(10);

			btnAgregar = new JButton("Agregar Datos");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbIdProducto);
			add(txtIdProducto);
			add(lbNombre);
			add(txtNombre);
			add(lbPrecio);
			add(txtPrecio);
			add(btnAgregar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtIdProducto.setText("");
			txtNombre.setText("");
			txtPrecio.setText("");
		}

	public void agregarEventos(){
		btnAgregar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Guardando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtIdProducto.setText("");
					txtNombre.setText("");
					txtPrecio.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
}