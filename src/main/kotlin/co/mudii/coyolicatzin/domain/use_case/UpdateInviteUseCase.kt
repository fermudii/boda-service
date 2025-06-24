package co.mudii.coyolicatzin.domain.use_case

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository
import co.mudii.coyolicatzin.presentation.graphql.dto.UpdateInviteInput

class UpdateInviteUseCase(private val repository: InviteRepository) {

    fun execute(id: Long, input: UpdateInviteInput): Invite {
        val foundInvite = repository.findById(id)
        foundInvite.apply {
            fullname = input.fullname
            alias = input.alias
            phone = input.phone
            comments = input.comments
            attendance = input.attendance
            guestsCount = input.guestsCount
        }

        return repository.save(foundInvite)
    }
}