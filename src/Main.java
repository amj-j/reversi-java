import model.ReversiModel;
import view.ReversiView;
import controller.ReversiController;

public class Main {
    public static void main(String[] args) {
        ReversiView theView = new ReversiView(8);
        
    	//ReversiModel theModel = new ReversiModel();
        
        //ReversiController theController = new ReversiController(theModel, theView);
        theView.setVisible(true);
    }

    
}