package other.mvvm.slidefragment.layout

fun mvvmTabFragmentItemXml(
        packageName: String,
        fragmentClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="bean"
            type="String" />
    </data>
    
    <androidx.constraintlayout.widget.ConstraintLayout 
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/color_ffffff"
        android:paddingBottom="45pt">
    
        <com.ruffian.library.widget.RImageView
            android:id="@+id/ri_header"
            android:layout_width="300pt"
            android:layout_height="300pt"
            android:scaleType="centerCrop"
            app:corner_radius="25pt"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:src="@mipmap/new_logo" />
    
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
"""

