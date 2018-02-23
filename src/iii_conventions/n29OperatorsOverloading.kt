package iii_conventions

import i_introduction._5_String_Templates.month
import util.TODO
import iii_conventions.TimeInterval.*

fun todoTask29(): Nothing = TODO(
    """
        Task 29.
        Implement a kind of date arithmetic. Support adding years, weeks and days to a date.
        Use classes 'MyDate' and 'TimeInterval'.
        Use the provided utility function 'MyDate.addTimeIntervals'.
        Uncomment the commented line and make it compile.

        (1). Add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument.
        (2). Support adding several time intervals to a date. Add an extra class.
        If you have any problems, see the iii_conventions/_29_Tips.kt file.
    """,
    references = { date: MyDate, timeInterval: TimeInterval ->
        date.addTimeIntervals(timeInterval, 1)
    })

fun task29_1(today: MyDate): MyDate {
    //todoTask29()
    return today + YEAR + WEEK
}

private operator fun MyDate.plus(plusTime: TimeInterval): MyDate {
    if(TimeInterval.YEAR.equals(plusTime)) return MyDate(this.year.inc(), month, dayOfMonth)
    else if(TimeInterval.WEEK.equals(plusTime)) return MyDate(this.year.inc(), month, this.dayOfMonth+7)
    else if(TimeInterval.DAY.equals(plusTime)) return MyDate(this.year.inc(), month, this.dayOfMonth+1)
    return this;
}

private operator fun MyDate.plus(plusTime: MyDate): MyDate {
    if(TimeInterval.YEAR.equals(plusTime)) return MyDate(this.year.inc(), month, dayOfMonth)
    else if(TimeInterval.WEEK.equals(plusTime)) return MyDate(this.year.inc(), month, this.dayOfMonth+7)
    else if(TimeInterval.DAY.equals(plusTime)) return MyDate(this.year.inc(), month, this.dayOfMonth+1)
    return this;
}

fun task29_2(today: MyDate): MyDate {
    //todoTask29()
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

private operator fun TimeInterval.times(i: Int): MyDate {
    if(TimeInterval.YEAR.equals(i)) return MyDate(ordinal*i, 0, 0)
    else if(TimeInterval.WEEK.equals(i)) return MyDate(0, 0, ordinal*i*7)
    else if(TimeInterval.DAY.equals(i)) return MyDate(0,0,ordinal*i)
    return MyDate(0,0,0)
}

