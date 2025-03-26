import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
  private JButton wortartButton = new JButton();
  private JSpinner jSpinner1 = new JSpinner();
    private SpinnerNumberModel jSpinner1Model = new SpinnerNumberModel(3, 1, 20, 1);
  private JCheckBox jCheckBox1 = new JCheckBox();
  Wort pWort;
  // Ende Attribute
  
  public AppFrame() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 598; 
    int frameHeight = 182;
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
    wortartButton.setBounds(144, 24, 107, 33);
    wortartButton.setText("Substantiv");
    wortartButton.setMargin(new Insets(2, 2, 2, 2));
    wortartButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        wortartButton_ActionPerformed(evt);
      }
    });
    wortartButton.setToolTipText("Wortart");
    wortartButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    cp.add(wortartButton);
    jSpinner1.setBounds(200, 80, 46, 32);
    jSpinner1.setValue(3);
    jSpinner1.setModel(jSpinner1Model);
    jSpinner1.setFont(new Font("Dialog", Font.BOLD, 15));
    jSpinner1.setToolTipText("Silbenanzahl");
    jSpinner1.addChangeListener(new ChangeListener() { 
      public void stateChanged(ChangeEvent evt) { 
        jSpinner1_StateChanged(evt);
      }
    });
    cp.add(jSpinner1);

    jCheckBox1.setBounds(16, 80, 172, 28);
    jCheckBox1.setOpaque(false);
    jCheckBox1.setText("manuelle Silbenzahl");
    jCheckBox1.setFont(new Font("Dialog", Font.PLAIN, 15));
    jCheckBox1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jCheckBox1_ActionPerformed(evt);
      }
    });
    jCheckBox1.addItemListener(new ItemListener() { 
      public void itemStateChanged(ItemEvent evt) { 
        jCheckBox1_ItemStateChanged(evt);
      }
    });
    jCheckBox1.addChangeListener(new ChangeListener() { 
      public void stateChanged(ChangeEvent evt) { 
        jCheckBox1_StateChanged(evt);
      }
    });
    jCheckBox1.setSelected(true);
    cp.add(jCheckBox1);
    // Ende Komponenten
    
    setVisible(true);

    pWort = new Wort(true);
  }
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new AppFrame();
  }
  public void jButton1_ActionPerformed(ActionEvent evt) {
    taubischTxtField.setText(pWort.uebersetze(deutschTxtField.getText(),0,5));    
  }

  public void wortartButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  }

  public void jCheckBox1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  }

  public void jCheckBox1_ItemStateChanged(ItemEvent evt) {
    // TODO hier Quelltext einfügen
    
  }

  public void jCheckBox1_StateChanged(ChangeEvent evt) {
    // TODO hier Quelltext einfügen
    // if(jCheckBox1){}
      
    }
  public void jSpinner1_StateChanged(ChangeEvent evt) {
    // TODO hier Quelltext einfügen
    
  }

  // Ende Methoden
}
