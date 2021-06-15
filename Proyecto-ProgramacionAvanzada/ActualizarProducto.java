import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ActualizarProducto extends JFrame{

	JLabel lbTitulo, lbCampo, lbNuevo;
	JTextField txtID, txtNuevo;
	JButton btnActualizar;
	JButton btnLimpiar;
	JComboBox combo1 = new JComboBox();


	public ActualizarProducto(){
	
		super("Actualizar Producto");
		setBounds(100,100,600,400);
		setLayout(new GridLayout(4,2));
		this.inicializar();
		this.agregarControles();
		this.agregarEventos();

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true); 

	}	

		public void inicializar(){
			
			lbTitulo = new JLabel("Introduce el ID del Producto a actualizar");
			lbCampo = new JLabel("Elige el atributo a actualizar");
			lbNuevo = new JLabel("Introduce el nuevo valor para el atributo ");

			txtID = new JTextField(10);
			txtNuevo = new JTextField(20);

			btnActualizar = new JButton("Actualizar Campo");
			btnLimpiar = new JButton("Limpiar");
			

		}
		
		public void agregarControles(){
			combo1.addItem("Nombre");
			combo1.addItem("Precio");
			add(lbTitulo);
			add(txtID);
			add(lbCampo);
			add(combo1);
			add(lbNuevo);
			add(txtNuevo);
			add(btnActualizar);
			add(btnLimpiar);
		}	


	public void agregarEventos(){
		btnActualizar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){

					try{

						SingleConnection con = new SingleConnection();
						String atributo = (String) combo1.getSelectedItem();
						
						String id = txtID.getText();
						int t2 =0, t=0;
						con.driver();

						if(atributo.equals("Precio")){

							int nuevo2 = Integer.parseInt(txtNuevo.getText());
							String nuevof= String.valueOf(nuevo2);
							t2 = con.actualizarProducto(atributo, nuevof, id);

						}
						if(atributo.equals("Nombre")){
							String nuevo = txtNuevo.getText();
							t = con.actualizarProducto(atributo, nuevo, id);
						}

						

						if(t == 1 || t2 == 1){
							JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
						}else{
							JOptionPane.showMessageDialog(null, "Error, no se pudo actualizar el registro ):");
						}

						con.cerrar();

					}catch(Exception ex){

						JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				}
			});

		btnLimpiar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					txtID.setText("");
					txtNuevo.setText("");
			}
		});			
	

}			
	

}
