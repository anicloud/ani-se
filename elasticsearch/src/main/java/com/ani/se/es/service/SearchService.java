package com.ani.se.es.service;

import com.ani.se.es.dto.ApplicationSeDto;
import com.ani.se.es.dto.MasterSeDto;
import com.ani.se.es.dto.SlaveSeDto;

import java.util.List;

/**
 * Created by huangbin on 6/21/15.
 */
public interface SearchService {
//    For indexer
    public void updateIndexDevice(MasterSeDto dto) throws Exception;
    public void updateIndexApplication(ApplicationSeDto dto) throws Exception;

    public void removeIndexDevice(MasterSeDto dto) throws Exception;
    public void removeIndexApplication(ApplicationSeDto dto) throws Exception;

//    For searcher
    public List<MasterSeDto> searchDevice(String query) throws Exception;
    public List<ApplicationSeDto> searchApplication(String query) throws Exception;

//    public Page<DeviceSeDto> searchDevice(String query, Pageable pageable) throws Exception;
//    public Page<ApplicationSeDto> searchApplication(String query, Pageable pageable) throws Exception;

}
