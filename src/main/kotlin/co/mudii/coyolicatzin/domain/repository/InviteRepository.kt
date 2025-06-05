package co.mudii.coyolicatzin.domain.repository

import co.mudii.coyolicatzin.domain.model.Invite


interface InviteRepository {

    fun save(invite: Invite): Invite

    fun findAll(): List<Invite>

    fun findById(id: Long): Invite

    fun findByToken(token: String): Invite

    fun deleteById(id: Long): Unit
}