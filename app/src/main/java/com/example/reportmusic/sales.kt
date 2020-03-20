package com.example.reportmusic

class sales (var name: String, var score: Float) {

    companion object {
        fun getSampleStudentData(size: Int): ArrayList<sales> {
            val sales: ArrayList<sales> = ArrayList()
            for (i in 1 until size) {
                sales.add(sales("year $i", Math.random().toFloat() * 100))
            }
            return sales
        }
    }

}
