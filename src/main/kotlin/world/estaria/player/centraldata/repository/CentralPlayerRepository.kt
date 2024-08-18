package world.estaria.player.centraldata.repository

import dev.morphia.Datastore
import world.avionik.database.simplified.repository.AbstractMorphiaRepository

/**
 * @author Niklas Nieberler
 */

class CentralPlayerRepository(
    datastore: Datastore
) : AbstractMorphiaRepository<String, CentralPlayerEntity>(
    datastore,
    CentralPlayerEntity::class.java
) {



}