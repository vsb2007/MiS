package bgroup.service;

import bgroup.model.ServiceList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;


@Service("serviceListService")
@Transactional
public class ServiceListServiceImpl implements ServiceListService {

    public ServiceList findById(int id) {
        return null;
    }

    public void saveServiceList(ServiceList serviceList) {

    }

    public void updateServiceList(ServiceList serviceList) {

    }

    public void deleteServiceListById(int id) {

    }

    public List<ServiceList> findAllServiceList() {
        return null;
    }
}
