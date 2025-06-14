package components.Geral;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Geral extends JFrame {

    private static final Color COR_FUNDO_ESCURO = new Color(0x333333);
    private static final Color COR_FUNDO_CLARO = new Color(0xF0F0F0);
    private static final Color COR_RODAPE = new Color(0x2A3A68);
    private static final Color COR_LETRA_PAINEL = new Color(0x666666);
    private static final Color COR_VERMELHO_IDOSAS = new Color(0xD9534F);
    private static final Color COR_VERDE_ENFERMARIA = new Color(0x5CB85C);

    public Geral() {
        initUI();
    }

    private void initUI() {
        setTitle("Tela 2 - Geral");
        setSize(900, 700);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COR_FUNDO_ESCURO);
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createFooterPanel(), BorderLayout.SOUTH);
        add(createMainPanel(), BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout(10, 10));
        headerPanel.setBackground(COR_FUNDO_ESCURO);
        headerPanel.setBorder(new EmptyBorder(15, 25, 15, 25));
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

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(COR_RODAPE);
        footerPanel.setPreferredSize(new Dimension(getWidth(), 40));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        JLabel dateTimeLabel = new JLabel(sdf.format(new Date()));
        dateTimeLabel.setForeground(Color.WHITE);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateTimeLabel.setBorder(new EmptyBorder(0, 0, 0, 25));
        footerPanel.add(dateTimeLabel);
        return footerPanel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(COR_FUNDO_CLARO);
        mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Painel Administrativo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(COR_LETRA_PAINEL);
        titleLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        statsPanel.setOpaque(false);
        statsPanel.add(createStatItem("Pacientes", "100", COR_VERMELHO_IDOSAS));
        statsPanel.add(createStatItem("Enfermaria", "20", COR_VERDE_ENFERMARIA));
        statsPanel.add(createStatItem("Visitas", "2", COR_VERDE_ENFERMARIA));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(statsPanel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        JPanel gridPanel = new JPanel(new GridLayout(2, 4, 20, 20));
        gridPanel.setOpaque(false);
        gridPanel.add(createDashboardButton("Idosas", "idosas.png"));
        gridPanel.add(createDashboardButton("Família", "familia.png"));
        gridPanel.add(createDashboardButton("Documentos", "documentos.png"));
        gridPanel.add(createDashboardButton("Eventos Sentinelas", "eventos.png"));
        gridPanel.add(createDashboardButton("Prontuários", "prontuarios.png"));
        gridPanel.add(createDashboardButton("Consultas", "consultas.png"));
        gridPanel.add(createDashboardButton("Vacinas", "vacinas.png"));
        gridPanel.add(createDashboardButton("Relatórios", "relatorios.png"));
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createStatItem(String title, String value, Color valueColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setForeground(COR_LETRA_PAINEL);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 20));
        valueLabel.setForeground(valueColor);
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(valueLabel);
        return panel;
    }

    private JButton createDashboardButton(String text, String iconName) {
        ImageIcon icon = createScaledIcon("/assets/" + iconName, 48, 48);
        JButton button = new JButton(text, icon);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(COR_LETRA_PAINEL);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(0xDDDDDD)));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        if (url == null) {
            System.err.println("Erro ao carregar o recurso: " + path);
            return null;
        }
        return new ImageIcon(url);
    }

    private ImageIcon createScaledIcon(String path, int width, int height) {
        ImageIcon originalIcon = createIcon(path);
        if (originalIcon == null) {
            return null;
        }
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Geral ex = new Geral();
            ex.setVisible(true);
        });
    }
}