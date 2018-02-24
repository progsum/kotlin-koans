package vi_generics

import util.TODO
import java.util.*
import java.util.function.Predicate
import kotlin.collections.HashSet

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
//    task41()
    return partitionTo(ArrayList<String>(), ArrayList<String>()) { s:String -> !s.contains(" ") }
}

//private fun <E, F> List<E>.partitionTo(arrayList: Collection<F>, arrayList1: Collection<F>, function: (E) -> Boolean): Pair<Collection<F>, Collection<F>> {
//private fun <E> Collection<E>.partitionTo(arrayList: Collection<E>, arrayList1: Collection<E>, function: (E) -> Boolean): Pair<Collection<E>, Collection<E>> {
//private fun <E> List<E>.partitionTo(arrayList: Collection<E>, arrayList1: Collection<E>, function: (E) -> Boolean): Pair<Collection<E>,Collection<E>> {
//private fun <E, F> Collection<E>.partitionTo(arrayList: F<E>, arrayList1: F<E>, function: (E) -> Boolean): Pair<F<E>,F<E>> {
//private fun <E> Collection<E>.partitionTo(arrayList: Collection<E>, arrayList1: Collection<E>, function: (E) -> Boolean): Pair<out Collection<E>,out Collection<E>> {
//private fun <E> Collection<E>.partitionTo(arrayList: Collection<E>, arrayList1: Collection<E>, function: (E) -> Boolean): Pair<Collection<E>,Collection<E>> {
//fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(arrayList: C, arrayList1: C, function: (T) -> Boolean): Pair<C, C> {
private fun <E, C: Collection<E>> Collection<E>.partitionTo(arrayList: C, arrayList1: C, function: (E) -> Boolean): Pair<C,C> {
    val pair= this.partition(function);
    pair.first.to(arrayList)
    pair.second.to(arrayList1)
    return Pair(arrayList, arrayList1)
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
//    task41()
    return partitionTo(HashSet<Char>(), HashSet<Char>()) { c:Char -> c in 'a'..'z' || c in 'A'..'Z'}
}