package gui;

import javax.swing.*;
import java.awt.*;
import main.main;

public class GuiBenda3D {

    public GuiBenda3D() {
        JFrame frame = new JFrame("Pilih Benda 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton btnPrismaJajarGenjang = new JButton("Prisma Jajar Genjang");
        JButton btnKembali = new JButton("Kembali ke Main View");

        frame.add(btnPrismaJajarGenjang);
        frame.add(btnKembali);

        btnPrismaJajarGenjang.addActionListener(e -> {
            new GuiPrismaJajarGenjang();
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
