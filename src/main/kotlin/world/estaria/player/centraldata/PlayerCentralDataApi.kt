package world.estaria.player.centraldata

import world.avionik.database.simplified.morphia.createMorphiaDatastore
import world.estaria.player.centraldata.player.CentralPlayerService

/**
 * @author Niklas Nieberler
 */

class PlayerCentralDataApi {

    val playerService = CentralPlayerService()

    init {
        instance = this
    }

    companion object {
        val datastore = createMorphiaDatastore("player_centraldata")

        lateinit var instance: PlayerCentralDataApi
            private set
    }

}