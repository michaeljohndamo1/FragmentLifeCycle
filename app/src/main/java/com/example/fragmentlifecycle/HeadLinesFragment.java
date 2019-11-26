package com.example.fragmentlifecycle;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class HeadLinesFragment extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int layout = android.R.layout.simple_list_item_1;
        String[] data = Ipsum.Headlines;

        setListAdapter(new ArrayAdapter<String>(getActivity(),layout,data));
    }
}
