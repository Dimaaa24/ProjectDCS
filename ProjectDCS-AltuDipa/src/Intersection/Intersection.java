package Project_Int;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import DataOnly.TransferOperation;

public class Intersection {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersections";

        pn.NetworkPort = 1080;

        DataCar p1 = new DataCar();
        p1.SetName("P_a1");
        pn.PlaceList.add(p1);

        DataCar p2 = new DataCar();
        p2.SetName("P_a2");
        pn.PlaceList.add(p2);

        DataCar p3 = new DataCar();
        p3.SetName("P_a3");
        pn.PlaceList.add(p3);

        DataCar p4 = new DataCar();
        p4.SetName("P_a4");
        pn.PlaceList.add(p4);

        DataCar p5 = new DataCar();
        p5.SetName("P_b1");
        pn.PlaceList.add(p5);

        DataCar p6 = new DataCar();
        p6.SetName("P_b2");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("P_b3");
        pn.PlaceList.add(p7);

        DataCar p8 = new DataCar();
        p8.SetName("P_c1");
        pn.PlaceList.add(p8);

        DataCar p9 = new DataCar();
        p9.SetName("P_c2");
        pn.PlaceList.add(p9);

        DataCarQueue p10 = new DataCarQueue();
        p10.Value.Size = 3;
        p10.SetName("P_x1");
        pn.PlaceList.add(p10);

        DataCarQueue p11 = new DataCarQueue();
        p11.Value.Size = 3;
        p11.SetName("P_x2");
        pn.PlaceList.add(p11);

        DataCarQueue p12 = new DataCarQueue();
        p12.Value.Size = 3;
        p12.SetName("P_x3");
        pn.PlaceList.add(p12);

        DataCarQueue p13 = new DataCarQueue();
        p13.Value.Size = 3;
        p13.SetName("P_x4");
        pn.PlaceList.add(p13);

        DataCarQueue p14 = new DataCarQueue();
        p14.Value.Size = 3;
        p14.SetName("P_x5");
        pn.PlaceList.add(p14);

        DataCarQueue p15 = new DataCarQueue();
        p15.Value.Size = 3;
        p15.SetName("P_x6");
        pn.PlaceList.add(p15);

        DataCarQueue p16 = new DataCarQueue();
        p16.Value.Size = 3;
        p16.SetName("P_x7");
        pn.PlaceList.add(p16);

        DataCarQueue p17 = new DataCarQueue();
        p17.Value.Size = 3;
        p17.SetName("P_x8");
        pn.PlaceList.add(p17);

        DataCarQueue p18 = new DataCarQueue();
        p18.Value.Size = 3;
        p18.SetName("P_x9");
        pn.PlaceList.add(p18);

        DataCarQueue p19 = new DataCarQueue();
        p19.Value.Size = 3;
        p19.SetName("P_station");
        pn.PlaceList.add(p19);

        DataString p20 = new DataString();
        p20.SetName("P_TL1");
        pn.PlaceList.add(p20);

        DataString p21 = new DataString();
        p21.SetName("P_TL2");
        pn.PlaceList.add(p21);

        DataString p22 = new DataString();
        p22.SetName("P_TL3");
        pn.PlaceList.add(p22);

        DataString p23 = new DataString();
        p23.SetName("P_TL4");
        pn.PlaceList.add(p23);

        DataString p24 = new DataString();
        p24.SetName("P_TL_BUS");
        pn.PlaceList.add(p24);

        DataCarQueue p25 = new DataCarQueue();
        p25.Value.Size = 3;
        p25.SetName("P_xx1");
        pn.PlaceList.add(p25);

        DataCarQueue p26 = new DataCarQueue();
        p26.Value.Size = 3;
        p26.SetName("P_xx2");
        pn.PlaceList.add(p26);

        DataString p27 = new DataString();
        p27.SetName("User");
        pn.PlaceList.add(p27);

        DataString p28 = new DataString();
        p28.SetName("User_taxi");
        pn.PlaceList.add(p28);

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetValue("OP1");
        OP1.Value = new TransferOperation( "localhost", "1081","IN1");
        pn.PlaceList.add(OP1);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetValue("OP2");
        OP2.Value = new TransferOperation("localhost", "1082", "IN2");
        pn.PlaceList.add(OP2);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetValue("OP3");
        OP3.Value = new TransferOperation("localhost", "1083", "IN3");
        pn.PlaceList.add(OP3);

