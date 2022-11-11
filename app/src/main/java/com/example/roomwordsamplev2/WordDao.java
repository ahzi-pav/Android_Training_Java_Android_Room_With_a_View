package com.example.roomwordsamplev2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    /* allowing insert of the same word multiple times by passing a
        conflicting resolution strategy */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER by word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

}
