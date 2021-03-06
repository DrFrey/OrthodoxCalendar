package com.example.orthodoxcalendar.data.storage.dao

import androidx.room.*
import com.example.orthodoxcalendar.data.storage.models.*

@Dao
interface SaintDao {
    @Transaction
    @Query("SELECT * FROM SaintBody")
    suspend fun getAllSaints(): List<SaintLocal>

    @Transaction
    @Query("SELECT * FROM SaintBody WHERE saintId = :id")
    suspend fun getSaintById(id: Int): SaintLocal

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaintInTransaction(
        body: SaintBody,
        icons: List<IconsOfSaint>,
        troparia: List<TropariaOrKontakia>
    ) {
        insertSaint(body)
        insertIcons(icons)
        insertTroparia(troparia)
        for (item in troparia) {
            insertCrossRef(SaintTropariaCrossRef(saintId = body.saintId, tropariaId = item.tropariaId))
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaint(body: SaintBody): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIcons(icons: List<IconsOfSaint>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTroparia(troparia: List<TropariaOrKontakia>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCrossRef(cross: SaintTropariaCrossRef)
}