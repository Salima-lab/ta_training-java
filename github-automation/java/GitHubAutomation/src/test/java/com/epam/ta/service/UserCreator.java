package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {
    public static final String FORMDATA_TOTAL_PRICE = "formdata.total.price";
    public static final String FORMDATA_SEARCH_TEXT = "formdata.search.text";
    public static final String FORMDATA_NUMBER_OF_INSTANCES = "formdata.number.of.instances";

    public static User withCredentialsFromProperty(){
        return new User(UserDataReader.getUserData(FORMDATA_TOTAL_PRICE),
                        UserDataReader.getUserData(FORMDATA_SEARCH_TEXT),
                        UserDataReader.getUserData(FORMDATA_NUMBER_OF_INSTANCES));
    }
}
