package com.example.testdrivingfloatingbuttom.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Driving Instructor.
 */
public final class InstructorContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private InstructorContract() {
    }

    /**
     * Inner class that defines constant values for the Instructor database table.
     * Each entry in the table represents a single Instructor.
     */
    public static final class InstructorEntry implements BaseColumns{

        public final static String TABLE_NAME="Instructors";

        /**
         * Unique ID number for the Instructor (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID=BaseColumns._ID;

        /*Name of Instructors
        *
        * */
        public final static String COLUMN_INSTRUCTOR_NAME="name";
        public final static String COLUMN_INSTRUCTOR_EMAIL="email";
        public final static String COLUMN_INSTRUCTOR_PASSWORD="password";
        public final static String COLUMN_INSTRUCTOR_PHON="phon";

    }

}
