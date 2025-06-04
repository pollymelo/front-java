import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {
    public Login () {

        setTitle("Recanto do Sagrado Coração");
        setSize(1920, 1080);
        JPanel panel = new JPanel();

        JTextField usuario = new JTextField();
        JTextField senha = new JPasswordField();
        usuario.setFont(new Font("Arial", Font.PLAIN, 20));
        senha.setFont(new Font("Arial", Font.PLAIN, 20));
        usuario.setBounds(70, 242, 342, 41);
        usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 3));
        senha.setBounds(70, 312, 342, 41);
        senha.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 3));

        JButton logar = new JButton("Logar");
        JButton cadastrar = new JButton("Cadastrar");
        Font font = (new Font("Arial", Font.BOLD, 20));
        logar.setFont(font);
        cadastrar.setFont(font);
        logar.setForeground(Color.WHITE);
        cadastrar.setForeground(Color.WHITE);
        logar.setBackground(Color.decode("#1C2F5C"));
        cadastrar.setBackground(Color.decode("#1C2F5C"));

        add(panel);
        panel.setLayout(new GridBagLayout());
        panel.add(logar);
        panel.add(cadastrar);
        panel.add(usuario);
        panel.add(senha);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}