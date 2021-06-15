import java.awt.event.*;
import javax.swing.*;

public class Gestion implements ActionListener{
	
	VentanaMenu v;
    
    public Gestion(VentanaMenu v){
        this.v = v;
    }

    @Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == v.datos){

			try{
				VentanaDatos vc = new VentanaDatos("Tabla Cliente");
				SingleConnection con = new SingleConnection();
				con.driver();
				vc.add(con.datosTabla("select * from CLIENTE"));

				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}

        }
        if (e.getSource() == v.datosF){

			try{
				VentanaDatos vcf = new VentanaDatos("Tabla Registros");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcf.add(con.datosTabla("select * from REGISTRO"));

				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.datosD){

			try{
				VentanaDatos vcd = new VentanaDatos("Tabla Tienda");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcd.add(con.datosTabla("select * from TIENDA"));

				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.datosP){

			try{
				VentanaDatos vcp = new VentanaDatos("Tabla Producto");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcp.add(con.datosTabla("select * from PRODUCTO"));

				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.agregar){

			try{
				AgregarCliente ag=new AgregarCliente();
				ag.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.agregarF){

			try{
				AgregarRegistro af=new AgregarRegistro();
				af.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.agregarD){

			try{
				AgregarTienda ad=new AgregarTienda();
				ad.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.agregarP){

			try{
				AgregarProducto ap=new AgregarProducto();
				ap.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.eliminar){
			try{
				EliminarCliente ec=new EliminarCliente();
				ec.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.eliminarF){
			try{
				EliminarRegistro ef=new EliminarRegistro();
				ef.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.eliminarD){
			try{
				EliminarTienda ed=new EliminarTienda();
				ed.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if (e.getSource() == v.eliminarP){
			try{
				EliminarProducto ep=new EliminarProducto();
				ep.setVisible(true);
				SingleConnection con = new SingleConnection();
				con.driver();
				con.cerrar();
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    	if(e.getSource()  == v.actualizar){
    		ActualizarCliente ac = new ActualizarCliente();

    	}


     	if(e.getSource()  == v.actualizarD){
    		ActualizarTienda ad = new ActualizarTienda();

    	}  

     	/*if(e.getSource()  == v.actualizarF){
    		ActualizarRegistro af = new ActualizarRegistro();

    	}*/ 

     	if(e.getSource()  == v.actualizarP){
    		ActualizarProducto ap = new ActualizarProducto();

    	}

     	/*if(e.getSource()  == v.consultarP){

			try{
				VentanaDatos vcp = new VentanaDatos("Productos con precio mayor a 5,000 pesos");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcp.add(con.datosTabla("select * from PRODUCTOSCAROS"));

				con.cerrar();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

    	}*/

     	/*if(e.getSource()  == v.consultarF){

			try{
				VentanaDatos vcp = new VentanaDatos("Fechas de Registros de Cliente");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcp.add(con.datosTabla("select * from REGISTROCliente"));

				con.cerrar();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

    	}*/


     	/*if(e.getSource()  == v.consultarD){

			try{
				VentanaDatos vcp = new VentanaDatos("Tienda de Productos");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcp.add(con.datosTabla("select * from TiendaPRODUCTOS"));

				con.cerrar();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

    	}*/

     	/*if(e.getSource()  == v.consultar){

			try{
				VentanaDatos vcp = new VentanaDatos("Cliente Ahorradores");
				SingleConnection con = new SingleConnection();
				con.driver();
				vcp.add(con.datosTabla("select * from ClienteAHORRADORES"));

				con.cerrar();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
    	}
    	*/
    	if (e.getSource() == v.verMas2){
			try{
				VerMas vm=new VerMas();
				vm.setVisible(true);
			}catch(Exception ex){
				 ex.printStackTrace();
			}
    	}
    }
}