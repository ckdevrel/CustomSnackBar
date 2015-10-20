package com.takeoffandroid.customsnackbar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Chandru-MacBook on 10/20/15.
 */
public class SnackBar {



    enum SnackBarDuration {
        SHORT, LONG, INDEFINITE;
    }


    enum IconPosition {
        LEFT, RIGHT, TOP, BOTTOM;
    }
    //Default snackbar will be showed for short duration
    private SnackBarDuration mSnackBarDuration = SnackBarDuration.SHORT;

    //Icons will be shown left by default for title
    private IconPosition mIconPositionTitle = IconPosition.LEFT;

    //Icons will be shown right by default for action
    private IconPosition mIconPositionAction = IconPosition.RIGHT;

    private OnActionClickListener mOnActionClickListener;

    private View mView;

    private String mTitleText;

    private String mActionText;

    private int mTitleTextColor = Color.WHITE;

    private int mActionTextColor = Color.YELLOW;

    private int mBackgroundColor = Color.BLACK;


    private Typeface mTfTitle = Typeface.DEFAULT;

    private Typeface mTfAction = Typeface.DEFAULT;

    private Drawable mTitleIconDrawable = null;

    private Drawable mActionIconDrawable = null;

    private boolean isNeedClickEvent;

    private int mIconTitlePadding = 0;

    private int mIconActionPadding = 0;

    //Assigning the view for which Snackbar responds
    public SnackBar view(View view) {
        this.mView = view;
        return this;
    }

    //Assigning the title and action text

    public SnackBar text(String titleText, String actionText) {
        this.mTitleText = titleText;
        this.mActionText = actionText;
        return this;
    }

    //To customize title and action text colors

    public SnackBar textColors(int titleTextColor, int actionTextColor) {
        this.mTitleTextColor = titleTextColor;
        this.mActionTextColor = actionTextColor;
        return this;
    }

    //To customize background color of snack bar
    public SnackBar backgroundColor(int backgroundColor) {
        this.mBackgroundColor = backgroundColor;
        return this;
    }

    //Change duration whether SnackBar should be shown for short, long or Indefinite
    public SnackBar duration(SnackBarDuration snackBarDuration) {
        this.mSnackBarDuration = snackBarDuration;
        return this;
    }

    //Change font for title
    public SnackBar customTitleFont(Typeface tf){
        this.mTfTitle = tf;
        return this;
    }

    //Change font for title
    public SnackBar customActionFont(Typeface tf){
        this.mTfAction = tf;
        return this;
    }


    public SnackBar setIconForTitle(Drawable titleDrawable, IconPosition iconPostion, int drawablePadding){
        this.mTitleIconDrawable = titleDrawable;
        this.mIconPositionTitle = iconPostion;
        this.mIconTitlePadding = drawablePadding;
        return this;
    }

    public SnackBar setIconForAction(Drawable actionDrawable, IconPosition iconPostion,int drawablePadding){
        this.mActionIconDrawable = actionDrawable;
        this.mIconPositionAction = iconPostion;
        this.mIconActionPadding = drawablePadding;
        return this;
    }

    public Snackbar getSnackBar() {

        int duration = 0;

        switch (mSnackBarDuration) {

            case SHORT:
                duration = Snackbar.LENGTH_SHORT;
                break;

            case LONG:
                duration = Snackbar.LENGTH_LONG;
                break;

            case INDEFINITE:
                duration = Snackbar.LENGTH_INDEFINITE;
                break;
        }


        Snackbar snackbar = Snackbar
                .make(mView, mTitleText, duration)
                .setAction(mActionText, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(isNeedClickEvent) {
                            mOnActionClickListener.onClick(view);
                        }
                    }
                });



        View sbView = snackbar.getView();
        TextView txtTitle = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        TextView txtAction = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_action);

        // Changing message text color
        txtTitle.setTextColor(mTitleTextColor);


        // Changing action button text color
        txtAction.setTextColor(mActionTextColor);

        //Changing background color
        sbView.setBackgroundColor(mBackgroundColor);

        //Changing font style for title
        txtTitle.setTypeface(mTfTitle);

        //Changing font style for action
        txtAction.setTypeface(mTfAction);

        setIcon(txtTitle,mTitleIconDrawable,mIconPositionTitle,Gravity.CENTER_VERTICAL, mIconTitlePadding);

        setIcon(txtAction,mActionIconDrawable,mIconPositionAction,Gravity.CENTER,mIconActionPadding);




        return snackbar;
    }

    private void setIcon(TextView textView, Drawable drawable, IconPosition iconPosition, int gravity, int iconPadding) {

        textView.setGravity(gravity);
        textView.setCompoundDrawablePadding(iconPadding);
        switch (iconPosition){

            case LEFT:

                textView.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                break;

            case RIGHT:
                textView.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null);

                break;

            case TOP:
                textView.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);

                break;

            case BOTTOM:
                textView.setCompoundDrawablesWithIntrinsicBounds(null,null,null,drawable);

                break;
        }
    }

    //To show the Snackbar in UI.
    public void show() {
        getSnackBar().show();
    }


    //Listeners to handle SnackBar Action click
    public SnackBar setOnClickListener(boolean isNeedClickEvent, OnActionClickListener onActionClickListener){

        this.isNeedClickEvent = isNeedClickEvent;
        this.mOnActionClickListener = onActionClickListener;
        return this;
    }

}





