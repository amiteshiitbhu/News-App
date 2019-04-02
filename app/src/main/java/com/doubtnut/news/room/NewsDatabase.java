//package com.doubtnut.news.room;
//
////TODO commented due to problem with androidx
////import androidx.room.Database;
////import androidx.room.Room;
////import androidx.room.RoomDatabase;
////
////@Database(entities = {Articles.class}, version = 1)
////public abstract class NewsDatabase extends RoomDatabase {
////
////    public static final String DATABASE_NAME = "news.db";
////    private static volatile NewsDatabase INSTANCE;
////
////    public abstract NewsDao newsDao();
////
////    public static NewsDatabase getInstance(Context context) {
////        if (INSTANCE == null) {
////            synchronized (NewsDatabase.class) {
////                if (INSTANCE == null) {
////                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
////                            NewsDatabase.class, DATABASE_NAME)
////                            .build();
////                }
////            }
////        }
////        return INSTANCE;
////    }
////
////}
