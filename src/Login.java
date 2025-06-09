import components.Footer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {


    public Login() {

        setTitle("Recanto do Sagrado Coração");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        // Panel principal
        JPanel backgroundPanel = new JPanel(new GridBagLayout());

        // cor de fundo
        backgroundPanel.setBackground(new Color(240, 240, 240));

        // --- secao dos componentes ---

        // títulos
        JLabel Titulo = new JLabel("Realize o login");
        Titulo.setFont(new Font("Arial", Font.BOLD, 32));
        Titulo.setForeground(Color.decode("#1C2F5C"));

        JLabel TituloUsuario = new JLabel("Usuário:");
        TituloUsuario.setFont(new Font("Arial", Font.BOLD, 28));
        TituloUsuario.setForeground(Color.decode("#1C2F5C"));

        JLabel TituloSenha = new JLabel("Senha:");
        TituloSenha.setFont(new Font("Arial", Font.BOLD, 28));
        TituloSenha.setForeground(Color.decode("#1C2F5C"));

        // inputs senha e usuário
        JTextField usuario = new JTextField();
        JPasswordField senha = new JPasswordField();

        // estilizacao inputs
        Font fontCampos = new Font("Arial", Font.PLAIN, 18);
        usuario.setFont(fontCampos);
        senha.setFont(fontCampos);
        usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 2));
        senha.setBorder(BorderFactory.createLineBorder(Color.decode("#1C2F5C"), 2));
        Dimension inputSize = new Dimension(380, 45);
        usuario.setPreferredSize(inputSize);
        senha.setPreferredSize(inputSize);

        // placeholder usuario
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

        // placeholder senha
        final String SENHA_PLACEHOLDER = "********";
        char defaultEchoChar = senha.getEchoChar();
        senha.setEchoChar((char) 0);
        senha.setText(SENHA_PLACEHOLDER);
        senha.setForeground(PLACEHOLDER_COLOR);
        senha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(senha.getPassword()).equals(SENHA_PLACEHOLDER)) {
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

        // esqueciSenha
        JLabel esqueciSenha = new JLabel("<html><u>Esqueci minha senha</u></html>");
        esqueciSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        esqueciSenha.setForeground(Color.decode("#1C2F5C"));
        esqueciSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        esqueciSenha.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Funcionalidade 'Esqueci minha senha' a ser implementada.");
            }
        });

        // botoes
        JButton logar = new JButton("Logar");
        JButton cancelar = new JButton("Cancelar");

        // estilizacao dos botoes
        Font fontBotoes = new Font("Arial", Font.BOLD, 18);
        logar.setFont(fontBotoes);
        cancelar.setFont(fontBotoes);
        logar.setForeground(Color.WHITE);
        cancelar.setForeground(Color.WHITE);
        logar.setBackground(Color.decode("#1C2F5C"));
        cancelar.setBackground(Color.decode("#1C2F5C"));
        Dimension buttonSize = new Dimension(180, 50);
        logar.setPreferredSize(buttonSize);
        cancelar.setPreferredSize(buttonSize);
        logar.setOpaque(true);
        logar.setBorderPainted(false);
        cancelar.setOpaque(true);
        cancelar.setBorderPainted(false);

        // --- inicio do layout ---

        // Painel do Formulário que conterá todos os elementos
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(backgroundPanel.getBackground());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        // titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 40, 0);
        formPanel.add(Titulo, gbc);

        // titulo usuario
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        formPanel.add(TituloUsuario, gbc);

        // input do usuário
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 40, 0);
        formPanel.add(usuario, gbc);

        // senha titulo
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 10, 0);
        formPanel.add(TituloSenha, gbc);

        // input senha
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 15, 0);
        formPanel.add(senha, gbc);

        // esqueciSenha
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 40, 0);
        formPanel.add(esqueciSenha, gbc);

        // panel dos botoes
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonsPanel.setBackground(formPanel.getBackground());
        buttonsPanel.add(logar);
        buttonsPanel.add(cancelar);

        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 0, 0);
        formPanel.add(buttonsPanel, gbc);

        //  posicionamento à esquerda e p cima
        GridBagConstraints backgroundConstraints = new GridBagConstraints();
        backgroundConstraints.gridx = 0;
        backgroundConstraints.gridy = 0;
        backgroundConstraints.anchor = GridBagConstraints.NORTHWEST;

        backgroundConstraints.insets = new Insets(150, 120, 0, 0);
        backgroundPanel.add(formPanel, backgroundConstraints);

        // empurra espaco restante a direita abaixo
        GridBagConstraints pusher = new GridBagConstraints();
        pusher.gridx = 1;
        pusher.gridy = 0;
        pusher.weightx = 1.0;
        pusher.weighty = 1.0;
        pusher.fill = GridBagConstraints.BOTH;
        backgroundPanel.add(new JLabel(""), pusher);

        Footer footerPanel = new Footer();
        add(backgroundPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));

    }
}
