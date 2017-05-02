package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by dewayneallen on 5/2/17.
 */

public final class PetContract {

    private PetContract() {}

    public static abstract class PetEntry implements BaseColumns {

        public static final String TABLE_NAME = "pets";


        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for gender of the pet.
         */
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_UNKNOWN = 3;
    }
}
