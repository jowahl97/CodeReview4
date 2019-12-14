package sample;

public class Product {
    private String productName;
    private String productQuantity;
    private double productOldPrice;
    private double productNewPrice;
    private String productDescription;

    public Product(String productName, String productQuantity, double productOldPrice, double productNewPrice, String productDescription) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productOldPrice = productOldPrice;
        this.productNewPrice = productNewPrice;
        this.productDescription = productDescription;
    }

    public Product(){

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(double productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public double getProductNewPrice() {
        return productNewPrice;
    }

    public void setProductNewPrice(double productNewPrice) {
        this.productNewPrice = productNewPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
