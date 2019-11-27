package com.example.fragmentlifecycle;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
;

public class HeadLinesFragment extends ListFragment {

    OnHeadLineLister callback;

    public interface OnHeadLineLister{
        public void onArticleSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (OnHeadLineLister) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Must implement OnHeadLineListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int layout = android.R.layout.simple_list_item_1;
        String[] data = Ipsum.Headlines;

        setListAdapter(new ArrayAdapter<String>(getActivity(),layout,data));
    }

    @Override
    public void onStart() {
        super.onStart();

        Fragment f = getFragmentManager().findFragmentById(R.id.headline_fragment);
        ListView v = getListView();
        if(f != null && v != null){
            v.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        callback.onArticleSelected(position);

        l.setItemChecked(position,true);
    }
}
