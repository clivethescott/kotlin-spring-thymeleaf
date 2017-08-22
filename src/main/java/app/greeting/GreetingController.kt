package app.greeting

import app.dto.SomeDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by scott on 10/10/2016.
 */
@Controller
class GreetingController @Autowired constructor(private val greetingService: GreetingService) {
    private val hasData = AtomicBoolean()

    @GetMapping("/show")
    @ResponseBody
    fun showGreetings(): List<Greeting> {

        return greetingService.findGreetings()

    }

    @GetMapping(value = "/data")
    @ResponseBody
    fun getSomeData() : List<SomeDataDto> {

        return greetingService.findSomeData()
    }

    @GetMapping(value = "/")
    fun index(model: ModelMap): String {
        val greeting = Greeting()

        greeting.content = "Some lousy content"
        model.addAttribute("greeting", greeting)
        return "index"
    }

    @GetMapping("/add")
    fun putGreetings() {

        if (!hasData.get()) {

            val greeting1 = Greeting(1L, "Hello clive")
            val greeting2 = Greeting(2L, "Hello Matthew")
            val greeting3 = Greeting(3L, "Goodbye Isaac")

            greetingService.save(greeting1)
            greetingService.save(greeting2)
            greetingService.save(greeting3)

            hasData.set(true)
        }
    }
}
