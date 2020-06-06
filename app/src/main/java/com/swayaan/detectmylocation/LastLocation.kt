package com.swayaan.detectmylocation

import android.graphics.Color
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_last_location.*
import kotlinx.android.synthetic.main.activity_main.*

class LastLocation : AppCompatActivity(), OnMapReadyCallback, OnPolylineClickListener{
    override fun onPolylineClick(p0: Polyline?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        false
    }
    // override fun onPolylineClick(p0: Polyline?)= false



    private lateinit var mMap: GoogleMap

    // private lateinit var
    private lateinit var lastLocation: Location

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    private lateinit var locationRequest: LocationRequest

    private var locationUpdateState = false

   // private ArrayList<LatLng> points;

    //private var Polyline: Polyline


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_location)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.hg
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
     // Polyline line = mMap.addPolyline(new PolylineOptions().add    )

                // Add a marker in Sydney and move the camera

                 val bangalore = LatLng(12.97,77.59)
                 val chennai =LatLng(13.08,80.27)
                 mMap.addMarker(MarkerOptions().position(bangalore).position(chennai).title("Marker in Sydney"))
                // mMap.addPolyline(PolylineOptions().add(sydney,mysore).color(55).width(8f))


                //map.addMarker(MarkerOptions().position(LatLng(lastLocation.latitude,lastLocation.longitude)).title("You've clicked on the path you travelled"))
                // mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(lastLocation.longitude,lastLocation.latitude)))

                 mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bangalore,12f))
        mMap.addPolyline(PolylineOptions().add(bangalore).add(chennai).color(Color.BLACK).width(8f))
            }
        }


