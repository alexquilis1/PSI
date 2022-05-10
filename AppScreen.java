import javax.swing.*;
import java.awt.event.*;
public class AppScreen implements ActionListener {
	
	String email;
	
	JFrame frame;

	JButton viewProfile = new JButton("Ver mi perfil");
	JButton consultPaths = new JButton("Consultar sendas");
	
	AppScreen(String email){
		this.email = email;
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow() {
		frame = new JFrame();
		frame.setTitle("Aplicación");
		frame.setBounds(10,10,350,300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void setLocationAndSize() {
		viewProfile.setBounds(100,85,150,30);
		consultPaths.setBounds(100,135,150,30);
	}
	
	public void addComponentsToFrame() {
		frame.add(viewProfile);
		frame.add(consultPaths);
	}
	
	public void actionEvent() {
		viewProfile.addActionListener(this);
		consultPaths.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewProfile) {
			frame.setVisible(false);
			new VerPerfil(email);
		}
		if(e.getSource()==consultPaths) {
			frame.setVisible(false);
			new VerSendas();
		}
	}
}

