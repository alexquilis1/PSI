import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class registrationForm implements ActionListener {

    // Creating object of JFrame class
    JFrame frame;
    ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
    String[] gender = { "Hombre", "Mujer", "Otro" };

    JLabel usernameLabel = new JLabel("Usuario");
    JLabel nameLabel = new JLabel("Nombre");
    JLabel genderLabel = new JLabel("Género");
    JLabel passwordLabel = new JLabel("Contraseña");
    JLabel confirmPasswordLabel = new JLabel("Confirmar contraseña");
    JLabel cityLabel = new JLabel("Ciudad");
    JLabel emailLabel = new JLabel("Correo electrónico");

    JTextField usernameTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField cityTextField = new JTextField();
    JTextField emailTextField = new JTextField();

    JButton registerButton = new JButton("Registrar");
    JButton resetButton = new JButton("Reset");

    // Creating constructor
    registrationForm() {
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
        frame.setTitle("Formulario de registro");
        frame.setBounds(40, 40, 380, 500);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        // Setting Location and Size of Each Component
        usernameLabel.setBounds(20, 20, 80, 70);
        nameLabel.setBounds(20, 70, 80, 70);
        genderLabel.setBounds(20, 120, 100, 70);
        passwordLabel.setBounds(20, 170, 100, 70);
        confirmPasswordLabel.setBounds(20, 220, 140, 70);
        cityLabel.setBounds(20, 270, 100, 70);
        emailLabel.setBounds(20, 320, 130, 70);
        usernameTextField.setBounds(180, 43, 165, 23);
        nameTextField.setBounds(180, 93, 165, 23);
        genderComboBox.setBounds(180, 143, 165, 23);
        passwordField.setBounds(180, 193, 165, 23);
        confirmPasswordField.setBounds(180, 243, 165, 23);
        cityTextField.setBounds(180, 293, 165, 23);
        emailTextField.setBounds(180, 343, 165, 23);
        registerButton.setBounds(60, 400, 100, 35);
        resetButton.setBounds(210, 400, 100, 35);
    }

    public void addComponentsToFrame() {
        // Adding components to Frame
        frame.add(usernameLabel);
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(usernameTextField);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }

    public void actionEvent() {
        // Adding Action Listener to buttons
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            try {
                // Creating Connection Object
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
                // Preapared Statement
                PreparedStatement Pstatement = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
                // Specifying the values of it's parameter
                Pstatement.setString(1, null);
                Pstatement.setString(2, usernameTextField.getText());
                Pstatement.setString(3, nameTextField.getText());
                Pstatement.setString(4, genderComboBox.getSelectedItem().toString());
                Pstatement.setString(5, passwordField.getText());
                Pstatement.setString(6, confirmPasswordField.getText());
                Pstatement.setString(7, cityTextField.getText());
                Pstatement.setString(8, emailTextField.getText());
                // Checking for the Password match
                if (passwordField.getText().equals(confirmPasswordField.getText())) {
                    // Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
                    frame.setVisible(false);
                    new loginForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == resetButton) {
            // Clearing Fields
            usernameTextField.setText("");
            nameTextField.setText("");
            genderComboBox.setSelectedItem("Hombre");
            passwordField.setText("");
            confirmPasswordField.setText("");
            cityTextField.setText("");
            emailTextField.setText("");
        }
    }
}
