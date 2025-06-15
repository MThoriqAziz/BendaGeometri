package gui;

import main.main;
import bendaGeometri.Trapesium;
import bendaGeometri.LimasTrapesium;
import bendaGeometri.LimasTrapesiumThread;

import javax.swing.*;
import java.awt.*;

public class GuiLimasTrapesium {
    public GuiLimasTrapesium() {
        JFrame frame = new JFrame("Limas Trapesium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Trapesium");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfSisi1 = new JTextField();
        JTextField tfSisi2 = new JTextField();
        JTextField tfTinggi = new JTextField();
        JTextField tfSisiMiring = new JTextField();
        JTextField tfTinggiLimas = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Sisi Sejajar 1:")); panel.add(tfSisi1);
        panel.add(new JLabel("Sisi Sejajar 2:")); panel.add(tfSisi2);
        panel.add(new JLabel("Tinggi Trapesium:")); panel.add(tfTinggi);
        panel.add(new JLabel("Sisi Miring:")); panel.add(tfSisiMiring);
        panel.add(new JLabel("Tinggi Limas:")); panel.add(tfTinggiLimas);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            Trapesium tr = SharedData.getTrapesium();
            if (tr != null) {
                tfSisi1.setText(String.valueOf(tr.sisiSejajar1));
                tfSisi2.setText(String.valueOf(tr.sisiSejajar2));
                tfTinggi.setText(String.valueOf((int) tr.tinggi));
                tfSisiMiring.setText(String.valueOf(tr.sisiMiring));

                tfSisi1.setEditable(false);
                tfSisi2.setEditable(false);
                tfTinggi.setEditable(false);
                tfSisiMiring.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Trapesium!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfSisi1.setText("");
            tfSisi2.setText("");
            tfTinggi.setText("");
            tfSisiMiring.setText("");

            tfSisi1.setEditable(true);
            tfSisi2.setEditable(true);
            tfTinggi.setEditable(true);
            tfSisiMiring.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());
                LimasTrapesium limas;

                if (rbParent.isSelected()) {
                    Trapesium tr = SharedData.getTrapesium();
                    if (tr == null) throw new IllegalStateException("Belum ada data Trapesium");

                    limas = new LimasTrapesium(
                        tr.sisiSejajar1,
                        tr.sisiSejajar2,
                        (int) tr.tinggi,
                        tr.sisiMiring,
                        tinggiLimas
                    );
                } else if (rbManual.isSelected()) {
                    double sisi1 = Double.parseDouble(tfSisi1.getText());
                    double sisi2 = Double.parseDouble(tfSisi2.getText());
                    int tinggi = Integer.parseInt(tfTinggi.getText());
                    double sisiMiring = Double.parseDouble(tfSisiMiring.getText());

                    limas = new LimasTrapesium(sisi1, sisi2, tinggi, sisiMiring, tinggiLimas);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                LimasTrapesiumThread thread = new LimasTrapesiumThread(limas, output);
                thread.start();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
