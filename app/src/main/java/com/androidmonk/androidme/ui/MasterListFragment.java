package com.androidmonk.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androidmonk.androidme.R;
import com.androidmonk.androidme.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallbacks;

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallbacks = (OnImageClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement onImageClickListener");
        }
    }

    //Mandatory Empty Constructor
    public MasterListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallbacks.onImageSelected(position);
            }
        });

        return rootView;
    }
}
