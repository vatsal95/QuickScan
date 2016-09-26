package com.example.admin.quickscan.activities;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.admin.quickscan.R;

import static java.lang.String.valueOf;

/**
 * Created by Vatsal on 06-02-2016.
 */
public class FeedbackDialog extends Dialog implements android.view.View.OnClickListener {
    public Activity act;
    public Dialog d;
    public ImageView Feedback_ImageBackgrnd, Feedback_userProfile;
    public TextView Feedback_User, RatingValue;
    public RatingBar ratingBar;
    public EditText Feedback_content;
    public Button btnFeedback_submit;


    public FeedbackDialog(Activity activity_fedback) {
        super(activity_fedback);
        // TODO Auto-generated constructor stub
        this.act = activity_fedback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feedbackdialog);
      //  Feedback_ImageBackgrnd = (ImageView) findViewById(R.id.Feedback_ImageBackgrnd);
        Feedback_userProfile = (ImageView) findViewById(R.id.Feedback_userProfile);
        Feedback_User = (TextView) findViewById(R.id.Feedback_User);
        RatingValue = (TextView) findViewById(R.id.RatingValue);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Feedback_content = (EditText) findViewById(R.id.Feedback_content);
        btnFeedback_submit = (Button) findViewById(R.id.btnFeedback_submit);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch ((int) rating) {
                    case 0:
                        RatingValue.setText("hated it");
                        break;
                    case 1:
                        RatingValue.setText("Dislike it");
                        break;
                    case 2:
                        RatingValue.setText("It's Ok");
                        break;
                    case 3:
                        RatingValue.setText("Liked it");
                        break;
                    case 4:
                        RatingValue.setText("Loved it");
                        break;


                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFeedback_submit:
                d.dismiss();



        }
    }
}