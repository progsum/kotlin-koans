package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return Date(year, month, dayOfMonth).compareTo(Date(other.year,other.month, other.dayOfMonth))
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange =
        if(Date(this.year, this.month, this.dayOfMonth).equals(Date(other.year, other.month, other.dayOfMonth)))
            DateRange(this,other);
        else if(Date(this.year, this.month, this.dayOfMonth).before(Date(other.year, other.month, other.dayOfMonth)))
            DateRange(this.copy(dayOfMonth=this.dayOfMonth-1),other);
        else
            DateRange(other.copy(dayOfMonth=this.dayOfMonth-1),this);

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    operator fun contains(d: MyDate): Boolean {
        val sD = Date(start.year, start.month, start.dayOfMonth);
        val cD = Date(d.year, d.month, d.dayOfMonth);
        val eD = Date(endInclusive.year, endInclusive.month, endInclusive.dayOfMonth);

        if (!sD.after(cD) && !eD.before(cD)) return true;
        return false
    }
    var curr = this.start
    override fun hasNext(): Boolean { return curr < this.endInclusive }
    override fun next():MyDate { curr = curr.nextDay(); return curr }
}
