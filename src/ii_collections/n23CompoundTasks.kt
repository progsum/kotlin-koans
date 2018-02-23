package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    // todoCollectionTask()
    return this.customers.filter { c->c.orders.stream().anyMatch{o->o.products.contains(product)} }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    // todoCollectionTask()
    return this.orders.filter { o->o.isDelivered }.flatMap { o->o.products.map{ p->p } }.maxBy { p->p.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    // todoCollectionTask()
    var count=0;
    this.customers.forEach{c->c.orders.forEach{o->o.products.forEach{p->if(p.name.equals(product.name)) count++}}}
    //println(this.customers.flatMap { c->c.orderedProducts }) //eats up dupes..?
    //return this.customers.flatMap { c->c.orderedProducts }.count { p->p.name.equals(product.name) }
    return count;
}
