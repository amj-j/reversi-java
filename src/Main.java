import model.Model;
import view.View;
import controller.Controller;

public class Main {
    public static void main(String[] args) {
        View theView = new View();
        
    	Model theModel = new Model();
        
        Controller theController = new Controller(theView, theModel);
        
        theView.setVisible(true);
    }

    
}