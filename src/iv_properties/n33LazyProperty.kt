package iv_properties

import com.sun.org.apache.xpath.internal.operations.Bool
import util.TODO

class LazyProperty(val initializer: () -> Int) {
    private var initialized: Boolean = false
    private var value: Int = 0;
    val lazy: Int
        get() = init()

    private fun init(): Int {
        if(!initialized){initialized=true; value=initializer();}
        return value;
    }
}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties yet!
    """,
    references = { LazyProperty({ 42 }).lazy }
)
