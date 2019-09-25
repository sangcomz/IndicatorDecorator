package xyz.sangcomz.indicatordecorator.ext

import android.content.res.Resources

fun Int.toDP()= Resources.getSystem().displayMetrics.density * this