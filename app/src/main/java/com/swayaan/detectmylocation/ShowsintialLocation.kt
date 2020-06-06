package com.swayaan.detectmylocation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Point
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.io.IOException
import com.google.android.gms.maps.model.PolylineOptions
import java.lang.reflect.Array


class ShowsintialLocation : AppCompatActivity(), OnMapReadyCallback ,GoogleMap.OnMarkerClickListener {


    override fun onMarkerClick(p0: Marker?) = false

    companion object {

        private const val LOCATION_PERMISSION_REQUEST_CODE = 1

        private const val REQUEST_CHECK_SETTINGS = 2
    }


    private lateinit var map: GoogleMap

    private lateinit var lastLocation: Location

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var locationCallback: LocationCallback

    private lateinit var locationRequest: LocationRequest

    private var locationUpdateState = false

    private lateinit var originLocation: Location

    private lateinit var originPosition : Point

    private lateinit var destinationPosition: Point

    private lateinit var p0: Point

    private lateinit var polylineOptions: PolylineOptions

//    private  val locations: ArrayList<LatLng>()
//            .

    val locations = ArrayList<LatLng>()




    val position = 0

    // private lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showsintial_location)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
//        var first = LatLng(
//            12.9722007,
//            77.654007
//        )
//
//      locations.add(first)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        //locationManager= LocationManager.GPS_PROVIDER.requestLocationUpdates
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)
                lastLocation = p0.lastLocation

                     var map2 =p0.toString()
                  println(" Value og po $map2")

//                var LatLng1 = LatLng(map2.get(0),map2.get(1))

               println("Vale of $p0")
                // Log.e("msg",(LatLng(lastLocation.latitude,lastLocation.longitude))
                // print(LatLng(lastLocation.latitude,lastLocation.longitude))
               var map1 =  map.addMarker(
                    MarkerOptions().position(
                        LatLng(
                            lastLocation.latitude,
                            lastLocation.longitude
                        )
                    ).title("You've clicked on the path you travelled")
                )


                println(" Value of marker ${map1.position}")
                //I need to draw a line from one marker to the other


//                var LatLng = arrayListOf<Any>()
//                    .addAll(Lat

                //  map.addPolyline(PolylineOptions().add(LatLng(lastLocation.latitude,lastLocation.longitude)).add(LatLng.get(0),LatLng(1)))

                // var first = LatLng(LatLng.get(0),LatLng.get(1))

                // var range= 0..LatLng[lastLocat{}ion.latitude,lastLocation.latitude]

                //  for (element in 0..LatLng){

                ///  }
//
//
//                println(" Longitude "+LatLng.get(0)+"- Latitude "+LatLng.get(1));
//
//                for (element in 0..1) {
//                    for (longitude in LatLng) {
//                        println(" Latitude${LatLng[element]}  $ longitude  ")
//
//
//                    }
//                }

//                var LatLng1= arrayOf(arrayOf(lastLocation.latitude,lastLocation.longitude))





//                ArrayList<LatLng> coordinates = new ArrayList<>();
//                coordinates.add(LatLng)
//                val polylineOptions = PolylineOptions().addAll(coordinates)


//               }


               var LatLng= arrayOf(lastLocation.latitude,lastLocation.longitude)
//
                // The marker has to be placed here // Later I need to draw line from one marker to the other
                var last = LatLng(LatLng.get(0), LatLng.get(1))
//             var first = LatLng(LatLng.get(2),LatLng.get(3))

//                for(lattitude in Latng){
//
//                }

                val first1 = arrayOf((arrayOf(last)))
                println("First first one ${first1.asList()}")

                val arrayList = ArrayList<Double>()
//                arrayList.addAll(index = 0,elements = LatLng<Double>) for( i in arrayList){
                   // println(" value of array List $i")
                   // println(" value of array List ${arrayList[1]}")



                      locations.add(last)

//
                if(locations.size > 1){
                    map.addPolyline(PolylineOptions().add(last).add(locations.get(locations.size - 2)).width(8F).color(Color.BLACK))
                }


//                map.addPolyline(PolylineOptions().addAll(iterator<LatLng> {  }(map1)))

//                val map1 =map.addPolyline(PolylineOptions().add(LatLng(Point)))
                println("try to understand which one is creating the end point" + last)


                // map.addPolyline(arrayOf(PolylineOptions()))


                // map.addPolyline(PolylineOptions().p)`

                // first = last; reassign

