package com.aportillo.koombeaapp.data.local

import android.content.ContentValues.TAG
import android.content.Context
import com.couchbase.lite.*
import java.net.URI

abstract class AppDatabase : PostDao {

   abstract fun postDao(): PostDao

    companion object {
        @Volatile private var instance: Database? = null

       public fun getDatabase(context: Context): Database =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { it -> instance = it } }

        private fun buildDatabase(appContext: Context) : Database {
            val config = DatabaseConfiguration()
            config.directory = appContext.getFilesDir().getAbsolutePath()

            var database = Database("koombea-app-bd", config)

            configDB(database)

            return database
        }

        private fun configDB(database: Database) {
            val targetEndpoint: Endpoint = URLEndpoint(URI("ws://localhost:4984/getting-started-db"))
            val replConfig = ReplicatorConfiguration(database, targetEndpoint)
            replConfig.setPushFilter { document, flags ->
                flags.contains(
                    DocumentFlag.DocumentFlagsDeleted
                )
            }
            replConfig.setAuthenticator(BasicAuthenticator("root", "a3a090au8d"))

            val replicator = Replicator(replConfig)
            replicator.addChangeListener { change: ReplicatorChange ->
                if (change.status.error != null) {
                    android.util.Log.i(TAG, "Error code ::  " + change.status.error!!.code)
                }
            }

            replicator.addChangeListener { change: ReplicatorChange ->
                if (change.status.error != null) {
                    android.util.Log.i(TAG, "Error code ::  " + change.status.error!!.code)
                }
            }
            replicator.start()
        }
    }


     // Get the database (and create it if it doesn’t exist).
 // var config: DatabaseConfiguration = DatabaseConfiguration( /* Android Context*/context)
 // var database: Database = Database("mydb", config)


}