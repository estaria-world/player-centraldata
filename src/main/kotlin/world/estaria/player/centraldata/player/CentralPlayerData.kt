package world.estaria.player.centraldata.player

import world.estaria.player.centraldata.sector.Sector
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

interface CentralPlayerData {

    fun getUniqueId(): UUID

    fun getFruties(): Sector

}