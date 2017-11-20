package com.example.hassanusman.getdisciplined.di

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by HassanUsman on 10/09/2017.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo



