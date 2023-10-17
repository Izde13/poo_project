package gui;

import javax.swing.*;

public class MenuBarExample {

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("New");
        JMenuItem menuItem2 = new JMenuItem("Open");
        JMenuItem menuItem3 = new JMenuItem("Save");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        menuBar.add(menu);

        return menuBar;
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Frame 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 300);

        JFrame frame2 = new JFrame("Frame 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 300);

        JMenuBar menuBar = createMenuBar();

        frame1.setJMenuBar(menuBar);
        frame2.setJMenuBar(menuBar);

        frame1.setVisible(true);
        frame2.setVisible(true);
    }
}