//                    println("my value stop");
                //  println(LatLng.last())
                // println(element)
                //var last = LatLng.last()
                //var last
                // var last1= last.toInt()
                //  map.addPolyline(PolylineOptions().add().add(last).color(Color.BLACK).width(8f))
                //map.addPolylin(P)
                // map.addPolyline(arrayOf(PolylineOptions))


            }


            //override f

        }
        createLocationRequest()
        //  Drawline()
        //addPolylines()


    }


    private fun setUpMap() {

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        map.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                //  map.addPolyline(PolylineOptions().add(currentLatLng).width(8f).color(Color.BLACK))

            }
        }
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return

        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)


    }

    private fun createLocationRequest() {

        locationRequest = LocationRequest()

        println(" Location Request $locationRequest")

        locationRequest.interval = 1000

        //   locationRequest.fastestInterval = 1000

        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)

        val client = LocationServices.getSettingsClient(this)
        val task = client.checkLocationSettings(builder.build())


        task.addOnSuccessListener {
            locationUpdateState = true
            startLocationUpdates()
        }

        task.addOnFailureListener { e ->
            if (e is ResolvableApiException) {

                try {
                    e.startResolutionForResult(this@ShowsintialLocation, REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException) {

                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == Activity.RESULT_OK) {
                locationUpdateState = true
                startLocationUpdates()
            }
        }
    }

    override fun onPause() {
        super.onPause()

        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    public override fun onResume() {
        super.onResume()
        if (!locationUpdateState) {
            startLocationUpdates()
        }
    }

    public override fun onStop() {
        super.onStop()
        //startLocationUpdates()
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)
        setUpMap()


    }
}

//    private fun Drawline() {
//        locationCallback = object : LocationCallback(){
//            override fun onLocationResult(p0: LocationResult) {
//                super.onLocationResult(p0)
//                lastLocation=p0.lastLocation
//
//                println("Print the value of lastlocation $lastLocation")
//               var first2=lastLocation
//                println("inital location $first2")
//
//                var first3 =LatLng(lastLocation.latitude,lastLocation.longitude)
//                    println(first3)
//
//                var LatLng = arrayOf(lastLocation.latitude, lastLocation.longitude)
//
//                //var first = LatLng(lastLocation.latitude,lastLocation.longitude)
//                val first = LatLng(lastLocation.latitude ,lastLocation.longitude)
//                println("This ahould return the first point $first and value of $LatLng")
//                 map.addPolyline(PolylineOptions().add())
//                     for (myelement in 0..1){
//                    println(" Should return the value $LatLng and this is value of myelement ${(myelement)} this is the value of element in LatLng ${((LatLng(lastLocation.latitude,lastLocation.longitude)))} Value of O in ${LatLng[0]} this is the value in ${LatLng[1]} also print $lastLocation")
//                    var last = LatLng(LatLng.get(0),LatLng.get(1))
//                    println(" Last value $last")
//                         val first1 = LatLng(lastLocation.latitude ,lastLocation.longitude)
//                         println(" pritn first elemt im loop = $first1")
//                         println(" Output the value of first that is $first and out put for last that is $last and also $first1 and First 2 $first2 and First 3 $first3")
//                         map.addPolyline(PolylineOptions().add(first3).add(last).width(8f).color(Color.BLACK))
//                }
//            }
//          }
//        }
//    }


//    private fun Drawline() {
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(p0: LocationResult) {
//                super.onLocationResult(p0)
//                lastLocation = p0.lastLocation
//                println(" VALUE lastlocation" + lastLocation)
//                // map.addPolyline(PolylineOptions().add(LatLng(lastLocation.latitude,lastLocation.longitude)).add(lastLocation.latitude,lastLocation.longitude))
//                // map.addPolyline(arrayOf(LatLng))
//                var linedrawer = lastLocation.latitude
//
//                println(" VALUE lastlocation" + linedrawer)
//
//                var LatLng = arrayOf(lastLocation.latitude, lastLocation.longitude)
//                val first = LatLng(LatLng.get(0),LatLng.get(1))
//               // var last = LatLng(lastLocation.latitude,lastLocation.longitude)
//               //
//                // var last = LatLng(LatLng.first(),LatLng.last())
//                for (myelement2 in 1..LatLng.size) {
//                    var last = LatLng(lastLocation.latitude,lastLocation.longitude)
//                    println("Know what first contains $first and what LatLng ${LatLng[0]} and last $last  along with Lat Lng of 1 ${LatLng[1]}")
//
//                    map.addPolyline(PolylineOptions().add(first).add(last).width(8f).color(Color.BLUE))
//                }
//
////                var element= LatLng.get()
////                println(" should retrieve the first point " +element)
//                //Create an array which stores the first point and second point
//                for (element in 0 until  LatLng.size) {
//                    //for (myelment in )
//                    println("let see what thsi will retrieve and also see whar latlng contsian ${LatLng.size} SEE and also ${LatLng.lastIndex}  along with show me the values for $element and o index of LatLng " + LatLng[0])
//                }
//                for (myelement in LatLng){
//                    println(" this will print the contents of my element $myelement let see the value of 0 ${LatLng[0]} and WhatLat Lng of ! ${LatLng[1]}")
//                }
//
//            }
//
//
//
//        }
//
//
//    }
//}










