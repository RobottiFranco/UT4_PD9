package com.example;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Almacen almacen = new Almacen("Julio");
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("altasPrueba.txt");
        String[] linea;
        Producto nuevoProducto;
        for (String string : archivo) {
            linea = string.split(",");
            if (almacen.buscarPorCodigo(linea[0]) == null) {
                nuevoProducto = new Producto(linea[0], linea[1]);
                nuevoProducto.setPrecio(Integer.parseInt(linea[2]));
                nuevoProducto.setStock(Integer.parseInt(linea[3]));
                almacen.insertarProducto(nuevoProducto);
            } else {
                almacen.buscarPorCodigo(linea[0]).agergarStock(Integer.parseInt(linea[3]));
            }
        }

        System.out.println("existe el elemento con id : 1000073?");
        System.out.println(almacen.buscarPorCodigo("1000073") != null);

        /* stock */
        System.out.println("stock1");
        System.out.println(almacen.buscarPorCodigo("1000073").getStock());

        almacen.buscarPorCodigo("1000073").agergarStock(1000);

        System.out.println("stock2");
        System.out.println(almacen.buscarPorCodigo("1000073").getStock());

        almacen.buscarPorCodigo("1000073").restarStock(1000);

        System.out.println("stock3");
        System.out.println(almacen.buscarPorCodigo("1000073").getStock());

        /* lista productos */
        System.out.println(almacen.imprimirProductos());

        // cargar los productos desde el archivo "altasprueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente
        // emitir el valor del stock
        // simular las ventas a partir del archivo "ventaspruebas.txt"
        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente

    }
}
