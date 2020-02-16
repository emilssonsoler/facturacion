/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.fx;




import facturacionlb.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
/**
 * FXML Controller class
 *
 * @author Emilsson Soler
 */
public class FormProductoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Producto p = new Producto();
        p.setNm("hah");
        System.out.println(p.getNm());
        
    }    
    
}
