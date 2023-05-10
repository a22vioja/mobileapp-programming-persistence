package com.example.persistence;

class DatabaseTables {

    static class Bonsai {

        static final String TABLE_NAME = "bonsai";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_AGE = "age";

    }

    static final String SQL_CREATE_TABLE_MOUNTAIN =
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + Bonsai.TABLE_NAME + " (" +
                    Bonsai.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Bonsai.COLUMN_NAME_NAME + " TEXT," +
                    Bonsai.COLUMN_NAME_AGE + " INT)";

    static final String SQL_DELETE_TABLE_MOUNTAIN =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + Bonsai.TABLE_NAME;

}
