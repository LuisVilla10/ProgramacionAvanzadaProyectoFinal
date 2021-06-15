import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class VerMas extends JFrame{

	private JLabel materia, integrantes, integrante1, integrante2;

	public VerMas(){
		super("Mas Info");
		this.setBounds(100,100,450,300);
		materia=new JLabel("     ~ E.E PROGRAMACION AVANZADA ~");
		materia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		integrantes=new JLabel("                          INTEGRANTES");
		integrantes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		integrante1=new JLabel("                  - Luis Armando Villa Ceballos");
		integrante1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		integrante2=new JLabel("             - Joyce Enid Garcia Lopez");
		integrante2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		JPanel panel=new JPanel ();
		panel.setLayout(new GridLayout(4,1));
		panel.add(materia);
		panel.add(integrantes);
		panel.add(integrante1);
		panel.add(integrante2);

		this.add(panel);
		this.setVisible(true);

	}

}