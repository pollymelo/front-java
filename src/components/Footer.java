package components;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Footer extends JPanel {

    public Footer() {
        //cor fundo panel;
        this.setBackground(Color.decode("#1C2F5C"));
        //altura panel

        this.setPreferredSize(new Dimension(1, 35));
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        // label date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        JLabel footerLabel = new JLabel(LocalDateTime.now().format(dtf));
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setForeground(Color.WHITE);

        // add texto ao panel
        this.add(footerLabel);
    }
}