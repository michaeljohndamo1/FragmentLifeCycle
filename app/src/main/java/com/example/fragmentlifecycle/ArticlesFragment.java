package com.example.fragmentlifecycle;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ArticlesFragment extends Fragment {


    final static String ARG_POSITION = "position";
    private int currentPosition = -1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if(savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        View myFragmentView = inflater.inflate(R.layout.article_fragment,container,false);

        return myFragmentView;
    }

    public void updateArticle(int position){
        View v = getView();
        TextView article = (TextView) v.findViewById(R.id.article);
        String[] data = Ipsum.Articles;
        article.setText(data[position]);
        currentPosition = position;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if(args != null) {
            updateArticle(args.getInt(ARG_POSITION));
        }else{
            updateArticle(currentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION,currentPosition);
    }
}
