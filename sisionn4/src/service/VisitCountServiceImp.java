package service;

import Dao.VisitCountDao;
import Dao.VisitCountDaoImp;

public class VisitCountServiceImp implements VisitCountService{

	@Override
	public void incrementCount() {
		VisitCountDao visitCountDao =new VisitCountDaoImp();
        visitCountDao.incrementNumberOfVisits();
		
	}

}