        DataTransfer OP4 = new DataTransfer();
        OP4.SetValue("OP4");
        OP4.Value = new TransferOperation("localhost", "1084", "IN4");
        pn.PlaceList.add(OP4);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T_u1";
        t1.InputPlaceName.add("P_a1");

        Condition T1Ct1 = new Condition(t1, "P_a1", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 1;
        pn.Transitions.add(t1);

        // T_S -----------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T_s";
        t2.InputPlaceName.add("P_x1");

        Condition T2Ct1 = new Condition(t2, "P_x1", TransitionCondition.HaveCarForMe);
        Condition T2Ct2 = new Condition(t2, "P_x1", TransitionCondition.IsPriority);
        Condition T2Ct3 = new Condition(t2, "P_x1", TransitionCondition.HaveBus);
        T2Ct2.SetNextCondition(LogicConnector.OR, T2Ct3);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P_x1", TransitionOperation.AddElement, "P_station"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 1;
        pn.Transitions.add(t2);

        //T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T17";
        t3.InputPlaceName.add("P_x1");

        Condition T3Ct1 = new Condition(t3, "P_x1", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P_x1", TransitionOperation.AddElement, "P_x2"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        //T4 -----------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T_e1";
        t4.InputPlaceName.add("P_x2");
        t4.InputPlaceName.add("P_TL1");

        Condition T4Ct1 = new Condition(t4, "P_x2", TransitionCondition.HaveCarForMe);
        Condition T4Ct2 = new Condition(t4, "P_TL1", TransitionCondition.Equal, "Green");
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_xx1"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 1;
        pn.Transitions.add(t4);

        //T5
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T_b1";
        t5.InputPlaceName.add("P_xx1");

        Condition T5Ct1 = new Condition(t5, "P_xx1", TransitionCondition.HaveCarForMe);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P_xx1", TransitionOperation.PopElementWithTarget, "P_b1"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);

        //T6
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T_b2";
        t6.InputPlaceName.add("P_xx1");

        Condition T6Ct1 = new Condition(t6, "P_xx1", TransitionCondition.HaveCarForMe);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P_xx1", TransitionOperation.PopElementWithTarget, "P_b2"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);

        //T7
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T_e2";
        t7.InputPlaceName.add("P_x3");
        t7.InputPlaceName.add("P_TL2");

        Condition T7Ct1 = new Condition(t7, "P_x3", TransitionCondition.HaveCarForMe);
        Condition T7Ct2 = new Condition(t7, "P_TL2", TransitionCondition.Equal, "Green");
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_xx1"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 1;
        pn.Transitions.add(t7);

        //T8
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T_u2";
        t8.InputPlaceName.add("P_a2");

        Condition T8Ct1 = new Condition(t8, "P_a2", TransitionCondition.HaveCarForMe);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t8, "P_a2", TransitionOperation.AddElement, "P_x3"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);

        // T9
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T_c1";
        t9.InputPlaceName.add("P_xx1");

        Condition T9Ct1 = new Condition(t9, "P_xx1", TransitionCondition.HaveCarForMe);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t9, "P_xx1", TransitionOperation.PopElementWithTarget, "P_c1"));
        t9.GuardMappingList.add(grdT9);

        t9.Delay = 0;
        pn.Transitions.add(t9);

        // T10
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "T23";
        t10.InputPlaceName.add("P_c1");

        Condition T10Ct1 = new Condition(t10, "P_c1", TransitionCondition.HaveCarForMe);
        Condition T10Ct2 = new Condition(t10, "P_c1", TransitionCondition.IsPriority);
        Condition T10Ct3 = new Condition(t10, "P_c1", TransitionCondition.HaveBus);
        T10Ct2.SetNextCondition(LogicConnector.OR, T10Ct3);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t10, "P_c1", TransitionOperation.AddElement, "P_x9"));
        t10.GuardMappingList.add(grdT10);

        t10.Delay = 0;
        pn.Transitions.add(t10);

        // T11
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "T_e_bus";
        t11.InputPlaceName.add("P_x9");
        t11.InputPlaceName.add("P_TL_BUS");

        Condition T11Ct1 = new Condition(t11, "P_x9", TransitionCondition.HaveCar);
        Condition T11Ct2 = new Condition(t11, "P_TL_BUS", TransitionCondition.Equal, "Green");
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t11, "P_x9", TransitionOperation.PopElementWithoutTarget, "P_xx2"));
        t11.GuardMappingList.add(grdT11);

        t11.Delay = 1;
        pn.Transitions.add(t11);

        // T12
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "T_u3";
        t12.InputPlaceName.add("P_a3");

        Condition T12Ct1 = new Condition(t12, "P_a3", TransitionCondition.HaveCarForMe);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t12, "P_a3", TransitionOperation.AddElement, "P_x4"));
        t12.GuardMappingList.add(grdT12);

        t12.Delay = 0;
        pn.Transitions.add(t12);

        // T13
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "T7";
        t13.InputPlaceName.add("P_x4");

        Condition T13Ct1 = new Condition(t13, "P_x4", TransitionCondition.NotNull);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(t13, "P_x4", TransitionOperation.AddElement, "P_x5"));
        t13.GuardMappingList.add(grdT13);

        t13.Delay = 0;
        pn.Transitions.add(t13);

        // T14
        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "T11";
        t14.InputPlaceName.add("P_c1");

        Condition T14Ct1 = new Condition(t14, "P_c1", TransitionCondition.NotNull);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t14, "P_c1", TransitionOperation.AddElement, "P_x5"));
        t14.GuardMappingList.add(grdT14);

        t14.Delay = 0;
        pn.Transitions.add(t14);

        // T15
        PetriTransition t15 = new PetriTransition(pn);
        t15.TransitionName = "T18";
        t15.InputPlaceName.add("P_x5");

        Condition T15Ct1 = new Condition(t15, "P_x5", TransitionCondition.NotNull);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(t15, "P_x5", TransitionOperation.AddElement, "P_x6"));
        t15.GuardMappingList.add(grdT15);

        t15.Delay = 0;
        pn.Transitions.add(t15);

        // T16
        PetriTransition t16 = new PetriTransition(pn);
        t16.TransitionName = "T_e3";
        t16.InputPlaceName.add("P_x6");
        t16.InputPlaceName.add("P_TL3");

        Condition T16Ct1 = new Condition(t16, "P_x6", TransitionCondition.HaveCarForMe);
        Condition T16Ct2 = new Condition(t16, "P_TL3", TransitionCondition.Equal, "Green");
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;
        grdT16.Activations.add(new Activation(t16, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_xx2"));
        t16.GuardMappingList.add(grdT16);

        t16.Delay = 1;
        pn.Transitions.add(t16);

        // T17
        PetriTransition t17 = new PetriTransition(pn);
        t17.TransitionName = "T_u4";
        t17.InputPlaceName.add("P_a4");

        Condition T17Ct1 = new Condition(t17, "P_a4", TransitionCondition.HaveCarForMe);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;
        grdT17.Activations.add(new Activation(t17, "P_a4", TransitionOperation.AddElement, "P_x7"));
        t17.GuardMappingList.add(grdT17);

        t17.Delay = 0;
        pn.Transitions.add(t17);

        // T18
        PetriTransition t18 = new PetriTransition(pn);
        t18.TransitionName = "T_c2";
        t18.InputPlaceName.add("P_xx2");

        Condition T18Ct1 = new Condition(t18, "P_xx2", TransitionCondition.HaveCarForMe);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;
        grdT18.Activations.add(new Activation(t18, "P_xx2", TransitionOperation.PopElementWithTarget, "P_c2"));
        t18.GuardMappingList.add(grdT18);

        t18.Delay = 0;
        pn.Transitions.add(t18);

        // T19
        PetriTransition t19 = new PetriTransition(pn);
        t19.TransitionName = "T_s2";
        t19.InputPlaceName.add("P_x7");

        Condition T19Ct1 = new Condition(t19, "P_x7", TransitionCondition.HaveCarForMe);
        Condition T19Ct2 = new Condition(t19, "P_x7", TransitionCondition.IsPriority);
        Condition T19Ct3 = new Condition(t19, "P_x7", TransitionCondition.HaveBus);
        T19Ct2.SetNextCondition(LogicConnector.OR, T19Ct3);
        T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);

        GuardMapping grdT19 = new GuardMapping();
        grdT19.condition = T19Ct1;
        grdT19.Activations.add(new Activation(t19, "P_x7", TransitionOperation.AddElement, "P_taxi_station"));
        t19.GuardMappingList.add(grdT19);

        t19.Delay = 0;
        pn.Transitions.add(t19);

        // T20
        PetriTransition t20 = new PetriTransition(pn);
        t20.TransitionName = "T_es";
        t20.InputPlaceName.add("user");
        t20.InputPlaceName.add("P_station");

        Condition T20Ct1 = new Condition(t20, "user", TransitionCondition.NotNull);
        Condition T20Ct2 = new Condition(t20, "P_station", TransitionCondition.HaveBus);
        T20Ct1.SetNextCondition(LogicConnector.AND, T20Ct2);

        GuardMapping grdT20 = new GuardMapping();
        grdT20.condition = T20Ct1;
        grdT20.Activations.add(new Activation(t20, "P_station", TransitionOperation.PopBusToQueue, "P_x2"));
        t20.GuardMappingList.add(grdT20);

        t20.Delay = 0;
        pn.Transitions.add(t20);

        // T21
        PetriTransition t21 = new PetriTransition(pn);
        t21.TransitionName = "T_es2";
        t21.InputPlaceName.add("user_taxi");
        t21.InputPlaceName.add("P_taxi_station");

        Condition T21Ct1 = new Condition(t21, "user_taxi", TransitionCondition.NotNull);
        Condition T21Ct2 = new Condition(t21, "P_taxi_station", TransitionCondition.HaveCarForMe);
        T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T21Ct1;
        grdT21.Activations.add(new Activation(t21, "P_taxi_station", TransitionOperation.PopTaxiToQueue, "P_x8"));
        t21.GuardMappingList.add(grdT21);

        t21.Delay = 0;
        pn.Transitions.add(t21);

        // T22
        PetriTransition t22 = new PetriTransition(pn);
        t22.TransitionName = "T22";
        t22.InputPlaceName.add("P_x1");
        t22.InputPlaceName.add("P_x2");
        t22.IsAsync = true;

        Condition T22Ct1 = new Condition(t22, "P_x1", TransitionCondition.NotNull);
        Condition T22Ct2 = new Condition(t22, "P_x2", TransitionCondition.CanNotAddCars);
        T22Ct1.SetNextCondition(LogicConnector.AND, T22Ct2);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T22Ct1;
        grdT22.Activations.add(new Activation(t22, "full", TransitionOperation.SendROverNetwork, "OP1"));
        t22.GuardMappingList.add(grdT22);

        t22.Delay = 0;
        pn.Transitions.add(t22);

        // T23
        PetriTransition t23 = new PetriTransition(pn);
        t23.TransitionName = "T23";
        t23.InputPlaceName.add("P_a2");
        t23.InputPlaceName.add("P_x3");
        t23.IsAsync = true;

        Condition T23Ct1 = new Condition(t23, "P_a2", TransitionCondition.NotNull);
        Condition T23Ct2 = new Condition(t23, "P_x3", TransitionCondition.CanNotAddCars);
        T23Ct1.SetNextCondition(LogicConnector.AND, T23Ct2);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T23Ct1;
        grdT23.Activations.add(new Activation(t23, "full", TransitionOperation.SendROverNetwork, "OP2"));
        t23.GuardMappingList.add(grdT23);

        t23.Delay = 0;
        pn.Transitions.add(t23);

        // T24
        PetriTransition t24 = new PetriTransition(pn);
        t24.TransitionName = "T24";
        t24.InputPlaceName.add("P_x5");
        t24.InputPlaceName.add("P_x6");
        t24.IsAsync = true;

        Condition T24Ct1 = new Condition(t24, "P_x5", TransitionCondition.NotNull);
        Condition T24Ct2 = new Condition(t24, "P_x6", TransitionCondition.CanNotAddCars);
        T24Ct1.SetNextCondition(LogicConnector.AND, T24Ct2);

        GuardMapping grdT24 = new GuardMapping();
        grdT24.condition = T24Ct1;
        grdT24.Activations.add(new Activation(t24, "full", TransitionOperation.SendROverNetwork, "OP3"));
        t24.GuardMappingList.add(grdT24);

        t24.Delay = 0;
        pn.Transitions.add(t24);

        // T25
        PetriTransition t25 = new PetriTransition(pn);
        t25.TransitionName = "T25";
        t25.InputPlaceName.add("P_x7");
        t25.InputPlaceName.add("P_x8");
        t25.IsAsync = true;

        Condition T25Ct1 = new Condition(t25, "P_x7", TransitionCondition.NotNull);
        Condition T25Ct2 = new Condition(t25, "P_x8", TransitionCondition.CanNotAddCars);
        T25Ct1.SetNextCondition(LogicConnector.AND, T25Ct2);

        GuardMapping grdT25 = new GuardMapping();
        grdT25.condition = T25Ct1;
        grdT25.Activations.add(new Activation(t25, "full", TransitionOperation.SendROverNetwork, "OP4"));
        t25.GuardMappingList.add(grdT25);

        t25.Delay = 0;
        pn.Transitions.add(t25);

        System.out.println("Intersection started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}