import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FormularioInicio implements ActionListener {

	// Creating object of JFrame class
	JFrame frame;
	ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
	JLabel emailLabel = new JLabel("Email");
	JLabel passwordLabel = new JLabel("Contraseña");

	JTextField emailTextField = new JTextField();
	JPasswordField passwordTextField = new JPasswordField();

	JButton loginButton = new JButton("Log in");
	JButton resetButton = new JButton("Reset");

	JButton backButton = new JButton("Volver atrás");

	JCheckBox showPassword = new JCheckBox("Mostrar contraseña");

	// Creating constructor
	FormularioInicio() {
		// Calling method from constructor
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {
		// Setting properties of JFrame
		frame = new JFrame();
		frame.setIconImage(img.getImage());
		frame.setTitle("Login");
		frame.setBounds(10, 10, 370, 300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		// Setting location and size of each component
		emailLabel.setBounds(50, 50, 100, 30);
		passwordLabel.setBounds(50, 105, 100, 30);
		emailTextField.setBounds(150, 50, 150, 30);
		passwordTextField.setBounds(150, 105, 150, 30);
		loginButton.setBounds(20, 200, 100, 30);
		resetButton.setBounds(130, 200, 100, 30);
		backButton.setBounds(240, 200, 100, 30);
		showPassword.setBounds(150, 135, 150, 30);
	}

	public void addComponentsToFrame() {
		// Adding components to frame
		frame.add(emailLabel);
		frame.add(passwordLabel);
		frame.add(emailTextField);
		frame.add(passwordTextField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(backButton);
		frame.add(showPassword);
	}

	public void actionEvent() {
		// Adding action listener to button
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Coding Part of LOGIN button
		if (e.getSource() == loginButton) {
			try {
				// Creating Connection Object
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
				PreparedStatement ps = connection
						.prepareStatement("Select * from user where email = ? and password = ?");
				ps.setString(1, emailTextField.getText());
				ps.setString(2, passwordTextField.getText());
				ResultSet rs = ps.executeQuery();
				String email = "";
				String password = "";
				while (rs.next()) {
					email = rs.getString("email");
					password = rs.getString("password");
				}
				if (email.equals(emailTextField.getText()) && password.equals(passwordTextField.getText())) {
					frame.setVisible(false);
					new Aplicación(emailTextField.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Los datos introducidos son incorrectos");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		// Coding Part of RESET button
		if (e.getSource() == resetButton) {
			emailTextField.setText("");
			passwordTextField.setText("");
		}
		// Coding part of goBack button
		if (e.getSource() == backButton) {
			frame.setVisible(false);
			new Bienvenida();
		}
		// Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordTextField.setEchoChar((char) 0);
			} else {
				passwordTextField.setEchoChar('*');
			}
		}
	}
}
