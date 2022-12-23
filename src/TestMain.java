import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        ArrayList<InvoiceHeader> invoiceHeaderArrayList = new ArrayList<>();
        ArrayList<InvoiceLine> invoiceLineArrayList = new ArrayList<>();

        FileOperations file = new FileOperations();


        Scanner sc = new Scanner(System.in);

        System.out.println("Choose file Operation !\n 1-Read File \n 2-Write File");
        String fileOperation = sc.next();

        //read files
        if (fileOperation.equals("1")) {

            System.out.println("Please Choose Invoice Line file !");
            ArrayList<InvoiceLine> invoiceLines = file.readLineFile();

            System.out.println("Please Choose Invoice Header file !");
            ArrayList<InvoiceHeader> invoiceHeaders = file.readHeaderFile();

            System.out.println("Read done Successfully!");

            //print the output format
            for (InvoiceHeader invoice : invoiceHeaders) {
                System.out.println(invoice.getInvoiceNum() + "\n{");
                System.out.println(invoice.getInvoiceDate() + ", " + invoice.getCustomerName());
                for (InvoiceLine line : invoiceLines) {
                    if (invoice.getInvoiceNum().equals(line.getInvoiceNumber())) {
                        System.out.println(line.getItemName() + ", " + line.getItemPrice() + ", " + line.getCount());
                    }
                }
                System.out.println("}");
            }


        } else if (fileOperation.equals("2")) {
            System.out.println("Please Choose file !\n 1-Invoice Header \n 2-Invoice Line");
            String fileType = sc.next();

            //write Invoice Header CSV file if choose 1
            if (fileType.equals("1")) {
                InvoiceHeader invoiceHeader = new InvoiceHeader();
                System.out.print("Enter invoice number: ");
                invoiceHeader.setInvoiceNum(sc.next());
                System.out.print("Enter invoice Date: ");
                invoiceHeader.setInvoiceDate(sc.next());
                System.out.print("Enter customer name: ");
                invoiceHeader.setCustomerName(sc.next());
                invoiceHeaderArrayList.add(invoiceHeader);
                System.out.println("Choose file to Save Data !");

                file.writeHeaderFile(invoiceHeaderArrayList);

                //Write on Invoice Lines CSV file if choose 2
            } else if (fileType.equals("2")) {
                System.out.print("Enter number of Items: ");
                int numofitems = sc.nextInt();
                for (int i = 0; i < numofitems; i++) {
                    InvoiceLine invoiceLine = new InvoiceLine();
                    System.out.print("Enter invoice number: ");
                    invoiceLine.setInvoiceNumber(sc.next());
                    System.out.print("Enter item Name: ");
                    invoiceLine.setItemName(sc.next());
                    System.out.print("Enter Item Price: ");
                    invoiceLine.setItemPrice(sc.next());
                    System.out.print("Enter Count: ");
                    invoiceLine.setCount(sc.next());
                    invoiceLineArrayList.add(invoiceLine);
                }
                System.out.println(invoiceLineArrayList);
                file.writelineFile(invoiceLineArrayList);
            } else {
                System.out.println("Invalid Input please try again !");
            }
            sc.close();
        } else {
            System.out.println("Invalid Input please try again !");
        }
        sc.close();
    }
}
