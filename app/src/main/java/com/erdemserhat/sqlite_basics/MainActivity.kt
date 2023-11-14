package com.erdemserhat.sqlite_basics

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // # SQLite Database basics PART 1 {creating db, inserting data, reading data)

        //->Database operations are critical operations, they might throw error that's why use TRY/CATCH

        try {
            // #Creating a database
            val myDatabase: SQLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null)


            // #Creating a sheet and columns in database
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR,age INT)")


            // #Inserting data
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('SERHAT',12)")

            // #Reading data

            // ##Creating a cursor to select data from sheet
            val cursor: Cursor = myDatabase.rawQuery("SELECT * FROM users", null)
            // ##Getting column indexes
            val nameIx: Int = cursor.getColumnIndex("name")
            val ageIx: Int = cursor.getColumnIndex("age")

            // ##Creating a while loop to read cursor

            while (cursor.moveToNext()) {
                //println("Name :" +cursor.getString(nameIx))
                //println("Age :" + cursor.getInt(ageIx))

            }
            cursor.close()

            /**
             * your local database locate on --->
             * /data/data/your_package_name/databases/
             *
             */

            /**
             * User id INTEGER PRIMARY KEY to increment id automatically..
             *
             *
             */


        }catch (e:Exception){e.printStackTrace()

        }

        // # SQLite Database basics PART 2 { filtering data, increment id automatically}
        try {
            val myDatabase:SQLiteDatabase = this.openOrCreateDatabase("Developers", MODE_PRIVATE,null)
           // myDatabase.execSQL("CREATE TABLE IF NOT EXISTS engineers (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")
          //  myDatabase.execSQL("INSERT INTO engineers (name,age) VALUES ('Mike', 23)")
          //  myDatabase.execSQL("INSERT INTO engineers (name,age) VALUES ('Serhat', 22)")
           // myDatabase.execSQL("INSERT INTO engineers (name,age) VALUES ('John', 34)")


            //filtering data queries
            val wholeData = "SELECT * FROM engineers"
            val filteredData = "SELECT * FROM engineers WHERE id=2"
            val filteredData2 = "SELECT * FROM engineers WHERE name LIKE '%e'"
            val filteredData3 = "SELECT * FROM engineers WHERE name LIKE '%ike%'"
            val filteredData4 = "SELECT * FROM engineers WHERE name LIKE 'ike%'"

            //updating data...
            val updateQuery:String="UPDATE engineers SET age=81 WHERE name='Mike'"
            myDatabase.execSQL(updateQuery)

            val cursor:Cursor = myDatabase.rawQuery(wholeData,null)
            val nameIX = cursor.getColumnIndex("name")
            val ageIX = cursor.getColumnIndex("age")
            val idIX = cursor.getColumnIndex("id")

            //deleting data...
            val deleteQuery = "DELETE FROM engineers WHERE id=3"
            myDatabase.execSQL(deleteQuery)

            while (cursor.moveToNext()){
                println("id: ${cursor.getInt(idIX)}, name: ${cursor.getString(nameIX)}, age: ${cursor.getInt(ageIX)} " )

            }












        }catch (e:Exception){
            e.printStackTrace()
        }







    }
}