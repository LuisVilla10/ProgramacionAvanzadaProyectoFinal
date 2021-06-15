import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class AgregarTienda extends JFrame{

	 Statement st= null;
	 SingleConnection c=new SingleConnection();

	private JLabel lbNumTienda, lbIdFactura, lbIdProducto, lbTotal;
	private JTextField txtNumTienda, txtIdFactura, txtIdProducto, txtTotal;
	private JButton btnAgregar;
	private JButton btnLimpiar;

	public AgregarTienda(){
	
		super("Agregar Tienda");
		setBounds(100,100,400,200);
		setLayout(new GridLayout(5,2));
		inicializar();
		agregarControles();
		agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int numTienda=Integer.parseInt(txtNumTienda.getText());
				int idFactura=Integer.parseInt(txtIdFactura.getText());
				String idProducto=txtIdProducto.getText();
				int total=Integer.parseInt(txtTotal.getText());					

			try{
				c.driver();
				st=c.conn.createStatement();
			 	int numtuplas = st.executeUpdate("insert into TIENDA values('"+numTienda+"','"+idFactura+"','"+idProducto+"','"+total+"')");

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
			lbNumTienda = new JLabel("Numero Tienda");
			lbIdFactura = new JLabel("Id de Factura");
			lbIdProducto = new JLabel("Id de Producto");
			lbTotal= new JLabel("Total");

			txtNumTienda = new JTextField(10);
			txtIdFactura = new JTextField(10);
			txtIdProducto = new JTextField(10);
			txtTotal = new JTextField(10);

			btnAgregar = new JButton("Agregar Datos");
			btnLimpiar = new JButton("Limpiar");
		}
		
		public void agregarControles(){
			add(lbNumTienda);
			add(txtNumTienda);
			add(lbIdFactura);
			add(txtIdFactura);
			add(lbIdProducto);
			add(txtIdProducto);
			add(lbTotal);
			add(txtTotal);
			add(btnAgregar);
			add(btnLimpiar);
		}
		
		private void Limpiar(){
			txtNumTienda.setText("");
			txtIdFactura.setText("");
			txtIdProducto.setText("");
			txtTotal.setText("");
		}

	public void agregarEventos(){
		btnAgregar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Guardando...");
				}
			});
		
		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtNumTienda.setText("");
					txtIdFactura.setText("");
					txtIdProducto.setText("");
					txtTotal.setText("");

					System.out.println("Limpiando...");
			}
		});
	}
}