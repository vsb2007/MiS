package bgroup.dao;

import bgroup.model.ServiceList;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("serviceListDao")
public class ServiceListImpl extends AbstractDao<Integer, ServiceList> implements ServiceListDao {

    static final Logger logger = LoggerFactory.getLogger(ServiceListImpl.class);

    public ServiceList findById(int id) {
        ServiceList serviceList = getByKey(id);
        /*
        if(serviceList!=null){
			Hibernate.initialize(serviceList.getUserProfiles());
		}*/
        return serviceList;
    }

    public ServiceList findByPartnerID(int id) {
        logger.info("PasrtnerID : {}", id);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", id));
        ServiceList serviceList = (ServiceList) crit.uniqueResult();

        return serviceList;
    }

    @SuppressWarnings("unchecked")
    public List<ServiceList> findAllServiceList() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("deleted", false));
        criteria.add(Restrictions.eq("paid", false));
        criteria.addOrder(Order.asc("date"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ServiceList> serviceLists = (List<ServiceList>) criteria.list();

        return serviceLists;
    }

    public List<ServiceList> findServiceListByPartnerID(int partnerId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("partnerId", partnerId));
        criteria.add(Restrictions.eq("deleted", false));
        criteria.add(Restrictions.eq("paid", false));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ServiceList> serviceLists = (List<ServiceList>) criteria.list();

        return serviceLists;
    }

    public void save(ServiceList serviceList) {
        persist(serviceList);
    }

    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", id));
        ServiceList serviceList = (ServiceList) crit.uniqueResult();
        delete(serviceList);
    }
}
