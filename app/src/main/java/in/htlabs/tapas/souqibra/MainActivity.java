package in.htlabs.tapas.souqibra;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    Button am_bt_cars,am_bt_furniture,am_bt_mobile,am_bt_elec,am_bt_animals,am_bt_house;

    public static String selection=null;
    public static String user=null;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am_bt_cars=(Button)findViewById(R.id.am_bt_cars);
        am_bt_furniture=(Button)findViewById(R.id.am_bt_furniture);
        am_bt_mobile=(Button)findViewById(R.id.am_bt_mobile);
        am_bt_elec=(Button)findViewById(R.id.am_bt_elec);
        am_bt_animals=(Button)findViewById(R.id.am_bt_animals);
        am_bt_house=(Button)findViewById(R.id.am_bt_house);

        am_bt_cars.setOnClickListener(this);
        am_bt_furniture.setOnClickListener(this);
        am_bt_mobile.setOnClickListener(this);
        am_bt_elec.setOnClickListener(this);
        am_bt_animals.setOnClickListener(this);
        am_bt_house.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.am_bt_cars:
                MainActivity.selection="2";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
            case R.id.am_bt_furniture:
                MainActivity.selection="4";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
            case R.id.am_bt_mobile:
                MainActivity.selection="6";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
            case R.id.am_bt_elec:
                MainActivity.selection="3";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
            case R.id.am_bt_animals:
                MainActivity.selection="1";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
            case R.id.am_bt_house:
                MainActivity.selection="5";
                i=new Intent(MainActivity.this,ProductListActivity.class);
                startActivity(i);

                break;
        }
    }
}
