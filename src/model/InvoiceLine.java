package model;

public class InvoiceLine {
    private String itemName;
    private String itemPrice;
    private String count;
    private String invoiceNumber;

    public InvoiceLine() {
    }

    public InvoiceLine(String itemName, String itemPrice, String count, String invoiceNumber) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoiceNumber = invoiceNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", count='" + count + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
    }
}
