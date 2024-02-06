import javax.swing.*;

public class DeskovkyFrame extends JFrame {
    private JTextField tfNazev;
    private JButton btPrevisous;
    private JButton btChange;
    private JButton btNext;
    private JCheckBox checkBox1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton3;
    private JRadioButton radioButton2;
    private JPanel panelMain;
    private int indexAktualniHry = 0;
    private final EvidenceDeskovek evidenceDeskovek;

    public DeskovkyFrame (){
        super("Deskovky");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelMain);
        setSize(450,300);


        evidenceDeskovek = new EvidenceDeskovek();
        evidenceDeskovek.nactiEvidenci();

        btPrevisous.addActionListener(e ->  {
            if (indexAktualniHry > 0) {
                indexAktualniHry--;
                zobrazDeskovku();
            }
        });

        btNext.addActionListener(e ->  {
            if (indexAktualniHry < evidenceDeskovek.getSeznamDeskovek().size() - 1) {
                indexAktualniHry++;
                zobrazDeskovku();
            }
        });

        checkBox1.addActionListener( e -> {
            zobrazDeskovku();
        });

        zobrazDeskovku();
    }

    public void zobrazDeskovku(){
        Deskovka aktualniDeskova = evidenceDeskovek.getSeznamDeskovek().get(indexAktualniHry);
        tfNazev.setText(aktualniDeskova.getNazev());
        Deskovka deskovka = evidenceDeskovek.getSeznamDeskovek().get(indexAktualniHry);
        checkBox1.setSelected(deskovka.getVlastnictvi());
        radioButton1.setSelected(deskovka.getHodnoceni() == 1);
        radioButton2.setSelected(deskovka.getHodnoceni() == 2);
        radioButton3.setSelected(deskovka.getHodnoceni() == 3);
    }
}

