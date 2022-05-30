import javax.swing.*;
import java.awt.event.*;

public class app implements ActionListener {

	String email;

	JFrame frame;
	ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
	JButton viewProfile = new JButton("Ver mi perfil");
	JButton editProfile = new JButton("Editar datos");
	JButton consultPaths = new JButton("Consultar sendas");

	app(String email) {
		this.email = email;
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {
		frame = new JFrame();
		frame.setIconImage(img.getImage());
		frame.setTitle("Aplicación");
		frame.setBounds(10, 10, 350, 300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		viewProfile.setBounds(100, 85, 150, 30);
		editProfile.setBounds(100, 135, 150, 30);
		consultPaths.setBounds(100, 185, 150, 30);
	}

	public void addComponentsToFrame() {
		frame.add(viewProfile);
		frame.add(editProfile);
		frame.add(consultPaths);
	}

	public void actionEvent() {
		viewProfile.addActionListener(this);
		editProfile.addActionListener(this);
		consultPaths.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewProfile) {
			frame.setVisible(false);
			new VerPerfil(email);
		}
		if (e.getSource() == editProfile) {
			frame.setVisible(false);
			new editarDatos(email);
		}
		if (e.getSource() == consultPaths) {
			frame.setVisible(false);
			new Sendas();
		}
	}
}
