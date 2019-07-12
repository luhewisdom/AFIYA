package com.example.afiyahospital.data

import com.example.loginpage.data.AfiaDataBase
import java.util.*



import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardDaoTest {
    private lateinit var database:AfiaDataBase
    private lateinit var cardDao: CardDao
    private val card1 = Card(1, "First", "this is first", date = Date(21/2/2019),approved = true, userName = "user1", hospitalName = "first hospital")
    private val card2 = Card(2, "Second", "this is second",date = Date(21/8/2019) , approved = false, userName = "user2", hospitalName = "second hospital")
    private val card3 = Card(3, "Third", "this is third", date = Date(2/22019), approved = true, userName = "user3", hospitalName = "third hospital")

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = inMemoryDatabaseBuilder(context,AfiaDataBase::class.java).build()
        cardDao = database.cardDao()

        // Insert plants in non-alphabetical order to test that results are sorted by name
        cardDao.insertAll(listOf(card2, card3, card1))
    }
    @After
    fun closeDb() {
        database.close()
    }

    @Test fun testGetAllCards(){
        val cardList =(cardDao.getAllCard()) as List<Card>
        assertThat(cardList.size, equalTo(3))
        assertThat(cardList[0], equalTo(card1))
        assertThat(cardList[1], equalTo(card2))
        assertThat(cardList[2], equalTo(card3))
    }

    @Test fun testGetCardByNo() {
        val cardList = cardDao.getCardByNo("1") as List<Card>
        assertThat(cardList.size, equalTo(2))
        assertThat(cardList.size, equalTo(1))
        assertThat(cardList.size, equalTo(0))
    }


}