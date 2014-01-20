package com.example.fufloma;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class GMapsActivity extends Activity {

    private GoogleMap googleMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gmaps);
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Load map
        try {
            // Loading map
            initilizeMap(savedInstanceState);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap(Bundle savedInstanceState) {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
                
                return;
            }
            
        	googleMap.setMyLocationEnabled(true);
        	googleMap.getUiSettings().setCompassEnabled(true);
        	
        	// zoom to given location
    		double lat = 0;
    		double lng = 0;

            if (savedInstanceState == null) {
                Bundle extras = getIntent().getExtras();

                if (extras == null) {
            		lat = 0;
            		lng = 0;
                } else {
                	lat = extras.getDouble("lat");
                	lng = extras.getDouble("lng");
                }
            } else {
            	lat = (Double) savedInstanceState.getSerializable("lat");
            	lat = (Double) savedInstanceState.getSerializable("lng");
            }
        	
            LatLng latlngLoc = new LatLng(lat, lng);
            MarkerOptions marker = new MarkerOptions().position(latlngLoc);
            
            googleMap.addMarker(marker);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlngLoc, 14));
        }
    }
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gmaps, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
