/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:03
 */


package other.mvvm.activity.res.layout

fun mvvmActivityXml(
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
    
        <androidx.constraintlayout.widget.ConstraintLayout 
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            
        </androidx.constraintlayout.widget.ConstraintLayout>
    
    </LinearLayout>
    
</layout>
"""