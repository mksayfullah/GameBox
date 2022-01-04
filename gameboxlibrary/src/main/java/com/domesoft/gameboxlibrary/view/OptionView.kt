package com.domesoft.gameboxlibrary.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.domesoft.gameboxlibrary.R

class OptionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr){




    private var childLayout = 0



    private fun init(set: AttributeSet?) {
        if (set == null) return
        val typedArray = context.obtainStyledAttributes(set, R.styleable.OptionView)
        childLayout = typedArray.getResourceId(
            R.styleable.OptionView_set_child_layout,
            R.layout.simple_child_view
        )
        typedArray.recycle()
    }

}