/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author USUARIO
 */
public class BalonDTO {
      private int Id;
    private String Balon;
    private String Pais;
    private String Año;

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
     * @return the Balon
     */
    public String getBalon() {
        return Balon;
    }

    /**
     * @param Balon the Balon to set
     */
    public void setBalon(String Balon) {
        this.Balon = Balon;
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
     * @return the Año
     */
    public String getAño() {
        return Año;
    }

    /**
     * @param Año the Año to set
     */
    public void setAño(String Año) {
        this.Año = Año;
    }
    @Override
    public String toString() {
        return "{" + "Id=" + getId()+ ", Balon=" + getBalon() + ", Pais=" + getPais() + ", Año=" + getAño() + '}';
    }

}
