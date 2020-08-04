package com.example.carterasclientes.BaseDatos;

import android.provider.BaseColumns;

public final class FeedReaderClient {
    private FeedReaderClient() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "cliente";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_DIRECCION = "direccion";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_TELEFONO = "telefono";
    }
}
