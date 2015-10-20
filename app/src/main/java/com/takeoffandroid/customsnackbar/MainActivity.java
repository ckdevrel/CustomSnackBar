package com.takeoffandroid.customsnackbar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button snackTxtColor;
    private Button snackBgColor;
    private Button snackActionClick;
    private Button snackTitleFont;
    private Button snackActionFont;
    private Button snackTitleIcon;
    private Button snackActionIcon;

    private void findViews() {
        snackTxtColor = (Button)findViewById( R.id.snack_txt_color );
        snackBgColor = (Button)findViewById( R.id.snack_bg_color );
        snackActionClick = (Button)findViewById( R.id.snack_action_click );
        snackTitleFont = (Button)findViewById( R.id.snack_title_font );
        snackActionFont = (Button)findViewById( R.id.snack_action_font );
        snackTitleIcon = (Button)findViewById( R.id.snack_title_icon );
        snackActionIcon = (Button)findViewById( R.id.snack_action_icon );

        snackTxtColor.setOnClickListener( this );
        snackBgColor.setOnClickListener( this );
        snackActionClick.setOnClickListener( this );
        snackTitleFont.setOnClickListener( this );
        snackActionFont.setOnClickListener( this );
        snackTitleIcon.setOnClickListener( this );
        snackActionIcon.setOnClickListener( this );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.snack_txt_color:
                // Handle clicks for snackTxtColor

                SnackBar snackBarTxtColor = new SnackBar();
                snackBarTxtColor.view(snackTxtColor)
                        .text("Snackbar with custom text and action color","Done")
                        .textColors(Color.RED,Color.GREEN)
                        .duration(SnackBar.SnackBarDuration.SHORT)
                        .show();
                break;

            case R.id.snack_bg_color:
                // Handle clicks for snackBgColor

                SnackBar snackBarBgColor = new SnackBar();
                snackBarBgColor.view(snackBgColor)
                        .text("Snackbar with custom background color", "Done")
                        .backgroundColor(Color.BLUE)
                        .duration(SnackBar.SnackBarDuration.LONG)
                        .show();
                break;

            case R.id.snack_action_click:
                // Handle clicks for snackActionClick

                SnackBar snackBarActionClick = new SnackBar();
                snackBarActionClick.view(snackActionClick)
                        .text("Snackbar with ActionClick", "Click me")
                        .duration(SnackBar.SnackBarDuration.INDEFINITE)
                        .setOnClickListener(true, new OnActionClickListener() {
                            @Override
                            public void onClick(View view) {

                              Toast.makeText(MainActivity.this,"Bye bye snackbar Toast is back",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

                break;

            case R.id.snack_title_font:

                SnackBar snackBarTitleFont = new SnackBar();
                snackBarTitleFont.view(snackTitleFont)
                        .text("Custom font for Title", "Done")
                        .customTitleFont(Typeface.MONOSPACE)
                        .show();

                break;

            case R.id.snack_action_font:

                SnackBar snackBarActionFont = new SnackBar();
                snackBarActionFont.view(snackActionFont)
                        .text("Custom font for Action", "Done")
                        .customActionFont(Typeface.MONOSPACE)
                        .show();

                break;

            case R.id.snack_title_icon:

                SnackBar snackBarIconTitle = new SnackBar();
                snackBarIconTitle.view(snackActionFont)
                        .text("Icons for title", "Done")
                        .setIconForTitle(generateDrawableBasedOnVersions(), SnackBar.IconPosition.LEFT,6)
                        .show();
                break;

            case R.id.snack_action_icon:

                SnackBar snackBarIconAction = new SnackBar();
                snackBarIconAction.view(snackActionFont)
                        .text("Icons for action", "Done")
                        .setIconForAction(generateDrawableBasedOnVersions(), SnackBar.IconPosition.RIGHT,6)
                        .show();
                break;
        }
    }


    public Drawable generateDrawableBasedOnVersions(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getResources().getDrawable(android.R.drawable.ic_lock_lock, null);
        } else {
            return getResources().getDrawable(android.R.drawable.ic_lock_lock);
        }
    }
}
