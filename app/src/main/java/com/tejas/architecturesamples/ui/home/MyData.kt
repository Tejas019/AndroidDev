package com.tejas.architecturesamples.ui.home

import io.realm.RealmObject

open class MyData: RealmObject() {
    var userId: Int? = null
    var id: Int? = null
    var title: String? = null
    var completed: Boolean? = null
}