import javax.swing.*;
import java.awt.*;
import java.util.*;

public class VentanaMenu extends JFrame{

	JMenuBar menuBar;
	JMenu cliente, registro, proveedor, producto, verMas;
	JMenuItem datos, agregar, eliminar, consultar, actualizar;
	JMenuItem datosF, agregarF, eliminarF, consultarF, actualizarF;
	JMenuItem datosD, agregarD, eliminarD, consultarD, actualizarD;
	JMenuItem datosP, agregarP, eliminarP, consultarP, actualizarP;
	JMenuItem verMas2;
	JLabel l1;

	//JButton registrotienda, registrocliente;


	public VentanaMenu(String titulo) {

		super(titulo);
		this.setBounds(50, 25, 450, 350);
		this.setLayout(null);

		Ventana ven = new Ventana("Hola");

		l1 = new JLabel("Hola");
		this.add(l1, BorderLayout.CENTER);

		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		cliente = new JMenu("CLIENTE");
		menuBar.add(cliente);

		registro = new JMenu("REGISTRO");
		menuBar.add(registro);

		proveedor = new JMenu("PROVEEDOR");
		menuBar.add(proveedor);

		producto = new JMenu("PRODUCTO");
		menuBar.add(producto);

		verMas = new JMenu("VER MÁS");
		menuBar.add(verMas);

		Gestion gb = new Gestion(this);

		//Menú para clientes
		datos =new JMenuItem("Datos de clientes");
		cliente.add(datos);
		datos.addActionListener(gb);
		cliente.addSeparator();
		agregar =new JMenuItem("Agregar cliente");
		cliente.add(agregar);
		agregar.addActionListener(gb);
		cliente.addSeparator();
		eliminar =new JMenuItem("Eliminar cliente");
		cliente.add(eliminar);
		eliminar.addActionListener(gb);
		cliente.addSeparator();
		/*consultar =new JMenuItem("clientes Ahorradores");
		cliente.add(consultar);
		consultar.addActionListener(gb);
		cliente.addSeparator();*/
		actualizar =new JMenuItem("Actualizar un registro");
		cliente.add(actualizar);
		actualizar.addActionListener(gb);

		//Menú para Registro
		datosF =new JMenuItem("Datos de los Registro");
		registro.add(datosF);
		datosF.addActionListener(gb);
		registro.addSeparator();
		/*agregarF =new JMenuItem("Agregar registro");
		registro.add(agregarF);
		agregarF.addActionListener(gb);
		registro.addSeparator();*/
		eliminarF =new JMenuItem("Eliminar registro");
		registro.add(eliminarF);
		eliminarF.addActionListener(gb);
		registro.addSeparator();
		/*consultarF =new JMenuItem("Registro clientes");
		registro.add(consultarF);
		consultarF.addActionListener(gb);
		registro.addSeparator();*/
		/*actualizarF =new JMenuItem("Actualizar un registro");
		registro.add(actualizarF);
		actualizarF.addActionListener(gb);*/

		//Menú para proveedor
		datosD =new JMenuItem("Datos de proveedores");
		proveedor.add(datosD);
		datosD.addActionListener(gb);
		proveedor.addSeparator();
		agregarD =new JMenuItem("Agregar proveedor");
		proveedor.add(agregarD);
		agregarD.addActionListener(gb);
		proveedor.addSeparator();
		eliminarD =new JMenuItem("Eliminar proveedor");
		proveedor.add(eliminarD);
		eliminarD.addActionListener(gb);
		proveedor.addSeparator();
		consultarD =new JMenuItem("Proveedores de Productos");
		proveedor.add(consultarD);
		consultarD.addActionListener(gb);
		proveedor.addSeparator();
		actualizarD =new JMenuItem("Actualizar un registro");
		proveedor.add(actualizarD);
		actualizarD.addActionListener(gb);

		//Menú para producto
		datosP =new JMenuItem("Datos de los productos");
		producto.add(datosP);
		datosP.addActionListener(gb);
		producto.addSeparator();
		agregarP =new JMenuItem("Agregar producto");
		producto.add(agregarP);
		agregarP.addActionListener(gb);
		producto.addSeparator();
		eliminarP =new JMenuItem("Eliminar producto");
		producto.add(eliminarP);
		eliminarP.addActionListener(gb);
		producto.addSeparator();
		/*consultarP =new JMenuItem("Productos Caros");
		producto.add(consultarP);
		consultarP.addActionListener(gb);
		producto.addSeparator();*/
		actualizarP =new JMenuItem("Actualizar un registro");
		producto.add(actualizarP);
		actualizarP.addActionListener(gb);

		verMas2=new JMenuItem("+Info");
		verMas.add(verMas2);
		verMas2.addActionListener(gb);

		GestionBotones gbs = new Gestion(this);
		//
		registrotienda= new JButton("Registro Tienda");
		registrotienda.setBounds(40, 125, 80, 50);
		GestionBotones gbs = new GestionBotones(this);
		registrotienda.addActionListener(gbs);

		registrocompras= new JButton("Registro Compras");
		registrocompras.setBounds(40, 125, 80, 50);
		GestionBotones gbs = new GestionBotones(this);
		registrocompras.addActionListener(gsb);

		registrocliente= new JButton("Registro Cliente");
		registrocliente.setBounds(40, 125, 80, 50);
		GestionBotones gbs = new GestionBotones(this);
		registrocliente.addActionListener(gsb);

		this.add(registrotienda);
		this.add(registrocompras);
		this.add(registrocliente);




		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public static void main(String args[]){
		VentanaMenu v = new VentanaMenu("Programacion Avanzada");
	}

	public class Ventana extends JPanel{
	  public Ventana(String titulo){
	      this.setBounds(100, 100, 800, 500);
	      this.setVisible(true);    
	  }

	}

}