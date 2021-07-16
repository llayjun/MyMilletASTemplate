package other.mvvm.slideCeilingfragment.layout

fun mvvmTabCeilingFragmentXml(
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

         <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/rv_view"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                app:spaceVertical="@{15}"
                tools:itemCount="3"
                tools:listitem="@layout/${itemLayoutName}" />
    
    </LinearLayout>
    
</layout>
"""