package com.mercadolibreprueba.mercadomobile.controller;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * **************************************************************************
 * NAME: Utilities.java
 * DESCRIPTION:  Execute Utility Tasks.
 * UPDATES:
 * VERSION      DATE       AUTOR      REQUIREMENT              UPDATE DESCRIPTION
 * -------  ------------  ----------  ---------------  -------------------------------------------------
 * 1.0       19/08/2021   jquiroga      creation                    creation
 * ***************************************************************************
 */

public class Utilities {

    public Utilities(){
        //not used
    }


    public boolean checkInternetConnection(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = connectivityManager.getActiveNetwork();
        if (network == null) return false;
        NetworkCapabilities actualNetwork = connectivityManager.getNetworkCapabilities(network);
        return actualNetwork != null && (actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)|| actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));
    }

    public void setUpCardRecyclerView(RecyclerView cardRecyclerView, LinearLayoutManager cardLinearLayoutManager){

        cardLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        cardRecyclerView.setLayoutManager(cardLinearLayoutManager);

    }
}
