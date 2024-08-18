package world.estaria.player.centraldata.player

import world.estaria.player.centraldata.PlayerCentralDataApi
import world.estaria.player.centraldata.repository.CentralPlayerEntity
import world.estaria.player.centraldata.repository.CentralPlayerRepository
import java.util.UUID
import java.util.concurrent.CompletableFuture

/**
 * @author Niklas Nieberler
 */

class CentralPlayerService {

    private val repository = CentralPlayerRepository(PlayerCentralDataApi.datastore)

    /**
     * Gets or creates a new [CentralPlayerData] for the player
     * @param uniqueId of the player
     * @return completable future with the instance of [CentralPlayerData]
     */
    fun getPlayerData(uniqueId: UUID): CompletableFuture<CentralPlayerData> {
        return this.repository.findOrNull(uniqueId.toString())
            .thenApply { it ?: createPlayer(uniqueId) }
            .thenApply { CentralPlayerDataImpl(it) }
    }

    private fun createPlayer(uniqueId: UUID): CentralPlayerEntity {
        val newEntity = CentralPlayerEntity(uniqueId.toString())
        this.repository.save(newEntity)
        return newEntity
    }

}