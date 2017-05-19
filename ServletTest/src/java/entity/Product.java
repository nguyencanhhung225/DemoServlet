package entity;

public class Product {

    private Integer id;
    private String name;
    private Integer price;
    private Integer idCategory;

    public Product() {
    }

    public Product(String name, Integer price, Integer idCategory) {
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product(Integer id, String name, Integer price, Integer idCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

}
