/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionlb;

import java.util.ArrayList;

/**
 *
 * @author Emilsson Soler
 */
public class ProductoServicio {
    private final ArrayList<Producto> listaDeProducto;

    public ProductoServicio() {
        listaDeProducto = new ArrayList<>();
        crearDatosDePrueba();
    }

    public ArrayList<Producto> getListaDeProducto() {
        return listaDeProducto;
    }
    
    
    public void guardar(Producto producto){
        boolean idrepetida=false;
        for(Producto busqueda:listaDeProducto){
            if (busqueda.getId()==producto.getId()) {
                idrepetida=true;
            }
        }
        
     if(!idrepetida){
     listaDeProducto.add(producto);
     }
    }

    private void crearDatosDePrueba() {
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("queso");
        producto1.setPrecio(12.5);
        producto1.setExistencia(4);
        
        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("mantequilla");
        producto2.setPrecio(14.4);
        producto2.setExistencia(45);
        listaDeProducto.add(producto1);
        listaDeProducto.add(producto2);
    }
    
    
    
}
