package other.mvvm.slidefragment.layout

fun mvvmTabFragmentXml(
        packageName: String,
        fragmentClass: String,
        itemLayoutName: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${fragmentClass}FragVM" />
    </data>
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/color_f2f2f2"
        android:orientation="vertical"
        tools:context="${packageName}.${fragmentClass}Fragment">

         <com.scwang.smartrefresh.layout.SmartRefreshLayout
            android:id="@+id/smart_refresh"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:headerType="@{3}"
            app:onRefreshCommand="@{viewModel.onRefreshHeader}"
            app:srlEnablePreviewInEditMode="true">

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/rv_xxx"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                app:spaceVertical="@{15}"
                tools:itemCount="3"
                tools:listitem="@layout/${itemLayoutName}" />

        </com.scwang.smartrefresh.layout.SmartRefreshLayout>
    
    </LinearLayout>
    
</layout>
"""