import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class EliminarCliente extends JFrame{

	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbIdCliente;
	private JTextField txtIdCliente;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	public EliminarCliente(){
	
		super("Eliminar Cliente");
		setBounds(100,100,270,120);
		setLayout(new GridLayout(2,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String idCliente=txtIdCliente.getText();		

			    try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("delete from Cliente where idCliente='"+idCliente+"'");
			 	int numtuplas2 = st.executeUpdate("delete from FACTURA where idCliente='"+idCliente+"'");

			 	JOptionPane.showMessageDialog(null, "Los datos se han eliminado correctamente");

			  	}catch(Exception ex){
		          ex.printStackTrace();
		   		}	
				}
			});
		}	

		public void inicializar(){
			lbIdCliente = new JLabel("Id del Cliente");

			txtIdCliente = new JTextField(10);

			btnEliminar = new JButton("Eliminar");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbIdCliente);
			add(txtIdCliente);
			add(btnEliminar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtIdCliente.setText("");
		}

	public void agregarEventos(){
		btnEliminar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Eliminando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtIdCliente.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
}