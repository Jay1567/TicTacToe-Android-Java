package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtMsg;
    /*
        True: X's turn, False: 0's Turn
        0 = Null
        1 = Player 1
        2 = Player 2
     */
    boolean playerTurn;
    int board[][]={{0,0,0},{0,0,0},{0,0,0}};
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMsg);
        txtMsg.setText("X's Turn!");
        count = 0;
        playerTurn = true;

        int height = findViewById(R.id.img0).getHeight();
        int width = findViewById(R.id.img0).getWidth();

        System.out.println(height);
        System.out.println(width);

        ((ImageView)findViewById(R.id.img0)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img0)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img1)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img1)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img2)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img2)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img3)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img3)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img4)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img4)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img5)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img5)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img6)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img6)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img7)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img7)).setMaxWidth(width);
        ((ImageView)findViewById(R.id.img8)).setMaxHeight(height);
        ((ImageView)findViewById(R.id.img8)).setMaxWidth(width);
    }

    public void movePlayed(View view){
        ImageView img = (ImageView) view;
        int index = Integer.parseInt(img.getTag().toString());
        int i = index/3;
        int j = index%3;

        if(board[i][j] != 0)
            return;

        count++;
        if(playerTurn) {
            board[i][j] = 1;
            img.setImageResource(R.drawable.x);
        }
        else {
            board[i][j] = 2;
            img.setImageResource(R.drawable.o);
        }

        switch (checkGameStatus()) {
            case 1:
                //Player 1 Won
                break;
            case 2:
                //Player 2 Won
                break;
            default:
                if (count == 9) {
                    //Draw
                }
        }

        playerTurn = !playerTurn;
        updateBoard();
    }

    private void updateBoard(){
        if(playerTurn)
            txtMsg.setText("X's Turn!");
        else
            txtMsg.setText("O's Turn!");
    }

    private int checkGameStatus(){
        //For Player 1
        if(board[0][0]==1&&board[0][1]==1&&board[0][2]==1)
            return 1;
        if(board[1][0]==1&&board[1][1]==1&&board[1][2]==1)
            return 1;
        if(board[2][0]==1&&board[2][1]==1&&board[2][2]==1)
            return 1;
        if(board[0][0]==1&&board[1][0]==1&&board[2][0]==1)
            return 1;
        if(board[0][1]==1&&board[1][1]==1&&board[2][1]==1)
            return 1;
        if(board[0][2]==1&&board[1][2]==1&&board[2][2]==1)
            return 1;
        if(board[0][0]==1&&board[1][1]==1&&board[2][2]==1)
            return 1;
        if(board[0][2]==1&&board[1][1]==1&&board[2][0]==1)
            return 1;

        //For Player 2
        if(board[0][0]==2&&board[0][1]==2&&board[0][2]==2)
            return 2;
        if(board[1][0]==2&&board[1][1]==2&&board[1][2]==2)
            return 2;
        if(board[2][0]==2&&board[2][1]==2&&board[2][2]==2)
            return 2;
        if(board[0][0]==2&&board[1][0]==2&&board[2][0]==2)
            return 2;
        if(board[0][1]==2&&board[1][1]==2&&board[2][1]==2)
            return 2;
        if(board[0][2]==2&&board[1][2]==2&&board[2][2]==2)
            return 2;
        if(board[0][0]==2&&board[1][1]==2&&board[2][2]==2)
            return 2;
        if(board[0][2]==2&&board[1][1]==2&&board[2][0]==2)
            return 2;
        //For Draw
        return 0;
    }

}