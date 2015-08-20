package com.example.project.view.common.mvp;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Base presenter for fragments.
 */
@EFragment
public abstract class BaseFragmentPresenter extends Fragment implements BasePresenter {

    /** Guard to avoid multiple calls to {@link BasePresenter#onViewCreated} */
    private boolean firstTimeOnAfterViews = true;

    // wrapper for the life cycles

    @AfterViews
    protected void baseOnAfterViews() {
        if (firstTimeOnAfterViews) {
            firstTimeOnAfterViews = false;
            onViewCreated();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        onViewResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        onViewPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onViewDestroy();
    }

    // don't force child classes to implement the life cycle methods

    @Override
    public void onViewCreated() {
    }

    @Override
    public void onViewResume() {
    }

    @Override
    public void onViewPause() {
    }

    @Override
    public void onViewDestroy() {
    }
}