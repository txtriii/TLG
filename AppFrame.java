import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 26.03.2025
 * @author 
 */

public class AppFrame extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JTextField deutschTxtField = new JTextField();
  private JTextField taubischTxtField = new JTextField();
  WortGenerator pWort;
  int wortArt;
  private JButton listeButton = new JButton();
  private JButton substantivButton = new JButton();
  private JButton verbButton = new JButton();
  private JButton adjektivButton = new JButton();
  private JLabel wortArtLabel = new JLabel();
  // Ende Attribute
  
  public AppFrame() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 598; 
    int frameHeight = 242;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Taubisch Language Generator");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    setUndecorated(false);
    cp.setBackground(Color.GRAY);
    jButton1.setBounds(24, 24, 107, 33);
    jButton1.setText("Übersetzen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setBackground(new Color(0xC0C0C0));
    jButton1.setFont(new Font("Dialog", Font.PLAIN, 15));
    cp.add(jButton1);
    deutschTxtField.setBounds(256, 24, 302, 36);
    deutschTxtField.setToolTipText("deutsch");
    deutschTxtField.setText("hier deutsches Wort eintragen");
    deutschTxtField.setFont(new Font("Dialog", Font.PLAIN, 15));
    cp.add(deutschTxtField);
    taubischTxtField.setBounds(256, 80, 302, 36);
    taubischTxtField.setToolTipText("taubische Übersetzung");
    taubischTxtField.setText("Übersetzung");
    taubischTxtField.setFont(new Font("Dialog", Font.PLAIN, 15));
    cp.add(taubischTxtField);

    listeButton.setBounds(419, 154, 147, 33);
    listeButton.setText("Vollständige Liste");
    listeButton.setMargin(new Insets(2, 2, 2, 2));
    listeButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        listeButton_ActionPerformed(evt);
      }
    });
    cp.add(listeButton);
    substantivButton.setBounds(147, 16, 27, 25);
    substantivButton.setText("S");
    substantivButton.setMargin(new Insets(2, 2, 2, 2));
    substantivButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        substantivButton_ActionPerformed(evt);
      }
    });
    cp.add(substantivButton);
    verbButton.setBounds(179, 16, 27, 25);
    verbButton.setText("V");
    verbButton.setMargin(new Insets(2, 2, 2, 2));
    verbButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        verbButton_ActionPerformed(evt);
      }
    });
    cp.add(verbButton);
    adjektivButton.setBounds(211, 16, 27, 25);
    adjektivButton.setText("A");
    adjektivButton.setMargin(new Insets(2, 2, 2, 2));
    adjektivButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        adjektivButton_ActionPerformed(evt);
      }
    });
    cp.add(adjektivButton);
    wortArtLabel.setBounds(138, 43, 110, 22);
    wortArtLabel.setText("Substantiv");
    wortArtLabel.setHorizontalAlignment(SwingConstants.CENTER);
    wortArtLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    wortArtLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
    wortArtLabel.setToolTipText("Wortart");
    cp.add(wortArtLabel);

    // Ende Komponenten
    
    setVisible(true);

    pWort = new WortGenerator(true);
    wortArt = 0;
  }
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new AppFrame();
  }
  public void jButton1_ActionPerformed(ActionEvent evt) {
    taubischTxtField.setText(pWort.uebersetze(deutschTxtField.getText(),wortArt,5));    
  }

  public void listeButton_ActionPerformed(ActionEvent evt) {
    pWort.printTranslationList();
  }

  public void substantivButton_ActionPerformed(ActionEvent evt) {
    wortArtLabel.setText("Substantiv");
    wortArt = 0;
  }

  public void verbButton_ActionPerformed(ActionEvent evt) {
    wortArtLabel.setText("Verb");
    wortArt = 1;
  }

  public void adjektivButton_ActionPerformed(ActionEvent evt) {
    wortArtLabel.setText("Adjektiv");
    wortArt = 2;
  }

  // Ende Methoden
}
