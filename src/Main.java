import model.ReversiModel;
import view.ReversiView;
import controller.ReversiController;

public class Main {
    public static void main(String[] args) {
        ReversiView theView = new ReversiView();
        
    	ReversiModel theModel = new ReversiModel();
        
        ReversiController theController = new ReversiController(theView, theModel);
        
        theView.setVisible(true);
    }

    
}