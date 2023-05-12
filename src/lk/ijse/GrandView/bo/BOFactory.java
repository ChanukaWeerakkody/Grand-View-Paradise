package lk.ijse.GrandView.bo;

import lk.ijse.GrandView.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes{
        EMPLOYEE,USER,HALL,ROOM,MEAL,GUEST,COMPLAINT,MEAL_DETAIL,ROOM_DETAIL
    }
    public SuperBO getBO(BOFactory.BOTypes types){
        switch (types){
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case USER:
                return new UserBOImpl();
            case HALL:
                return new HallBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case MEAL:
                return new MealBOImpl();
            case GUEST:
                return new GuestBOImpl();
            case COMPLAINT:
                return new ComplaintBOImpl();
            case MEAL_DETAIL:
                return new MealDetailBOImpl();
            case ROOM_DETAIL:
                return new RoomDetailBOImpl();
            default:
                return null;
        }
    }
}
