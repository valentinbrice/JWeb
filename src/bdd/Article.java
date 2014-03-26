package bdd;

/**
 * Created by valen_000 on 04/02/14.
 */
public class Article {

    int id;
    String nom;
    double prix;
    int stock;
    int category;
    String desc;
    String photo;

    public Article(int id, String nom, double prix, int stock, int category, String desc, String photo){
        this.id=id;
        this.nom=nom;
        this.prix=prix;
        this.stock=stock;
        this.category=category;
        this.desc = desc;
        this.photo = photo;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
