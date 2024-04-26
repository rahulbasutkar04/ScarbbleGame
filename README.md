## Controller

### PlayerController
- `createPlayer(id, name)`: Creates a player entity with the specified ID and name.

### GameController
- `startGame(playerId)`: Starts a game with the specified player entity.

## OuterService

### PlayerService
- `createPlayer(id, name)`: Service responsible for creating player entities.

### RackService
- `assignRackWithLettersTo(playerId)`: Service responsible for assigning a rack with letter tiles to a player entity.

### GameService
- `getScrabbleScore(word)`: Service responsible for calculating the score of a word in Scrabble. Checks if the word can be formed using letter tiles from the rack, removes the used letter tiles from the rack, and sends the word to the inner service for score calculation.

## Domain


#### Model

##### ScrabbleLetterPoints
- `getPointValue(char c)`: Model class responsible for providing the point value of a Scrabble letter.

## Inner Service

### ScrabbleCalculator
- `calculateForWord(String word)`: Service responsible for calculating the score of a word in Scrabble.
    - Extensions:
        - `double()`
        - `triple()`
- `calculateForLetter(char letter)`: Service responsible for calculating the score of a single letter in Scrabble.
    - Extensions:
        - `double()`
        - `triple()`



### Entities
- **Player**: Represents a player participating in the game.
- **Game**: Represents a game instance.

### Value Objects
- **ScrabbleLetterPoints**: Represents a letter tile with a character and point value.



## Assumption

- In the general Scrabble game, players can create words only using letter tiles present in their rack, with a limit of 7 letter tiles per rack. However, in this problem statement, there is no limit on the number of letter tiles in the rack, so users are not restricted to a limited number of letter tiles.
