package co.mudii.coyolicatzin.application.service

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.use_case.CreateInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.DeleteInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteByIdUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteByTokenUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.UpdateInviteUseCase
import co.mudii.coyolicatzin.presentation.graphql.dto.UpdateInviteInput
import org.springframework.stereotype.Service

@Service
class InviteService(
    private val createInviteUseCase: CreateInviteUseCase,
    private val getInviteByIdUseCase: GetInviteByIdUseCase,
    private val getInviteUseCase: GetInviteUseCase,
    private val getInviteByTokenUseCase: GetInviteByTokenUseCase,
    private val updateInviteUseCase: UpdateInviteUseCase,
    private val deleteInviteUseCase: DeleteInviteUseCase
) {
    fun createInvite(
        fullname: String,
        alias: String,
        phone: String
    ): Invite =
        createInviteUseCase.execute(fullname, alias, phone)

    fun getInvite(): List<Invite> =
        getInviteUseCase.execute()

    fun getInviteById(id: Long): Invite =
        getInviteByIdUseCase.execute(id)

    fun getInviteByToken(token: String): Invite =
        getInviteByTokenUseCase.execute(token)

    fun updateInvite(id: Long, input: UpdateInviteInput): Invite =
        updateInviteUseCase.execute(id, input)

    fun deleteInvite(id: Long) = deleteInviteUseCase.execute(id)
}