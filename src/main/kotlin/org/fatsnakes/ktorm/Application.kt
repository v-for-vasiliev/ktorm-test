package org.fatsnakes.ktorm

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.select
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import org.ktorm.support.postgresql.PostgreSqlDialect
import org.ktorm.support.sqlite.SQLiteDialect
import java.nio.file.Paths

class Application {

    private val db by lazy {
        /*
        val workDir = Paths.get("").toAbsolutePath().toString()
        Database.connect(
            url = "jdbc:sqlite:///${workDir}/example.db",
            driver = "org.sqlite.JDBC",
            dialect = SQLiteDialect()
        )
        */
        // When bot starts on server use "jdbc:postgresql://localhost:5432/turina1v"
        Database.connect(
            url = "jdbc:postgresql://202.61.239.148:5432/turina1v",
            user = "turina1v",
            password = "pa55word",
            driver = "org.postgresql.Driver",
            dialect = PostgreSqlDialect(),
            logger = ConsoleLogger(threshold = LogLevel.TRACE)
        )

    }

    fun test() {

        for (row in db.from(Users).select()) {
            println("id = ${row[Users.id]}")
            println("name = ${row[Users.name]}")
            println("isAdmin = ${row[Users.admin]}")
        }
    }
}

fun main(args: Array<String>) {
    runBlocking {
        launch {
            Application().test()
        }
    }
}

object Users : Table<Nothing>("t_users") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val admin = boolean("admin")
}