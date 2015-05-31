package in.htlabs.tapas.souqibra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import in.htlabs.tapas.souqibra.app.AppController;

/**
 * Created by Tapas on 5/31/2015.
 */
public class SingleProductActivity extends Activity {

    String p_name,p_details,p_price,p_image;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.activity_single_product);

        Intent i = getIntent();
        // Get the result of rank
        p_name = i.getStringExtra("p_name");
        // Get the result of country
        p_details = i.getStringExtra("p_details");
        // Get the result of population
        p_price = i.getStringExtra("p_price");
        // Get the result of population
        p_image = i.getStringExtra("p_image");

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        // Locate the TextViews in singleitemview.xml
        TextView txtname = (TextView) findViewById(R.id.si_p_name);
        TextView txtdetails = (TextView) findViewById(R.id.si_p_details);
        TextView txtprice = (TextView) findViewById(R.id.si_p_price);
        NetworkImageView ivpic=(NetworkImageView)findViewById(R.id.si_p_image);

        // Set results to the TextViews
        txtname.setText(p_name);
        txtdetails.setText(p_details);
        txtprice.setText(p_price);
        ivpic.setImageUrl(p_image,imageLoader);
    }
}
