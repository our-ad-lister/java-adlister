package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Ad findByID(String id) {
        int queryId = Integer.parseInt(id);
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, queryId);
            return extractAd(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by id", e);
        }
    }

    public List<Ad> findByUserId(String id) {
        List<Ad> userAds = new ArrayList<>();
        int queryId = Integer.parseInt(id);
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, queryId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("img_url")
                        )
                );
            }
            return userAds;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by id", e);
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("img_url")

                        )
                );
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, img_url) VALUES (?, ?, ?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getImg_url());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
                rs.getString("img_url")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public List<Ad> findByUsername(int user_id) {
        List <Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM Ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("img_url")
                        )
                );
            }
            return ads;

        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }

    }


    public void deleteEntry (Long ID){
        String query = "DELETE from ads where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating your ad.", e);
        }
    }

    @Override
    public List<Ad> search(String input){
        PreparedStatement stmt = null;
        List<Ad> ads = new ArrayList<>();


        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?");
            stmt.setString(1,"%"+input+"%");
            stmt.setString(2,"%"+input+"%");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("img_url")
                        )
                );
            }
            return ads;

        }catch (SQLException e){
            throw new RuntimeException("Error retrieving search results");
        }

    }


//    public static void main(String[] args) {
//        MySQLAdsDao test = new MySQLAdsDao(new Config());
//
//
//        List<Ad> results = test.search("hyper");
//
//        for (Ad ad : results) {
//            System.out.println(ad.getTitle() + ad.getDescription());
//        }
//    }



    }


