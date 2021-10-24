package model;

public class OrderDetail {

    private static final long serialVersionUID = 1L;

    private long no;
    private int custId;
    private String itemId;
    private String orderDate;
    private int quantity;
    private int taxId;
    private int status;

    public OrderDetail() {};

    public OrderDetail(long no, int custId, String itemId, String orderDate, int quantity, int taxId, int status) {
        this.no = no;
        this.custId = custId;
        this.itemId = itemId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.taxId = taxId;
        this.status = status;
    }

    public void setNo(long no) {
        this.no = no;
    }
    public long getNo() {
        return no;
    }


    public void setCustId(int custId) {
        this.custId = custId;
    }
    public int getCustId() {
        return custId;
    }


    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getItemId() {
        return itemId;
    }


    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderDate() {
        return orderDate;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }


    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }
    public int getTaxId() {
        return taxId;
    }


    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
}