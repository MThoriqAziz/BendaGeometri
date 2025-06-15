package main;

import gui.GuiBenda2D;
import gui.GuiBenda3D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gui.GuiJajarGenjang;
import gui.GuiPrismaJajarGenjang;
import gui.GuiSegitiga;
import bendaGeometri.Benda2D;

public class main {
    public void showMainView() {
        JFrame frame = new JFrame("Main View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton btn2D = new JButton("Benda 2D");
        JButton btn3D = new JButton("Benda 3D");

        frame.add(btn2D);
        frame.add(btn3D);

        btn2D.addActionListener(e -> {
            new GuiBenda2D();
            frame.dispose();
        });

        btn3D.addActionListener(e -> {
            new GuiBenda3D();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // tetap butuh main() untuk entry point
    public static void main(String[] args) {
        new main().showMainView();
    }
    }
////public class TesGeometri {
////
////    
////    public static void main(String[] args) {
////        
////    }
////    
////}
