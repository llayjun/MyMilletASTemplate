/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:03
 */


package other.mvvm.refreshactivity.res.layout

fun mvvmRefreshActivityXml(
        packageName: String,
        activityClass: String,
        itemLayoutName: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${activityClass}VM" />
    </data>
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/color_f2f2f2"
        android:orientation="vertical"
        tools:context="${packageName}.${activityClass}Activity">

        <com.hhkj.base_lib.ui.view.BaseActionBarView
            android:layout_width="match_parent"
            android:layout_height="140pt"
            app:action_bar_title="xxx" />
    
        <com.scwang.smartrefresh.layout.SmartRefreshLayout
            android:id="@+id/smart_refresh"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:headerType="@{3}"
            app:onRefreshCommand="@{viewModel.onRefreshHeader}"
            app:srlEnablePreviewInEditMode="true">

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/rv_view"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                tools:itemCount="3"
                app:spaceVertical="@{15}"
                tools:listitem="@layout/${itemLayoutName}" />
                    
        </com.scwang.smartrefresh.layout.SmartRefreshLayout>
    
    </LinearLayout>
    
</layout>
"""