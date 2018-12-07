package com.tejas.architecturesamples.repository

import com.tejas.architecturesamples.ui.MyData
import io.realm.annotations.RealmModule

@RealmModule(library = true, classes = [MyData::class])
public class AppRealmModule {
}