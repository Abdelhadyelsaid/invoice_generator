package model;

public class InvoiceHeader {
    private String invoiceNum;
    private String invoiceDate;
    private String customerName;

    public InvoiceHeader() {
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "invoiceNum='" + invoiceNum + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", customerName='" + customerName + '\'' +
                //   ", invoiceLines=" + invoiceLines +
                '}';
    }
}
