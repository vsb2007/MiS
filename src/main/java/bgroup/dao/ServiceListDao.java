package bgroup.dao;

import bgroup.model.ServiceList;

import java.util.List;


public interface ServiceListDao {

    ServiceList findById(int id);

    void save(ServiceList serviceList);

    void deleteById(int id);

    List<ServiceList> findAllServiceList();
    List<ServiceList> findServiceListByPartnerID(int partnerId);

}

