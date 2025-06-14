package components.Geral;

import javax.swing.*;
import java.awt.*;

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


    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Geral ex = new Geral();
            ex.setVisible(true);
        });
    }

}
