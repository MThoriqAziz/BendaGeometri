package gui;

import javax.swing.*;
import java.awt.*;
import main.main;

public class GuiBenda2D {

    public GuiBenda2D() {
        JFrame frame = new JFrame("Pilih Benda 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton btnJajarGenjang = new JButton("Jajar Genjang");
        JButton btnSegitiga = new JButton("Segitiga");
        JButton btnKembali = new JButton("Kembali ke Main View");

        frame.add(btnJajarGenjang);
        frame.add(btnSegitiga);
        frame.add(btnKembali);

        btnJajarGenjang.addActionListener(e -> {
            new GuiJajarGenjang();
            frame.dispose();
        });
        
        btnSegitiga.addActionListener(e -> {
            new GuiSegitiga();
            frame.dispose();
        });


        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
