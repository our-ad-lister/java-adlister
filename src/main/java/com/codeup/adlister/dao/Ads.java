package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;


public interface Ads {

    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad findByID(String id);
    List<Ad> findByUsername(int user_id);
    void deleteEntry (Long ID);
    List<Ad> findByUserId(String id);
    List<Ad>search(String input);
    void editAd (long id, String title, String description);
}
