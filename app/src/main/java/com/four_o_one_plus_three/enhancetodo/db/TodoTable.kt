package com.four_o_one_plus_three.enhancetodo.db

import androidx.annotation.NonNull
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.Instant

enum class TodoRepeatType(val flag: Int) {
    NON_REPEAT(0),
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    YEARLY(4)
}

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "content")
    val content: String = "",
    @ColumnInfo(name = "create_time")
    val createTime: Long = Instant.now().epochSecond,
    @ColumnInfo(name = "last_modified")
    val lastModified: Long = Instant.now().epochSecond,
    @ColumnInfo(name = "profile_id") // fk, https://stackoverflow.com/questions/47511750/how-to-use-foreign-key-in-room-persistence-library
    val profileId: Long = 0,
    @ColumnInfo(name = "repeat_type")
    val repeatType: Int = TodoRepeatType.NON_REPEAT.flag,
    @ColumnInfo(name = "repeat_interval")
    val repeatInterval: Int = 0, // will be ignored if type is non repeat
    @ColumnInfo(name = "is_done")
    val isDone: Boolean = false,
    @ColumnInfo(name = "is_deleted")
    val isDeleted: Boolean = false,
    @ColumnInfo(name = "is_archived")
    val isArchived: Boolean = false,
)

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg todoes: TodoEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(todo: TodoEntity)

    @Query("SELECT * FROM todo")
    suspend fun queryAllTodo(): Flow<List<TodoEntity>>

    @Query("SELECT * FROM todo WHERE id=:id")
    suspend fun queryTodoById(id: Long): TodoEntity?
}
