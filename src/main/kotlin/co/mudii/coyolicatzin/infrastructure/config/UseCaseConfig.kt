package co.mudii.coyolicatzin.infrastructure.config

import co.mudii.coyolicatzin.domain.repository.InviteRepository
import co.mudii.coyolicatzin.domain.use_case.CreateInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.DeleteInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteByIdUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteByTokenUseCase
import co.mudii.coyolicatzin.domain.use_case.GetInviteUseCase
import co.mudii.coyolicatzin.domain.use_case.UpdateInviteUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    fun createInviteUseCase(inviteRepository: InviteRepository): CreateInviteUseCase =
        CreateInviteUseCase(inviteRepository)

    @Bean
    fun getInviteUseCase(inviteRepository: InviteRepository): GetInviteUseCase =
        GetInviteUseCase(inviteRepository)

    @Bean
    fun getInviteByIdUseCase(inviteRepository: InviteRepository): GetInviteByIdUseCase =
        GetInviteByIdUseCase(inviteRepository)

    @Bean
    fun getInviteByTokenUseCase(inviteRepository: InviteRepository): GetInviteByTokenUseCase =
        GetInviteByTokenUseCase(inviteRepository)

    @Bean
    fun updateInviteUseCase(inviteRepository: InviteRepository): UpdateInviteUseCase =
        UpdateInviteUseCase(inviteRepository)

    @Bean
    fun deleteInviteUseCase(inviteRepository: InviteRepository): DeleteInviteUseCase =
        DeleteInviteUseCase(inviteRepository)
}