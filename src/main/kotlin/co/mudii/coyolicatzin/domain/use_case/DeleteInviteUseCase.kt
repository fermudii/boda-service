package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.repository.InviteRepository

class DeleteInviteUseCase(private val repository: InviteRepository) {

    fun execute(id: Long) {
        return repository.deleteById(id)
    }
}