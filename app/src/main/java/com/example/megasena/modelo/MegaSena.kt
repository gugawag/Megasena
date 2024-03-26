package com.example.megasena.modelo

class MegaSena {
    val numeros: MutableSet<Int> = mutableSetOf()

    init {
        setNumeros()
    }

    private fun setNumeros() {
        while (numeros.size < 6) {
            numeros.add((1..60).random())
        }
        println(numeros)
    }

    override fun toString(): String {
        return this.numeros.toString()
    }


}