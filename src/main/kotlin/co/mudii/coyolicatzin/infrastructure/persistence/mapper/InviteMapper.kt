package co.mudii.coyolicatzin.infrastructure.persistence.mapper

import co.mudii.coyolicatzin.domain.model.Invite
import co.mudii.coyolicatzin.infrastructure.persistence.entity.InviteEntity
import org.springframework.stereotype.Component

@Component
class InviteMapper {

    fun toDomain(entity: InviteEntity): Invite =
        Invite(
            id = entity.id,
            fullname = entity.fullname,
            alias = entity.alias,
            phone = entity.phone,
            attendance = entity.attendance,
            comments = entity.comments,
            guestsCount = entity.guestsCount,
            timestamp = entity.timestamp,
            token = entity.token
        )

    fun toEntity(domain: Invite): InviteEntity =
        InviteEntity(
            id = domain.id,
            fullname = domain.fullname,
            alias = domain.alias,
            phone = domain.phone,
            attendance = domain.attendance,
            comments = domain.comments,
            guestsCount = domain.guestsCount,
            timestamp = domain.timestamp,
            token = domain.token
        )
}