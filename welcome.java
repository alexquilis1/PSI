import javax.swing.*;
import java.awt.event.*;
public class welcome implements ActionListener {

	//Creating object of JFrame class
	JFrame frame;
	ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
	JLabel title = new JLabel("Sendrid");
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
		frame.setIconImage(img.getImage());
		frame.setTitle("Traccia");
		frame.setBounds(10,10,300,240);
		// Saber qué es??
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	
	}
	
	public void setLocationAndSize() {
		//Setting location and size of each component
		title.setBounds(120, 40, 200, 50);
		loginButton.setBounds(35,100,100,30);
		registerButton.setBounds(155,100,100,30);
	}
	
	public void addComponentsToFrame() {
		frame.add(title);
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
		//Coding part of Login Button
		if(e.getSource()==loginButton) {
			new loginForm();
			frame.setVisible(false);
		}
		//Coding part of Register Button
		else if(e.getSource()==registerButton){
			new registrationForm();
			frame.setVisible(false);
		}
	}
}

