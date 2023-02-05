import model.ReversiModel;
import view.ReversiView;
import controller.ReversiController;

public class Main {
    public static void main(String[] args) {  
        ReversiModel theModel = new ReversiModel();
        ReversiView theView = new ReversiView(theModel.getBoardSize());
        ReversiController theController = new ReversiController(theModel, theView); 

        theModel.addListener(theView);
        theView.addTileClickedListener(theController);
        theView.addNewGameListener(theController);
        theView.addPlayerNameListener(theController);
        theView.addHighlightMovesListener(theController);
        theView.addSingleplayerListener(theController);
        theView.addBoardSizeListener(theController);
        theView.addResetSettingsListener(theController);


        theModel.newGame();
        theView.setVisible(true);    
    }
}