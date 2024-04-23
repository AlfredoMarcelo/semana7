package sistemaentradas7;

import java.util.ArrayList;

public class Venta {
    public Integer id;
    public ArrayList<Entrada> entradasVendidas;

    public Venta() {
    }

    public Venta(Integer id, ArrayList<Entrada> entradasVendidas) {
        this.id = id;
        this.entradasVendidas = entradasVendidas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(ArrayList<Entrada> entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    @Override
    public String toString() {
        return "Venta numero " + id + "\n Resumen Venta: ";
    }
    
    
}
