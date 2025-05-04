package co.mudii.coyolicatzin.presentation.graphql.dto

import co.mudii.coyolicatzin.domain.model.Invite
import java.time.LocalDateTime

class InviteDTO (
    val id: Long = 0,
    val fullname: String = "",
    val alias: String = "",
    val phone: String = "",
    val attendance: Boolean? = null,
    val comments: String = "",
    val guestsCount: Long = 1,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val token: String = ""
    )

fun Invite.toDTO(): InviteDTO =
    InviteDTO(
        id = id,
        fullname = fullname,
        alias = alias,
        phone = phone,
        attendance = attendance,
        comments = comments,
        guestsCount = guestsCount,
        timestamp = timestamp,
        token = token
    )
