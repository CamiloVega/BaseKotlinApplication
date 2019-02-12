package com.cvdevelopers.checklist.utils.poweradapter.item

import dagger.MapKey

@MapKey
@Target(AnnotationTarget.FUNCTION)
internal annotation class RenderKey(val value: String)