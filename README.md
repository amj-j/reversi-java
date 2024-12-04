
# Reversi

A version of the game "Reversi" in the form of a desktop JAVA aplication. AWT and Swing libraries are used for graphical output.

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
 
### Controls
Click the mouse on a tile to place your disk on it. Other input is just pressing buttons and entering players names from keyboard.

