package lk.ijse.GrandView.dao;

import lk.ijse.GrandView.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        EMPLOYEE,USER,HALL,ROOM,MEAL,GUEST,COMPLAINT,MEAL_DETAIL,ROOM_DETAIL
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case USER:
                return new UserDAOImpl();
            case HALL:
                return new HallDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case MEAL:
                return new MealDAOImpl();
            case GUEST:
                return new GuestDAOImpl();
            case COMPLAINT:
                return new ComplaintDAOImpl();
            case MEAL_DETAIL:
                return new MealDetailDAOImpl();
            case ROOM_DETAIL:
                return new RoomDetailDAOImpl();
            default:
                return null;
        }
    }
}
