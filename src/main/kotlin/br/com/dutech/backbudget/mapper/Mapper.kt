package br.com.dutech.backbudget.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
