

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormClass extends JFrame  {
    private JPanel panel;
    private JButton addKeyButton;
    public JTextArea WordArea;
    private JLabel stopWord;
    private JTextArea maxArea;
    private JLabel label1;
    private JTextArea AreaCoef2;
    private JLabel label2;
    private JTextArea cursArea;
    private JLabel cursDollar;

    //public static FormClass instance ;
    public static String key = null;
    public static String max = null;
    public static String coef = null;
    public static String dollarCurs = null;
    public static int maxI = 100;
    public double coef1,coef2;
    public static FormClass dialog;
    public FormClass() {

        try {
            setContentPane(panel);
            //setModal(true);
            getRootPane().setDefaultButton(addKeyButton);
            try {
                Document doc = Jsoup
                        .connect("https://www.calc.ru/kurs-USD-RUB.html")
                        // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                        .get();
                dollarCurs = doc.toString().split("1 USD = ")[1].split(" RUB</strong>\n" + "           <br> \n" + "           <strong>1 RUB")[0];
                //System.out.println(doc.toString());
                cursArea.setText("1 USD = " + dollarCurs);
            } catch (Exception erGo) {
                System.out.println(erGo.getMessage());
            }


            addKeyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    key = WordArea.getText();
                    coef = AreaCoef2.getText();
                    max = maxArea.getText();
                    if (!key.equals("")) {
                        if (!coef.equals("")) {
                            coef1 = Double.parseDouble(max);
                            coef2 = Double.parseDouble(coef);
                            WordArea.setText(CountMoney.TwoCoefs(coef1, coef2, Integer.parseInt(key)));
                        } else {
                            maxI = Integer.parseInt(max);
                            try {
                                Scanning scanning = new Scanning();
                                Thread scan = new Thread(scanning);
                                scan.start();
                            } catch (Exception e1) {
                                System.out.println(e1.getMessage());
                            }

                        }
                    } else {
                        AreaCoef2.setText("В рублях: " + Double.parseDouble(max) * Double.parseDouble(dollarCurs));
                    }
                }
            });
            setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        }catch (IllegalComponentStateException illegalComponentStateException){
            System.out.println(illegalComponentStateException.getMessage());}
    }


    public static void CteateForm() {
        dialog = new FormClass();

        dialog.pack();
        dialog.setTitle("Start");
        dialog.setLocation(500,300);
        dialog.setSize(500,300);
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);

    }
}
