package net.ucoz.abondarenko.android_me.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.ucoz.abondarenko.android_me.R;
import net.ucoz.abondarenko.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyPartFragment";

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIds;
    private int mListIndex;


    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.body_part_image_view);
        if(mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        }else {
            Log.e(TAG, "This fragment has a null list of image id's");
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        this.mListIndex = listIndex;
    }
}
