/*import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class AgregarRegistro extends JFrame{

	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbNumRegistro, lbIdCliente, lbFecha, lbNumPago;
	private JTextField txtNumRegistro, txtIdCliente, txtFecha, txtNumPago;
	private JButton btnAgregar;
	private JButton btnLimpiar;

	public AgregarRegistro(){
	
		super("Agregar Registro");
		setBounds(100,100,400,200);
		setLayout(new GridLayout(5,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int numRegistro=Integer.parseInt(txtNumRegistro.getText());
				String idCliente=txtIdCliente.getText();
				String fecha=txtFecha.getText();
				int numPago=Integer.parseInt(txtNumPago.getText());					

			    try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("insert into Registro values('"+numRegistro+"','"+idCliente+"','"+fecha+"','"+numPago+"')");

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
			lbNumRegistro= new JLabel("Numero de Registro");
			lbIdCliente = new JLabel("Id de Cliente");
			lbFecha = new JLabel("Fecha");
			lbNumPago= new JLabel("Numero de Pago");

			txtNumRegistro = new JTextField(10);
			txtIdCliente = new JTextField(10);
			txtFecha = new JTextField(30);
			txtNumPago = new JTextField(10);

			btnAgregar = new JButton("Agregar Datos");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbNumRegistro);
			add(txtNumRegistro);
			add(lbIdCliente);
			add(txtIdCliente);
			add(lbFecha);
			add(txtFecha);
			add(lbNumPago);
			add(txtNumPago);
			add(btnAgregar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtNumRegistro.setText("");
			txtIdCliente.setText("");
			txtFecha.setText("");
			txtNumPago.setText("");
		}

	public void agregarEventos(){
		btnAgregar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Guardando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtNumRegistro.setText("");
					txtIdCliente.setText("");
					txtFecha.setText("");
					txtNumPago.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
}*/