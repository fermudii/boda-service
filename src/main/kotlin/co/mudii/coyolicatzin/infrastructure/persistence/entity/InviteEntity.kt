package co.mudii.coyolicatzin.infrastructure.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class InviteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fullname: String = "",
    val alias: String = "",
    val phone: String = "",
    val attendance: Boolean? = null,
    val comments: String = "",
    val guestsCount: Long = 1,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val token: String = ""
) {
    constructor(): this(id = 0, fullname = "", alias = "", phone = "", attendance = null, comments = "", guestsCount = 1, timestamp = LocalDateTime.now(), token = "")
}
