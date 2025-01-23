# JackPot Game


-> This project for midterm 


## Usage
## Note extract this project on drive D and make sureyou have netbeans
To use this project, follow the steps below:



1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/JackPot_Game.git
    cd JackPot_Game
    ```

2. **Build the project:**
    Ensure you have Java installed on your machine. Then, compile the project using:
    ```sh
    javac -d bin src/*.java
    ```

3. **Run the game:**
    Navigate to the `bin` directory and run the main class:
    ```sh
    cd bin
    java MainClassName
    ```

4. **Enjoy the game:**
    Follow the on-screen instructions to play the JackPot Game.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Git
- IDE Netbeans

### Installing NetBeans

1. **Download NetBeans:**
    - Visit the [NetBeans download page](https://netbeans.apache.org/download/index.html).
    - Choose the appropriate version for your operating system and download the installer.

2. **Install NetBeans:**
    - Run the downloaded installer.
    - Follow the on-screen instructions to complete the installation.

### Adding the Project to NetBeans

1. **Open NetBeans:**
    - Launch NetBeans IDE on your computer.

2. **Import the Project:**
    - Go to `File` > `Open Project`.
    - Navigate to the directory where you cloned the repository (`/d:/java_midterm_project/JackPot_Game`).
    - Select the `JackPot_Game` folder and click `Open Project`.

3. **Build and Run the Project:**
    - Once the project is loaded, right-click on the project in the `Projects` pane.
    - Select `Build` to compile the project.
    - After building, right-click on the project again and select `Run` to start the game.


## Contributing

Feel free to fork this project, make improvements, and submit pull requests. Contributions are welcome!

## License

This project is licensed under the Kungsamarch License.

## v1.0.0


1. **Game Setup:**
    - The game includes one dealer and multiple players (e.g., Player 1, Player 2, Player 3, Player 4, Player 5, etc.).
    - At the start of the game:
      - Each player is given 1,000 coins.
      - The dealer starts with 10,000 coins.

2. **Gameplay Mechanics:**
    - If a player's score is higher than the dealer's score, that player wins and earns 100 coins from the dealer.
    - If the dealer's score is higher than a player's score, the player loses 100 coins, and the dealer collects those coins from the player who scored lower than the dealer.
    - The dealer must pay 100 coins to a player who wins their score in the first round, which means after dealing 2 cards.

3. **Win/Loss Conditions:**
    - Dealer Losing the Round:
      - If multiple players win against the dealer, the dealer pays 100 coins to each winning player.
    - Dealer Winning the Round:
      - If the dealer wins or ties a player's score, the player forfeits 100 coins, and the dealer collects these coins.
      - If the dealer wins with a score lower than the player, the dealer will not get coins from the player.

4. **Result Calculation Example:**
    - Suppose the dealer scores 2 and the players have the following scores:
      - Player 1: 8 (Win) → Gains 100 coins.
      - Player 2: 5 → Gains 100 coins.
      - Player 3: 7 → Gains 100 coins.
      - Player 4: 9 (Win) → Gains 100 coins.
      - Player 5: 4 → Gains 100 coins.
    - The dealer loses 100 coins to each player (total loss: 500 coins).

5. **Game Example:**
    - Save the results after every round into a `jTable_game_store_info_coin_player_and_dealer`. The table should include the following columns:
      - Game Number: The current game round.
      - Dealer Coins: The dealer's remaining balance after the game.
      - Player Balances: The coin balances for each player after the game.
    - Example table after the first game:
      ```
      Game, Dealer, Player 1, Player 2, Player 3, Player 4, Player 5
      1,   9500,   1100,     1100,     1100,     1100,     1100
      ```
    - If the same players win again in the next game, the table might look like this:
      ```
      2,   9000,   1200,     1200,     1200,     1200,     1200
      ```

6. **Elimination and Rebalancing:**
    - A player who has zero coins is eliminated and cannot participate in the next game.
    - If the dealer's coins reach zero, automatically replenish the dealer's coins (e.g., reset to 10,000 coins).

7. **Game End Conditions:**
    - The game ends when:
      - The dealer or all players are eliminated.
      - A predefined number of rounds is reached.


