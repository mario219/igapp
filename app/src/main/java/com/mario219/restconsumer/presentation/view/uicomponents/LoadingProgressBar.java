package com.mario219.restconsumer.presentation.view.uicomponents;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Window;

import com.mario219.restconsumer.R;

/**
 * Created by mario on 29/01/18.
 */

public class LoadingProgressBar extends Dialog {

    public LoadingProgressBar(@NonNull Context context) {
        super(context);
        initView();
    }

    public LoadingProgressBar(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    protected LoadingProgressBar(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    private void initView() {
        hideDialogTitleBar();
        setContentView(R.layout.view_loading_progress);
    }

    // For versions lowers than Marshmallow
    private void hideDialogTitleBar() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            Window window = getWindow();
            if(window != null){
                window.requestFeature(Window.FEATURE_NO_TITLE);
            }
        }
    }

}
