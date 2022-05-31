import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class FormularioDatos implements ActionListener {

    JFrame frame;
    ImageIcon img = new ImageIcon("logo/tortuga_fav.png");
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB";
    static final String DB_USER = "root";
    static final String DB_PSSWD = "root";

    Connection c = null;
    PreparedStatement ps = null;

    String email;
    String[] gender = { "Hombre", "Mujer", "Otro" };

    JLabel usernameL = new JLabel("Usuario: ");
    JLabel emailL = new JLabel("Email: ");
    JLabel nameL = new JLabel("Nombre: ");
    JLabel genderL = new JLabel("Género: ");
    JLabel passwordL = new JLabel("Contaseña: ");
    JLabel cpasswordL = new JLabel("Confirmar contraseña: ");
    JLabel cityL = new JLabel("Ciudad: ");

    JTextField usernameTF = new JTextField();
    JTextField emailTF = new JTextField();
    JTextField nameTF = new JTextField();
    JComboBox genderCB = new JComboBox<>(gender);
    JPasswordField passwordPF = new JPasswordField();
    JPasswordField cpasswordPF = new JPasswordField();
    JTextField cityTF = new JTextField();

    JButton saveChangesButton = new JButton("Guardar");
    JButton backButton = new JButton("Volver atrás");

    FormularioDatos(String email) {
        this.email = email;
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setIconImage(img.getImage());
        frame.setTitle("Editar perfil");
        frame.setBounds(40, 40, 380, 500);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        usernameL.setBounds(20, 20, 80, 70);
        emailL.setBounds(20, 70, 130, 70);
        nameL.setBounds(20, 120, 100, 70);
        genderL.setBounds(20, 170, 100, 70);
        passwordL.setBounds(20, 220, 140, 70);
        cpasswordL.setBounds(20, 270, 100, 70);
        cityL.setBounds(20, 320, 130, 70);
        usernameTF.setBounds(180, 43, 165, 23);
        emailTF.setBounds(180, 93, 165, 23);
        nameTF.setBounds(180, 143, 165, 23);
        genderCB.setBounds(180, 193, 165, 23);
        passwordPF.setBounds(180, 243, 165, 23);
        cpasswordPF.setBounds(180, 293, 165, 23);
        cityTF.setBounds(180, 343, 165, 23);
        saveChangesButton.setBounds(60, 400, 100, 35);
        backButton.setBounds(210, 400, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(usernameL);
        frame.add(emailL);
        frame.add(nameL);
        frame.add(genderL);
        frame.add(passwordL);
        frame.add(cpasswordL);
        frame.add(cityL);
        frame.add(usernameTF);
        frame.add(emailTF);
        frame.add(nameTF);
        frame.add(genderCB);
        frame.add(passwordPF);
        frame.add(cpasswordPF);
        frame.add(cityTF);
        frame.add(saveChangesButton);
        frame.add(backButton);

    }

    public void actionEvent() {
        saveChangesButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveChangesButton) {
            frame.setVisible(false);
            try {
                c = DriverManager.getConnection(DB_URL, DB_USER, DB_PSSWD);
                ps = c.prepareStatement(
                        "update user set username = ?, name = ?, gender = ?, password = ?, cpassword = ?, city = ?, email = ? where email = ?");
                ps.setString(1, usernameTF.getText());
                ps.setString(2, nameTF.getText());
                ps.setString(3, genderCB.getSelectedItem().toString());
                ps.setString(4, passwordPF.getText());
                ps.setString(5, cpasswordPF.getText());
                ps.setString(6, cityTF.getText());
                ps.setString(7, emailTF.getText());
                ps.setString(8, email);
                if (passwordPF.getText().equals(cpasswordPF.getText())) {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos actualizados");
                    frame.setVisible(false);
                    new Aplicación(email);
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == backButton) {
            frame.setVisible(false);
            new Aplicación(email);
        }

    }

}
