package co.mudii.coyolicatzin.domain.model

import java.time.LocalDateTime

data class Invite(
    val id: Long = 0,
    var fullname: String = "",
    val alias: String = "",
    var phone: String = "",
    var attendance: Boolean? = null,
    var comments: String = "",
    var guestsCount: Long = 1,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val token: String = ""
)