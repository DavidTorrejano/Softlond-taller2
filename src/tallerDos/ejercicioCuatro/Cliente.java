package tallerDos.ejercicioCuatro;

public class Cliente {
    private String nombreEmpresa;
    private String idCorporativo;

    public Cliente(String nombreEmpresa, String idCorporativo) {
        this.nombreEmpresa = nombreEmpresa;
        this.idCorporativo = idCorporativo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getIdCorporativo() {
        return idCorporativo;
    }

    public void setIdCorporativo(String idCorporativo) {
        this.idCorporativo = idCorporativo;
    }
}
