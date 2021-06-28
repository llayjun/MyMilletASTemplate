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

        <com.longyan.mmmutually.view.TitleLayout
            android:id="@+id/titleLayout"
            style="@style/mm_title_style_pt"
            android:background="@color/color_ffffff"
            app:title_text="xxxx" />
    
        <com.flyco.tablayout.SlidingTabLayout
            android:id="@+id/tab_segment"
            android:layout_width="match_parent"
            android:layout_height="120pt"
            app:tl_indicator_anim_enable="true"
            app:tl_indicator_color="@color/color_FF6E44"
            app:tl_indicator_corner_radius="4pt"
            app:tl_indicator_height="9pt"
            app:tl_indicator_width="101pt"
            app:tl_indicator_width_equal_title="true"
            app:tl_textSelectColor="@color/color_333333"
            app:tl_textUnselectColor="@color/color_666666"
            app:tl_textsize="46pt" />

        <com.longyan.mmmutually.txl.widget.AutoHeightViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:overScrollMode="never" />
    
    </LinearLayout>
    
</layout>
"""