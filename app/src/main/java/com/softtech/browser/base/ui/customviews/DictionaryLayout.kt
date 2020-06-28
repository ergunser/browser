package com.softtech.browser.base.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import com.softtech.browser.R
import com.softtech.browser.base.extensions.orTrue
import com.softtech.browser.base.ui.model.DictionaryModel
import com.softtech.browser.base.ui.model.KeyValueModel


class DictionaryLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun setDictionaryModel(dictionaryModel: DictionaryModel?) {

        removeAllViews()

        if (dictionaryModel?.keyValueList?.isEmpty().orTrue()) {
            return
        }

        for (keyValue in dictionaryModel?.keyValueList!!) {

            addView(createItemView(keyValue))
        }
    }

    private fun createItemView(keyValue: KeyValueModel): LinearLayout {

        val keyView = LayoutInflater.from(context).inflate(R.layout.item_key, null) as TextView

        keyView.text = keyValue.key

        val spaceView = Space(context).apply {
            layoutParams = LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                1.0f
            )
        }

        val valueView = LayoutInflater.from(context).inflate(R.layout.item_value, null) as TextView

        valueView.text = keyValue.value

        val itemView = LinearLayout(context).apply { orientation = HORIZONTAL }

        itemView.addView(keyView)
        itemView.addView(spaceView)
        itemView.addView(valueView)

        return itemView
    }

}
