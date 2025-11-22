package com.rishik.tictactoe;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    int activeplayer = 0;  // 0 = X, 1 = O

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void PlayerTap(View view) {

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);

        // If game is finished → reset
        if (!gameActive) {
            GameReset();
            return;
        }

        // Only allow tapping empty box
        if (gameState[tappedImage] == 2) {

            gameState[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);

            if (activeplayer == 0) {
                img.setImageResource(R.drawable.xbg);
                activeplayer = 1;
                status.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.obg);
                activeplayer = 0;
                status.setText("X's Turn - Tap to Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);

            // Check winner
            for (int[] wp : winPositions) {
                if (gameState[wp[0]] == gameState[wp[1]]
                        && gameState[wp[1]] == gameState[wp[2]]
                        && gameState[wp[0]] != 2) {

                    gameActive = false;

                    String winner;
                    if (gameState[wp[0]] == 0)
                        winner = "X Has Won! Tap Anywhere to Restart";
                    else
                        winner = "O Has Won! Tap Anywhere to Restart";

                    status.setText(winner);
                }
            }
        }
    }

    // RESET GAME
    public void GameReset() {

        gameActive = true;
        activeplayer = 0;

        for (int i = 0; i < 9; i++) gameState[i] = 2;

        // Clear all 9 ImageViews based on your XML IDs
        ((ImageView)findViewById(R.id.imageView3a)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2a)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1a)).setImageResource(0);

        ((ImageView)findViewById(R.id.imageView3b)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2b)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1b)).setImageResource(0);

        ((ImageView)findViewById(R.id.imageView3c)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2c)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1c)).setImageResource(0);

        // Reset status text
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");
    }
}
