package io.andrewedgar.bolt_exercise.datatransfer

interface Mapper<in From, out To> {
    fun map(from: From): To
}