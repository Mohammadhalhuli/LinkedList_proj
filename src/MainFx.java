//Mohammad hlhwly -1191413
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainFx extends Application {

	Stage stage;
	Stage welcame;
	static sNode head;
	static LinkedList<TRecord> lStudents = new LinkedList<TRecord>();
	static LinkedList<TRecord> sStudents = new LinkedList<TRecord>();
	static LinkedList<TRecord> lStudentsW = new LinkedList<TRecord>();
	static LinkedList<TRecord> sStudentsW = new LinkedList<TRecord>();
	static String content ; 
	static FileWriter fileName;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// --write file
		// ---in the Read file
		File myfile = new File("Gaza_2019.csv");
		System.out.println(myfile.exists());

		Scanner scan = new Scanner(myfile);
		while (scan.hasNextLine()) {

			TRecord rec = new TRecord(scan.nextLine());
			if (rec.branch.equals("Scientific")) {
				sStudents.insert(rec);
			} else
				lStudents.insert(rec);

		}
		///// Read file west Bank
		File file = new File("WestBank_2019.csv");
		System.out.println(myfile.exists());
		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			TRecord rec = new TRecord(in.nextLine());
			if (rec.branch.equals("Scientific")) {
				sStudentsW.insert(rec);
			} else
				lStudentsW.insert(rec);

		}
		/////////////
		try {
			Image image = new Image(new FileInputStream("download.png"));  
		      ImageView imageView = new ImageView(image); 
		      imageView.setX(50); 
		      imageView.setY(25); 
		      imageView.setFitHeight(455); 
		      imageView.setFitWidth(500); 
		      imageView.setPreserveRatio(true);  
		      Button we=new Button("   log in   ");
		      we.setTranslateY(370);
		      TextField tfw=new TextField();
		      tfw.setTranslateY(370);
		      tfw.setTranslateX(100);
		      tfw.setPromptText("Enter you Name ");
		      we.setOnAction(e -> {
		    	  String x=(tfw.getText());
		    	  JOptionPane.showMessageDialog(null, "welcame " + x);
		    	  welcame.show();
		      });
		      /////////stage w
			GridPane gp = new GridPane();
			gp.setMinSize(600, 600);
			ToggleGroup tg = new ToggleGroup();
			ToggleGroup tg1 = new ToggleGroup();
			RadioButton radioG = new RadioButton("Gaza     ");
			RadioButton radioW = new RadioButton("Wast Bsnk    ");
			gp.add(radioG, 2, 2);
			gp.add(radioW, 3, 2);
			RadioButton radioL = new RadioButton("Literary     ");
			RadioButton radioS = new RadioButton("Scientific    ");
			gp.add(radioL, 2, 50);
			gp.add(radioS, 3, 50);
			radioG.setToggleGroup(tg);
			radioW.setToggleGroup(tg);
			radioL.setToggleGroup(tg1);
			radioS.setToggleGroup(tg1);

			Button insert = new Button("insert");
			gp.add(insert, 40, 1000);
			TextField t_insert = new TextField();
			t_insert.setPromptText("insert");
			gp.add(t_insert, 70, 1000);
			insert.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					String ins = (t_insert.getText());
					System.out.println(ins);
					String x = lStudents.insert(new TRecord(ins));
					content= "insert is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					String ins = (t_insert.getText());
					System.out.println(ins);
					String x = sStudents.insert(new TRecord(ins));
					content= "insert is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					String ins = (t_insert.getText());
					System.out.println(ins);
					String x = lStudentsW.insert(new TRecord(ins));
					content= "insert is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					String ins = (t_insert.getText());
					System.out.println(ins);
					String x = sStudentsW.insert(new TRecord(ins));
					content= "insert is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				
			});
			Button delete = new Button("Delete");
			gp.add(delete, 40, 1050);
			TextField t_delete = new TextField();
			t_delete.setPromptText("delete");
			gp.add(t_delete, 70, 1050);
			delete.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					String dele = (t_delete.getText());
					System.out.println(dele);
					boolean x = lStudents.delete(new TRecord(dele));
					content= "deleat is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					String dele = (t_delete.getText());
					System.out.println(dele);
					boolean x = sStudents.delete(new TRecord(dele));
					content= "deleat is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					String dele = (t_delete.getText());
					System.out.println(dele);
					boolean x = lStudentsW.delete(new TRecord(dele));
					content= "deleat is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					String dele = (t_delete.getText());
					System.out.println(dele);
					boolean x = sStudentsW.delete(new TRecord(dele));
					content= "deleat is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
			});
			Button search = new Button("search");
			gp.add(search, 40, 1010);
			TextField t_search = new TextField();
			gp.add(t_search, 70, 1010);
			t_search.setPromptText("search");
			search.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					String sea = (t_search.getText());
					System.out.println(sea);
					sNode<TRecord> x = lStudents.find(new TRecord(sea));
					content= "search is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					String sea = (t_search.getText());
					System.out.println(sea);
					sNode<TRecord> x = sStudents.find(new TRecord(sea));
					content= "search is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					String sea = (t_search.getText());
					System.out.println(sea);
					sNode<TRecord> x = lStudentsW.find(new TRecord(sea));
					content= "search is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					String sea = (t_search.getText());
					System.out.println(sea);
					sNode<TRecord> x = sStudentsW.find(new TRecord(sea));
					content= "search is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
			});
			Button top10students = new Button("top 10 students");
			gp.add(top10students, 40, 10100);
			Pane root = new Pane();
			// ListView<String> lv_topten=new ListView<>();
			TextArea lv_topten = new TextArea();
			root.getChildren().add(lv_topten);
			Scene scene2 = new Scene(root, 500, 400);
			stage = new Stage();
			stage.setScene(scene2);
			stage.setTitle(" Top  ten-10 ");
			top10students.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					String x =lStudents.Topten(lStudents);
					System.out.println(lStudents.Topten(lStudents));
					lv_topten.setText("" + x);
					content= "mean is "+x;
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					String x =sStudents.Topten(sStudents);
					System.out.println(sStudents.Topten(sStudents));
					lv_topten.setText("" + x);
					content= "mean is "+x;
				}
				
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					String x =lStudentsW.Topten(lStudentsW);
					System.out.println(lStudentsW.Topten(sStudentsW));
					lv_topten.setText("" + x);
					content= "mean is "+x;
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					String x =sStudentsW.Topten(sStudentsW);
					System.out.println(sStudentsW.Topten(sStudentsW));
					lv_topten.setText("" + x);
					content= "mean is "+x;
				}
				stage.show();
			});
			Button mean = new Button("mean");
			gp.add(mean, 40, 10150);
			TextField t_mean = new TextField();
			t_mean.setPromptText("mean");
			gp.add(t_mean, 70, 10150);
			mean.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					System.out.println(mean(lStudents));
					t_mean.setText(meanL());
					content= "mean is "+meanL();
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					System.out.println(mean(sStudents));
					t_mean.setText(meanS());
					content= "mean is "+meanS();
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					double x = mean(lStudentsW);
					System.out.println(mean(lStudentsW));
					t_mean.setText("" + x);
					content= "mean is "+x;
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					double x = mean(sStudentsW);
					System.out.println(mean(sStudentsW));
					t_mean.setText("" + x);
					content= "mean is "+x;
				}
			});
			Button mode = new Button("mode");
			gp.add(mode, 40, 10200);
			TextField t_mode = new TextField();
			gp.add(t_mode, 70, 10200);
			t_mode.setPromptText("mode");
			mode.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					double x = mode(lStudents);
					System.out.println(mode(lStudents));
					t_mode.setText("" + x);
					content= "mode is "+x;
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					//System.out.println(mode(sStudents));
					double x = mode(lStudents);
					t_mode.setText(" "+x);
					content= "mode is "+modeS();
				}
				/////////////////
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					double x = mean(lStudentsW);
					System.out.println(mode(lStudentsW));
					t_mean.setText("" + x);
					content= "mode is "+x;
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					double x = mean(sStudentsW);
					System.out.println(mode(sStudentsW));
					t_mean.setText("" + x);
					content= "mode is "+x;
				}
			});
			Button standarddeviation = new Button("standard deviation");
			gp.add(standarddeviation, 40, 10250);
			TextField t_standarddeviation = new TextField();
			t_standarddeviation.setPromptText("standard deviation");
			gp.add(t_standarddeviation, 70, 10250);
			standarddeviation.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					System.out.println(variance(lStudents));
					t_standarddeviation.setText(sdL());
					content= "standard deviation "+sdL();
					String n=standarddeviation(lStudents);
					JOptionPane.showMessageDialog(null,n);
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					System.out.println(variance(sStudents));
					t_standarddeviation.setText(sdS());
					content= "standard deviation "+sdS();
					String n=standarddeviation(sStudents);
					JOptionPane.showMessageDialog(null,n);
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					double x = variance(lStudentsW);
					System.out.println(variance(lStudentsW));
					t_mean.setText(""+x);
					content= "standard deviation is "+x;
					String n=standarddeviation(lStudentsW);
					JOptionPane.showMessageDialog(null,n);
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					double x = variance(sStudentsW);
					System.out.println(variance(sStudentsW));
					t_mean.setText(""+x);
					content= "standard deviation is "+x;
					String n=standarddeviation(sStudentsW);
					JOptionPane.showMessageDialog(null,n);
				}
			});
			Button median = new Button("median");
			gp.add(median, 40, 10300);
			TextField t_median = new TextField();
			gp.add(t_median, 70, 10300);
			t_median.setPromptText("median");
			median.setOnAction(e -> {
				
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					double x = median(lStudents);
					System.out.println(median(lStudents));
					t_median.setText(" "+x);
					content= "median is "+x;
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					System.out.println(median(sStudents));
					t_median.setText(mideanS());
					content= "median is "+mideanS();
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					double x = median(lStudentsW);
					System.out.println(median(lStudentsW));
					t_mean.setText("" + x);
					content= "median is "+x;
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					double x = median(sStudentsW);
					System.out.println(median(sStudentsW));
					t_mean.setText("" + x);
					content= "median is "+x;
				}
			});
			Button B_return = new Button("return");
			gp.add(B_return, 40, 10350);
			TextField t_return = new TextField();
			gp.add(t_return, 70, 10350);
			t_return.setPromptText("return");
			B_return.setOnAction(e -> {
				if (radioG.isSelected() == true && radioL.isSelected() == true) {
					String sea = (t_return.getText());
					System.out.println(sea);
					String x = lStudents.Return(Double.parseDouble(sea));
					content= "return is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioG.isSelected() == true && radioS.isSelected() == true) {
					String sea = (t_return.getText());
					System.out.println(sea);
					String x = sStudents.Return(Double.parseDouble(sea));
					content= "return is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioL.isSelected() == true) {
					String sea = (t_return.getText());
					System.out.println(sea);
					String x = lStudentsW.Return(Double.parseDouble(sea));
					content= "return is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
				if (radioW.isSelected() == true && radioS.isSelected() == true) {
					String sea = (t_return.getText());
					System.out.println(sea);
					String x = sStudentsW.Return(Double.parseDouble(sea));
					content= "return is "+x;
					JOptionPane.showMessageDialog(null, "" + x);
				}
			});
			Button read = new Button("Read my File");
			gp.add(read, 40, 10400);
			read.setOnAction(e ->{
				try {
					fileName = new FileWriter("output1.txt",true);
					fileName.write(content);
					fileName.close();
					//Files.writeString(fileName,content);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error");
					e1.printStackTrace();
				}
			});
			Button Exit = new Button("Exit in stage");
			gp.add(Exit, 40, 611000);
			Exit.setOnAction(e -> primaryStage.close());
			
			
			Scene scene = new Scene(gp, 700, 350);
			welcame = new Stage();
			welcame.setScene(scene);
		    Group roott = new Group(imageView,we,tfw);  
		    Scene sc = new Scene(roott, 600, 500);  
			primaryStage.setTitle("Displaying Image");
		    primaryStage.setScene(sc);
		    primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String meanL() {
		double n = mean(lStudents);
		return "  " + n;
	}

	public String meanS() {
		double n = mean(sStudents);
		return "  " + n;
	}

	public String modeL() {
		double n = mode(lStudents);
		return "  " + n;
	}

	public String modeS() {
		double n = mode(sStudents);
		return "  " + n;
	}

	public String RES () {
		double n=mode(sStudents);
		return "  " +n;
	}
	public String REL () {
		double n=mode(sStudents);
		return "  " +n;
	}
	public String sdS() {
		double n = variance(sStudents);
		return "  " + n;
	}

	public String sdL() {
		double n = variance(lStudents);
		return "  " + n;
	}

	public String mideanS() {
		double n = median(sStudents);
		return "  " + n;
	}

	public String mideanL() {
		double n = median(lStudents);
		return "  " + n;
	}	
	public static void main(String[] args) {
		launch(args);//call function start
	}
	
	// Function for calculating 
	public static double mean(LinkedList<TRecord> records) {
		// variables 
		sNode<TRecord> curr = records.head;
		double sum = 0, num = 0, count = 0, mean;
        // while loop
		while (curr != null) {
			num = (curr.getData()).grade;
			sum += num;
			count++;
			curr = curr.getNext();
		}
		mean = sum / count;   //calculating the mean sum divided by count 
		return mean;

	}
	// find the mode 
	// Function for calculating 
	public static float mode(LinkedList<TRecord> records) {
	            // variables
		float maxValue = 0;
		int maxCount = 0,size = records.size(),i = 0;;
		sNode<TRecord> curr1 = records.head; //exest two node Directs to linked list 
		// while loop when i  less then size do ....
		while(i < size) {
			sNode<TRecord> curr2 = records.head;
			int count = 0;
			for (int j = 0; j < size; ++j) {
				// if statmeat to test rhe equal 
		         if (((TRecord) curr2.getData()).grade == ((TRecord) curr1.getData()).grade)
		         ++count;
		        curr2=curr2.getNext();
		      //   curr2.setNext(curr2.getNext());
		      }
		       // reset the count 
			 if (count > maxCount) {
		         maxCount = count;
		         maxValue = ((TRecord) curr1.getData()).grade;
		      }
			 curr1=curr1.getNext();
			 i++;
		}
		 return maxValue;
	}
	
	// claculating the var  and standard dev using formula
	// Function for calculating 
	public static double variance(LinkedList<TRecord> records) {
		// variables 
		sNode<TRecord> curr = records.head;
		// Compute mean (average 
        // of elements)
		double sum = 0, number = 0, count = 0, mean = mean(records);
		double var = 0;
		// while loop to test the curr if null or not 
		while (curr != null) {
			number = (curr.getData()).grade;
			count++;
			// Compute sum squared 
	        // differences with mean.
			sum = sum + Math.pow((number - mean), 2);
			curr = curr.getNext();
		}
		var = sum / count;   // the value of variance 
		return var;
	}
	// calculating the standard deviation  using variance 
	// Function for calculating 
	public static String standarddeviation(LinkedList<TRecord> records) {
		double var=variance(records);
		double SD= Math.sqrt(var);
		return "the standard deviation "+SD;
	}
	// median method 
	public double median(LinkedList<TRecord> records) {
		// variables
		/**
		 * if size is odd:
    	 *		median is size/2th element
		 *	else
    	 *		median is size/2th element + (N/2+1)th element*/
		sNode curr = records.head;
		int count = 0;
		System.out.println();
		int size = (size(records) / 2); // take the half size
		
		if (size(records) % 2 == 1){   // the odd value 
			while (count < size) {
				curr = curr.getNext();
				count++;
			}
			System.out.println(curr.getData());
			return ((TRecord) curr.getData()).grade;
		} else { // the even value 

			while (count < size) {
				curr = curr.getNext();
				count++;
			}
			return (double) (((TRecord) (curr.getData())).grade
					+ ((TRecord) (curr.getNext().getData())).grade) / 2;
		}
	}
	// count the size of linked list
	public static int size(LinkedList<TRecord> list) {
		sNode curr = list.head;
		int size = 0;
		while (curr != null) {/**Count how much value size in Linked List*/
			size++;
			curr = curr.getNext();
		}
		return size;
		// return the size.....
	}
}
