import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class EliminarTienda extends JFrame{

 	Statement st= null;
	SingleConnection c=new SingleConnection();
     
	private JLabel lbNumTienda;
	private JTextField txtNumTienda;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	public EliminarTienda(){
	
		super("Eliminar Tienda");
		setBounds(100,100,270,120);
		setLayout(new GridLayout(2,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int numTienda=Integer.parseInt(txtNumTienda.getText());		

			   try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("delete from Tienda where NUMTIENDA='"+numTienda+"'");

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
			lbNumTienda= new JLabel("Numero de Tienda");

			txtNumTienda = new JTextField(10);

			btnEliminar = new JButton("Eliminar");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbNumTienda);
			add(txtNumTienda);
			add(btnEliminar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtNumTienda.setText("");
		}

	public void agregarEventos(){
		btnEliminar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Eliminando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtNumTienda.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
		
  public static void main(String arg[]){
    EliminarTienda ed = new EliminarTienda();

  }
}