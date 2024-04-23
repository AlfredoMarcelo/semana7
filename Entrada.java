
package sistemaentradas7;


public class Entrada {
    public String ubicacion;
    public Integer costoBase;
    public Integer valorDescuento;
    public Integer costoFinal;

    public Entrada() {
    }

    public Entrada(String ubicacion, Integer costoBase, Integer valorDescuento, Integer costoFinal) {
        this.ubicacion = ubicacion;
        this.costoBase = costoBase;
        this.valorDescuento = valorDescuento;
        this.costoFinal = costoFinal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(Integer costoBase) {
        this.costoBase = costoBase;
    }

    public Integer getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Integer valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Integer getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Integer costoFinal) {
        this.costoFinal = costoFinal;
    }

    @Override
    public String toString() {
        return "Resumen  Entrada Vendida: \n" + " Ubicacion: " + ubicacion + "\n Valor Base: $" + costoBase + "\n Descuento: $" + valorDescuento + "\n Valor Final: $" + costoFinal;
    }
    
    
}
