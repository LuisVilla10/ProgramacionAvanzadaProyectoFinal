import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class EliminarRegistro extends JFrame{

 	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbNumPago;
	private JTextField txtNumPago;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	public EliminarRegistro(){
	
		super("Eliminar Registro");
		setBounds(100,100,270,120);
		setLayout(new GridLayout(2,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int numPago=Integer.parseInt(txtNumPago.getText());		
					
			    try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("delete from Registro where NumPago='"+numPago+"'");

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
			lbNumPago= new JLabel("Numero de Pago");
			txtNumPago = new JTextField(10);
			btnEliminar = new JButton("Eliminar");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbNumPago);
			add(txtNumPago);
			add(btnEliminar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtNumPago.setText("");
		}

	public void agregarEventos(){
		btnEliminar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Eliminando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtNumPago.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
		
  public static void main(String arg[]){
    EliminarRegistro ef= new EliminarRegistro();

  }
}