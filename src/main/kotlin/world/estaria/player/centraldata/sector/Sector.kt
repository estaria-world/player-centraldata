package world.estaria.player.centraldata.sector

import world.estaria.player.centraldata.PlayerCentralDataApi
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

/**
 * This class brings you some methods to easily manage your coins or other currency.
 */
interface Sector {

    /**
     * Sets a new value to the currency
     * @param value new value
     */
    fun set(value: Long)

    /**
     * Gets the current currency by a player
     * @return currency value
     */
    fun get(): Long

    /**
     * Adds a value to the currency
     * @param value ddd to the current currency
     */
    fun add(value: Long) {
        set(get() + value)
    }

    /**
     * Removes a value to the currency
     * @param value removes to the current currency
     */
    fun remove(value: Long) {
        set(get() - value)
    }

    companion object {
        /**
         * Creates a new sector implementation
         * @param id currency name
         * @param uniqueId of the player
         * @param getSectorFunction to get the currency
         */
        fun create(id: String, uniqueId: UUID, getSectorFunction: () -> Long): Sector {
            val datastore = PlayerCentralDataApi.datastore
            return SectorImpl(id, uniqueId, datastore, getSectorFunction)
        }
    }

}