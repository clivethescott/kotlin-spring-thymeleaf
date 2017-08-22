package app.greeting

import app.dto.SomeDataDto
import java.io.Serializable
import javax.persistence.*

/**
 * Created by scott on 10/10/2016.
 */

@Entity
@SqlResultSetMapping(name = "SomeDataMapping", classes = arrayOf(ConstructorResult(
        targetClass = SomeDataDto::class, columns = arrayOf(
        ColumnResult(name = "id", type = Long::class),
        ColumnResult(name = "info", type = String::class)
))))
class Greeting() : Serializable {

    @Id
    @GeneratedValue
    var id: Long = 0
    var content: String? = null

    constructor(content: String) : this() {
        this.content = content
    }

    constructor(id: Long, content: String) : this() {
        this.id = id
        this.content = content
    }
}
