package co.mudii.coyolicatzin.infrastructure.persistence.adapter

import co.mudii.coyolicatzin.common.Logging
import co.mudii.coyolicatzin.common.exceptions.NotFoundException
import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.domain.repository.InviteRepository
import co.mudii.coyolicatzin.infrastructure.persistence.mapper.InviteMapper
import co.mudii.coyolicatzin.infrastructure.persistence.repository.InviteRepositorySpringDataRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class InviteRepositoryAdapter(
    private val inviteRepositorySpringDataRepository: InviteRepositorySpringDataRepository,
    private val inviteMapper: InviteMapper
): InviteRepository, Logging {

    override fun save(invite: Invite): Invite {
        logger.info("Saving Invite: $invite")
        val entity = inviteMapper.toEntity(invite)
        val savedEntity = inviteRepositorySpringDataRepository.save(entity)
        return inviteMapper.toDomain(savedEntity)
    }

    override fun findAll(): List<Invite> {
        logger.info("Fetching all invites...")
        return inviteRepositorySpringDataRepository.findAll().map { inviteMapper.toDomain(it) }
    }

    override fun findById(id: Long): Invite {
        logger.info("Fetching invite by id...")
        return inviteRepositorySpringDataRepository.findById(id)
            .map { inviteMapper.toDomain(it) }
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "Invite not found by id $id")}

    }

    override fun findByToken(token: String): Invite {
        logger.info("Fetching invite by token...")
        val invite = inviteRepositorySpringDataRepository.findByToken(token)
        return inviteMapper.toDomain(
            invite ?:
            throw NotFoundException("Invite not found by token $token")
        )
    }
}
