package evr.com.evr.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import evr.com.evr.R;

public class OfferDetailActivity extends AppCompatActivity {

    ImageView offerImageView;
    ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);

        int offerImageId = (int) getIntent().getExtras().getInt("offer_image");

        offerImageView = (ImageView) findViewById(R.id.offer_holder);
        offerImageView.setImageResource(offerImageId);

        closeButton = (ImageButton) findViewById(R.id.btn_close);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
