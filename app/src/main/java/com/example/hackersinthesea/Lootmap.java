package com.example.hackersinthesea;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;

public class Lootmap extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,getString(R.string.MAPBOX_ACCESS_TOKEN));
        setContentView(R.layout.loot_map);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        // Map is set up and the style has loaded. Now you can add data or make other map adjustment

                    }
                });
                MarkerOptions options = new MarkerOptions();
                options.title("current location");

                IconFactory iconFactory = IconFactory.getInstance(Lootmap.this);
                Icon icon = iconFactory.fromResource(R.drawable.pirate_treasure);

                options.icon(icon);


                List<LootLocations> lootLocations = new ArrayList<>();
                lootLocations.add(new LootLocations(45.516022, -122.681427));
                lootLocations.add(new LootLocations(49.162780, -123.136650));
                lootLocations.add(new LootLocations(-32.860500, 151.505035));
                lootLocations.add(new LootLocations(32.080898, -81.091202));
                lootLocations.add(new LootLocations(47.606209, -122.332069));
                lootLocations.add(new LootLocations(30.917130, -93.284790));
                lootLocations.add(new LootLocations(29.384020, -94.902550));
                lootLocations.add(new LootLocations(39.744430, -75.545100));
                lootLocations.add(new LootLocations(42.360081, -71.058884));
                lootLocations.add(new LootLocations(19.135000, 72.793440));
                lootLocations.add(new LootLocations(22.565570, 88.370210));
                lootLocations.add(new LootLocations(13.072090, 80.201859));
                lootLocations.add(new LootLocations(17.686815, 83.218483));
                lootLocations.add(new LootLocations(-7.742020, 109.014520));
                lootLocations.add(new LootLocations(-2.987960, 104.760310));
                lootLocations.add(new LootLocations(30.347296, 48.293400));
                lootLocations.add(new LootLocations(53.716770, -6.354350));
                lootLocations.add(new LootLocations(33.473499, -82.010513));
                lootLocations.add(new LootLocations(51.412331, -0.300689));
                lootLocations.add(new LootLocations(41.794979, 140.739975));
                lootLocations.add(new LootLocations(35.529991, 139.705002));
                lootLocations.add(new LootLocations(39.160488, 127.430817));
                lootLocations.add(new LootLocations(18.135660, -94.440224));
                lootLocations.add(new LootLocations(23.249414, -106.411140));
                lootLocations.add(new LootLocations(36.673161, 10.155510));
                lootLocations.add(new LootLocations(11.252100, -85.869698));
                lootLocations.add(new LootLocations(60.391262, 5.322054));
                lootLocations.add(new LootLocations(37.137630, -8.534400));
                lootLocations.add(new LootLocations(25.724100, 51.531010));
                lootLocations.add(new LootLocations(47.061420, 142.053650));
                lootLocations.add(new LootLocations(60.710918, 28.751930));


                for (int i = 0; i < lootLocations.size(); i++) {
                    options.position(new LatLng(lootLocations.get(i).latitude, lootLocations.get(i).longitude));
                    mapboxMap.addMarker(options);
                }

            }
        });



    }
    @Override
    protected void onStart () {
        super.onStart();
        mapView.onStart();
    }
        @Override
        protected void onResume () {
            super.onResume();
            mapView.onResume();
        }

        @Override
        protected void onPause () {
            super.onPause();
            mapView.onPause();
        }

        @Override
        protected void onStop () {
            super.onStop();
            mapView.onStop();
        }

        @Override
        protected void onSaveInstanceState (Bundle outState){
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }

        @Override
        public void onLowMemory () {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            mapView.onDestroy();
        }

    public class LootLocations {
        public final double latitude;
        public  double longitude;

        public LootLocations(double lat, double lon) {
            latitude = lat;
            longitude = lon;
        }
    }
    }
