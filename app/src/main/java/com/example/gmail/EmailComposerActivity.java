package com.example.gmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class EmailComposerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendEmail();
    }

    public void sendEmail( )  {
        String[] recipients=new String[]{""};
        String subject="";
        String content ="";

        Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT, content);

        intentEmail.setType("text/plain");

        startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
    }
}
