package bdd;

/**
 * Created by valen_000 on 04/02/14.
 */
public class User {

    int id;
    String login;
    String pwd;
    int nbPanier;

    public User(int id, String login, String pwd){
        this.id=id;
        this.login=login;
        this.pwd=pwd;
        this.nbPanier=0;
    }

    public User(int id, String login, String pwd, int nbPanier){
        this.id=id;
        this.login=login;
        this.pwd=pwd;
        this.nbPanier=nbPanier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getNbPanier() {
        return nbPanier;
    }

    public void setNbPanier(int nbPanier) {
        this.nbPanier = nbPanier;
    }
}
