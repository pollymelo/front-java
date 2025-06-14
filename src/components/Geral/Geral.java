package components.Geral;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
public class Geral extends JFrame {


    private static final Color COR_FUNDO_ESCURO = new Color(0x333333);
    private static final Color COR_FUNDO_CLARO = new Color(0xF0F0F0);
    private static final Color COR_RODAPE = new Color(0x2A3A68);

    public Geral() {
        initUI();
    }

    private void initUI() {
        setTitle("Tela 2 - Geral");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        getContentPane().setBackground(COR_FUNDO_ESCURO);

        add(createHeaderPanel(), BorderLayout.NORTH);

    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout(10, 10));
        headerPanel.setBackground(COR_FUNDO_ESCURO);
        headerPanel.setBorder(new EmptyBorder(15, 25, 15, 25));

        // --- Lado Esquerdo: Logo e Texto ---
        // OBS: O ícone não vai aparecer ainda, pois os métodos de ícone estão vazios.
        ImageIcon logoIcon = createScaledIcon("/assets/logo.png", 50, 50);
        JLabel logoLabel = new JLabel(logoIcon);

        JPanel companyInfoPanel = new JPanel();
        companyInfoPanel.setLayout(new BoxLayout(companyInfoPanel, BoxLayout.Y_AXIS));
        companyInfoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel("RECANTO DO SAGRADO CORAÇÃO");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel subtitleLabel = new JLabel("ASSISTÊNCIA SOCIAL CATARINA LABOURÉ");
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        companyInfoPanel.add(nameLabel);
        companyInfoPanel.add(subtitleLabel);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftPanel.setOpaque(false);
        leftPanel.add(logoLabel);
        leftPanel.add(companyInfoPanel);

        // --- Lado Direito: Botões ---
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonsPanel.setOpaque(false);

        JButton adminButton = new JButton("Administrador Painel", createIcon("/assets/admin.png"));
        JButton exitButton = new JButton("Sair", createIcon("/assets/exit.png"));
        JButton refreshButton = new JButton(createIcon("/assets/refresh.png"));

        for (JButton btn : new JButton[]{adminButton, exitButton, refreshButton}) {
            btn.setBackground(new Color(0x4F4F4F));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(new EmptyBorder(8, 12, 8, 12));
            if (btn == refreshButton) {
                btn.setBorder(new EmptyBorder(8, 8, 8, 8));
            }
        }

        buttonsPanel.add(adminButton);
        buttonsPanel.add(exitButton);
        buttonsPanel.add(refreshButton);

        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(buttonsPanel, BorderLayout.EAST);

        return headerPanel;
    }


    private ImageIcon createIcon(String path) {

        return null;
    }
    private ImageIcon createScaledIcon(String path, int width, int height) {

        return null;
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Geral ex = new Geral();
            ex.setVisible(true);
        });
    }

}
