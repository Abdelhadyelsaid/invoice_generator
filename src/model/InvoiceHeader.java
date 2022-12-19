package model;

import java.util.ArrayList;

public class InvoiceHeader {
    private String invoiceNum;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
}