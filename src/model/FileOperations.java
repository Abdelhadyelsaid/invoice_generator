package model;

import Exceptions.WrongFileFormatException;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class FileOperations extends JFrame {
    private final ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
    private final ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();

    //Read invoice data function
    public ArrayList<InvoiceLine> readLineFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        String path = fc.getSelectedFile().getPath();
        String line;
        try {
            if (result == JFileChooser.APPROVE_OPTION && path.endsWith(".csv")) {
                FileInputStream file = null;
                try {
                    file = new FileInputStream(path);
                    BufferedReader br = new BufferedReader(new FileReader(path));
                    while ((line = br.readLine()) != null) {
                        String[] lines = line.split(",");

                        InvoiceLine invoiceLine = new InvoiceLine();
                        invoiceLine.setInvoiceNumber(lines[0]);
                        invoiceLine.setItemName(lines[1]);
                        invoiceLine.setCount(lines[3]);
                        invoiceLine.setItemPrice(lines[2]);

                        invoiceLines.add(invoiceLine);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new WrongFileFormatException("Wrong file format must ends with CSV");
            }
        } catch (WrongFileFormatException e) {
            e.printStackTrace();
        }
        return invoiceLines;
    }

    //read header file function
    public ArrayList<InvoiceHeader> readHeaderFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        String path = fc.getSelectedFile().getPath();
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            if (result == JFileChooser.APPROVE_OPTION && path.endsWith(".csv")) {
                FileInputStream file = null;
                try {
                    file = new FileInputStream(path);
                    BufferedReader br = new BufferedReader(new FileReader(path));
                    while ((line = br.readLine()) != null) {
                        String[] headers = line.split(",");
                        InvoiceHeader invoiceHeader = new InvoiceHeader();

                        invoiceHeader.setInvoiceNum(headers[0]);
                        invoiceHeader.setInvoiceDate(headers[1]);
                        invoiceHeader.setCustomerName(headers[2]);
                        invoiceHeaders.add(invoiceHeader);
                        try {
                            dateFormat.parse(invoiceHeader.getInvoiceDate());
                            System.out.println("Date is valid");
                        } catch (ParseException e) {
                            System.out.println(invoiceHeader.getInvoiceDate() + "Is not valid Date");
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        assert file != null;
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new WrongFileFormatException("Wrong file format must ends with CSV");
            }
        } catch (WrongFileFormatException e) {
            e.printStackTrace();
        }
        return invoiceHeaders;
    }

    //write header data function
    public void writeHeaderFile(ArrayList<InvoiceHeader> invoiceHeadersList) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        String path = fc.getSelectedFile().getPath();
        File log = new File(path);
        if (result == JFileChooser.APPROVE_OPTION && path.endsWith(".csv")) {
            try {
                PrintWriter write = new PrintWriter(new FileWriter(log, true));
                for (InvoiceHeader invoice : invoiceHeadersList) {
                    write.append(invoice.getInvoiceNum() + "," + invoice.getInvoiceDate() + "," + invoice.getCustomerName() + "\n");
                }
                write.close();
                System.out.println();
                System.out.print("Done Write");
            } catch (WrongFileFormatException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    //write invoice data function
    public void writelineFile(ArrayList<InvoiceLine> invoiceLineList) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        String path = fc.getSelectedFile().getPath();
        File log = new File(path);
        if (result == JFileChooser.APPROVE_OPTION && path.endsWith(".csv")) {
            try {
                PrintWriter write = new PrintWriter(new FileWriter(log, true));
                for (InvoiceLine invoice : invoiceLineList) {
                    write.append(invoice.getInvoiceNumber() + "," + invoice.getItemName() + "," + invoice.getItemPrice() + "," + invoice.getCount() + "\n");
                }
                write.close();
                System.out.println();
                System.out.print("Done Write");
            } catch (WrongFileFormatException | NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

