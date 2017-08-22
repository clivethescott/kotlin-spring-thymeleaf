package app.greeting

import app.dto.SomeDataDto

/**
 * Created by scott on 10/10/2016.
 */
interface GreetingService {

    fun findGreetings(): List<Greeting>

    fun save(greeting: Greeting): Greeting

    fun findSomeData(): List<SomeDataDto>
}
