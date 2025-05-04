package co.mudii.coyolicatzin.presentation.graphql.resolver


import co.mudii.coyolicatzin.application.service.InviteService
import co.mudii.coyolicatzin.presentation.graphql.dto.InviteDTO
import co.mudii.coyolicatzin.presentation.graphql.dto.UpdateInviteInput
import co.mudii.coyolicatzin.presentation.graphql.dto.toDTO
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin

@Controller
class InviteResolver(private val inviteService: InviteService) {

    @QueryMapping
    fun invites(
    ): List<InviteDTO> =
        inviteService.getInvite().map { it.toDTO() }

    @QueryMapping
    fun inviteById(
       @Argument id: Long): InviteDTO =
        inviteService.getInviteById(id).toDTO()

    @QueryMapping
    fun inviteByToken(
        @Argument token: String): InviteDTO =
        inviteService.getInviteByToken(token).toDTO()

    @MutationMapping
    fun createInvite(
        @Argument fullname: String,
        @Argument alias: String,
        @Argument phone: String
    ): InviteDTO =
        inviteService.createInvite(
            fullname = fullname,
            alias = alias,
            phone = phone
        ).toDTO()

    @MutationMapping
    fun updateInvite(
        @Argument id: Long,
        @Argument input: UpdateInviteInput): InviteDTO =
        inviteService.updateInvite(id, input).toDTO()
}