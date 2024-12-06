package models;
 
public class Clube {   
private int id;
private static Double receita;
private static Double gastos;
private static Double bilheteria;
private static String serie;
private static String posicao;
private static String presidente;
private static String tecnico;
 
// Construtores
 
 
public Clube() {
 
}
 
 
public Clube (Double receita, Double gastos, Double bilheteria, String serie, String posicao, String presidente, String tecnico) {
this.receita = receita;
this.gastos = gastos;
this.bilheteria = bilheteria;
this.serie = serie;
this.posicao = posicao;
this.presidente = presidente;
this.tecnico = tecnico;
}
 
public Clube(int id, Double receita, Double gastos, Double bilheteria, String serie, String posicao, String presidente, String tecnico) {
 
this.id = id;
this.receita = receita;
this.gastos = gastos;
this.bilheteria = bilheteria;
this.serie = serie;
this.posicao = posicao;
this.presidente = presidente;
this.tecnico = tecnico;
 
}
 
// Getters e Setters

public int getId() {
    return id;   
  }
    // ID somente leitura, sem setter
     
    public static Double getReceita() { 
    return receita;
    }
     
    public void setReceita (Double receita) {
    this.receita = receita;
    }
     
    public static Double getGastos() {
    return gastos; 
    }
     
    public void setGastos(Double gastos) {
    this.gastos = gastos;
    }

    public static Double  getBilheteria(){
        return bilheteria;
    }
         
    public void setBilheteria(Double bilheteria){
        this.bilheteria = bilheteria;
    }

    public static String getSerie(){
        return serie;
    }
     
    public void setSerie(String serie){
        this.serie = serie;
    }

    public static String getPosicao(){
        return posicao;
    }
     
    public void setPosicao(String posicao){
        this.posicao = posicao;
    }

    public static String getPresidente(){
        return presidente;
    }
     
    public void setPresidente(String presidente){
        this.presidente = presidente;
    }

    public static String getTecnico(){
        return tecnico;
    }
     
    public void setTecnico(String tecnico){
        this.tecnico = tecnico;
    }


//toString

@Override
public String toString(){
     return "Clube [id=" + id + ", receita=" + receita + ", gastos= " + gastos + ", bilheteria=" + bilheteria + ", serie= " + serie + ", posicao=" + posicao +"]";   
}

}