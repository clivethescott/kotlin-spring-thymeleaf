package app.greeting

import app.dto.SomeDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * Created by scott on 10/10/2016.
 */
@Service
class GreetingServiceImpl @Autowired constructor(private val greetingRepository: GreetingRepository) : GreetingService {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findGreetings(): List<Greeting> {
        return greetingRepository.findAll()
    }

    override fun save(greeting: Greeting): Greeting {

        return greetingRepository.save(greeting)
    }

    override fun findSomeData(): List<SomeDataDto> {

        @Suppress("UNCHECKED_CAST")
        return entityManager.createNativeQuery("select id, content as info from greeting", "SomeDataMapping")
                .resultList as List<SomeDataDto>

    }
}
