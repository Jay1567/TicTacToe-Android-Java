package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
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
                txtMsg.setText("X Won!");
                ((GridLayout)findViewById(R.id.gridLayout)).setVisibility(View.GONE);
                ((Button)findViewById(R.id.btnReset)).setVisibility(View.VISIBLE);
                return;
            case 2:
                //Player 2 Won
                txtMsg.setText("O Won!");
                ((GridLayout)findViewById(R.id.gridLayout)).setVisibility(View.GONE);
                ((Button)findViewById(R.id.btnReset)).setVisibility(View.VISIBLE);
                return;
            default:
                if (count == 9) {
                    //Draw
                    txtMsg.setText("It's a Draw!");
                    ((GridLayout)findViewById(R.id.gridLayout)).setVisibility(View.GONE);
                    ((Button)findViewById(R.id.btnReset)).setVisibility(View.VISIBLE);
                    return;
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

    public void newGame(View view){
        ((GridLayout)findViewById(R.id.gridLayout)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.btnReset)).setVisibility(View.GONE);

        txtMsg.setText("X's Turn!");
        count = 0;
        playerTurn = true;

        for(int i=0;i<3;i++)
            for(int j=0; j<3; j++)
                board[i][j] = 0;

        ((ImageView)findViewById(R.id.img0)).setImageResource(0);
        ((ImageView)findViewById(R.id.img1)).setImageResource(0);
        ((ImageView)findViewById(R.id.img2)).setImageResource(0);
        ((ImageView)findViewById(R.id.img3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img4)).setImageResource(0);
        ((ImageView)findViewById(R.id.img5)).setImageResource(0);
        ((ImageView)findViewById(R.id.img6)).setImageResource(0);
        ((ImageView)findViewById(R.id.img7)).setImageResource(0);
        ((ImageView)findViewById(R.id.img8)).setImageResource(0);
    }
}