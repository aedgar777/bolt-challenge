package io.andrewedgar.bolt_exercise.data

interface Mapper<in From, out To> {
    fun map(from: From): To
}