# Reversi

_English version of the assignment can be found at the end of this document._

Vašou úlohou je naprogramovať hru Reversi ako oknovú aplikáciu v jazyku Java s pomocou knižníc AWT a Swing. Používateľské rozhranie aplikácie má pozostávať z:

* canvasu (alebo JPanel) - ktorý bude tvoriť hernú plochu
* bočné menu (jeho umiestnenie si zvoľte sami, teda môže byť aj hore, alebo dole)
## Pravidlá hry
### Základná pozícia a cieľ hry

Hra je známa aj pod názvom Othello. Hra bude začínať na hracej ploche veľkosti 6x6 polí, a bude možné jej veľkosť meniť (na obrázku je znázornená veľkosť 8x8).

![image](images/reversi.png)

Cieľom hry Reversi je mať na hracej ploche viac kameňov ako súper. Hra končí, ak sú všetky štvorce obsadené kameňmi alebo ak žiadny z hráčov nemôže urobiť platný ťah.

### Umiesťnovanie kameňov
Ak je hráč na ťahu, umiestni kameň svojej farby na hraciu plochu. Kamene nie je možné ukladať kdekoľvek - každým ťahom musíte zajať jeden alebo viac súperových kameňov, ktoré zmenia farbu a stávajú sa kameňmi aktuálneho hráča. Pokiaľ hráč nemôže v danej pozícii zajať žiaden súperov kameň, musí prenechať ťah súperovi.
Na začiatku hry sú 4 kamene umiestnené na hracej ploche, pričom dve sú bieleho a dve čierneho hráča (viď rozloženie na obrázku vyššie).

### Ako zajať súperove kamene
Hráč musí umiestniť kameň tak, aby obkľúčil svojimi dvoma kameňmi súvislý rad súperových kameňov, a to v ľubovoľnom smere (vodorovne, zvisle alebo uhlopriečne).
Všetky obkľúčené súperove kamene sú zajaté hráčom a zmenia farbu.

Pokiaľ žiaden hráč nevie zahrať platný ťah, hra končí.

Zdroj:

[BrainKing](https://brainking.com/sk/GameRules?tp=9)

[Hra samotná](https://cardgames.io/reversi/)
## Požiadavky
Hru hrá jeden hráč proti počítaču. Môžete sa rozhodnúť, ktorá farba patrí hráčovi a ktorá počítaču. Počítač môže hrať dvoma spôsobmi:

* Náhodný ťah z možných ťahov (Penalizácia 1 bod)
* Ťah, ktorým zajme súperovi najviac kameňov (Ak je takýchto ťahov viac môžete medzi nimi rozhodnúť ľubovoľným spôsobom)

Hra má byť hrateľná pomocou myši, keď myšou prejdem ponad pole na ktoré smieme umiesniť kameň, dané pole sa musí zvýrazniť. Všetky polia na ktoré vieme umiestniť kameň sú automaticky nejako vyznačené.
V menu sa má nachádzať:
* informácia o tom, ktorý hráč je na ťahu, poprípade keď hra skončí, ktorý hráč vyhral.
* tlačidlo, ktorým vieme hru zresetovať.
* informáca hovoriaca o aktuálnom rozmere hracieho plánu.
* komponent pomocou ktorého je možné zmeniť veľkosť hracej plochy (iba na hodnoty 6,8,10,12). Konkrétny komponent si môžete zvoliť sami, napríklad jeden z: Slider, JTextField, JComboBox

Stlačením klávesy R na klávesnici vieme tiež hru reštartovať, a pomocou klávesy ESC vypnúť.




# Reversi

Your task is to create a window Java application running the game Reversi using the AWT and Swing libraries. The user interface of the application must consist of:

* Canvas (or JPanel) - that will draw the game board
* side menu (you can choose the placement of this menu, it can also be on the top, or at the bottom of the window)

## Game rules
### Starting position and the win condition

The game is also known as Othello. The game starts with a board of 6x6 tiles, the size of the board can be changed by the user (the picture shows a board od size 8x8).

![image](images/reversi.png)

The goal of the game is to have more stones on the board than your opponent. The game ends if all tiles are occupied by stones, or if neither player can play a valid move.

### Placing the stones
The player places a stone of their color onto the board on their turn. The stone must be placed in such a way, that it captures at least one stone of their opponent. If a player cannot capture a stone with any available move, they pass their turn.
The game begins with 4 stones placed on the board, two stones belong to the white and two stones belong to the black player (see picture above).

### Capturing stones
The players must place stones in such a way, that they trap opposing stones in a continuous line between two stones of their own color in any direction (vertically, horizontally, or diagonally).
All the trapped stones are captured by the player and change color.

If neither player can make a capturing move the game ends.

Source:

[BrainKing](https://brainking.com/en/GameRules?tp=9)

[Online version of the game](https://cardgames.io/reversi/)
## Requirements
The game is played against a computer opponent. You can decide which color is played by the player and which by the computer. The computer can play in two ways:

* By playing a random valid move (Penalisation of 1 point)
* By playing the move that captures the most stones (If there are more such moves you can choose one in any way you want)

The game is played with the mouse. When a mouse hovers above a tile that is a valid move, this tile is highlighted. All the tiles that are valid moves are highlighted.

The menu must contain:
* information about the current player, or when the game ends, information about the winner.
* a button that resets the game
* information about the current dimensions of the board
* a component that is used to set the size of the game board (out of the valid values 6,8,10,12). You can choose what component to use for this, possible examples include: Slider, JTextField, JComboBox

By pressing the R key on the keyboard the game resets. By pressing the ESC key the game closes.
