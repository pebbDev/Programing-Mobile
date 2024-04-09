package com.pebdev.layoutwithfragment.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pebdev.layoutwithfragment.R;
public class ExploreFragment extends Fragment {
    View view;
    public ExploreFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_explore,container, false);
        return view;
    }
}