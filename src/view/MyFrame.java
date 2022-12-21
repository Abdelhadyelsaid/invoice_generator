package view;

import controller.MyListener;
import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MyFrame extends JFrame {
    private JTextField invoiceNumber;
    private JTextField invoiceDate;
    private JTextField customerName;
    InvoiceLine invoiceLine = new InvoiceLine();
    InvoiceHeader invoiceHeader = new InvoiceHeader();
    JDialog dialog = new JDialog();
    private JTable table;

    private String[] columns = {"Invoice Number", "Item Name", "ItemPrice", "count"};

    private String[][] lineData = {
            {invoiceHeader.getInvoiceNum(), invoiceLine.getItemName(), invoiceLine.getItemPrice(), invoiceLine.getCount()}
    };
    private JMenuBar mb;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;


    public MyFrame() {
        super("Sales Invoice Generator");
        setLayout(new FlowLayout());
        setSize(1080, 720);
        setLocation(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        invoiceNumber = new JTextField(15);
        add(new JLabel("Invioce Number"));
        add(invoiceNumber);

        invoiceDate = new JTextField(15);
        add(new JLabel("Invioce Date"));
        add(invoiceDate);

        customerName = new JTextField(15);
        add(new JLabel("Customer Number"));
        add(customerName);


        table = new JTable(lineData, columns);
        add(new JScrollPane(table));
        mb = new JMenuBar();

        fileMenu = new JMenu("File");
        openItem = new JMenuItem("open", 'O');
        saveItem = new JMenuItem("save", 'S');
        exitItem = new JMenuItem("exit", 'x');

        openItem.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_DOWN_MASK));

        openItem.addActionListener(new MyListener());
        saveItem.addActionListener(new MyListener());
        exitItem.addActionListener(new MyListener());

        openItem.setActionCommand("O");
        saveItem.setActionCommand("S");
        exitItem.setActionCommand("X");


        setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


    }


}
