package com.example.mari_.pymescontrol.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.mari_.pymescontrol.R;


public class DialogSendResponse extends Dialog implements View.OnClickListener {
    public Activity activity;
    public Dialog d;
    private ImageView closeBtn;

    public DialogSendResponse(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_send_response);
        d = this;
        setCancelable(false);
        closeBtn = findViewById(R.id.dialog_send_response_close);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
    }
    @Override
    public void onClick(View v) {}
}
