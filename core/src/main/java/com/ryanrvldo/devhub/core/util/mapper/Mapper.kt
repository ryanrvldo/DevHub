package com.ryanrvldo.devhub.core.util.mapper

interface Mapper<I, O> {

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    fun map(input: I): O

}
