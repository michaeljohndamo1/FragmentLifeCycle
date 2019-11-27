package com.example.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements HeadLinesFragment.OnHeadLineLister{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container) != null){

            if(savedInstanceState != null){
                return;
            }

            HeadLinesFragment headLinesFragment = new HeadLinesFragment();

            headLinesFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.container,headLinesFragment)
                    .commit();


        }

    }

    @Override
    public void onArticleSelected(int position) {

        ArticlesFragment articlesFragment = (ArticlesFragment) getFragmentManager().findFragmentById(R.id.article_fragment);

        if(articlesFragment != null){

            articlesFragment.updateArticle(position);
        }else {
            ArticlesFragment swapFragment = new ArticlesFragment();
            Bundle args = new Bundle();
            args.putInt(ArticlesFragment.ARG_POSITION,position);
            swapFragment.setArguments(args);

            getFragmentManager().beginTransaction()
                    .replace(R.id.container,swapFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
