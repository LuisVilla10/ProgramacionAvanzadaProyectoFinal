import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class AgregarCliente extends JFrame{
	
	Statement st= null;
	SingleConnection c=new SingleConnection();

	private JLabel lbIdCliente, lbNombre, lbDireccion, lbEmail;
	private JTextField txtIdCliente, txtNombre, txtDireccion, txtEmail;
	private JButton btnAgregar;
	private JButton btnLimpiar;

	public AgregarCliente(){
	
		super("Agregar Cliente");
		setBounds(100,100,450,250);
		setLayout(new GridLayout(5,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String idCliente=txtIdCliente.getText();
				String nombre=txtNombre.getText();
				String direccion=txtDireccion.getText();
				String email=txtEmail.getText();					

				try{
					c.driver();
					st=c.conn.createStatement();
				 	int numtuplas = st.executeUpdate("insert into Cliente values('"+idCliente+"','"+nombre+"','"+direccion+"','"+email+"')");
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
			lbIdCliente = new JLabel("IdCliente");
			lbNombre = new JLabel("Nombre");
			lbDireccion = new JLabel("Direccion");
			lbEmail= new JLabel("E-mail");

			txtIdCliente = new JTextField(10);
			txtNombre = new JTextField(40);
			txtDireccion = new JTextField(50);
			txtEmail = new JTextField(20);

			btnAgregar = new JButton("Agregar Datos");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbIdCliente);
			add(txtIdCliente);
			add(lbNombre);
			add(txtNombre);
			add(lbDireccion);
			add(txtDireccion);
			add(lbEmail);
			add(txtEmail);
			add(btnAgregar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtIdCliente.setText("");
			txtNombre.setText("");
			txtDireccion.setText("");
			txtEmail.setText("");
		}

	public void agregarEventos(){
		btnAgregar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Guardando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtIdCliente.setText("");
					txtNombre.setText("");
					txtDireccion.setText("");
					txtEmail.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
		
}