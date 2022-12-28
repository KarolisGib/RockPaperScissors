import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class GameFrame extends JFrame implements ActionListener {

    JFrame f;
    JButton b1, b2, b3, r;
    JLabel p, c, s;
    ImageIcon rock, paper, scissors, restart;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem saveItem, loadItem, exitItem, editFont, editBack;
    String Player;
    String Computer;
    int playerScore=1;
    int computerScore=1;
        GameFrame() {
        f = new JFrame("Rock Paper Scissors");
        f.setPreferredSize(new Dimension(615, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.BLACK);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        loadItem = new JMenuItem("Load");
        loadItem.addActionListener(this);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        editFont = new JMenuItem("Font Color");
        editFont.addActionListener(this);
        editBack = new JMenuItem("Background Color");
        editBack.addActionListener(this);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);

        editMenu.add(editFont);
        editMenu.add(editBack);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        f.setJMenuBar(menuBar);

        b1 = new JButton("Rock");
        b1.setBounds(15, 100, 180, 180);
        rock = new ImageIcon("images/rock.png");
        b1.setIcon(rock);
        b1.addActionListener(this);
        b1.setFocusable(false);
        f.add(b1);
        b2 = new JButton("Paper");
        b2.setBounds(210, 100, 180, 180);
        paper = new ImageIcon("images/paper.png");
        b2.setIcon(paper);
        b2.addActionListener(this);
        b2.setFocusable(false);
        f.add(b2);
        b3 = new JButton("Scissors");
        scissors = new ImageIcon("images/scissors.png");
        b3.setIcon(scissors);
        b3.setBounds(405, 100, 180, 180);
        b3.addActionListener(this);
        b3.setFocusable(false);
        f.add(b3);
        r = new JButton("Restart");
        restart = new ImageIcon("images/restart.png");
        r.setIcon(restart);
        r.setBounds(210, 25, 180, 50);
        r.addActionListener(this);
        r.setFocusable(false);
        f.add(r);

        p = new JLabel("Player score:");
        p.setBounds(15, 25, 180, 50);
        p.setHorizontalAlignment(SwingConstants.CENTER);
        p.setFont(new Font("Ink Free",Font.PLAIN,20));
        p.setForeground(Color.WHITE);
        p.setBackground(Color.BLACK);
        p.setOpaque(true);
        f.add(p);

        c = new JLabel("Computer score:");
        c.setBounds(405, 25, 180, 50);
        c.setHorizontalAlignment(SwingConstants.CENTER);
        c.setFont(new Font("Ink Free",Font.PLAIN,20));
        c.setForeground(Color.WHITE);
        c.setBackground(Color.BLACK);
        c.setOpaque(true);
        f.add(c);

        s = new JLabel();
        s.setBounds(25, 300, 550, 50);
        s.setHorizontalAlignment(SwingConstants.CENTER);
        s.setFont(new Font("Ink Free",Font.PLAIN,20));
        s.setForeground(Color.WHITE);
        s.setBackground(Color.BLACK);
        s.setOpaque(true);
        f.add(s);

        f.pack();
        f.setVisible(true);

        startGame();
    }
    public void startGame () {
        s.setText("Chose rock, paper or scissors");
        r.setEnabled(false);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == b1) {
            Player = "rock";
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            computerChoice();
        } else if (e.getSource() == b2) {
            Player = "paper";
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            computerChoice();
        } else if (e.getSource() == b3) {
            Player = "scissors";
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            computerChoice();
        }
        if (e.getSource() == r) {
            startGame();
        }
        if(e.getSource()==editBack) {
//            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Chose background color", Color.BLACK);
            f.getContentPane().setBackground(color);
            p.setBackground(color);
            c.setBackground(color);
            s.setBackground(color);
        }
        if(e.getSource()==editFont) {
//            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Chose font color", Color.WHITE);
            p.setForeground(color);
            c.setForeground(color);
            s.setForeground(color);
        }
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
        if(e.getSource()==saveItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt files", "txt");
            fileChooser.addChoosableFileFilter(restrict);
            fileChooser.setCurrentDirectory(new File("C:\\Program Files (x86)"));
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // save to file
            }
        }
        if(e.getSource()==loadItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt files", "txt");
            fileChooser.addChoosableFileFilter(restrict);
            fileChooser.setCurrentDirectory(new File("C:\\Program Files (x86)"));

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                // load from file
            }
        }
    }
    public void computerChoice () {

        int computerChoice = (int) Math.floor(Math.random() * 3 + 1);

        Computer =
                computerChoice == 1
                        ? "rock"
                        : computerChoice == 2
                        ? "paper"
                        : "scissors";
        result();
    }
    public void result () {
        if (Objects.equals(Player, Computer)) {
            s.setText("Player chose "+Player+". Computer chose "+Computer+". Tie game");
            r.setEnabled(true);
        } else if (Objects.equals(Player, "rock") && Objects.equals(Computer, "paper")) {
            s.setText("Player chose "+Player+". Computer chose "+Computer+". Computer won");
            c.setText("Computer score: "+computerScore++);
            r.setEnabled(true);
        } else if (Objects.equals(Player, "paper") && Objects.equals(Computer, "scissors")) {
            s.setText("Player chose "+Player+". Computer chose "+Computer+". Computer won");
            c.setText("Computer score: "+computerScore++);
            r.setEnabled(true);
        } else if (Objects.equals(Player, "scissors") && Objects.equals(Computer, "rock")) {
            s.setText("Player chose "+Player+". Computer chose "+Computer+". Computer won");
            c.setText("Computer score: "+computerScore++);
            r.setEnabled(true);
        } else {
            s.setText("Player chose "+Player+". Computer chose "+Computer+". Player won");
            p.setText("Player score: "+playerScore++);
            r.setEnabled(true);

        }
    }
}