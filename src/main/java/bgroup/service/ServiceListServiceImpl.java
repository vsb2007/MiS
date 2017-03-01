package bgroup.service;

import bgroup.dao.ServiceListDao;
import bgroup.model.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Autowired
    private ServiceListDao serviceListDao;

    public List<ServiceList> findAllOpenServiceListByPartnerId(Integer id) {
        if (id == null) id=-1;
        List<ServiceList> serviceLists = serviceListDao.findServiceListByPartnerID(id);
        return serviceLists;
    }

    public List<ServiceList> findAllOpenServiceList() {

        List<ServiceList> serviceLists = serviceListDao.findAllServiceList();
        return serviceLists;
    }
}
