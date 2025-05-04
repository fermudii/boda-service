package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository

class GetInviteByTokenUseCase(private val repository: InviteRepository) {

    fun execute(token: String): Invite =
        repository.findByToken(token)
}