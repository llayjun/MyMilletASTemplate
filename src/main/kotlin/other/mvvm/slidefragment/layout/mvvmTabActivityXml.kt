package other.mvvm.slidefragment.layout

fun mvvmTabActivityXml(
        packageName: String,
        activityClass: String
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
    
        <com.flyco.tablayout.SlidingTabLayout
            android:id="@+id/tab_segment"
            android:layout_width="match_parent"
            android:layout_height="120pt"
            app:tl_indicator_anim_enable="true"
            app:tl_indicator_color="@color/color_FFD41D"
            app:tl_indicator_corner_radius="4pt"
            app:tl_indicator_height="9pt"
            android:paddingStart="30pt"
            android:paddingEnd="30pt"
            app:tl_indicator_width="101pt"
            app:tl_tab_space_equal="true"
            app:tl_indicator_width_equal_title="true"
            app:tl_textSelectColor="@color/color_333333"
            app:tl_textUnselectColor="@color/color_666666"
            app:tl_textsize="46pt" />

        <com.hhkj.base_lib.ui.view.NoScrollViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:overScrollMode="never" />
    
    </LinearLayout>
    
</layout>
"""