package world.estaria.player.centraldata.player

import world.estaria.player.centraldata.sector.Sector
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

interface CentralPlayerData {

    /**
     * Gets the uniqueId from this player
     * @return uniqueId
     */
    fun getUniqueId(): UUID

    /**
     * Gets the fruties [Sector] from this player
     * @return fruties sector
     */
    fun getFruties(): Sector

}