package com.example.unittestingexapmle

object MockData {
    fun prepareRcvItemList(): ArrayList<RecyclerItem> {
        val rcvItem = RecyclerItem(position = 1, isChecked = false, name = "test")
        val rcvItem2 = RecyclerItem(position = 2, isChecked = true, name = "test2")
        val rcvItem3 = RecyclerItem(position = 3, isChecked = false, name = "test3")
        val rcvItem4 = RecyclerItem(position = 4, isChecked = false, name = "test4")
        return arrayListOf(rcvItem, rcvItem2, rcvItem3, rcvItem4)
    }

}