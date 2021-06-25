/**
 * @description
 * @author Millet
 * @date 2021/6/24 18:03
 */


package other.mvvm.refreshactivity.res.layout

fun mvvmRefreshActivityItemXml(
        packageName: String,
        activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/color_ffffff"
    android:paddingBottom="45pt">

    <com.ruffian.library.widget.RTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawablePadding="22pt"
        android:textColor="@color/color_000000"
        android:textSize="33pt"
        app:icon_height="39pt"
        app:icon_width="39pt"
        app:icon_src_normal="@mipmap/ic_meet_location"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        tools:text="xxx" />

</androidx.constraintlayout.widget.ConstraintLayout>
"""

