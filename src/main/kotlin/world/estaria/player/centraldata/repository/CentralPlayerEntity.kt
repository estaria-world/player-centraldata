package world.estaria.player.centraldata.repository

import dev.morphia.annotations.Entity
import dev.morphia.annotations.Id
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

@Entity("players")
data class CentralPlayerEntity(
    @Id val uniqueId: String = UUID.randomUUID().toString(),
    val fruties: Long = 0
)