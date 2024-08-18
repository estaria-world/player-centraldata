package world.estaria.player.centraldata.player

import world.estaria.player.centraldata.repository.CentralPlayerEntity
import world.estaria.player.centraldata.sector.Sector
import java.util.*

/**
 * @author Niklas Nieberler
 */

class CentralPlayerDataImpl(
    private val entity: CentralPlayerEntity,
) : CentralPlayerData {

    override fun getUniqueId(): UUID {
        return UUID.fromString(this.entity.uniqueId)
    }

    override fun getFruties(): Sector {
        return Sector.create("fruties", getUniqueId()) { this.entity.fruties }
    }

}