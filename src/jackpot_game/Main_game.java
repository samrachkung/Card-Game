/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jackpot_game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kung SamRach -> G_ST20
 */
public class Main_game extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private ImageIcon front_card;
    private List<ImageIcon> deck;
    private List<ImageIcon> player1Cards;
    private List<ImageIcon> player2Cards;
    private List<ImageIcon> player3Cards;
    private List<ImageIcon> player4Cards;
    private List<ImageIcon> player5Cards;
    private List<ImageIcon> dealerCards;
    private DefaultTableModel scoreTableModel;
    private boolean player1Stopped = false;
    private boolean player2Stopped = false;
    private boolean player3Stopped = false;
    private boolean player4Stopped = false;
    private boolean player5Stopped = false;
    private int dealerCoins = 10000;
    private int player1Coins = 1000;
    private int player2Coins = 1000;
    private int player3Coins = 1000;
    private int player4Coins = 1000;
    private int player5Coins = 1000;

    private class BackgroundPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private final Image backgroundImage;

        BackgroundPanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void initializeScoreTable() {
        scoreTableModel = new DefaultTableModel(
                new Object[] { "No. Game", "Dealer Coin", "Player 1 Coin", "Player 2 Coin", "Player 3 Coin", "Player 4 Coin", "Player 5 Coin" }, 0);
        jTable_game_store_info_coin_player_and_dealer.setModel(scoreTableModel);
    }

    /**
     * Creates new form Main_game
     */
    public Main_game() {
        setContentPane(new BackgroundPanel("D:/java_midterm_project/JackPot_Game/src/asset/19836745_6173954.jpg"));
        initComponents();
        loadImages();
        initDeck();
        initGame();
        initializeScoreTable();
        jButton_start_next_game.setEnabled(false);
        jButton_add_random_card_to_player_and_dealer.setEnabled(false);
        jButton_check_winner.setEnabled(false);
        scoreTableModel = (DefaultTableModel) jTable_game_store_info_coin_player_and_dealer.getModel();
    }

    private void loadImages() {
        front_card = scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/player-front-card.jpg", 85, 120,
                "front_card");
        // Load all card images into the deck

    }

    private void initDeck() {
        deck = new ArrayList<>();
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(A).png", 85, 120, "A♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(2).png", 85, 120, "2♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(3).png", 85, 120, "3♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(4).png", 85, 120, "4♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(5).png", 85, 120, "5♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(6).png", 85, 120, "6♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(7).png", 85, 120, "7♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(8).png", 85, 120, "8♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(9).png", 85, 120, "9♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(10).png", 85, 120, "10♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(J).png", 85, 120, "J♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(Q).png", 85, 120, "Q♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/diamond-card(K).png", 85, 120, "K♦"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(A).png", 85, 120, "A♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(2).png", 85, 120, "2♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(3).png", 85, 120, "3♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(4).png", 85, 120, "4♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(5).png", 85, 120, "5♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(6).png", 85, 120, "6♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(7).png", 85, 120, "7♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(8).png", 85, 120, "8♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(9).png", 85, 120, "9♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(10).png", 85, 120, "10♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(J).png", 85, 120, "J♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(Q).png", 85, 120, "Q♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/heart-card(K).png", 85, 120, "K♥"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(A).png", 85, 120, "A♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(2).png", 85, 120, "2♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(3).png", 85, 120, "3♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(4).png", 85, 120, "4♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(5).png", 85, 120, "5♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(6).png", 85, 120, "6♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(7).png", 85, 120, "7♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(8).png", 85, 120, "8♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(9).png", 85, 120, "9♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(10).png", 85, 120, "10♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(J).png", 85, 120, "J♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(Q).png", 85, 120, "Q♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/spade-card(K).png", 85, 120, "K♠"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(A).png", 85, 120, "A♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(2).png", 85, 120, "2♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(3).png", 85, 120, "3♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(4).png", 85, 120, "4♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(5).png", 85, 120, "5♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(6).png", 85, 120, "6♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(7).png", 85, 120, "7♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(8).png", 85, 120, "8♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(9).png", 85, 120, "9♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(10).png", 85, 120, "10♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(J).png", 85, 120, "J♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(Q).png", 85, 120, "Q♣"));
        deck.add(scaleImageIcon("D:/java_midterm_project/JackPot_Game/src/asset/club-card(K).png", 85, 120, "K♣"));

        Collections.shuffle(deck);
    }

    private void initGame() {
        player1Cards = new ArrayList<>();
        player2Cards = new ArrayList<>();
        player3Cards = new ArrayList<>();
        player4Cards = new ArrayList<>();
        player5Cards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    private ImageIcon scaleImageIcon(String path, int width, int height, String description) {
        try {
            ImageIcon icon = new ImageIcon(
                    new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            icon.setDescription(description);
            return icon;
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            return null;
        }
    }

    private void dealCard(List<ImageIcon> hand) {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0));
        }
    }

    private void showCards(List<ImageIcon> cards, JLabel cardLabel1, JLabel cardLabel2, JLabel cardLabel3) {
        if (cards.size() > 0) {
            cardLabel1.setIcon(cards.get(0));
        } else {
            cardLabel1.setIcon(front_card);
        }

        if (cards.size() > 1) {
            cardLabel2.setIcon(cards.get(1));
        } else {
            cardLabel2.setIcon(front_card);
        }

        if (cards.size() > 2) {
            cardLabel3.setIcon(cards.get(2));
        } else {
            cardLabel3.setIcon(front_card);
        }
    }

    private int calculateScore(List<ImageIcon> hand) {
        int score = 0;
        for (ImageIcon card : hand) {
            String description = card.getDescription();
            if (description != null) {
                if (description.contains("A")) {
                    score += 1;
                } else if (description.contains("2")) {
                    score += 2;
                } else if (description.contains("3")) {
                    score += 3;
                } else if (description.contains("4")) {
                    score += 4;
                } else if (description.contains("5")) {
                    score += 5;
                } else if (description.contains("6")) {
                    score += 6;
                } else if (description.contains("7")) {
                    score += 7;
                } else if (description.contains("8")) {
                    score += 8;
                } else if (description.contains("9")) {
                    score += 9;
                } else if (description.contains("10")) {
                    score += 0;
                } else if (description.contains("J")) {
                    score += 10;
                } else if (description.contains("Q")) {
                    score += 10;
                } else if (description.contains("K")) {
                    score += 10;
                }
            }
        }
        return score;
    }

    private List<String> determineWinnersWithoutCoins() {
        int dealerScore = adjustScore(calculateScore(dealerCards));
        boolean dealerSpecialCondition = hasSpecialCondition(dealerScore, dealerCards.size());

        List<String> winners = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            boolean isPlayerStopped = false;
            switch (i) {
                case 1:
                    isPlayerStopped = player1Stopped;
                    break;
                case 2:
                    isPlayerStopped = player2Stopped;
                    break;
                case 3:
                    isPlayerStopped = player3Stopped;
                    break;
                case 4:
                    isPlayerStopped = player4Stopped;
                    break;
                case 5:
                    isPlayerStopped = player5Stopped;
                    break;
            }

            if (isPlayerStopped) {
                // Skip this player
                continue;
            }

            List<ImageIcon> playerCards = getPlayerCards(i);
            int playerScore = adjustScore(calculateScore(playerCards));
            boolean playerSpecialCondition = hasSpecialCondition(playerScore, playerCards.size());

            if (playerSpecialCondition && !dealerSpecialCondition) {
                winners.add("Player " + i + " wins with score: " + playerScore);
            } else if (playerScore > dealerScore) {
                winners.add("Player " + i + " wins with score: " + playerScore);
            }
        }

        return winners;
    }

    private List<String> checkWinner() {
        int dealerScore = adjustScore(calculateScore(dealerCards));
        boolean dealerSpecialCondition = hasSpecialCondition(dealerScore, dealerCards.size());

        List<String> winners = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            List<ImageIcon> playerCards = getPlayerCards(i);
            int playerScore = adjustScore(calculateScore(playerCards));
            boolean playerSpecialCondition = hasSpecialCondition(playerScore, playerCards.size());

            if (playerSpecialCondition && !dealerSpecialCondition) {
                winners.add("Player " + i + " wins with score: " + playerScore);
                adjustCoins(i, 100);
            } else if (!playerSpecialCondition && dealerSpecialCondition) {
                adjustCoins(i, -100);
            } else if (playerScore > dealerScore) {
                winners.add("Player " + i + " wins with score: " + playerScore);
                adjustCoins(i, 100);
            } else if (playerScore < dealerScore) {
                adjustCoins(i, -100);
            }
            // Draw case: No action required
        }

        if (winners.isEmpty() && dealerCards.size() == 3) {
            for (int i = 1; i <= 5; i++) {
                List<ImageIcon> playerCards = getPlayerCards(i);
                int playerScore = adjustScore(calculateScore(playerCards));

                if (playerCards.size() == 3) {
                    if (playerScore > dealerScore) {
                        winners.add("Player " + i + " wins with score: " + playerScore);
                        adjustCoins(i, 100);
                    } else if (playerScore < dealerScore) {
                        adjustCoins(i, -100);
                    }
                }
            }
        }
        // If no winners, declare the dealer as the winner
        if (winners.isEmpty()) {
            winners.add("Dealer wins with score: " + dealerScore);
        }

        endFirstGame(); // Enable the next game button
        return winners;
    }

    // Adjust score based on specific game rules
    private int adjustScore(int score) {
        switch (score) {
            case 10, 20 -> {
                return 0;
            }
            case 19, 29 -> {
                return 9;
            }
            case 18, 28 -> {
                return 8;
            }
            case 11, 21 -> {
                return 1;
            }
            case 12, 22 -> {
                return 2;
            }
            case 13, 23 -> {
                return 3;
            }
            case 14, 24 -> {
                return 4;
            }
            case 15, 25 -> {
                return 5;
            }
            case 16, 26 -> {
                return 6;
            }
            case 17, 27 -> {
                return 7;
            }
            default -> {
                return score;
            }
        }
    }

    // Determine if a hand has special conditions
    private boolean hasSpecialCondition(int score, int cardCount) {
        return (cardCount == 2 || cardCount == 3) &&
                (score == 8 || score == 9 || score == 30 ||
                        (score >= 18 && score <= 19) ||
                        (score >= 28 && score <= 29));
    }

    // Adjust player and dealer coins
    private void adjustCoins(int playerNumber, int amount) {
        switch (playerNumber) {
            case 1:
                if (!player1Stopped) {
                    player1Coins += amount;
                    dealerCoins -= amount;
                }
                break;
            case 2:
                if (!player2Stopped) {
                    player2Coins += amount;
                    dealerCoins -= amount;
                }
                break;
            case 3:
                if (!player3Stopped) {
                    player3Coins += amount;
                    dealerCoins -= amount;
                }
                break;
            case 4:
                if (!player4Stopped) {
                    player4Coins += amount;
                    dealerCoins -= amount;
                }
                break;
            case 5:
                if (!player5Stopped) {
                    player5Coins += amount;
                    dealerCoins -= amount;
                }
                break;
        }
    }

    // Button event handler
    private void jButton_check_winnerActionPerformed(java.awt.event.ActionEvent evt) {
        List<String> winners = determineWinnersWithoutCoins(); // Fetch winners without adjusting coins
        if (!winners.isEmpty()) {
            StringBuilder winnerMessage = new StringBuilder("Results:\n");
            for (String winner : winners) {
                winnerMessage.append(winner).append("\n");
            }
            JOptionPane.showMessageDialog(this, winnerMessage.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No winners.");
        }
    }

    private List<ImageIcon> getPlayerCards(int playerNumber) {
        switch (playerNumber) {
            case 1:
                return player1Cards;
            case 2:
                return player2Cards;
            case 3:
                return player3Cards;
            case 4:
                return player4Cards;
            case 5:
                return player5Cards;
            default:
                return null;
        }
    }

    private void resetGame() {

        player1Stopped = false;
        player2Stopped = false;
        player3Stopped = false;
        player4Stopped = false;
        player5Stopped = false;

        player1Cards.clear();
        player2Cards.clear();
        player3Cards.clear();
        player4Cards.clear();
        player5Cards.clear();
        dealerCards.clear();

        // Reset the UI components to their initial state
        jLabel_player1_card_1.setIcon(null);
        jLabel_player1_card_2.setIcon(null);
        jLabel_player1_add_more_card.setIcon(null);
        jLabel_player2_card_2.setIcon(null);
        jLabel_player2_card_1.setIcon(null);
        jLabel_player2_add_more_card.setIcon(null);
        jLabel_player3_card_1.setIcon(null);
        jLabel_player3_card_2.setIcon(null);
        jLabel_player3_add_more_card.setIcon(null);
        jLabel_player4_card_1.setIcon(null);
        jLabel_player4_card_2.setIcon(null);
        jLabel_player4_add_more_card.setIcon(null);
        jLabel_player5_card_1.setIcon(null);
        jLabel_player5_card_2.setIcon(null);
        jLabel_player5_add_more_card.setIcon(null);
        jLabel_dealer_card_1.setIcon(null);
        jLabel_dealer_card_2.setIcon(null);
        jLabel_dealer_add_more_card.setIcon(null);
        jLabel_player1_card_1.setIcon(front_card);
        jLabel_player1_card_2.setIcon(front_card);
        jLabel_player1_add_more_card.setIcon(front_card);
        jLabel_player2_card_2.setIcon(front_card);
        jLabel_player2_card_1.setIcon(front_card);
        jLabel_player2_add_more_card.setIcon(front_card);
        jLabel_player3_card_1.setIcon(front_card);
        jLabel_player3_card_2.setIcon(front_card);
        jLabel_player3_add_more_card.setIcon(front_card);
        jLabel_player4_card_1.setIcon(front_card);
        jLabel_player4_card_2.setIcon(front_card);
        jLabel_player4_add_more_card.setIcon(front_card);
        jLabel_player5_card_1.setIcon(front_card);
        jLabel_player5_card_2.setIcon(front_card);
        jLabel_player5_add_more_card.setIcon(front_card);
        jLabel_dealer_card_1.setIcon(front_card);
        jLabel_dealer_card_2.setIcon(front_card);
        jLabel_dealer_add_more_card.setIcon(front_card);
        initDeck();
    }

    private void SaveGameInfoCoinToTable() {
        Object[] rowData = new Object[7];
        rowData[0] = scoreTableModel.getRowCount() + 1; // Game round number
        rowData[1] = dealerCoins;
        rowData[2] = player1Coins;
        rowData[3] = player2Coins;
        rowData[4] = player3Coins;
        rowData[5] = player4Coins;
        rowData[6] = player5Coins;
        scoreTableModel.addRow(rowData);

        // Print dealer and players' coins to the console
        System.out.println("Dealer Coins: " + dealerCoins);
        System.out.println("Player 1 Coins: " + player1Coins);
        System.out.println("Player 2 Coins: " + player2Coins);
        System.out.println("Player 3 Coins: " + player3Coins);
        System.out.println("Player 4 Coins: " + player4Coins);
        System.out.println("Player 5 Coins: " + player5Coins);
    }

    private void handleAddMoreCard(List<ImageIcon> cards, String name) {
        int dealerScore = calculateScore(dealerCards);
        if ((dealerScore == 8 || dealerScore == 9 || dealerScore == 18 || dealerScore == 19 || dealerScore == 28
                || dealerScore == 29 || dealerScore == 30) && (dealerCards.size() == 2 || dealerCards.size() == 3)) {
            JOptionPane.showMessageDialog(this,
                    "Dealer has already won with a score of " + dealerScore + ". No more cards can be added.");
            return;
        }

        int score = calculateScore(cards);
        if (cards.isEmpty()) {
            JOptionPane.showMessageDialog(this, name + " cannot add more cards with an empty hand.");
            return;
        }
        if (cards.size() == 1) {
            JOptionPane.showMessageDialog(this, name + " cannot add more cards with only one card.");
            return;
        }
        if ((score == 8 || score == 9 || score == 18 || score == 19 || score == 28 || score == 29 || score == 30)
                && (cards.size() == 2 || cards.size() == 3)) {
            JOptionPane.showMessageDialog(this,
                    name + " has already won with a score of " + score + ". No more cards can be added.");
            return;
        }
        if (score == 6 || score == 7 || score == 16 || score == 17 || score == 26 || score == 27) {
            int response = JOptionPane.showConfirmDialog(this,
                    name + " has a score of " + score + ". Do you want to add more cards?", "Add More Cards",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                dealCard(cards);
            }
        } else {
            dealCard(cards);
        }
    }

    private void startNewGame() {
        resetGame();
        Collections.shuffle(deck); // Shuffle the existing deck for a new game
    }

    private void jButton_start_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_start_gameActionPerformed
        startNewGame();
        jButton_start_next_game.setEnabled(true);
        jButton_add_random_card_to_player_and_dealer.setEnabled(true);

        // Disable the next game button when starting a new game
    }// GEN-LAST:event_jButton_start_gameActionPerformed

    private void jButton_start_next_gameActionPerformed(java.awt.event.ActionEvent evt) {

        List<String> results = checkWinner(); // Adjust coins and determine winners

        if (!results.isEmpty()) {
            StringBuilder winnerMessage = new StringBuilder("Winners of this round:\n");
            for (String result : results) {
                winnerMessage.append(result).append("\n");
            }
            JOptionPane.showMessageDialog(this, winnerMessage.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No winners this round.");
        }

        SaveGameInfoCoinToTable();

        // Check if any player has 0 coins and disable their play for the next game
        if (player1Coins <= 0) {
            player1Stopped = true;
            JOptionPane.showMessageDialog(this, "Player 1 has 0 coins and cannot play the next game.");
        }
        if (player2Coins <= 0) {
            player2Stopped = true;
            JOptionPane.showMessageDialog(this, "Player 2 has 0 coins and cannot play the next game.");
        }
        if (player3Coins <= 0) {
            player3Stopped = true;
            JOptionPane.showMessageDialog(this, "Player 3 has 0 coins and cannot play the next game.");
        }
        if (player4Coins <= 0) {
            player4Stopped = true;
            JOptionPane.showMessageDialog(this, "Player 4 has 0 coins and cannot play the next game.");
        }
        if (player5Coins <= 0) {
            player5Stopped = true;
            JOptionPane.showMessageDialog(this, "Player 5 has 0 coins and cannot play the next game.");
        }

        startNewGame();
    }

    // GEN-LAST:event_jButton_start_next_gameActionPerformed

    private void endFirstGame() {

        jButton_start_game.setEnabled(false);
        // Enable the next game button after the first game ends
    }

    private void jButton_add_random_card_to_player_and_dealerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_add_random_card_to_player_and_dealerActionPerformed
        boolean cardDealt = false;

        if (!player1Stopped && player1Cards.size() < 2) {
            dealCard(player1Cards);
            cardDealt = true;

        }
        if (!player2Stopped && player2Cards.size() < 2) {
            dealCard(player2Cards);
            cardDealt = true;

        }
        if (!player3Stopped && player3Cards.size() < 2) {
            dealCard(player3Cards);
            cardDealt = true;

        }
        if (!player4Stopped && player4Cards.size() < 2) {
            dealCard(player4Cards);
            cardDealt = true;

        }
        if (!player5Stopped && player5Cards.size() < 2) {
            dealCard(player5Cards);
            cardDealt = true;

        }
        if (dealerCards.size() < 2) {
            dealCard(dealerCards);
            cardDealt = true;

            jButton_check_winner.setEnabled(false);

        }
        if (dealerCards.size() > 1) {

            jButton_check_winner.setEnabled(true);

        }

        if (!cardDealt) {
            JOptionPane.showMessageDialog(this, "You can deal only 2 cards per player or dealer.");
        }

        showCards(player1Cards, jLabel_player1_card_1, jLabel_player1_card_2, jLabel_player1_add_more_card);
        showCards(player2Cards, jLabel_player2_card_2, jLabel_player2_card_1, jLabel_player2_add_more_card);
        showCards(player3Cards, jLabel_player3_card_1, jLabel_player3_card_2, jLabel_player3_add_more_card);
        showCards(player4Cards, jLabel_player4_card_1, jLabel_player4_card_2, jLabel_player4_add_more_card);
        showCards(player5Cards, jLabel_player5_card_1, jLabel_player5_card_2, jLabel_player5_add_more_card);
        showCards(dealerCards, jLabel_dealer_card_1, jLabel_dealer_card_2, jLabel_dealer_add_more_card);

    }// GEN-LAST:event_jButton_add_random_card_to_player_and_dealerActionPerformed

    private void jButton_for_player5_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player5_add_1_more_cardActionPerformed
        handleAddMoreCard(player5Cards, "Player 5");

        showCards(player5Cards, jLabel_player5_card_1, jLabel_player5_card_2, jLabel_player5_add_more_card);

    }// GEN-LAST:event_jButton_for_player5_add_1_more_cardActionPerformed

    private void jButton_for_player1_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player1_add_1_more_cardActionPerformed
        handleAddMoreCard(player1Cards, "Player 1");

        showCards(player1Cards, jLabel_player1_card_1, jLabel_player1_card_2, jLabel_player1_add_more_card);

    }// GEN-LAST:event_jButton_for_player1_add_1_more_cardActionPerformed

    private void jButton_for_player2_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player2_add_1_more_cardActionPerformed
        handleAddMoreCard(player2Cards, "Player 2");

        showCards(player2Cards, jLabel_player2_card_2, jLabel_player2_card_1, jLabel_player2_add_more_card);

    }// GEN-LAST:event_jButton_for_player2_add_1_more_cardActionPerformed

    private void jButton_for_player3_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player3_add_1_more_cardActionPerformed
        handleAddMoreCard(player3Cards, "Player 3");
        showCards(player3Cards, jLabel_player3_card_1, jLabel_player3_card_2, jLabel_player3_add_more_card);
    }// GEN-LAST:event_jButton_for_player3_add_1_more_cardActionPerformed

    private void jButton_for_player4_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player4_add_1_more_cardActionPerformed
        handleAddMoreCard(player4Cards, "Player 4");
        showCards(player4Cards, jLabel_player4_card_1, jLabel_player4_card_2, jLabel_player4_add_more_card);
    }// GEN-LAST:event_jButton_for_player4_add_1_more_cardActionPerformed

    private void jButton_for_player5_stop_player_this_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player5_stop_player_this_gameActionPerformed
        player5Stopped = true;
        handlePlayerStop(5);
    }// GEN-LAST:event_jButton_for_player5_stop_player_this_gameActionPerformed

    private void jButton_for_player4_stop_player_this_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player4_stop_player_this_gameActionPerformed
        player4Stopped = true;
        handlePlayerStop(4);
    }// GEN-LAST:event_jButton_for_player4_stop_player_this_gameActionPerformed

    private void jButton_for_player3_stop_player_this_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player3_stop_player_this_gameActionPerformed
        player3Stopped = true;
        handlePlayerStop(3);
    }// GEN-LAST:event_jButton_for_player3_stop_player_this_gameActionPerformed

    private void jButton_for_player2_stop_player_this_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player2_stop_player_this_gameActionPerformed
        player2Stopped = true;
        handlePlayerStop(2);
    }// GEN-LAST:event_jButton_for_player2_stop_player_this_gameActionPerformed

    private void jButton_for_player1_stop_player_this_gameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_player1_stop_player_this_gameActionPerformed
        player1Stopped = true;
        handlePlayerStop(1);
    }// GEN-LAST:event_jButton_for_player1_stop_player_this_gameActionPerformed

    private void handlePlayerStop(int playerNumber) {
        // Logic to handle player stop, e.g., update UI, log message, etc.
        System.out.println("Player " + playerNumber + " has stopped playing.");
        JOptionPane.showMessageDialog(null, "Player " + playerNumber + " has stopped playing.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_game_store_info_coin_player_and_dealer = new javax.swing.JTable();
        jButton_start_game = new javax.swing.JButton();
        Jlabel_welcome = new javax.swing.JLabel();
        Jlabel_store_table_coin = new javax.swing.JLabel();
        jButton_for_dealer_add_1_more_card = new javax.swing.JButton();
        jLabel_dealer_card_1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_dealer_add_more_card = new javax.swing.JLabel();
        jLabel_dealer_card_2 = new javax.swing.JLabel();
        jLabel_player1_card_1 = new javax.swing.JLabel();
        jLabel_player1_card_2 = new javax.swing.JLabel();
        jLabel_player1_add_more_card = new javax.swing.JLabel();
        jButton_for_player1_stop_player_this_game = new javax.swing.JButton();
        jLabel_player1 = new javax.swing.JLabel();
        jButton_for_player1_add_1_more_card = new javax.swing.JButton();
        jButton_for_player5_stop_player_this_game = new javax.swing.JButton();
        jButton_for_player5_add_1_more_card = new javax.swing.JButton();
        jLabel_player5 = new javax.swing.JLabel();
        jLabel_player5_card_1 = new javax.swing.JLabel();
        jLabel_player5_card_2 = new javax.swing.JLabel();
        jLabel_player5_add_more_card = new javax.swing.JLabel();
        jButton_start_next_game = new javax.swing.JButton();
        jButton_check_winner = new javax.swing.JButton();
        jButton_add_random_card_to_player_and_dealer = new javax.swing.JButton();
        jLabel_player2 = new javax.swing.JLabel();
        jLabel_player2_add_more_card = new javax.swing.JLabel();
        jButton_for_player2_add_1_more_card = new javax.swing.JButton();
        jButton_for_player2_stop_player_this_game = new javax.swing.JButton();
        jLabel_player3_add_more_card = new javax.swing.JLabel();
        jLabel_player3 = new javax.swing.JLabel();
        jButton_for_player3_stop_player_this_game = new javax.swing.JButton();
        jButton_for_player3_add_1_more_card = new javax.swing.JButton();
        jLabel_player4_add_more_card = new javax.swing.JLabel();
        jLabel_player4 = new javax.swing.JLabel();
        jButton_for_player4_stop_player_this_game = new javax.swing.JButton();
        jButton_for_player4_add_1_more_card = new javax.swing.JButton();
        jLabel_player2_card_2 = new javax.swing.JLabel();
        jLabel_player2_card_1 = new javax.swing.JLabel();
        jLabel_player3_card_2 = new javax.swing.JLabel();
        jLabel_player3_card_1 = new javax.swing.JLabel();
        jLabel_player4_card_2 = new javax.swing.JLabel();
        jLabel_player4_card_1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jlabel_store_table_coin1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_game_store_info_coin_player_and_dealer.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 51)));
        jTable_game_store_info_coin_player_and_dealer.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jTable_game_store_info_coin_player_and_dealer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable_game_store_info_coin_player_and_dealer);

        jButton_start_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_start_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_start_game.setForeground(new java.awt.Color(102, 255, 102));
        jButton_start_game.setText("START GAME");
        jButton_start_game.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_start_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_start_gameActionPerformed(evt);
            }
        });

        Jlabel_welcome.setBackground(new java.awt.Color(255, 255, 255));
        Jlabel_welcome.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        Jlabel_welcome.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel_welcome.setText("WELCOME TO JAKPOK GAME");

        Jlabel_store_table_coin.setBackground(new java.awt.Color(255, 255, 255));
        Jlabel_store_table_coin.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        Jlabel_store_table_coin.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel_store_table_coin.setText("GAME COIN");

        jButton_for_dealer_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_dealer_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_dealer_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_dealer_add_1_more_card.setText("ADD MORE DEALER CARD");
        jButton_for_dealer_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_dealer_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_dealer_add_1_more_cardActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DEALER");

        jButton_for_player1_stop_player_this_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player1_stop_player_this_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player1_stop_player_this_game.setForeground(new java.awt.Color(255, 0, 0));
        jButton_for_player1_stop_player_this_game.setText("STOP PLAY");
        jButton_for_player1_stop_player_this_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player1_stop_player_this_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player1_stop_player_this_gameActionPerformed(evt);
            }
        });

        jLabel_player1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_player1.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel_player1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_player1.setText("PLAYER 1");

        jButton_for_player1_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player1_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player1_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_player1_add_1_more_card.setText("ADD MORE CARD");
        jButton_for_player1_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player1_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player1_add_1_more_cardActionPerformed(evt);
            }
        });

        jButton_for_player5_stop_player_this_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player5_stop_player_this_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player5_stop_player_this_game.setForeground(new java.awt.Color(255, 0, 0));
        jButton_for_player5_stop_player_this_game.setText("STOP PLAY");
        jButton_for_player5_stop_player_this_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player5_stop_player_this_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player5_stop_player_this_gameActionPerformed(evt);
            }
        });

        jButton_for_player5_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player5_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player5_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_player5_add_1_more_card.setText("ADD MORE CARD");
        jButton_for_player5_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player5_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player5_add_1_more_cardActionPerformed(evt);
            }
        });

        jLabel_player5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_player5.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel_player5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_player5.setText("PLAYER 5");

        jButton_start_next_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_start_next_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_start_next_game.setForeground(new java.awt.Color(51, 255, 102));
        jButton_start_next_game.setText("START NEW GAME");
        jButton_start_next_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_start_next_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_start_next_gameActionPerformed(evt);
            }
        });

        jButton_check_winner.setBackground(new java.awt.Color(0, 0, 0));
        jButton_check_winner.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_check_winner.setForeground(new java.awt.Color(255, 255, 0));
        jButton_check_winner.setText("CHECK WINNER");
        jButton_check_winner.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_check_winner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_check_winnerActionPerformed(evt);
            }
        });

        jButton_add_random_card_to_player_and_dealer.setBackground(new java.awt.Color(0, 0, 0));
        jButton_add_random_card_to_player_and_dealer.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_add_random_card_to_player_and_dealer.setForeground(new java.awt.Color(51, 255, 51));
        jButton_add_random_card_to_player_and_dealer.setText("DEAL CARD TO PLAYER");
        jButton_add_random_card_to_player_and_dealer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_add_random_card_to_player_and_dealer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_random_card_to_player_and_dealerActionPerformed(evt);
            }
        });

        jLabel_player2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_player2.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel_player2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_player2.setText("PLAYER 2");

        jButton_for_player2_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player2_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player2_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_player2_add_1_more_card.setText("ADD MORE CARD");
        jButton_for_player2_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player2_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player2_add_1_more_cardActionPerformed(evt);
            }
        });

        jButton_for_player2_stop_player_this_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player2_stop_player_this_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player2_stop_player_this_game.setForeground(new java.awt.Color(255, 0, 0));
        jButton_for_player2_stop_player_this_game.setText("STOP PLAY");
        jButton_for_player2_stop_player_this_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player2_stop_player_this_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player2_stop_player_this_gameActionPerformed(evt);
            }
        });

        jLabel_player3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_player3.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel_player3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_player3.setText("PLAYER 3");

        jButton_for_player3_stop_player_this_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player3_stop_player_this_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player3_stop_player_this_game.setForeground(new java.awt.Color(255, 0, 0));
        jButton_for_player3_stop_player_this_game.setText("STOP PLAY");
        jButton_for_player3_stop_player_this_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player3_stop_player_this_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player3_stop_player_this_gameActionPerformed(evt);
            }
        });

        jButton_for_player3_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player3_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player3_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_player3_add_1_more_card.setText("ADD MORE CARD");
        jButton_for_player3_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player3_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player3_add_1_more_cardActionPerformed(evt);
            }
        });

        jLabel_player4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_player4.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel_player4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_player4.setText("PLAYER 4");

        jButton_for_player4_stop_player_this_game.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player4_stop_player_this_game.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player4_stop_player_this_game.setForeground(new java.awt.Color(255, 0, 0));
        jButton_for_player4_stop_player_this_game.setText("STOP PLAY");
        jButton_for_player4_stop_player_this_game.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player4_stop_player_this_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player4_stop_player_this_gameActionPerformed(evt);
            }
        });

        jButton_for_player4_add_1_more_card.setBackground(new java.awt.Color(0, 0, 0));
        jButton_for_player4_add_1_more_card.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jButton_for_player4_add_1_more_card.setForeground(new java.awt.Color(255, 102, 0));
        jButton_for_player4_add_1_more_card.setText("ADD MORE CARD");
        jButton_for_player4_add_1_more_card.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_for_player4_add_1_more_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_for_player4_add_1_more_cardActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Each player is given 1,000 coins.");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("The dealer starts with 10,000 coins");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Each player Need to bet 100 coins.");

        Jlabel_store_table_coin1.setBackground(new java.awt.Color(255, 255, 255));
        Jlabel_store_table_coin1.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        Jlabel_store_table_coin1.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel_store_table_coin1.setText("GAME SETUP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel_dealer_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_dealer_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_dealer_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(235, 235, 235))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(564, 564, 564)
                                        .addComponent(jLabel_player2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jButton_for_player2_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(42, 42, 42)
                                            .addComponent(jButton_for_player2_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(165, 165, 165)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jButton_for_player1_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton_for_player1_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel_player1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel_player1_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel_player1_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel_player1_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(31, 31, 31)
                                            .addComponent(jLabel_player2_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel_player2_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel_player2_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_player3_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_player3_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_player3_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel_player5_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_player5_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_player5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_player5_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_player3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton_for_player3_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_for_player3_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_for_player5_add_1_more_card, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jButton_for_player5_stop_player_this_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jButton_for_player4_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_for_player4_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel_player4_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_player4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_player4_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel_player4_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Jlabel_welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_add_random_card_to_player_and_dealer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_check_winner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_start_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_start_next_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_for_dealer_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(Jlabel_store_table_coin1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(732, 732, 732)
                                .addComponent(Jlabel_store_table_coin, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jlabel_store_table_coin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_start_game, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_start_next_game, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_add_random_card_to_player_and_dealer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_check_winner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel_player5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_player5_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_player5_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_player5_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButton_for_player5_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_for_player5_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_dealer_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_dealer_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_dealer_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Jlabel_store_table_coin1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(jButton_for_dealer_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_player2_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_player1_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_player1_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_player1_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel_player1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_for_player1_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton_for_player1_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_player4_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_player4_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_player4_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_player4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_for_player4_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton_for_player4_stop_player_this_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_player3_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_player3_card_2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_player3_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_player3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_player2_add_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_player2_card_1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_player2)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_for_player2_add_1_more_card, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_for_player2_stop_player_this_game, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_for_player3_stop_player_this_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_for_player3_add_1_more_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(170, 170, 170))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_for_dealer_add_1_more_cardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_for_dealer_add_1_more_cardActionPerformed
        if (dealerCards.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dealer cannot add more cards with an empty hand.");
            return;
        }
        if (dealerCards.size() == 1) {
            JOptionPane.showMessageDialog(this, "Dealer cannot add more cards with only one card.");
            return;
        }
        int dealerScore = calculateScore(dealerCards);
        if (dealerScore == 6 || dealerScore == 7 || dealerScore == 16 || dealerScore == 17 || dealerScore == 26
                || dealerScore == 27) {
            int response = JOptionPane.showConfirmDialog(this,
                    "Dealer has a score of " + dealerScore + ". Do you want to add more cards?", "Add More Cards",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                dealCard(dealerCards);
            }
        } else {
            handleAddMoreCard(dealerCards, "Dealer");

        }
        showCards(dealerCards, jLabel_dealer_card_1, jLabel_dealer_card_2, jLabel_dealer_add_more_card);

    }// GEN-LAST:event_jButton_for_dealer_add_1_more_cardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_store_table_coin;
    private javax.swing.JLabel Jlabel_store_table_coin1;
    private javax.swing.JLabel Jlabel_welcome;
    private javax.swing.JButton jButton_add_random_card_to_player_and_dealer;
    private javax.swing.JButton jButton_check_winner;
    private javax.swing.JButton jButton_for_dealer_add_1_more_card;
    private javax.swing.JButton jButton_for_player1_add_1_more_card;
    private javax.swing.JButton jButton_for_player1_stop_player_this_game;
    private javax.swing.JButton jButton_for_player2_add_1_more_card;
    private javax.swing.JButton jButton_for_player2_stop_player_this_game;
    private javax.swing.JButton jButton_for_player3_add_1_more_card;
    private javax.swing.JButton jButton_for_player3_stop_player_this_game;
    private javax.swing.JButton jButton_for_player4_add_1_more_card;
    private javax.swing.JButton jButton_for_player4_stop_player_this_game;
    private javax.swing.JButton jButton_for_player5_add_1_more_card;
    private javax.swing.JButton jButton_for_player5_stop_player_this_game;
    private javax.swing.JButton jButton_start_game;
    private javax.swing.JButton jButton_start_next_game;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_dealer_add_more_card;
    private javax.swing.JLabel jLabel_dealer_card_1;
    private javax.swing.JLabel jLabel_dealer_card_2;
    private javax.swing.JLabel jLabel_player1;
    private javax.swing.JLabel jLabel_player1_add_more_card;
    private javax.swing.JLabel jLabel_player1_card_1;
    private javax.swing.JLabel jLabel_player1_card_2;
    private javax.swing.JLabel jLabel_player2;
    private javax.swing.JLabel jLabel_player2_add_more_card;
    private javax.swing.JLabel jLabel_player2_card_1;
    private javax.swing.JLabel jLabel_player2_card_2;
    private javax.swing.JLabel jLabel_player3;
    private javax.swing.JLabel jLabel_player3_add_more_card;
    private javax.swing.JLabel jLabel_player3_card_1;
    private javax.swing.JLabel jLabel_player3_card_2;
    private javax.swing.JLabel jLabel_player4;
    private javax.swing.JLabel jLabel_player4_add_more_card;
    private javax.swing.JLabel jLabel_player4_card_1;
    private javax.swing.JLabel jLabel_player4_card_2;
    private javax.swing.JLabel jLabel_player5;
    private javax.swing.JLabel jLabel_player5_add_more_card;
    private javax.swing.JLabel jLabel_player5_card_1;
    private javax.swing.JLabel jLabel_player5_card_2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_game_store_info_coin_player_and_dealer;
    // End of variables declaration//GEN-END:variables
}
