package app.greeting

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by scott on 10/10/2016.
 */
interface GreetingRepository : JpaRepository<Greeting, Long>
