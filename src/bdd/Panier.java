package bdd;

import java.util.List;

public class Panier {
    int idpanier;
    List<Integer> lstidart;
    List<Integer> lstqte;

    public Panier(){}

    public Panier(int idpanier){
        this.idpanier=idpanier;
        lstidart=null;
        lstqte=null;
    }

    public Panier(int idpanier, List<Integer> lstidart, List<Integer> lstqte){
        this.idpanier=idpanier;
        this.lstidart=lstidart;
        this.lstqte=lstqte;
    }

    public List<Integer> getLstidart() {
        return lstidart;
    }

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public void setLstidart(List<Integer> lstidart) {
        this.lstidart = lstidart;
    }

    public List<Integer> getLstqte() {
        return lstqte;
    }

    public void setLstqte(List<Integer> lstqte) {
        this.lstqte = lstqte;
    }

    public void addarticle(int idarticle,int quantite){
        lstidart.add(idarticle);
        lstqte.add(quantite);
    }

    public int getlengthOfList(){
        return lstidart.size();
    }

}
