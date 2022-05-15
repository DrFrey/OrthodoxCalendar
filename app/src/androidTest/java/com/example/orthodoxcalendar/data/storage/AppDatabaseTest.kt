package com.example.orthodoxcalendar.data.storage

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.orthodoxcalendar.data.storage.dao.HolidayDao
import com.example.orthodoxcalendar.data.storage.dao.SaintDao
import com.example.orthodoxcalendar.data.storage.models.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var appDb: AppDatabase
    private lateinit var holidayDao: HolidayDao
    private lateinit var saintDao: SaintDao

    private var context = ApplicationProvider.getApplicationContext<Context>()

    private val testHolidayBody = HolidayBody(
        1, listOf(), 0, 0, "test holiday",
        false, 0, "", false, "test", 0,
        "", "", "test", "", "", 0
    )
    private val testIconsOfHoliday = IconsOfHoliday(1, 1, "testUrl")
    private val testSaintBody = SaintBody(
        1, "test saint", false, false,
        1, 0, false, false, "", false,
        0, "", false, false, "", "",
        "", "", "", "", "", "", ""
    )
    private val testIconsofSaint = IconsOfSaint(
        1, 1, "testUrl"
    )
    private val testTropariaOrKontakia = TropariaOrKontakia(
        1, "", 1,
        0, "test title", "", ""
    )

    @Before
    fun setup() {
        appDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        holidayDao = appDb.holidayDao()
        saintDao = appDb.saintDao()
    }

    @After
    fun cloaseDb() {
        appDb.close()
    }

    @Test
    fun testHolidayDao() {
        runBlocking {
            holidayDao.insertHolidayInTransaction(
                testHolidayBody,
                listOf(testIconsOfHoliday),
                listOf(testTropariaOrKontakia)
            )

            val holiday = holidayDao.getHolidayById(1)
            assertTrue(holiday.body.title == "test")
            assertTrue(holiday.icons[0].image == "testUrl")
            assertTrue(holiday.troparia[0].title == "test title")

            val holidays = holidayDao.getAllHolidays()
            assertTrue(holidays[0].body.title == "test")
            assertTrue(holidays[0].icons[0].image == "testUrl")
            assertTrue(holidays[0].troparia[0].title == "test title")
        }
    }

    @Test
    fun testSaintDao() {
        runBlocking {
            saintDao.insertSaintInTransaction(
                testSaintBody,
                listOf(testIconsofSaint),
                listOf(testTropariaOrKontakia)
            )
            val saint = saintDao.getSaintById(1)
            assertTrue(saint.body.description == "test saint")
            assertTrue(saint.icons[0].image == "testUrl")
            assertTrue(saint.troparia[0].title == "test title")

            val saints = saintDao.getAllSaints()
            assertTrue(saints[0].body.description == "test saint")
            assertTrue(saints[0].icons[0].image == "testUrl")
            assertTrue(saints[0].troparia[0].title == "test title")
        }
    }

}