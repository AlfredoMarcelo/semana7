package sistemaentradas7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SistemaEntradaS7 {

    public static void main(String[] args) {
        ArrayList<Venta> ventasRealizadas = new ArrayList<>();
        Boolean salirDelMenu = false;
        Scanner entradaDeTexto = new Scanner(System.in);
        String opcionSeleccionada;

        //Lectura de selección
        // Ciclo para menu principal
        while (!salirDelMenu) {
            //Menu principal
            System.out.println("Bienvenido al sistema de ventas del Teatro Moro:\n"
                    + "Seleccione una opción:\n"
                    + " 1 => Vender entrada\n"
                    + " 2 => Ver resumen de Ventas\n"
                    + " 3 => Generar Boleta\n"
                    + " 4 => Calcular Ingresos Totales\n"
                    + " 5 => Salir\n");

            opcionSeleccionada = entradaDeTexto.nextLine();

            if (opcionSeleccionada.equalsIgnoreCase("1")) {
                menuVentaEntrada(entradaDeTexto, ventasRealizadas);
            }
            if (opcionSeleccionada.equalsIgnoreCase("2")) {
                verResumenDeVentas(ventasRealizadas, entradaDeTexto);
            }
            if (opcionSeleccionada.equalsIgnoreCase("5")) {
                System.out.println("Ha salido del programa, hasta luego :)");
                salirDelMenu = true;
            }
        }
    }

    // Sub menu Venta de entrada
    public static void menuVentaEntrada(Scanner entradaDeTexto, ArrayList<Venta> ventasRealizadas) {
        Boolean salirDelMenu = false;
        Venta ventaRealizada = new Venta();
        Entrada entradaVendida = new Entrada();
        ArrayList<Entrada> entradasVendidas = new ArrayList<>();
        Integer valorVip = 30000;
        Integer valorPlatea = 20000;
        Integer valorGaleria = 10000;
        String opcionSeleccionada = "";

        while (!salirDelMenu) {
            
            System.out.println("**********************************\n"
                        + "Estas son las ubicaciones disponibles y sus valores:\n"
                        + "Vip => $30.000\n"
                        + "Platea => $20.000\n"
                        + "Galería => $10.000\n"
                        + "**********************************\n");
            
            
            // Submenu Ubicacion y valor
            Boolean ubicacionEstaSeleccionada = false;
            while (!ubicacionEstaSeleccionada) {
                String ubicacionSeleccionada;
                System.out.println("Seleccione una ubicación:\n"
                        + " 1 => Vip\n"
                        + " 2 => Platea\n"
                        + " 3 => Galería\n");

                ubicacionSeleccionada = entradaDeTexto.nextLine();

                if (ubicacionSeleccionada.equalsIgnoreCase("1")) {
                    entradaVendida.setUbicacion("vip");
                    entradaVendida.setCostoBase(valorVip);
                    ubicacionEstaSeleccionada = true;
                }
                if (ubicacionSeleccionada.equalsIgnoreCase("2")) {
                    entradaVendida.setUbicacion("platea");
                    entradaVendida.setCostoBase(valorPlatea);
                    ubicacionEstaSeleccionada = true;
                }
                if (ubicacionSeleccionada.equalsIgnoreCase("3")) {
                    entradaVendida.setUbicacion("galeria");
                    entradaVendida.setCostoBase(valorGaleria);
                    ubicacionEstaSeleccionada = true;
                }
            }
            
            
            // Submenu Descuento y valor final
            Boolean descuentoRegistrado = false;
            while (!descuentoRegistrado) {
                int descuento = 0;
                String opcionDescuentoSeleccionado;
                
                System.out.println("Cliente es Estudiante o de Tercera Edad:\n"
                        + "Seleccione una opción:\n"
                        + " 1 => Estudiante (descuento de 10%)\n"
                        + " 2 => Tercera Edad (descuento de 15%)\n"
                        + " 3 => Otro (sin descuento)\n");

                opcionDescuentoSeleccionado = entradaDeTexto.nextLine();

                if (opcionDescuentoSeleccionado.equalsIgnoreCase("1")) {
                    descuento = (int) (entradaVendida.getCostoBase() * 0.10);
                    entradaVendida.setValorDescuento(descuento);
                    entradaVendida.setCostoFinal(entradaVendida.getCostoBase() - entradaVendida.getValorDescuento());
                    descuentoRegistrado = true;
                }
                if (opcionDescuentoSeleccionado.equalsIgnoreCase("2")) {
                    descuento = (int) (entradaVendida.getCostoBase() * 0.15);
                    entradaVendida.setValorDescuento(descuento);
                    entradaVendida.setCostoFinal(entradaVendida.getCostoBase() - entradaVendida.getValorDescuento());
                    descuentoRegistrado = true;
                }
                if (opcionDescuentoSeleccionado.equalsIgnoreCase("3")) {
                    entradaVendida.setValorDescuento(0);
                    entradaVendida.setCostoFinal(entradaVendida.getCostoBase());
                    descuentoRegistrado = true;
                }
                
            }
            
            System.out.println("--------------------------------\n" + entradaVendida.toString() + "\n--------------------------------\n");
            
            // Guardar entrada vendida en la venta
            
            Random idAleatorio = new Random();
            ventaRealizada.setId(idAleatorio.nextInt(100000) + 1);
            entradasVendidas.add(entradaVendida);
            ventaRealizada.setEntradasVendidas(entradasVendidas);
            
            // Fin guardar entrada vendida en la venta
            
            // Submenu para vender otra entrada o salir del menu de venta
            Boolean  seRealizaOtraVenta = false;
            
            while (!seRealizaOtraVenta) {
                String opcionSeleccionadaSubmenu;
                System.out.println("Venta realizada con éxito!\n"
                        + " Seleccione una opcion\n"
                        + " 1 => Vender otra entrada\n"
                        + " 2 => Salir a Menu Principal\n");

                opcionSeleccionadaSubmenu = entradaDeTexto.nextLine();

                if (opcionSeleccionadaSubmenu.equalsIgnoreCase("1")) {
                    seRealizaOtraVenta = true;
                    System.out.println("");
                }
                if (opcionSeleccionadaSubmenu.equalsIgnoreCase("2")) {
                    if(!entradasVendidas.isEmpty()){
                        Integer totalVenta = 0;
                        System.out.println(ventaRealizada.toString()+ "\n Entradas vendidas " + entradasVendidas.size());
                        for(Entrada entrada : entradasVendidas){
                            totalVenta += entrada.costoFinal;
                        }
                        // se podría considerar como boleta :( me falto agregar la logica
                        System.out.println(" Total Venta: $" + totalVenta);
                        ventasRealizadas.add(ventaRealizada);
                    }
                    salirDelMenu = true;
                    seRealizaOtraVenta = true;
                    System.out.println("");
                }
            }
        }
    }
    
    
    // SubMenu Ver resumen de ventas
    public static void verResumenDeVentas(ArrayList<Venta> ventasRealizadas, Scanner entradaDeTexto  ) {
        Boolean salirDelSubMenu = false;
        String opcionSeleccionada = "";
         while (!salirDelSubMenu) {
             System.out.println(
                        " Seleccione una opcion\n"
                        + " 1 => Ver Resumen De Ventas\n"
                        + " 2 => Salir a Menu Principal\n");
             
             opcionSeleccionada = entradaDeTexto.nextLine();
             
             
            
            
                if (opcionSeleccionada.equalsIgnoreCase("1")) {
                    if(!ventasRealizadas.isEmpty()){
                        for(Venta venta : ventasRealizadas){
                            System.out.println("Venta numer: " + venta.id + "Venta Final: " + "Valor Final total");
                            
                            // Me falto otro for para realizar la consutal del valor final de cada venta :(
                            System.out.println("--------------------------");
                        }
                    }
                    }else{
                        System.out.println("No existen Ventas");
                    }
                }
                if (opcionSeleccionada.equalsIgnoreCase("2")) {
                    salirDelSubMenu = true;
                }
         }
}
