package ib.facmed.unam.mx.simexfacmed;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String sede="";
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Bundle bundle = getIntent().getExtras();
        sede=getIntent().getExtras().getString("sede");

        fab = (FloatingActionButton) findViewById(R.id.fab_waze);
        //fab.setVisibility(View.INVISIBLE);

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

        mMap.getUiSettings().setMapToolbarEnabled(false);

        LatLng centro = new LatLng(19.378139, -99.156844);

        // Add a marker in "Palacio de la escuela de medicina" and move the camera
        LatLng palacioMed = new LatLng(19.437815, -99.133386);
        mMap.addMarker(new MarkerOptions().position(palacioMed).title("Palacio de la escuela de medicina"));

        // Add a marker in "Unidad de posgrado" and move the camera
        LatLng posgrado = new LatLng(19.309583, -99.185448);
        mMap.addMarker(new MarkerOptions().position(posgrado).title("Unidad de posgrado"));

        // Add a marker in "Facultad de Medicina" and move the camera
        LatLng facMed = new LatLng(19.333250, -99.180235);
        mMap.addMarker(new MarkerOptions().position(facMed).title("Facultad de Medicina"));

        // Add a marker in "Instituto Nacional de Rehabilitacion" and move the camera
        LatLng inr = new LatLng(19.289642, -99.149272);
        mMap.addMarker(new MarkerOptions().position(inr).title("Instituto Nacional de Rehabilitación"));

        switch(sede){
            case "palacio" :

                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(palacioMed,15));

                                goWaze(palacioMed.latitude,palacioMed.longitude);
                                break;
            case "posgrado" :

                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posgrado,15));
                                goWaze(posgrado.latitude,posgrado.longitude);
                                break;
            case "facmed" :

                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(facMed,15));
                                goWaze(facMed.latitude,facMed.longitude);
                                break;
            case "inr" :

                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(inr,15));
                                goWaze(inr.latitude,inr.longitude);
                                break;
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                double latitude=marker.getPosition().latitude;
                double longitud=marker.getPosition().longitude;
                //fab.setVisibility(View.VISIBLE);
                goWaze(latitude,longitud);
                return false;
            }
        });

        /*mMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
            @Override
            public void onInfoWindowClose(Marker marker) {
                fab.setVisibility(View.INVISIBLE);
            }
        });*/



    }

    public void goWaze(final double lat, final double lon){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    // Launch Waze to look for Hawaii:
                    //String url = "https://waze.com/ul?q=Hawaii";
                    String urlNavigateLocation="https://waze.com/ul?ll="+lat+","+lon+"&navigate=yes";
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( urlNavigateLocation ) );
                    startActivity( intent );
                }
                catch ( ActivityNotFoundException ex  )
                {
                    // If Waze is not installed, open it in Google Play:
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
                    startActivity(intent);
                }
            }
        });
    }
}
