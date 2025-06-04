import javax.swing.*;
import java.awt.*;


public class Login {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Recanto do Sagrado Coração");
        jFrame.setSize(1920, 1080);
        JPanel panel = new JPanel();

        JTextField usuario = new JTextField("Administrador Painel");
        JTextField senha = new JPasswordField("<SENHA>");

        JButton logar = new JButton("Logar");
        JButton cadastrar = new JButton("Cadastrar");


        panel.setLayout(new GridBagLayout());
        panel.add(logar);
        panel.add(cadastrar);
        panel.add(usuario);
        panel.add(senha);
        jFrame.add(panel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}