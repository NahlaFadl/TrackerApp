package com.example.trackapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.trackapp.R
import com.example.trackapp.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.trackapp.services.TrackingService
import com.example.trackapp.ui.viewmodels.MainViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private var map: GoogleMap? = null
    private var mapView: MapView?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnToggleRun=view.findViewById<MaterialButton>(R.id.btnToggleRun)
        mapView = view.findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)

        mapView?.getMapAsync {
            map = it
        }

        btnToggleRun.setOnClickListener{
            sendCommendToService(ACTION_START_OR_RESUME_SERVICE)
        }
    }

    private fun sendCommendToService(action:String)=
        Intent(requireContext(),TrackingService::class.java).also {
            it.action=action
            requireContext().startService(it)
        }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }
    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }
}