package com.asdevelopers.academy.php

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asdevelopers.academy.core.ui.AcademyCourseApp

/**
 * نقطه ورود اپ PHP عمداً کوچک نگه داشته شده است.
 * Navigation، UI، Progress، Quiz، Search، Bookmark و Database از AS-Academy-Core می‌آیند.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcademyCourseApp(courseId = PhpCourseConfig.COURSE_ID)
        }
    }
}
