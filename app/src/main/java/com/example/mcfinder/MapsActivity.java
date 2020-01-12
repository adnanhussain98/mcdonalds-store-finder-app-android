package com.example.mcfinder;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mcfinder.models.Store;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String McJson = readJSONFile();

        // prints first 101 characters.
        Log.i(TAG, "onMapReady: " + McJson.substring(0,100));

        ArrayList<Store> stores = gson.fromJson(McJson, new TypeToken<List<Store>>(){}.getType());

        for (Store s: stores){
            Log.i(TAG, "onMapReady: " + s.getStoreName());

            // Add a marker in Sydney and move the camera
            LatLng location = new LatLng(s.getLatitude(),s.getLongitude());
            mMap.addMarker(new MarkerOptions().position(location).title(s.getStoreName()).icon(BitmapDescriptorFactory.fromResource(R.drawable.icon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        }

    }

    public String readJSONFile(){

        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("mcdonalds_data.json"), "UTF-8"));
            String line;

            //line string in brackets as it is read first. order of operations.
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
