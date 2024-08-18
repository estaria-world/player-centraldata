package world.estaria.player.centraldata.sector

import dev.morphia.Datastore
import dev.morphia.query.filters.Filters
import dev.morphia.query.updates.UpdateOperators
import world.avionik.minecraft.common.extension.async
import world.estaria.player.centraldata.repository.CentralPlayerEntity
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

class SectorImpl(
    private val id: String,
    private val uniqueId: UUID,
    private val datastore: Datastore,
    private val getSectorFunction: () -> Long
) : Sector {

    override fun set(value: Long) {
        //TODO: call protobuf event here
        async {
            this.datastore.find(CentralPlayerEntity::class.java)
                .filter(Filters.gte("uniqueId", this.uniqueId.toString()))
                .update(UpdateOperators.set(this.id, value))
                .execute()
        }
    }

    override fun get(): Long = this.getSectorFunction()

}