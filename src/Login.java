import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class Login extends JFrame {
    public Login () {

        setTitle("Recanto do Sagrado Coração");
        setSize(1920, 1080);
        JPanel panel = new JPanel();


        //cor de fundo do panel
        panel.setBackground(new Color(240, 240, 240));


        JTextField usuario = new JTextField(20);
        JPasswordField senha = new JPasswordField(20);

        usuario.setFont(new Font("Arial", Font.PLAIN, 20));
        senha.setFont(new Font("Arial", Font.PLAIN, 20));

        usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 3));
        senha.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 3));

        //placeholder usuario
        final String USUARIO_PLACEHOLDER = "Administrador Painel";
        final Color PLACEHOLDER_COLOR = Color.GRAY;
        final Color TEXT_COLOR = Color.BLACK;

        usuario.setText(USUARIO_PLACEHOLDER);
        usuario.setForeground(PLACEHOLDER_COLOR);

        usuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usuario.getText().equals(USUARIO_PLACEHOLDER)) {
                    usuario.setText("");
                    usuario.setForeground(TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usuario.getText().isEmpty()) {
                    usuario.setText(USUARIO_PLACEHOLDER);
                    usuario.setForeground(PLACEHOLDER_COLOR);
                }
            }
        });


        //placeholder senha
        final String SENHA_PLACEHOLDER = "Digite sua senha";
        char defaultEchoChar = senha.getEchoChar();
        senha.setEchoChar((char) 0);
        senha.setText(SENHA_PLACEHOLDER);
        senha.setForeground(PLACEHOLDER_COLOR);

        senha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String currentPassword = new String(senha.getPassword());
                if (currentPassword.equals(SENHA_PLACEHOLDER)) {
                    senha.setText("");
                    senha.setEchoChar(defaultEchoChar);
                    senha.setForeground(TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(senha.getPassword()).isEmpty()) {
                    senha.setEchoChar((char) 0);
                    senha.setText(SENHA_PLACEHOLDER);
                    senha.setForeground(PLACEHOLDER_COLOR);
                }
            }
        });


//        usuario.setText(USUARIO_PLACEHOLDER);
//        usuario.setForeground(PLACEHOLDER_COLOR);


        JButton logar = new JButton("Logar");
        JButton cadastrar = new JButton("Cadastrar");
        Font fontBotoes = (new Font("Arial", Font.BOLD, 20));
        logar.setFont(fontBotoes);
        cadastrar.setFont(fontBotoes);
        logar.setForeground(Color.WHITE);
        cadastrar.setForeground(Color.WHITE);
        logar.setBackground(Color.decode("#1C2F5C"));
        cadastrar.setBackground(Color.decode("#1C2F5C"));

        add(panel);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //titulo

        JLabel Titulo = new JLabel("Realize o Login");
        Titulo.setFont(new Font("Arial", Font.BOLD, 32));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(20, 10, 30, 10);
        panel.add(Titulo, gbc);


        //titulo usuario
        JLabel TituloUsuario = new JLabel("Usuário:");
        TituloUsuario.setFont(new Font("Arial", Font.PLAIN, 18));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 20, 5, 5);
        panel.add(TituloUsuario, gbc);


        //input do usuário
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 10, 20);
        panel.add(usuario, gbc);



        //senha titulo
        JLabel TituloSenha = new JLabel("Senha:");
        TituloSenha.setFont(new Font("Arial", Font.PLAIN, 18));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 20, 5, 5);
        panel.add(TituloSenha, gbc);

        //input senha
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 10, 20);
        panel.add(senha, gbc);




        // flex-grow
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JLabel(""), gbc);

//        panel.setLayout(new GridBagLayout());
//        panel.add(logar);
//        panel.add(cadastrar);
//        panel.add(usuario);
//        panel.add(senha);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
