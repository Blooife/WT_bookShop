package com.example.wt_bookshop.model.entities.phone;

import com.example.wt_bookshop.model.dao.ColorDao;
import com.example.wt_bookshop.model.dao.impl.JdbcColorDao;
import com.example.wt_bookshop.model.entities.color.Color;
import com.example.wt_bookshop.model.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhonesExtractor {
    ColorDao colorDao = new JdbcColorDao();

    public List<Phone> extractData(ResultSet resultSet) throws SQLException, DaoException {
        List<Phone> phones = new ArrayList<>();
        while (resultSet.next()) {
            Phone phone = new Phone();
            phone.setId(resultSet.getLong("ID"));
            phone.setBrand(resultSet.getString("BRAND"));
            phone.setModel(resultSet.getString("MODEL"));
            phone.setPrice(resultSet.getBigDecimal("PRICE"));
            phone.setDisplaySizeInches(resultSet.getBigDecimal("DISPLAYSIZEINCHES"));
            phone.setWeightGr(resultSet.getInt("WEIGHTGR"));
            phone.setLengthMm(resultSet.getBigDecimal("LENGTHMM"));
            phone.setWidthMm(resultSet.getBigDecimal("WIDTHMM"));
            phone.setHeightMm(resultSet.getBigDecimal("HEIGHTMM"));
            phone.setAnnounced(resultSet.getDate("ANNOUNCED"));
            phone.setDeviceType(resultSet.getString("DEVICETYPE"));
            phone.setOs(resultSet.getString("OS"));
            phone.setDisplayResolution(resultSet.getString("DISPLAYRESOLUTION"));
            phone.setPixelDensity(resultSet.getInt("PIXELDENSITY"));
            phone.setDisplayTechnology(resultSet.getString("DISPLAYTECHNOLOGY"));
            phone.setBackCameraMegapixels(resultSet.getBigDecimal("BACKCAMERAMEGAPIXELS"));
            phone.setFrontCameraMegapixels(resultSet.getBigDecimal("FRONTCAMERAMEGAPIXELS"));
            phone.setRamGb(resultSet.getBigDecimal("RAMGB"));
            phone.setInternalStorageGb(resultSet.getBigDecimal("INTERNALSTORAGEGB"));
            phone.setBatteryCapacityMah(resultSet.getInt("BATTERYCAPACITYMAH"));
            phone.setTalkTimeHours(resultSet.getBigDecimal("TALKTIMEHOURS"));
            phone.setStandByTimeHours(resultSet.getBigDecimal("STANDBYTIMEHOURS"));
            phone.setBluetooth(resultSet.getString("BLUETOOTH"));
            phone.setPositioning(resultSet.getString("POSITIONING"));
            phone.setImageUrl(resultSet.getString("IMAGEURL"));
            phone.setDescription(resultSet.getString("DESCRIPTION"));
            List<Color> colorList = colorDao.getColors(phone.getId());
            Set<Color> colors;
            if (colorList == null) {
                colors = null;
            } else {
                colors = new HashSet<>(colorList);
            }
            phone.setColors(colors);
            phones.add(phone);
        }

        return phones;
    }
}
