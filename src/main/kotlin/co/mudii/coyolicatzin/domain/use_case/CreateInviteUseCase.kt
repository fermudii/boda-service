package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository
import kotlin.random.Random

class CreateInviteUseCase(private val repository: InviteRepository) {

    fun execute(
        fullname: String,
        alias: String,
        phone: String,
    ): Invite {
        val invite = Invite(
            fullname = fullname,
            alias = alias,
            phone = phone,
            token = generateTimeBasedToken()
        )
        return repository.save(invite)
    }

    fun generateTimeBasedToken(): String {
        val timestamp = System.currentTimeMillis().toString(36)
        val randomValue = Random.nextInt(100, 999)
        println(timestamp)
        return "$timestamp$randomValue"
    }
}