/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.fx;




import facturacionlb.Producto;
import facturacionlb.ProductoServicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Emilsson Soler
 */
public class FormProductoController implements Initializable {
    @FXML
    private TableView tableviewproductos;
    
    @FXML
    private TableColumn<Producto,Integer> colidproducto;
    
    @FXML
    private TableColumn<Producto,String> colnombreproducto;
    
    @FXML
    private TableColumn<Producto,Double> colprecioproducto;
    
    @FXML
    private TableColumn<Producto,Integer> colexistenciaproducto;
    
    
    ObservableList<Producto> data;
    ProductoServicio servicio;

    /**
     * Initializes the controller class. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicio = new ProductoServicio();
        colidproducto.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnombreproducto.setCellValueFactory(new PropertyValueFactory("nombre") );
        colprecioproducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colexistenciaproducto.setCellValueFactory(new PropertyValueFactory<>("existencia"));
        cargardatos();
        
    }    
    
    public void  nuevoProducto() throws IOException{
        Producto producto=new Producto();
        abrirventanamodal(producto, "nuevo porducto");
    }

    private void abrirventanamodal(Producto producto,String titulo) throws IOException {
        FXMLLoader loader  = new FXMLLoader(getClass().getResource("NuevoEditarProducto.fxml"));
        Parent root =(Parent) loader.load();
        NuevoEditarProductoController controller = loader.getController();
        controller.setController(this);
        controller.setProducto(producto);
        Stage stage = new Stage();
        Scene scene  = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
         
        stage.setTitle(titulo);
        stage.show();
        
    }
    public void guardar(Producto producto){
        servicio.guardar(producto);
        cargardatos();
    }

    private void cargardatos() {
data= FXCollections.observableArrayList(servicio.getListaDeProducto());
        tableviewproductos.setItems(data);
        tableviewproductos.refresh();    
    }
     
}
