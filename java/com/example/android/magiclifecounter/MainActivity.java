package com.example.android.magiclifecounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int playerOneHealth = 20;
    int playerTwoHealth = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("player_1_health", playerOneHealth);
        savedInstanceState.putInt("player_2_health", playerTwoHealth);
        super.onSaveInstanceState(savedInstanceState);
    }

    // Changes health color to red if value is 5 or below.
    public void healthColor() {
        TextView player1Health = (TextView) findViewById(R.id.player_1_health);
        TextView player2Health = (TextView) findViewById(R.id.player_2_health);
        String p1Health = (String) player1Health.getText();
        String p2Health = (String) player2Health.getText();
        if (Integer.valueOf(p1Health) <= 5) {
            player1Health.setTextColor(Color.RED);
        } else {
            player1Health.setTextColor(Color.GREEN);
        }

        if (Integer.valueOf(p2Health) <= 5) {
            player2Health.setTextColor(Color.RED);
        } else {
            player2Health.setTextColor(Color.GREEN);
        }
    }

    // Adds 1 health to Player 1.
    public void addHealthPlayer1(View v) {
        playerOneHealth++;
        displayPlayerOneHealth(playerOneHealth);
    }

    // Subtracts 1 health from Player 1.
    public void subtractHealthPlayer1(View v) {
        playerOneHealth--;
        displayPlayerOneHealth(playerOneHealth);
    }

    // Displays updated health value for Player 1 and changes
    // text color if necessary.
    private void displayPlayerOneHealth(int playerOneHealth) {
        TextView p1Health = (TextView) findViewById(R.id.player_1_health);
        p1Health.setText(String.valueOf(playerOneHealth));
        healthColor();
    }

    // Adds 1 health to Player 2.
    public void addHealthPlayer2(View v) {
        playerTwoHealth++;
        displayPlayerTwoHealth(playerTwoHealth);
    }

    // Subtracts 1 health from Player 2.
    public void subtractHealthPlayer2(View v) {
        playerTwoHealth--;
        displayPlayerTwoHealth(playerTwoHealth);
    }

    // Displays updated health value for Player 2 and changes
    // text color if necessary.
    private void displayPlayerTwoHealth(int playerOneHealth) {
        TextView p2Health = (TextView) findViewById(R.id.player_2_health);
        p2Health.setText(String.valueOf(playerTwoHealth));
        healthColor();
    }

    public void resetGame(View v) {
        playerOneHealth = 20;
        playerTwoHealth = 20;
        displayPlayerOneHealth(playerOneHealth);
        displayPlayerTwoHealth(playerTwoHealth);
    }
}
