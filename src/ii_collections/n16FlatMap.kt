package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
    //todoCollectionTask()
    return this.orders.flatMap { o -> o.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    // todoCollectionTask()
    return this.customers.flatMap { cust -> cust.orderedProducts }.toSet()
}
