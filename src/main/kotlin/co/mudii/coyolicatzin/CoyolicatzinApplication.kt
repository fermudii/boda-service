package co.mudii.coyolicatzin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class CoyolicatzinApplication

fun main(args: Array<String>) {
	runApplication<CoyolicatzinApplication>(*args)
}
