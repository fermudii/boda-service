package co.mudii.coyolicatzin.infrastructure.persistence.repository

import co.mudii.coyolicatzin.infrastructure.persistence.entity.InviteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface InviteRepositorySpringDataRepository: JpaRepository<InviteEntity, Long> {

    fun findByToken(token: String): InviteEntity?

}