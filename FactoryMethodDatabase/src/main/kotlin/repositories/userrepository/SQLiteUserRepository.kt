package repositories.userrepository

import database.Database
import database.SQLiteDatabase

class SQLiteUserRepository: UserRepository() {
    override val database: Database
        get() = SQLiteDatabase()
}