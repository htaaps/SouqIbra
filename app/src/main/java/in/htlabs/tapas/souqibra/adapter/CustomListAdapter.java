package in.htlabs.tapas.souqibra.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import in.htlabs.tapas.souqibra.R;
import in.htlabs.tapas.souqibra.SingleProductActivity;
import in.htlabs.tapas.souqibra.app.AppController;
import in.htlabs.tapas.souqibra.model.Product;


public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Product> productItems;
	Product p;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Product> productItems) {
		this.activity = activity;
		this.productItems = productItems;
	}

	@Override
	public int getCount() {
		return productItems.size();
	}

	@Override
	public Object getItem(int location) {
		return productItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null)
			convertView = inflater.inflate(R.layout.activity_product_list_row, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView p_image = (NetworkImageView) convertView.findViewById(R.id.p_image);
		TextView p_name          = (TextView) convertView.findViewById(R.id.p_name);
		TextView p_details       = (TextView) convertView.findViewById(R.id.p_details);
		TextView p_price         = (TextView) convertView.findViewById(R.id.p_price);

		// getting movie data for the row
		p = productItems.get(position);

		// thumbnail image
		p_image.setImageUrl(p.getPImageUrl(), imageLoader);
		
		// title
		p_name.setText(p.getPName());
		
		// rating
		p_details.setText(p.getPDetails());
		
		// release year
		p_price.setText(p.getPPrice());


		convertView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				p = productItems.get(position);
				Intent intent = new Intent(activity, SingleProductActivity.class);
				// Pass all data rank
				intent.putExtra("p_name", p.getPName());
				// Pass all data country
				intent.putExtra("p_details", p.getPDetails());
				// Pass all data population
				intent.putExtra("p_price", p.getPPrice());
				// Pass all data flag
				intent.putExtra("p_image", p.getPImageUrl());
				// Start SingleItemView Class
				activity.startActivity(intent);

			}
		});

		return convertView;
	}

}