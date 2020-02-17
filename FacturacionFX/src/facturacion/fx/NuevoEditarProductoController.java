/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.fx;

import facturacionlb.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author Emilsson Soler
 */
public class NuevoEditarProductoController implements Initializable {
    
    @FXML
    Button bntcancelarproducto;
    
    @FXML
    TextField nuevoidprodcuto;
    
    @FXML
    TextField nuevoprecioproducto;
    
    
    @FXML
    TextField nuevaexistenciaproducto;
    
    @FXML
    TextField nuevonombreporoducto;
    
    
    
    private FormProductoController controller;
    private Producto producto;

    public void setProducto(Producto producto) {
         nuevoidprodcuto.textProperty().bindBidirectional(producto.idProperty(),new NumberStringConverter());
        nuevaexistenciaproducto.textProperty().bindBidirectional(producto.existenciaProperty(),new NumberStringConverter());
        nuevonombreporoducto.textProperty().bindBidirectional(producto.nombreProperty());
        nuevoprecioproducto.textProperty().bindBidirectional(producto.precioProperty(),new NumberStringConverter());
        this.producto = producto;
    }
   
    
    public void setController(FormProductoController controller) {
        this.controller = controller;
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
      
    }    
    public void aceptar(){
        
        controller.guardar(producto);
        cerrar();
        
        
    }
    
    public void cancelar(){
     cerrar();
    }
    

    private void cerrar() {
        Stage stage = (Stage) bntcancelarproducto.getScene().getWindow();
        stage.close();
    }
}
