package co.mudii.coyolicatzin.presentation.graphql.dto

data class UpdateInviteInput(
    val fullname: String,
    val alias: String,
    val phone: String,
    val attendance: Boolean?,
    val comments: String,
    val guestsCount: Long
)