package desafio.devoptopus.desafio3.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "products")
public class Product implements Serializable {

    @Id
    private String _id;

    private String id;

    private String brand;

    private String description;

    private String image;

    private int price;

    public Product() {
    }

    public Product(String _id, String id, String brand, String description, String image, int price) {
        this._id = _id;
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
