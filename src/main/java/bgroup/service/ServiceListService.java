package bgroup.service;

import bgroup.model.ServiceList;

import java.util.List;


public interface ServiceListService {

    ServiceList findById(int id);

    void saveServiceList(ServiceList serviceList);

    void updateServiceList(ServiceList serviceList);

    void deleteServiceListById(int id);

    List<ServiceList> findAllOpenServiceListByPartnerId(Integer id);
    List<ServiceList> findAllOpenServiceList();
}