/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author USUARIO
 */
public class MundialDTO {
     //DAO
    //modelo del objeto Persona
    private int Id;
    private String Pais;
    private String Region;
    private String Capitan;
    private String Ranking;
    private String  Mundiales_Ganados;

   

    
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Pais
     */
    public String getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    /**
     * @return the Region
     */
    public String getRegion() {
        return Region;
    }

    /**
     * @param Region the Region to set
     */
    public void setRegion(String Region) {
        this.Region = Region;
    }

    /**
     * @return the Capitan
     */
    public String getCapitan() {
        return Capitan;
    }

    /**
     * @param Capitan the Capitan to set
     */
    public void setCapitan(String Capitan) {
        this.Capitan = Capitan;
    }

    /**
     * @return the Ranking
     */
    public String getRanking() {
        return Ranking;
    }
    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    /**
     * @return the Mundiales_Ganados
     */
    public String getMundiales_Ganados() {
        return Mundiales_Ganados;
    }

    /**
     * @param Mundiales_Ganados the Mundiales_Ganados to set
     */
    public void setMundiales_Ganados(String Mundiales_Ganados) {
        this.Mundiales_Ganados = Mundiales_Ganados;
    }
    @Override
    public String toString() {
        return "{" + "Id=" + getId()+ ", Pais=" + getPais() + ", Region=" + getRegion() + ", Capitan=" + getCapitan() + ", Ranking=" + getRanking() +",Mundiales_Ganados="+getMundiales_Ganados()+ '}';
    }

    
    
}




