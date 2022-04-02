package com.example.orthodoxcalendar.data.storage.dao

import androidx.room.*

@Dao
interface BaseDao<T> {


    /** Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    /**
     * Insert a list of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(obj: List<T>): List<Long>

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    suspend fun update(obj: T): Int

    /**
     * Update a list of objects from the database.
     *
     * @param obj the objects to be updated
     */
    @Update
    suspend fun updateList(obj: List<T>): Int

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    suspend fun delete(obj: T): Int

    /**
     * Delete a list of objects from the database
     *
     * @param obj the objects to be deleted
     */
    @Delete
    suspend fun deleteList(obj: List<T>): Int
}