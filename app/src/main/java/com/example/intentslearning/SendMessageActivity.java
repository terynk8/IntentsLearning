package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private EditText editTextmsg;
    private Button buttonSendMsg;

    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        buttonSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text from the editText
                String message  = editTextmsg.getText().toString();

                //create an intent
                //the arguments are where you are coming from (this) and where you are going (TargetActivity.class)
                Intent intentSendMsg = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);

                //package the text into te intent
                intentSendMsg.putExtra(EXTRA_SENT_MESSAGE, message);

                //start the new activity
                startActivity(intentSendMsg);
            }
        });
    }

    private void wireWidgets() {
        editTextmsg = findViewById(R.id.editText_sendmessage_msg);
        buttonSendMsg = findViewById(R.id.button_sendmessage_send);
    }
}
