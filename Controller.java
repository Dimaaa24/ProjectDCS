package Project;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller {
	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection Controller";
		pn.NetworkPort = 1080;

		DataString  ini= new DataString();
		ini.SetName("ini");
		ini.SetValue("red");
		pn.ConstantPlaceList.add(ini);

		DataString  red= new DataString();
		red.SetName("red");
		red.SetValue("red");
		pn.ConstantPlaceList.add(red);

		DataString  yellow= new DataString();
		yellow.SetName("yellow");
		yellow.SetValue("yellow");
		pn.ConstantPlaceList.add(yellow);

		DataString  green= new DataString();
		green.SetName("green");
		green.SetValue("green");
		pn.ConstantPlaceList.add(green);

		DataString  p1= new DataString();
		p1.SetName("r1r2r3r4r5");
		p1.SetValue("signal");
		pn.PlaceList.add(p1);

		DataString  p2= new DataString();
		p2.SetName("g1r2r3r4r5");
		pn.PlaceList.add(p2);

		DataString  p3= new DataString();
		p3.SetName("y1r2r3r4r5");
		pn.PlaceList.add(p3);

		DataString  p4= new DataString();
		p4.SetName("r1g2r3r4r5");
		pn.PlaceList.add(p4);

		DataString  p5= new DataString();
		p5.SetName("r1y2r3r4r5");
		pn.PlaceList.add(p5);

		DataString  p6= new DataString();
		p6.SetName("r1r2g3r4r5");
		pn.PlaceList.add(p6);

		DataString  p7= new DataString();
		p7.SetName("r1r2y3r4r5");
		pn.PlaceList.add(p7);

		DataString  p8= new DataString();
		p8.SetName("g1r2r3g4g5");
		pn.PlaceList.add(p8);

		DataString  p9= new DataString();
		p9.SetName("g1r2r3y4y5");
		pn.PlaceList.add(p9);

		DataString pf1  = new DataString();
		pf1.SetName("P_f1");
		pn.PlaceList.add(pf1);

		DataString pf2  = new DataString();
		pf2.SetName("P_f2");
		pn.PlaceList.add(pf2);

		DataString pf3  = new DataString();
		pf3.SetName("P_f3");
		pn.PlaceList.add(pf3);

		DataString pf4  = new DataString();
		pf4.SetName("P_f4");
		pn.PlaceList.add(pf4);

		DataString in1 = new DataString();
		in1.SetName("In1");
		pn.PlaceList.add(in1);

		DataString in2 = new DataString();
		in2.SetName("In2");
		pn.PlaceList.add(in2);

		DataString in3 = new DataString();
		in3.SetName("In3");
		pn.PlaceList.add(in3);

		DataString in4 = new DataString();
		in4.SetName("In4");
		pn.PlaceList.add(in4);

		DataTransfer p10 = new DataTransfer();
		p10.SetName("OP1");
		p10.Value = new TransferOperation("localhost", "1081", "P_TL1");
		pn.PlaceList.add(p10);

		DataTransfer p11 = new DataTransfer();
		p11.SetName("OP2");
		p11.Value = new TransferOperation("localhost", "1081", "P_TL2");
		pn.PlaceList.add(p11);

		DataTransfer p12 = new DataTransfer();
		p12.SetName("OP3");
		p12.Value = new TransferOperation("localhost", "1081", "P_TL3");
		pn.PlaceList.add(p12);

		DataTransfer p13 = new DataTransfer();
		p13.SetName("OP4");
		p13.Value = new TransferOperation("localhost", "1081", "P_TL4");
		pn.PlaceList.add(p13);

		DataTransfer p14 = new DataTransfer();
		p14.SetName("OP_BUS");
		p14.Value = new TransferOperation("localhost", "1081", "P_TL_BUS");
		pn.PlaceList.add(p14);

		// ----------------------------------Initialise-----------------------------------------

		PetriTransition  initialTrans = new PetriTransition(pn);
		initialTrans.TransitionName = "initialTrans";

		Condition initTransC1 = new Condition(initialTrans, "ini", TransitionCondition.NotNull );

		GuardMapping grdInit = new GuardMapping();
		grdInit.condition = initTransC1;

		grdInit.Activations.add(new Activation(initialTrans, "ini", TransitionOperation.SendOverNetwork, "OP1"));
		grdInit.Activations.add(new Activation(initialTrans, "ini", TransitionOperation.SendOverNetwork, "OP2"));
		grdInit.Activations.add(new Activation(initialTrans, "ini", TransitionOperation.SendOverNetwork, "OP3"));
		grdInit.Activations.add(new Activation(initialTrans, "ini", TransitionOperation.SendOverNetwork, "OP4"));
		grdInit.Activations.add(new Activation(initialTrans, "ini", TransitionOperation.SendOverNetwork, "OP_BUS"));
		grdInit.Activations.add(new Activation(initialTrans, "", TransitionOperation.MakeNull, "ini"));

		initialTrans.GuardMappingList.add(grdInit);
		initialTrans.Delay = 2;
		pn.Transitions.add(initialTrans);

		// ----------------------------------T1-----------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T1";
		t1.InputPlaceName.add("r1r2r3r4r5");

		Condition T1C1 = new Condition(t1, "r1r2r3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1C1;
		grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5", TransitionOperation.Move, "g1r2r3r4r5"));
		grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5", TransitionOperation.Move, "P_f1"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));

		t1.GuardMappingList.add(grdT1);

		t1.Delay = 2;
		pn.Transitions.add(t1);

		// ----------------------------------T2-----------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T2";
		t2.InputPlaceName.add("g1r2r3r4r5");

		Condition T2C1 = new Condition(t2, "g1r2r3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2C1;
		grdT2.Activations.add(new Activation(t2, "g1r2r3r4r5", TransitionOperation.Move, "y1r2r3r4r5"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

		t2.GuardMappingList.add(grdT2);

		t2.Delay = 2;
		pn.Transitions.add(t2);

		// ----------------------------------T3-----------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "T3";
		t3.InputPlaceName.add("y1r2r3r4r5");

		Condition T3C1 = new Condition(t3, "y1r2r3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3C1;
		grdT3.Activations.add(new Activation(t3, "y1r2r3r4r5", TransitionOperation.Move, "r1g2r3r4r5"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));

		t3.GuardMappingList.add(grdT3);

		t3.Delay = 2;
		pn.Transitions.add(t3);

		// ----------------------------------T4-----------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "T4";
		t4.InputPlaceName.add("r1g2r3r4r5");

		Condition T4C1 = new Condition(t4, "r1g2r3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4C1;
		grdT4.Activations.add(new Activation(t4, "r1g2r3r4r5", TransitionOperation.Move, "r1y2r3r4r5"));
		grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));

		t4.GuardMappingList.add(grdT4);

		t4.Delay = 2;
		pn.Transitions.add(t4);

		// ----------------------------------T5-----------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "T5";
		t5.InputPlaceName.add("r1y2r3r4r5");

		Condition T5C1 = new Condition(t5, "r1y2r3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5C1;
		grdT5.Activations.add(new Activation(t5, "r1y2r3r4r5", TransitionOperation.Move, "r1r2g3r4r5"));
		grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
		grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));

		t5.GuardMappingList.add(grdT5);

		t5.Delay = 2;
		pn.Transitions.add(t5);

		// ----------------------------------T6-----------------------------------------
		PetriTransition t6 = new PetriTransition(pn);
		t6.TransitionName = "T6";
		t6.InputPlaceName.add("r1r2g3r4r5");

		Condition T6C1 = new Condition(t6, "r1r2g3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT6 = new GuardMapping();
		grdT6.condition = T6C1;
		grdT6.Activations.add(new Activation(t6, "r1r2g3r4r5", TransitionOperation.Move, "r1r2y3r4r5"));
		grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));

		t6.GuardMappingList.add(grdT6);

		t6.Delay = 2;
		pn.Transitions.add(t6);

		// ----------------------------------T7-----------------------------------------
		PetriTransition t7 = new PetriTransition(pn);
		t7.TransitionName = "T7";
		t7.InputPlaceName.add("r1r2y3r4r5");

		Condition T7C1 = new Condition(t7, "r1r2y3r4r5", TransitionCondition.NotNull);

		GuardMapping grdT7 = new GuardMapping();
		grdT7.condition = T7C1;
		grdT7.Activations.add(new Activation(t7, "r1r2y3r4r5", TransitionOperation.Move, "r1r2r3g4g5"));
		grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
		grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));
		grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP_BUS"));

		t7.GuardMappingList.add(grdT7);

		t7.Delay = 2;
		pn.Transitions.add(t7);

		// ----------------------------------T8-----------------------------------------
		PetriTransition t8 = new PetriTransition(pn);
		t8.TransitionName = "T8";
		t8.InputPlaceName.add("r1r2r3g4g5");

		Condition T8C1 = new Condition(t8, "r1r2r3g4g5", TransitionCondition.NotNull);

		GuardMapping grdT8 = new GuardMapping();
		grdT8.condition = T8C1;
		grdT8.Activations.add(new Activation(t8, "r1r2r3g4g5", TransitionOperation.Move, "r1r2r3y4y5"));
		grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
		grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP_BUS"));

		t8.GuardMappingList.add(grdT8);

		t8.Delay = 2;
		pn.Transitions.add(t8);

		// ----------------------------------T9-----------------------------------------
		PetriTransition t9 = new PetriTransition(pn);
		t9.TransitionName = "T9";
		t9.InputPlaceName.add("r1r2r3y4y5");

		Condition T9C1 = new Condition(t9, "r1r2r3y4y5", TransitionCondition.NotNull);

		GuardMapping grdT9 = new GuardMapping();
		grdT9.condition = T9C1;
		grdT9.Activations.add(new Activation(t9, "r1r2r3y4y5", TransitionOperation.Move, "r1r2r3r4r5"));
		grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));
		grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP_BUS"));

		t9.GuardMappingList.add(grdT9);

		t9.Delay = 2;
		pn.Transitions.add(t9);

		// ----------------------------------T_F1-----------------------------------------
		PetriTransition t_f1 = new PetriTransition(pn);
		t_f1.TransitionName = "T_F1";
		t_f1.InputPlaceName.add("P_f1");
		t_f1.InputPlaceName.add("In1");

		Condition Tf1C1 = new Condition(t_f1, "P_f1", TransitionCondition.NotNull);
		Condition Tf1C2 = new Condition(t_f1, "In1", TransitionCondition.NotNull);
		Tf1C1.SetNextCondition(LogicConnector.AND, Tf1C2);

		GuardMapping grdTf1 = new GuardMapping();
		grdTf1.condition = Tf1C1;
		grdTf1.Activations.add(new Activation(t_f1, "Ten", TransitionOperation.DynamicDelay, ""));

		t_f1.GuardMappingList.add(grdTf1);

		t_f1.Delay = 0;
		pn.Transitions.add(t_f1);

		// ----------------------------------T_F2-----------------------------------------
		PetriTransition t_f2 = new PetriTransition(pn);
		t_f2.TransitionName = "T_F2";
		t_f2.InputPlaceName.add("P_f2");
		t_f2.InputPlaceName.add("In2");

		Condition Tf2C1 = new Condition(t_f2, "P_f2", TransitionCondition.NotNull);
		Condition Tf2C2 = new Condition(t_f2, "In2", TransitionCondition.NotNull);
		Tf2C1.SetNextCondition(LogicConnector.AND, Tf2C2);

		GuardMapping grdTf2 = new GuardMapping();
		grdTf2.condition = Tf2C1;
		grdTf2.Activations.add(new Activation(t_f2, "Ten", TransitionOperation.DynamicDelay, ""));

		t_f2.GuardMappingList.add(grdTf2);

		t_f2.Delay = 0;
		pn.Transitions.add(t_f2);

		// ----------------------------------T_F3-----------------------------------------
		PetriTransition t_f3 = new PetriTransition(pn);
		t_f3.TransitionName = "T_F3";
		t_f3.InputPlaceName.add("P_f3");
		t_f3.InputPlaceName.add("In3");
		t_f3.IsAsync = true;

		Condition Tf3C1 = new Condition(t_f3, "P_f3", TransitionCondition.NotNull);
		Condition Tf3C2 = new Condition(t_f3, "In3", TransitionCondition.NotNull);
		Tf3C1.SetNextCondition(LogicConnector.AND, Tf3C2);

		GuardMapping grdTf3 = new GuardMapping();
		grdTf3.condition = Tf3C1;
		grdTf3.Activations.add(new Activation(t_f3, "Ten", TransitionOperation.DynamicDelay, ""));

		t_f3.GuardMappingList.add(grdTf3);

		t_f3.Delay = 2;
		pn.Transitions.add(t_f3);

		// ----------------------------------T_F4-----------------------------------------
		PetriTransition t_f4 = new PetriTransition(pn);
		t_f4.TransitionName = "T_F4";
		t_f4.InputPlaceName.add("P_f4");
		t_f4.InputPlaceName.add("In4");

		Condition Tf4C1 = new Condition(t_f4, "P_f4", TransitionCondition.NotNull);
		Condition Tf4C2 = new Condition(t_f4, "In4", TransitionCondition.NotNull);
		Tf4C1.SetNextCondition(LogicConnector.AND, Tf4C2);

		GuardMapping grdTf4 = new GuardMapping();
		grdTf4.condition = Tf4C1;
		grdTf3.Activations.add(new Activation(t_f4, "Ten", TransitionOperation.DynamicDelay, ""));

		t_f4.GuardMappingList.add(grdTf4);

		t_f4.Delay = 2;
		pn.Transitions.add(t_f4);

		// ----------------------------------PN START-----------------------------------------

		System.out.println("Controller started \n ------------------------------");
		pn.Delay = 3000;
		// pn.Start();

		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}
}
