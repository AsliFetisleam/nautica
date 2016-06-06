/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javafx.application.Application.launch;

/**
 *
 * @author aslif
 */
public class CustomTable extends Application{

    @FXML
    TableView TabelaAngajati;

    public TableView getTableView(){
        TableView<InstantaPersoana> table = new TableView<>(); 
        TabelaAngajati.setTableMenuButtonVisible(true);
     
        TableColumn<InstantaPersoana,String> albumArt = new TableColumn<>("Detalii");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200); 
        // SETTING THE CELL FACTORY FOR THE ALBUM ART                 
        albumArt.setCellFactory(new Callback<TableColumn<InstantaPersoana,String>,TableCell<InstantaPersoana,String>>(){        
            @Override
            public TableCell<InstantaPersoana, String> call(TableColumn<InstantaPersoana, String> param) {                
                TableCell<InstantaPersoana, String> cell = new TableCell<InstantaPersoana, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {                        
                        if(item!=null){                            
                            HBox box= new HBox();
                            box.setSpacing(10) ;
                            //image
                            ImageView imageview = new ImageView();
                            imageview.setFitHeight(50);
                            imageview.setFitWidth(50);
                            //imageview.setImage(new Image(CustomTable.class.getResource("img").toString()+"/"+item.getFilename())); 
                            //details
                            VBox vbox = new VBox();
                            vbox.getChildren().add(new Label("Details"));
                            vbox.getChildren().add(new Label(item)); 
                            //add edit button
                            Button editButton = new Button("Edit details");
                            editButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
                            //editButton.setId("Button");
                            box.getChildren().addAll(imageview,vbox,editButton); 
                            //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                            setGraphic(box);
                        }
                    }
                };
                //System.out.println(cell.getIndex());               
                return cell;
            }
            
        });        
        
        
        //ADDING ALL THE COLUMNS TO TABLEVIEW
        //table.getColumns().addAll(albumArt);        
        
        //ADDING ROWS INTO TABLEVIEW
       ObservableList<InstantaPersoana> musics = ControllerDatabase.getPersoane();
        for(int i = 0; i<10; i++){
            //Album al = new Album(i+1+".jpg",artists.get(i),artists.get(i)); 
            //Music m = new Music(artists.get(i),al,titles.get(i),i%5); 
            //musics.add(m); 
        }        
        table.setItems(musics); 
        
        return table;
    }
    
    
    /**
     * This function gives the fancy Background for the application
     * @return 
     */
   public Group getBackground(){
        Group group = new Group(); 
        group.setLayoutX(40); 
        group.setLayoutY(40); 
        
        Rectangle rect = new Rectangle();
        rect.setWidth(600); 
        rect.setHeight(460); 
        rect.setFill(Color.web("#f5f5f5"));
        //Some OuterGlow Effect
        rect.setEffect(DropShadowBuilder.create().                   
                color(Color.web("#969696")).
                offsetX(0).offsetY(0).radius(50).spread(0.2)
                .build());
        
        group.getChildren().add(rect); 
        
        return group;
    }

    @Override
    public void start(Stage stage) throws Exception {      
        
        //Main Group of the Application
        Group group = getBackground();
        //VBox for the Text and Table
        VBox box = new VBox();
        box.setLayoutX(20);
        box.setLayoutY(5);
        box.setSpacing(15); 
        
        //Text
        Text text = new Text("Music Library");
        text.setFont(new Font(20)); 
        
        //Table
        TableView table = getTableView();
        table.setLayoutX(20); table.setLayoutY(20); 
        
        //adding all components
        box.getChildren().addAll(text,table);                
        group.getChildren().add(box); 
        
        
        Scene scene = new Scene(group,680,530,Color.web("#666666"));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}


