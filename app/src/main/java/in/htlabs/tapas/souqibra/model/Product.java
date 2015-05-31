package in.htlabs.tapas.souqibra.model;

/**
 * Created by Tapas on 5/22/2015.
 */
public class Product {
    private String p_name, p_image, p_details, p_price;

    public Product() {
    }

    public Product(String p_name, String p_image, String p_details, String p_price) {
        this.p_name = p_name;
        this.p_image = p_image;
        this.p_details = p_details;
        this.p_price = p_price;
    }

    public String getPName() {
        return p_name;
    }

    public void setPName(String p_name) {
        this.p_name = p_name;
    }

    public String getPImageUrl() {
        return p_image;
    }

    public void setPImageUrl(String p_image) {
        this.p_image = p_image;
    }

    public String getPDetails() {
        return p_details;
    }

    public void setPDetails(String p_details) {
        this.p_details = p_details;
    }

    public String getPPrice() {
        return p_price;
    }

    public void setPPrice(String p_price) {
        this.p_price = p_price;
    }

}
