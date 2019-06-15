package com.tejas.architecturesamples.repository

import com.tejas.architecturesamples.ui.home.MyData
import io.realm.annotations.RealmModule

@RealmModule(library = true, classes = [MyData::class])
public class AppRealmModule {
}

//To rebase from branch 2 @ 01:06