package co.mudii.coyolicatzin.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Logging {
    val logger: Logger
        get() = LoggerFactory.getLogger(this::class.java)
}