package com.domesoft.gameboxlibrary.quizer;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.domesoft.gameboxlibrary.R;
//
//public class OptionView extends RecyclerView {
//
//
//    private int childLayout;
//
//
//    public OptionView(@NonNull Context context) {
//        super(context);
//        init(null);
//    }
//
//    public OptionView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs);
//    }
//
//    public OptionView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(attrs);
//    }
//
//
//    private void init(@Nullable AttributeSet set){
//        if (set== null) return;
//
//        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.OptionView);
//        childLayout = typedArray.getResourceId(R.styleable.OptionView_set_child_layout, R.layout.simple_child_view);
//        typedArray.recycle();
//
//    }
//
//    int getChildView(){
//        return childLayout;
//    }
//
//
//
//
//
//}
