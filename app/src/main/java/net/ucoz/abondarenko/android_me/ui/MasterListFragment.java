package net.ucoz.abondarenko.android_me.ui;

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

import net.ucoz.abondarenko.android_me.R;
import net.ucoz.abondarenko.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    public MasterListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.images_grid_view);
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onImageSelected(i);
            }
        });

        return view;
    }
}
