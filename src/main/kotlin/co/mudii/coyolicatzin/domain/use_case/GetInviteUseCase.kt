package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository

class GetInviteUseCase(private val repository: InviteRepository) {

    fun execute(): List<Invite> =
        repository.findAll()
}