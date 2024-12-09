
# Reversi

A version of the game "Reversi" in the form of a desktop JAVA aplication. AWT and Swing libraries are used for graphical user interface.

## My motivation
This is my first object-ortiented programming project with graphical user interface. I coded this in January/February of 2023.

This project is based on an assignment originally given in the "Object-Oriented Programming" course at my university.
Although I had not yet taken the course at the time, I found the assignment on the course website and decided to complete it as a self-directed challenge.
My goal was to deepen my understanding of Java and object-oriented programming principles, as well as to prepare myself for the actual course.

I also completed three other assignments from the same course (from previous years) as part of this initiative. 
These projects can be found on my GitHub: [Monopoly lite](https://github.com/amj-j/monopoly-lite-java), [Duck hunt](https://github.com/amj-j/duck-hunt-java), and [Rook in maze](https://github.com/amj-j/rook-in-maze-java).

### Goal
The purpose of this assignment is to practide the foundational principles of GUI development, such as event-driven programming and component-based design, which are also used in modern frameworks, through the Java Swing library.

## Prerequisites
You need to have JDK 8 or higher installed on you computer to compile and run this app.

## Installation
1. Open your terminal and navigate to folder in which you wish to clone this repository.
2. Clone this repository using ```git clone https://github.com/amj-j/reversi.git```
3. In your terminal, navigate inside the new directory created by cloning the repository.
4. Execute this command to compile the source code: ```javac -d bin $(find src -name "*.java")``` (This command works on Linux, macOS, and Git Bash on Windows but not in Command Prompt or PowerShell. For Windows, use Git Bash terminal for compatibility, or list the source files manually.)
5. Execute this command to run the app: ```java -cp bin Main```
6. The app will run in a new window.

## Gameplay
### Rules
See [Original game](https://cardgames.io/reversi/) for rules.

### Features
- two players, black and white
- each player has a name (which can be changed)
- the number next to each players name is the number of players disks currently present on the board
- "New Game" button - discard the current game and load a new one
- "Settings" button - open settings window
- Settings window:
  - "Singleplayer" checkbox
    - if unchecked, the user plays for both players
    - if checked, user plays against the computer
    - in singleplayer mode, there is an algorithm for choosing the opponents moves, which places a new disk in a way, so that it captures the as many disks as possible in the current move
    - toggling this checkbox will restart the game
  - "Highlight moves" checkbox - determines, whether the game highlights the tiles on which the player can place a new disk in their current move
  - Player names - text input boxes to change names of players (to change a name, the "save button" next to the text field must be clicked)
  - Board Size - click the "Choose..." button to choose the new board size (this will restart the game)
  - "Toggle Colors" button - switches the colors of the players
  - "Reset Settings" - resets the settings to default values (this will restart the game)
  - "Close" button - closes the Settings window

### Flaws
Perfectioning the design of the buttons and components in the Settigns window turned out to be quite extensive, Swing/AWT-specific work, requiring knowledge of what Swing component display parameters are overridden by other parameters. The aim of this project, however, was to practice implementing the architecture of an app with GUI. Therefore, the design of the settings window buttons and components is unfinished. This does however not affect any functionality of the app.
 
### Controls
Click the mouse on a tile to place your disk on it. Other input is just pressing buttons and entering players names from keyboard.

## Architecture
This was the first time I tried to implement MVC pattern, to make the game logic indipendent of the AWT and Swing classes. The essential classes are ```ReversiModel.java```, ```ReversiView.java``` and ```ReversiController.java```. There is a single instance of each of these classes in the app. They are, however, not implemented with singleton pattern, to make the app extensible (e.g. presence of multiple game instances at once could be implemented later). ```ReversiView``` implements the ```ReversiModelListener``` interface and its instance is passed into the ```ReversiModel``` instance, so that the model can notify the view about its changes. ```ReversiController``` implements multiple listener interfaces, which serve for handling user input. This controller is passed as listener into the view. View notifies all its listeners (in this version of the app only the ```ReversiController``` instance really) when some kind of user input occurs. The controller holds references to the model and view instances. When the controller is notified about user input, it calls model methods on its saved model instance to update the model (which then updates the view), or it directly calls view methods on its saved view insance, if the necessary action doesn't involve the model (game logic). Instantiation of the main model, view and controller classes, along with linking them together is done in the main class (```Main.java``` file).

