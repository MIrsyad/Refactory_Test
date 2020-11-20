package com.example.refactory_tes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.StringBuffer;


public class MainActivity extends AppCompatActivity implements TextUndoRedo.TextChangeInfo,View.OnClickListener{
    private TextUndoRedo TUR;
    private Button btn_undo;
    public EditText a;
    public TextView jawaban;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.input);
        jawaban = findViewById(R.id.txtviewjawaban);
        btn_undo = (Button) findViewById(R.id.unred);
        btn_undo.setOnClickListener(this);

        TUR = new TextUndoRedo((EditText) findViewById(R.id.input), this);
        textAction();
    }

    public void reverse(View view) {
        String input = a.getText().toString();
        StringBuffer buffer = new StringBuffer(input);
        buffer.reverse();
        jawaban.setText(buffer);
    }


//    public void undoredo(View view) {
//        int i = list.size();
//        a.setText(list.get(i-1).toString());
//        Log.d("Textwatcher", "undoredo: list ="+list.get(i-2));
//    }

    @Override
    public void onClick(View v) {
        i++;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (i){
                    case 1:
                        TUR.exeUndo();
                        i=0;
                        break;
                    case 2:
                        TUR.exeRedo();
                        i=0;
                        break;
                }
            }
        },200);


    }

    @Override
    public void textAction() {
        btn_undo.setEnabled(TUR.canUndo());
    }
}