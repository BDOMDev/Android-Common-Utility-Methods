package com.bdom.tools.utilitymethods


object ListUtils {

    fun removeNulls(list : List<Any?>){

        list.filterNotNull()

    }

}