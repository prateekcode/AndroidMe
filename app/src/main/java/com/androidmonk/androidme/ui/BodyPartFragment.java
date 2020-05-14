package com.androidmonk.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androidmonk.androidme.R;
import com.androidmonk.androidme.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // Final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    //Tag for Logging
    public static final String TAG = "BodyPartFragment";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    public List<Integer> mImageIds;
    public int mListIndex;

    public BodyPartFragment() {
        this.mImageIds = mImageIds;
        this.mListIndex = mListIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //Inflate the Android Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //Getting reference to ImageView
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.fragment_image_view);

        if (mImageIds != null){

            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex<mImageIds.size()-1){
                        mListIndex++;

                    }
                    else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));

                }

            });
        }else {
            Log.v(TAG, "This Fragment has a null list of image");
        }

        return rootView;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
