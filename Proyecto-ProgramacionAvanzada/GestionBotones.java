import java.awt.event.*;
import javax.swing.*;

public class GestionBotones implements ActionListener {
	
	VentanaMenu v;


	public GestionBotones(VentanaMenu v) {
		
		this.v = v;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == v.registrotienda){

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

    	if (e.getSource() == v.registrocompras){

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

    	if (e.getSource() == v.registrocliente){

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
	}

}