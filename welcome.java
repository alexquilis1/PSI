import javax.swing.*;
import java.awt.event.*;
public class welcome implements ActionListener {

	//Creating object of JFrame class
	JFrame frame;
	
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Registrarse");
	
	//Creating constructor
	welcome(){
		//Calling method from constructor
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow() {
		//Setting properties of JFrame
		frame = new JFrame();
		frame.setTitle("Welcome Screen");
		frame.setBounds(10,10,300,220);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	
	}
	
	public void setLocationAndSize() {
		//Setting location and size of each component
		loginButton.setBounds(35,80,100,30);
		registerButton.setBounds(155,80,100,30);
	}
	
	public void addComponentsToFrame() {
		frame.add(loginButton);
		frame.add(registerButton);
	}
	
	public void actionEvent() {
		//Adding action listener to button
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
		//Coding part of Login Button
		if(e.getSource()==loginButton) {
			new loginForm();
			frame.setVisible(false);
		}
		//Coding part of Register Button
		else if(e.getSource()==registerButton){
			new registrationForm();
=======
		// Coding part of Login Button
		if (e.getSource() == loginButton) {
			new LoginForm();
			frame.setVisible(false);
		}
		// Coding part of Register Button
		else if (e.getSource() == registerButton) {
			new RegistrationForm();
>>>>>>> Stashed changes
			frame.setVisible(false);
		}
	}
}

