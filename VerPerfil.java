import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerPerfil implements ActionListener {

	JFrame frame;
	ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
	String email;

	JLabel usernameLabel = new JLabel("Usuario");
	JLabel nameLabel = new JLabel("Nombre");
	JLabel genderLabel = new JLabel("Género");
	JLabel cityLabel = new JLabel("Ciudad");
	JLabel emailLabel = new JLabel("Email");

	JLabel usernameD = new JLabel();
	JLabel nameD = new JLabel();
	JLabel genderD = new JLabel();
	JLabel cityD = new JLabel();
	JLabel emailD = new JLabel();

	JButton back = new JButton("Volver");

	VerPerfil(String email) {
		this.email = email;
		connectionDB();
		createWindow();
		setLocationsAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {
		frame = new JFrame();
		frame.setIconImage(img.getImage());
		frame.setTitle("Ver perfil");
		frame.setBounds(40, 40, 380, 400);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationsAndSize() {
		usernameLabel.setBounds(50, 20, 80, 70);
		nameLabel.setBounds(50, 70, 80, 70);
		genderLabel.setBounds(50, 120, 100, 70);
		cityLabel.setBounds(50, 170, 100, 70);
		emailLabel.setBounds(50, 220, 140, 70);
		usernameD.setBounds(140, 43, 165, 23);
		nameD.setBounds(140, 93, 180, 23);
		genderD.setBounds(140, 143, 165, 23);
		cityD.setBounds(140, 193, 165, 23);
		emailD.setBounds(140, 243, 165, 23);
		back.setBounds(50, 300, 90, 23);
	}

	public void addComponentsToFrame() {
		frame.add(usernameLabel);
		frame.add(nameLabel);
		frame.add(genderLabel);
		frame.add(cityLabel);
		frame.add(emailLabel);
		frame.add(usernameD);
		frame.add(nameD);
		frame.add(genderD);
		frame.add(cityD);
		frame.add(emailD);
		frame.add(back);
	}

	public void actionEvent() {
		// Adding Action Listener to buttons
		back.addActionListener(this);
	}

	public void connectionDB() {
		try {
			// Creating Connection Object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			PreparedStatement ps = connection
					.prepareStatement("Select username, name, gender, city, email from user where email = ? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usernameD.setText(rs.getString("username"));
				nameD.setText(rs.getString("name"));
				genderD.setText(rs.getString("gender"));
				cityD.setText(rs.getString("city"));
				emailD.setText(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			frame.setVisible(false);
			new app(email);
		}

	}
}
