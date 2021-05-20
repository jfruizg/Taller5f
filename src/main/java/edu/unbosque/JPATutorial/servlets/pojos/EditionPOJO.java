package edu.unbosque.JPATutorial.servlets.pojos;

public class EditionPOJO {

    private Integer editionId;
    private String descripcion;
    private Integer realeseYear;


    public EditionPOJO(Integer editionId, String descripcion, Integer realeseYear) {
        this.editionId = editionId;
        this.descripcion = descripcion;
        this.realeseYear = realeseYear;

    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRealeseYear() {
        return realeseYear;
    }

    public void setRealeseYear(Integer realeseYear) {
        this.realeseYear = realeseYear;
    }

}
