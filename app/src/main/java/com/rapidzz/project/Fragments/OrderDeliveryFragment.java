package com.rapidzz.project.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rapidzz.project.R;

/**
 * Created by Talhazk on 14-Mar-16.
 */
public class OrderDeliveryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_order_delivery, container, false);

        return rootView;
    }
}