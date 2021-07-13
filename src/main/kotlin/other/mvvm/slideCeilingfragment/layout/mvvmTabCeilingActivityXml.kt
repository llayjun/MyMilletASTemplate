package other.mvvm.slideCeilingfragment.layout

fun mvvmTabCeilingActivityXml(
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

        <com.scwang.smartrefresh.layout.SmartRefreshLayout
            android:id="@+id/smart_refresh"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:headerType="@{3}"
            app:srlEnablePreviewInEditMode="true">

            <androidx.coordinatorlayout.widget.CoordinatorLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <com.google.android.material.appbar.AppBarLayout
                    android:id="@+id/appBar"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@color/transparent"
                    android:orientation="vertical">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="vertical"
                        android:paddingBottom="20pt"
                        app:layout_scrollFlags="scroll|enterAlwaysCollapsed">

                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="800pt"
                            android:background="@color/color_666666"
                            android:orientation="vertical" />

                    </LinearLayout>

                </com.google.android.material.appbar.AppBarLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    app:layout_behavior="@string/appbar_scrolling_view_behavior">

                    <com.flyco.tablayout.SlidingTabLayout
                        android:id="@+id/tab_segment"
                        android:layout_width="match_parent"
                        android:layout_height="120pt"
                        android:paddingStart="30pt"
                        android:paddingEnd="30pt"
                        app:tl_indicator_anim_enable="true"
                        app:tl_indicator_color="@color/color_FFD41D"
                        app:tl_indicator_corner_radius="4pt"
                        app:tl_indicator_height="9pt"
                        app:tl_indicator_width="101pt"
                        app:tl_indicator_width_equal_title="true"
                        app:tl_tab_space_equal="true"
                        app:tl_textSelectColor="@color/color_333333"
                        app:tl_textUnselectColor="@color/color_666666"
                        app:tl_textsize="46pt" />

                    <com.hhkj.base_lib.ui.view.NoScrollViewPager
                        android:id="@+id/view_pager"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:overScrollMode="never" />

                </LinearLayout>

            </androidx.coordinatorlayout.widget.CoordinatorLayout>

        </com.scwang.smartrefresh.layout.SmartRefreshLayout>
    
    </LinearLayout>
    
</layout>
"""