package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository

class GetInviteByIdUseCase(private val repository: InviteRepository) {

    fun execute(id: Long): Invite =
        repository.findById(id)
}