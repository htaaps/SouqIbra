package in.htlabs.tapas.souqibra;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.htlabs.tapas.souqibra.adapter.CustomListAdapter;
import in.htlabs.tapas.souqibra.app.AppController;
import in.htlabs.tapas.souqibra.model.Product;

/**
 * Created by Tapas on 5/31/2015.
 */
public class ProductListActivity extends Activity implements View.OnClickListener{

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static String url = null;
    private ProgressDialog pDialog;
    private List<Product> productList = new ArrayList<Product>();
    private ListView listView;
    private CustomListAdapter adapter;
    Button apl_btn_sell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        listView = (ListView) findViewById(R.id.list);

        apl_btn_sell=(Button)findViewById(R.id.apl_bt_sell);
        apl_btn_sell.setOnClickListener(this);

        adapter = new CustomListAdapter(this, productList);

        url = "http://www.htlabs.in/student/ibrasouq/getproducts.php"+"?category_id="+MainActivity.selection;

        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        // Creating volley request obj
        JsonArrayRequest prodReq = new JsonArrayRequest(url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                hidePDialog();

                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);
                        JSONArray pArray = obj.getJSONArray("posts");

                        for (int j = 0; j < pArray.length(); j++) {

                            JSONObject pro = pArray.getJSONObject(j);
                            Product item = new Product();
                            item.setPId(pro.getString("p_id"));
                            item.setCName(pro.getString("c_name"));
                            item.setCPhone(pro.getString("c_phone"));
                            item.setPName(pro.getString("p_name"));
                            item.setPImageUrl(pro.getString("p_image"));
                            item.setPDetails(pro.getString("p_details"));
                            item.setPPrice(pro.getString("p_price"));

                            // adding movie to movies array
                            productList.add(item);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                // notifying list adapter about data changes
                // so that it renders the list view with updated data
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(prodReq);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.apl_bt_sell:
                Intent i=new Intent(ProductListActivity.this,LoginActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
