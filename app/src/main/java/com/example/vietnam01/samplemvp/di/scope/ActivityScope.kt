package com.example.vietnam01.samplemvp.di.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME

import javax.inject.Scope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
