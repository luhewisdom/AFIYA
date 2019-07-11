package com.example.loginpage.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.afiyahospital.data.Hospital


@Dao
interface UserDao {

    @Query("SELECT * from user ORDER BY userName ASC")
    fun getAllUsers():LiveData<List<User>>

    @Query("SELECT * from user where username=:uname")
    fun getAllUsers(uname: String):LiveData<User>

    @Query("SELECT * FROM user Where userName=:uname and password =:pass")
    fun getUser(uname:String,pass:String):Boolean

    @Insert
    fun insert(user: User):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( users: List<User>)

    @Update
    fun update(user: User):Int

    @Delete
    fun deleteUser(user: User):Int

}